package com.capgemini.banking.exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(Integer accountNo,String str){
		super(accountNo+" "+str);
		System.err.println(accountNo+" "+str);
	}

}
