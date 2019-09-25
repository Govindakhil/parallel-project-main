package com.capgemini.banking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Customer;
import com.capgemini.banking.bean.Transaction;
import com.capgemini.banking.exception.AccountNotFoundException;

public class BankingServiceImpl implements Bankingservice {

	Account account = new Account();
	Customer customer = new Customer();
	double currentBalance;

	HashMap<Integer, Account> acc = new HashMap<Integer, Account>();

	@Override
	public void createAccount(Account account) {
		acc.put(account.getAccountNo(), account);
		System.out.println(acc);
	}

	@Override
	public void deposit(Integer amount, Integer accountNo) {
		if (acc.containsKey(accountNo)) {
			currentBalance = acc.get(accountNo).getBalance() + amount;
			acc.get(accountNo).setBalance(currentBalance);
			Transaction transaction = new Transaction("Credit", amount);
			acc.get(accountNo).addTransaction(transaction);
		} else {
			System.out.println("Account not found");
		}
	}

	@Override
	public void withdraw(Integer amount, Integer accountNo) {
		if (acc.containsKey(accountNo)) {
			currentBalance = acc.get(accountNo).getBalance() - amount;
			acc.get(accountNo).setBalance(currentBalance);
			Transaction transaction = new Transaction("Debit", amount);
			acc.get(accountNo).addTransaction(transaction);
		} else {
			System.out.println(" Insufficient Balance ");
		}
	}

	@Override
	public double checkBalance(Integer accountNo) {

		return acc.get(accountNo).getBalance();

	}

	Scanner sc = new Scanner(System.in);

	@Override
	public void fundtransfer(Integer accountNo1, Integer accountNo2) {
		if (accountNo1 != accountNo2) {
			double sent, recieved, amount;
			sent = acc.get(accountNo1).getBalance();
			recieved = acc.get(accountNo2).getBalance();
			System.out.println("Enter the amount to be transfered");
			amount = sc.nextFloat();
			if (sent < amount) {
				System.out.println(" Enter the amount with in limit");
			} else {
				sent = acc.get(accountNo1).getBalance() - amount;
				recieved = acc.get(accountNo2).getBalance() + amount;
				acc.get(accountNo1).setBalance(sent);
				acc.get(accountNo2).setBalance(recieved);
				Transaction transaction = new Transaction("Debit", amount);
				acc.get(accountNo1).addTransaction(transaction);
				Transaction transaction1 = new Transaction("Credit", amount);
				acc.get(accountNo2).addTransaction(transaction1);
			}

		}
	}

	@Override
	public void transactionList(Integer accountNo) {
		if (acc.containsKey(accountNo)) {
			List<Transaction> transaction = acc.get(accountNo).getTransaction();
			transaction.forEach(System.out::println);
		} else {
			try {
				throw new AccountNotFoundException(accountNo, "Account not found");
			} catch (AccountNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
