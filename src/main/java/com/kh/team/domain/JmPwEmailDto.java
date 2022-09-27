package com.kh.team.domain;

public class JmPwEmailDto {

	private String u_pw;
	private String u_email;
	public JmPwEmailDto() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	@Override
	public String toString() {
		return "JmPwEmailDto [u_pw=" + u_pw + ", u_email=" + u_email + "]";
	}
	
	
	
	
	
}
