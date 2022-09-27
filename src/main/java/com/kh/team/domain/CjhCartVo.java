package com.kh.team.domain;

import java.sql.Timestamp;

public class CjhCartVo {
	
	private int c_num;
	private String u_id;
	private int p_num;
	private String p_name;
	private int p_price;
	private String p_content;
	private int p_count;
	private String title_name;
	private int p_status;
	private Timestamp p_date;
	private String o_status;
	private String p_size;
	private String p_main;
	private String p_serve;
	
	public CjhCartVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CjhCartVo(int c_num, String u_id, int p_num, String p_name, int p_price, String p_content, int p_count,
			String title_name, int p_status, Timestamp p_date, String o_status, String p_size, String p_main,
			String p_serve) {
		super();
		this.c_num = c_num;
		this.u_id = u_id;
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_content = p_content;
		this.p_count = p_count;
		this.title_name = title_name;
		this.p_status = p_status;
		this.p_date = p_date;
		this.o_status = o_status;
		this.p_size = p_size;
		this.p_main = p_main;
		this.p_serve = p_serve;
	}


	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public int getP_status() {
		return p_status;
	}

	public void setP_status(int p_status) {
		this.p_status = p_status;
	}

	public Timestamp getP_date() {
		return p_date;
	}

	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}

	public String getO_status() {
		return o_status;
	}

	public void setO_status(String o_status) {
		this.o_status = o_status;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}
	

	public String getP_main() {
		return p_main;
	}


	public void setP_main(String p_main) {
		this.p_main = p_main;
	}


	public String getP_serve() {
		return p_serve;
	}


	public void setP_serve(String p_serve) {
		this.p_serve = p_serve;
	}


	@Override
	public String toString() {
		return "CjhCartVo [c_num=" + c_num + ", u_id=" + u_id + ", p_num=" + p_num + ", p_name=" + p_name + ", p_price="
				+ p_price + ", p_content=" + p_content + ", p_count=" + p_count + ", title_name=" + title_name
				+ ", p_status=" + p_status + ", p_date=" + p_date + ", o_status=" + o_status + ", p_size=" + p_size
				+ ", p_main=" + p_main + ", p_serve=" + p_serve + "]";
	}



}
