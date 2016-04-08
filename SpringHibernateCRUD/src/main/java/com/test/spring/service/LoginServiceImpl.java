package com.test.spring.service;

import javax.inject.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.model.UserDetails;
import com.test.spring.orm.User;
import com.test.spring.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger log = Logger.getLogger( LoginServiceImpl.class );

	@Autowired
	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Autowired
    Provider<UserDetails> prototypeServiceProvider;
	
	@Override
	public UserDetails validateUser(String userName, String password) {
		log.info( "" );
		User user = loginDao.validateUser(userName, password);
		UserDetails userDetails = prototypeServiceProvider.get();
		if ( user != null ) {
			BeanUtils.copyProperties ( user, userDetails );
			log.info("userDetails user role is::" +userDetails.getUserrole());
		} else {
			userDetails = null;
		}
		return userDetails;
	}
	
}
