package com.test.spring.service;

import com.test.spring.model.UserDetails;

public interface LoginService {

	public UserDetails validateUser ( String userName, String password );
}
