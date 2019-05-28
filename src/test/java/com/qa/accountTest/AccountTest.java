package com.qa.accountTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.app.Account;
import com.qa.app.AccountRepositoryMap;

public class AccountTest {
	Account account;
	@Before
	public void setup() {
		account = new Account(0, null, null, 0);
	}
	
	@Test
	public void accountRepositoryMapTest() {
		AccountRepositoryMap arm = new AccountRepositoryMap();
		int id = 2;
		account.setId(id);
		account.setFirstName("Chris");
		arm.add(account);
		Account retrieved = arm.retrieve(id);
		assertEquals("Wrong account retrieved", "Chris", retrieved.getFirstName());
	}
	
	@Test
	public void createAccountId() {
		account.setId(0);
		int id = account.getId();
		assertEquals("Wrong ID", 0, id);
	}
	
	@Test
	public void createAccountFName() {
		account.setFirstName("Danny");
		String firstName = account.getFirstName();
		assertEquals("Wrong first name", "Danny", firstName);
	}
	
	@Test
	public void createAccountLName() {
		account.setLastName("Little");
		String lastName = account.getLastName();
		assertEquals("Wrong last name", "Little", lastName);
	}
	
	@Test
	public void createAccountNum() {
		account.setAccountNumber(3);
		int accountNumber = account.getAccountNumber();
		assertEquals("Wrong account number", 3, accountNumber);
	}
}
