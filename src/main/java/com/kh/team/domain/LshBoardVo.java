package com.kh.team.domain;

public class LshBoardVo {
	private int p_num;
	private String p_name;
	private String p_content;
	private int p_price;
	private String p_main;
	private String p_serve;
	private int p_viewCnt;

	private String title_name;
	private String file_name;

	private int p_count;
	private String p_size;

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

	public int getP_viewCnt() {
		return p_viewCnt;
	}

	public void setP_viewCnt(int p_viewCnt) {
		this.p_viewCnt = p_viewCnt;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
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

	@Override
	public String toString() {
		return "LshBoardVo [p_num=" + p_num + ", p_name=" + p_name + ", p_content=" + p_content + ", p_price=" + p_price
				+ ", p_main=" + p_main + ", p_serve=" + p_serve + ", p_viewCnt=" + p_viewCnt + ", title_name="
				+ title_name + ", file_name=" + file_name + ", p_count=" + p_count + ", p_size=" + p_size + "]";
	}

}
