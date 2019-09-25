package com.capgemini.banking.exception;

import java.util.Scanner;

public class AccountNotFoundException extends Exception {
		public AccountNotFoundException(Integer accountNo,String str){
			super(accountNo+" "+str);
			Scanner sc=new Scanner(System.in);
			System.err.println(accountNo+" "+str);
			sc.nextLine();
		}

}
