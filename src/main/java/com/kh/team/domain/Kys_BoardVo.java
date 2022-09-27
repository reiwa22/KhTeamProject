package com.kh.team.domain;

import java.util.Arrays;

public class Kys_BoardVo {
	private int p_num;
	private String p_name;
	private String p_content;
	private int p_price;
	private String p_main;
	private String p_serve;
	private String p_deleted;
	private int viewcnt;
	//파일 이미지
	private String[] p_files;
	private String title_name;
	//사이즈 수량
	private String[] p_size;
	private int[] p_count;
	
	
	
	public Kys_BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Kys_BoardVo(int p_num, String p_name, String p_content, int p_price, String p_main, String p_serve,
			String p_deleted, int viewcnt, String[] p_files, String title_name, String[] p_size, int[] p_count) {
		super();
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_price = p_price;
		this.p_main = p_main;
		this.p_serve = p_serve;
		this.p_deleted = p_deleted;
		this.viewcnt = viewcnt;
		this.p_files = p_files;
		this.title_name = title_name;
		this.p_size = p_size;
		this.p_count = p_count;
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



	public String getP_content() {
		return p_content;
	}



	public void setP_content(String p_content) {
		this.p_content = p_content;
	}



	public int getP_price() {
		return p_price;
	}



	public void setP_price(int p_price) {
		this.p_price = p_price;
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



	public String getP_deleted() {
		return p_deleted;
	}



	public void setP_deleted(String p_deleted) {
		this.p_deleted = p_deleted;
	}



	public int getViewcnt() {
		return viewcnt;
	}



	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}



	public String[] getP_files() {
		return p_files;
	}



	public void setP_files(String[] p_files) {
		this.p_files = p_files;
	}



	public String getTitle_name() {
		return title_name;
	}



	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}



	public String[] getP_size() {
		return p_size;
	}



	public void setP_size(String[] p_size) {
		this.p_size = p_size;
	}



	public int[] getP_count() {
		return p_count;
	}



	public void setP_count(int[] p_count) {
		this.p_count = p_count;
	}



	@Override
	public String toString() {
		return "Kys_BoardVo [p_num=" + p_num + ", p_name=" + p_name + ", p_content=" + p_content + ", p_price="
				+ p_price + ", p_main=" + p_main + ", p_serve=" + p_serve + ", p_deleted=" + p_deleted + ", viewcnt="
				+ viewcnt + ", p_files=" + Arrays.toString(p_files) + ", title_name=" + title_name + ", p_size="
				+ Arrays.toString(p_size) + ", p_count=" + Arrays.toString(p_count) + "]";
	}

	




	
	

	
}
