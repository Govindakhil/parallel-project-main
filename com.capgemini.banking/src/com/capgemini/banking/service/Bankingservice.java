package com.capgemini.banking.service;

import com.capgemini.banking.bean.Account;

public interface Bankingservice {
	public void createAccount(Account account);
	public void deposit(Integer amount,Integer accountNo);
	public void withdraw(Integer amount,Integer accountNo);
	public double checkBalance(Integer accountNo);
	public void fundtransfer(Integer accountNo1,Integer accountNo2);
	public void transactionList(Integer accountNo);
	
}
