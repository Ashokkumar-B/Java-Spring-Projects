package com.test.spring.dao;

import com.test.spring.orm.User;

public interface LoginDao {

	public User validateUser ( String userName, String password );
}
