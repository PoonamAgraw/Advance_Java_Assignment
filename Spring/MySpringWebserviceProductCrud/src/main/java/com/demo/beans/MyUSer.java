package com.demo.beans;

public class MyUSer {
	private String uname;
	private String pass;
	private String role;
	public MyUSer() {
		super();
	}
	public MyUSer(String uname, String pass, String role) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MyUSer [uname=" + uname + ", pass=" + pass + ", role=" + role + "]";
	}
	

}
