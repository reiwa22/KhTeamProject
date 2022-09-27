package com.kh.team.domain;

public class CjhUserVo {
	private int u_num;
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_email;
	private String u_address;
	private String u_phone;
	private String u_grade;
	
	public CjhUserVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CjhUserVo(int u_num, String u_id, String u_pw, String u_name, String u_email, String u_address, String u_phone,
			String u_grade) {
		super();
		this.u_num = u_num;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_address = u_address;
		this.u_phone = u_phone;
		this.u_grade = u_grade;
	}

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_grade() {
		return u_grade;
	}

	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}

	@Override
	public String toString() {
		return "UserVo [u_num=" + u_num + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_email="
				+ u_email + ", u_address=" + u_address + ", u_phone=" + u_phone + ", u_grade=" + u_grade + "]";
	}
}
