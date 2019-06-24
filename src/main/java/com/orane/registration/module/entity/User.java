package com.orane.registration.module.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="master_user")
public class User {
	
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@JoinColumn(name="user_id")
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Address> address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	
	

}
