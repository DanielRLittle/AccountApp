package com.qa.app;

import java.util.HashMap;

public interface AccountRepository {
	
	public void add(Account account);
	
	public Account retrieve(Integer id);
}
