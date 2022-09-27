package com.kh.team.domain;

import java.sql.Timestamp;

public class Kys_salesVo {
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
	private String u_address;
	private String u_phone;
	public Kys_salesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kys_salesVo(int c_num, String u_id, int p_num, String p_name, int p_price, String p_content, int p_count,
			String title_name, int p_status, Timestamp p_date, String o_status, String p_size, String p_main,
			String p_serve, String u_address, String u_phone) {
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
		this.u_address = u_address;
		this.u_phone = u_phone;
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
	@Override
	public String toString() {
		return "Kys_salesVo [c_num=" + c_num + ", u_id=" + u_id + ", p_num=" + p_num + ", p_name=" + p_name
				+ ", p_price=" + p_price + ", p_content=" + p_content + ", p_count=" + p_count + ", title_name="
				+ title_name + ", p_status=" + p_status + ", p_date=" + p_date + ", o_status=" + o_status + ", p_size="
				+ p_size + ", p_main=" + p_main + ", p_serve=" + p_serve + ", u_address=" + u_address + ", u_phone="
				+ u_phone + "]";
	}
	
}
