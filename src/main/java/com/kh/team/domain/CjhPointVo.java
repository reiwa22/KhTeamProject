package com.kh.team.domain;

import java.sql.Timestamp;

public class CjhPointVo {
	private int point_num;
	private int point_code;
	private String user_id;
	private int point_value;
	private Timestamp point_date;
	private String point_content;
	
	public CjhPointVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CjhPointVo(int point_num, int point_code, String user_id, int point_value, Timestamp point_date,
			String point_content) {
		super();
		this.point_num = point_num;
		this.point_code = point_code;
		this.user_id = user_id;
		this.point_value = point_value;
		this.point_date = point_date;
		this.point_content = point_content;
	}


	public int getPoint_num() {
		return point_num;
	}

	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}

	public int getPoint_code() {
		return point_code;
	}

	public void setPoint_code(int point_code) {
		this.point_code = point_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPoint_value() {
		return point_value;
	}

	public void setPoint_value(int point_value) {
		this.point_value = point_value;
	}

	public Timestamp getPoint_date() {
		return point_date;
	}

	public void setPoint_date(Timestamp point_date) {
		this.point_date = point_date;
	}
	
	

	public String getPoint_content() {
		return point_content;
	}


	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}


	@Override
	public String toString() {
		return "CjhPointVo [point_num=" + point_num + ", point_code=" + point_code + ", user_id=" + user_id
				+ ", point_value=" + point_value + ", point_date=" + point_date + ", point_content=" + point_content
				+ "]";
	}


}
