package com.cg.account.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccountServiceImpl;
import com.cg.account.service.AccountService;



public class AccountTest {


	private AccountService service;

	@Before

	public void init() {
		service = new AccountServiceImpl();
	}

  
	@Test
	public void testcreateAccountForName() {
	Account acc = new Account();
	acc.setmobileNo("9876543210");
	acc.setName("amit");
	acc.setemail("amit@gmail.com");
	acc.setBalance(200.0);
	try {
	service.createAccount(acc);
	} catch (AccountException e) {
	assertEquals("Name should start with capital letter with minimum 3 characters and should contain only alphabets", e.getMessage());
	}
	}
	
	
	@Test
	public void testcreateAccountForNameIsEmpty() {
	Account acc = new Account();
	acc.setmobileNo("9988776655");
	acc.setName("");
	acc.setemail("amit@gmail.com");
	acc.setBalance(100.0);
	try {
	service.createAccount(acc);
	} catch (AccountException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	
	
	
	@Test
	public void testcreateAccount() {
	Account acc = new Account();
	acc.setmobileNo("9876543210");
	acc.setName("Sonu Kumar");
	acc.setemail("Sonu@gmail.com");
	acc.setBalance(300.0);
	 
	try {
	String s=service.createAccount(acc);
	assertNotNull(s);
	} catch (AccountException e) {
	
	 
	}
	 
	}	
	
	@Test
	public void testShowBalanceForMobileNo() {
	
	try {
	service.showBalance("98765");
	} catch (AccountException e) {
	
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}	
	
	
	@Test
	public void testDepositForMobileNo() {
	Account acc=new Account();
	acc.setmobileNo("99887766");
	try {
	service.deposit(acc.getmobileNo(), 300);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testDepositForDepositAmt1() {
	Account acc=new Account();
	acc.setmobileNo("9912365478");
	try {
	service.deposit(acc.getmobileNo(), -230);
	} catch (AccountException e) {
	assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setmobileNo("8974563215");
		try {
			Account ac1=service.deposit(acc.getmobileNo(), 230);
			assertNotNull(ac1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			}
	}	
	
	@Test
	public void testWithDrawForMobileNo() {
	Account acc=new Account();
	acc.setmobileNo("95059345");
	try {
	service.withdraw(acc.getmobileNo(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account acc=new Account();
		acc.setmobileNo("9505934512");
		try {
			service.withdraw(acc.getmobileNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	

	
	
	
	@Test
	public void testWithdrawForAmt() {
		Account ac=new Account();
		ac.setmobileNo("8185800166");
		try {
			service.withdraw(ac.getmobileNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawForAmt1() {
		Account ac=new Account();
		ac.setmobileNo("9948032465");
		try {
			service.withdraw(ac.getmobileNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawForAmt2() {
		Account ac=new Account();
		ac.setmobileNo("8185800165");
		try {
			service.withdraw(ac.getmobileNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}	
	
	@Test
	public void testWithdrawForAmt3() {
		Account ac=new Account();
		ac.setmobileNo("8185800167");
		try {
			service.withdraw(ac.getmobileNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForMobileNo() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setmobileNo("818580");
		ac2.setmobileNo("1234");
		try {
			service.fundTransfer(ac.getmobileNo(),ac2.getmobileNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test

	public void testFundTransferForMobileNoDoesNotExist() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setmobileNo("8185800167");
		ac2.setmobileNo("8185800165");
		try {
			service.fundTransfer(ac.getmobileNo(), ac2.getmobileNo(),  230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForAmt() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setmobileNo("8185800166");
		ac2.setmobileNo("8185800165");
		try {
			service.fundTransfer(ac.getmobileNo(), ac2.getmobileNo(),  -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransfer() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setmobileNo("8185800167");
		ac2.setmobileNo("9948032465");
		try {
			assertTrue(service.fundTransfer(ac.getmobileNo(), ac2.getmobileNo(),  230));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails() {
		Account ac=new Account();
		ac.setmobileNo("9948032465");
		try {
			Account acc=service.printTransactionDetails(ac.getmobileNo());
			assertNotNull(acc);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails1() {
		Account ac=new Account();
		ac.setmobileNo("8185800166");
		try {
			Account acc=service.printTransactionDetails(ac.getmobileNo());
			assertNotNull(acc);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails2() {
		Account ac=new Account();
		ac.setmobileNo("8185800165");
		try {
			Account acc=service.printTransactionDetails(ac.getmobileNo());
			assertNotNull(acc);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails3() {
		Account ac=new Account();
		ac.setmobileNo("8185800167");
		try {
			Account acc=service.printTransactionDetails(ac.getmobileNo());
			assertNotNull(acc);
		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}
	
	@Test
	public void testPrinttransactionDetailsForMobileNo() {
	Account acc=new Account();
	acc.setmobileNo("125463");
	try {
	Account acc1=service.printTransactionDetails(acc.getmobileNo());
	assertNotNull(acc1);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	 
	}

}
