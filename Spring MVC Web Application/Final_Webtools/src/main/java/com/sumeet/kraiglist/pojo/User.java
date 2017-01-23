package com.sumeet.kraiglist.pojo;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GenerationType;

@Entity
@Table(name="USER_TABLE", uniqueConstraints = {
		@UniqueConstraint(columnNames = "USERNAME"),
		@UniqueConstraint(columnNames = "HUSKY_ID"),
		@UniqueConstraint(columnNames = "EMAIL")})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID", unique = true, nullable = false, length = 10)
	private long userId;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 30)
	private String lastName;
	
	@Column(name = "HUSKY_ID", unique = true, nullable = false, length = 9)
	private String huskyId;
	
	@Column(name = "EMAIL",unique = true, nullable = false, length = 50)
	private String email;
	
	@Column(name = "PHONE", nullable = false, length = 10)
	private String phone;
	
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@OneToMany(mappedBy="user" , cascade={CascadeType.ALL})
	private Set<Advertisements> advertisements = new HashSet<Advertisements>();

	public User() {

	}
	
	public User(String firstName, String lastName, String huskyId, String email, String phone, String username,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.huskyId = huskyId;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHuskyId() {
		return huskyId;
	}

	public void setHuskyId(String huskyId) {
		this.huskyId = huskyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set<Advertisements> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisements> advertisements) {
		this.advertisements = advertisements;
	}
	
	

}
