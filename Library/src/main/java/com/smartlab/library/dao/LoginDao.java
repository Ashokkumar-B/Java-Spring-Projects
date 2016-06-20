package com.smartlab.library.dao;

import com.smartlab.library.orm.User;

public interface LoginDao {

	public User validateUser ( String userName, String password );
}
