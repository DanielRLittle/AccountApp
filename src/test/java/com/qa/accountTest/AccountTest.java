package com.qa.accountTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.app.Account;
import com.qa.app.AccountRepositoryDB;
import com.qa.app.AccountRepositoryMap;
import com.qa.app.Task;

public class AccountTest {
	Account account;
	@Before
	public void setup() {
		account = new Account(0, null, null, 0);
	}
	@Test
	public void testy() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		db.retrieveByName("Hugo");
	}
	
	@Test
	public void testTask() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		account.setFirstName("Danny");
		Task t = new Task();
		t.setTodo("Dance");
		Task t2 = new Task();
		t2.setTodo("Dog");
		account.getTasks().add(t);
		account.getTasks().add(t2);
		db.createWithTasks(account);
	}
	
	@Test
	public void removeAccount() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		db.add(account);
		int id = account.getId();
		db.remove(id);
		assertNull(db.retrieve(id));
	}
	
	@Test
	public void DBupdate() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		account.setFirstName("Adrian");
		db.add(account);
		int id = account.getId();
		db.updateFirstName(id, "Danny");
		String firstName = db.retrieve(id).getFirstName();
		assertEquals("Update Error", "Danny", firstName);
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
	
	@Test
	public void DBtest() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		db.add(account);
		int id = account.getId();
		Account accountBack = db.retrieve(id);
		assertEquals(account, accountBack);
	}
}
