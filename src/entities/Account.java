package entities;

import Exceptions.AmountException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdraw) {
		this.withdrawLimit = withdraw;
	}

	public void deposit(double amount) throws AmountException {
		if(amount < 0) {
			throw new AmountException("Amount must be positive");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) throws AmountException {
		if(amount > withdrawLimit) {
			throw new AmountException("The amount exceeds withdraw limit");
		}
		if(amount > balance) {
			throw new AmountException("Not enough balance");
		}
		balance -= amount;
	}
	
}
