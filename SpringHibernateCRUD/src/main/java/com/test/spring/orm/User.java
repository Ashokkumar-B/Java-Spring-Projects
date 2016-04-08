package com.test.spring.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "users") 
public class User {

	@Id
	@GeneratedValue
	@Column ( name = "id")
	private int id;
	
	@Column ( name = "user_name")
	private String userName;
	
	@Column ( name = "user_password")
	private String password;
	
	@Column ( name = "user_role")
	private String userrole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}	
	
}
