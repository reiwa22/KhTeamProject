package com.kh.team.domain;

public class JmMemberVo {

	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_email;
	private String u_address;
	private String u_phone;
	private int u_info;
	private String u_gender;
	private String u_grade;

	public JmMemberVo() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getU_info() {
		return u_info;
	}

	public void setU_info(int u_info) {
		this.u_info = u_info;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_grade() {
		return u_grade;
	}

	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}

	@Override
	public String toString() {
		return "JmMemberVo [u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_email=" + u_email
				+ ", u_address=" + u_address + ", u_phone=" + u_phone + ", u_info=" + u_info + ", u_gender=" + u_gender
				+ ", u_grade=" + u_grade + "]";
	}

}
