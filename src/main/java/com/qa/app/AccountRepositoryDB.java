package com.qa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class AccountRepositoryDB implements AccountRepository{
	 
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void add(Account account) {
		et.begin();
		em.persist(account);
		et.commit();
	}
	
	public List<Account> retrieveByName(String firstName){
		TypedQuery<Account> q = em.createQuery("Select a from Account a where a.firstName = '" + firstName + "'", Account.class);
		List<Account> accounts = q.getResultList();
		for(Account account : accounts) {
			System.out.println(account.getFirstName());
		}
		return accounts;
	}

	public Account retrieve(Integer id) {	
		return em.find(Account.class, id);
	}

	public Account updateFirstName(int id, String newFirstName) {
		et.begin();
		Account account = retrieve(id);
		account.setFirstName(newFirstName);
		et.commit();
		return account;
	}

	public void remove(int id) {
		et.begin();
		Account account = retrieve(id);
		em.remove(account);
		et.commit();
		
	}

	public void createWithTasks(Account account) {
		et.begin();
		em.persist(account);
		for (Task t : account.getTasks()) {
			em.persist(t);
		}
		et.commit();
	}

}
