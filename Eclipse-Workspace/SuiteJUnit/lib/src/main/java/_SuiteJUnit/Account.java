package _SuiteJUnit;

import _ExceptionsPackage.AmountException;

//https://github.com/owenbrown/python_stack/blob/master/bank_account.py

public class Account {
	private double Balance = 0;
	
	public Account(double balance) {
		this.Balance = balance;
	}
	
	public double GetBalance() {
		return this.Balance;
	}
	
	public void Deposite(double amount) throws AmountException {
		if(amount <= 0) throw new AmountException("Amount less or equal to 0, cant be deposited");
		this.Balance += amount;
	}
	
	public void Withdraw(double amount) throws AmountException {
		if(amount <= 0) throw new AmountException("Amount less or equal to 0, cant be withdrawn");
		else if (amount > this.Balance) throw new AmountException("Amount greater to balance, cant be withdrawn");
		else this.Balance -= amount;
	}
}