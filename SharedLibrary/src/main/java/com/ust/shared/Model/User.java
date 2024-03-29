package com.ust.shared.Model;

public class User {
private int id;
	
	private String name;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	private String conpassword;
	private String type;
	public User() {
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getConpassword() {
		return conpassword;
	}
	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User(int id, String name, String username, String password, String email, String address, String phone,
			String conpassword, String type) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.conpassword = conpassword;
		this.type = type;
	}
	

}
