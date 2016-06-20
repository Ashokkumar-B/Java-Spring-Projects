package com.smartlab.library.service;

import com.smartlab.library.model.UserDetails;

public interface LoginService {

	public UserDetails validateUser ( String userName, String password );
}
