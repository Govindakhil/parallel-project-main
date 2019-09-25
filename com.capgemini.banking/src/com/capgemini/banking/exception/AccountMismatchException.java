package com.capgemini.banking.exception;

import java.util.Scanner;

public class AccountMismatchException extends Exception{
	public AccountMismatchException(Integer accountNo1,Integer accountNo2,String str){
		super(accountNo1+","+accountNo2+" "+str);
		System.err.println(accountNo1+","+accountNo2+" "+str);
	}

}
