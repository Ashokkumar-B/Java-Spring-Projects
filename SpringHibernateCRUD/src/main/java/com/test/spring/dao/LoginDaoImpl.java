package com.test.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.spring.orm.User;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	
	public static final Logger log = Logger.getLogger( LoginDaoImpl.class );

	@Autowired
	SessionFactory sessionFactory;
	
	 public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	
	@Override
	public User validateUser(String userName, String password) {
		log.info ( "" );
		Session session = sessionFactory.getCurrentSession ();
		List<?> lUser = session.createQuery("from User where userName = '"+userName +"' and password = '" +password+"'").list();
		return (User) (lUser != null && lUser.size() > 0 ? lUser.get(0) : null);
	}
}
