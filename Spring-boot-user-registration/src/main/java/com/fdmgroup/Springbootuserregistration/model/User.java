package com.fdmgroup.Springbootuserregistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")


@Entity
@Table(name="Spring_JPA_Users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator ="User_Id_Seq")
	@SequenceGenerator(name ="User_Id_Seq", allocationSize=1, initialValue =1)
	private int id;
	
	private String username;
	private String password;
	
	
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}



	

	
	

	

}
