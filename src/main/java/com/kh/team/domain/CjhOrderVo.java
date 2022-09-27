package com.kh.team.domain;

import java.sql.Timestamp;

public class CjhOrderVo {
	private int p_num;
	private String u_id;
	private int o_num;
	private int o_status;
	private Timestamp o_date;
	private int p_count;
	private String p_size;
	private String title_name;
	
	public CjhOrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CjhOrderVo(int p_num, String u_id, int o_num, int o_status, Timestamp o_date, int p_count, String p_size,
			String title_name) {
		super();
		this.p_num = p_num;
		this.u_id = u_id;
		this.o_num = o_num;
		this.o_status = o_status;
		this.o_date = o_date;
		this.p_count = p_count;
		this.p_size = p_size;
		this.title_name = title_name;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getO_num() {
		return o_num;
	}

	public void setO_num(int o_num) {
		this.o_num = o_num;
	}

	public int getO_status() {
		return o_status;
	}

	public void setO_status(int o_status) {
		this.o_status = o_status;
	}

	public Timestamp getO_date() {
		return o_date;
	}

	public void setO_date(Timestamp o_date) {
		this.o_date = o_date;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	@Override
	public String toString() {
		return "CjhOrderVo [p_num=" + p_num + ", u_id=" + u_id + ", o_num=" + o_num + ", o_status=" + o_status
				+ ", o_date=" + o_date + ", p_count=" + p_count + ", p_size=" + p_size + ", title_name=" + title_name
				+ "]";
	}

}
