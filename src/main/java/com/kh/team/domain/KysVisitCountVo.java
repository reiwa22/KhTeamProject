package com.kh.team.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class KysVisitCountVo {
	private int visit_id;
	private String visit_ip;
	private String visit_time;
	
	private int totalCnt;
	private int todayCon;
	//매출
	private int c_num;
	private String u_id;
	private int p_num;
	private String p_name;
	private int p_price;
	private String p_content;
	private int p_count;
	private String title_name;
	private int p_status;
	private String p_date;
	private String o_status;
	private String p_size;
	private String p_main;
	private String p_serve;
	public KysVisitCountVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KysVisitCountVo(int visit_id, String visit_ip, String visit_time, int totalCnt, int todayCon, int c_num,
			String u_id, int p_num, String p_name, int p_price, String p_content, int p_count, String title_name,
			int p_status, String p_date, String o_status, String p_size, String p_main, String p_serve) {
		super();
		this.visit_id = visit_id;
		this.visit_ip = visit_ip;
		this.visit_time = visit_time;
		this.totalCnt = totalCnt;
		this.todayCon = todayCon;
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
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	public String getVisit_ip() {
		return visit_ip;
	}
	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getTodayCon() {
		return todayCon;
	}
	public void setTodayCon(int todayCon) {
		this.todayCon = todayCon;
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
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
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
		return "KysVisitCountVo [visit_id=" + visit_id + ", visit_ip=" + visit_ip + ", visit_time=" + visit_time
				+ ", totalCnt=" + totalCnt + ", todayCon=" + todayCon + ", c_num=" + c_num + ", u_id=" + u_id
				+ ", p_num=" + p_num + ", p_name=" + p_name + ", p_price=" + p_price + ", p_content=" + p_content
				+ ", p_count=" + p_count + ", title_name=" + title_name + ", p_status=" + p_status + ", p_date="
				+ p_date + ", o_status=" + o_status + ", p_size=" + p_size + ", p_main=" + p_main + ", p_serve="
				+ p_serve + "]";
	}
	
	
}
