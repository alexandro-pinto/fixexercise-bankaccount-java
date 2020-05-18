package model.entities;

import model.exceptions.DomainExceptions;

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
		this.withdrawLimit = withdrawLimit;
		this.deposit(balance);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance = amount;
	}

	public void withdraw(Double amount) {
		if (amount > this.balance)
			throw new DomainExceptions("Not enough balance");

		if (amount > this.withdrawLimit)
			throw new DomainExceptions("The amount exceeds withdraw limit");

		this.balance -= amount;
	}
}
