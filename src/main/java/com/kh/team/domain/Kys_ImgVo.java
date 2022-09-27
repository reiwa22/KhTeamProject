package com.kh.team.domain;

public class Kys_ImgVo {
	private String file_name;
	private int p_num;
	private int p_imgnum;
	private String title_name;
	public Kys_ImgVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kys_ImgVo(String file_name, int p_num, int p_imgnum) {
		super();
		this.file_name = file_name;
		this.p_num = p_num;
		this.p_imgnum = p_imgnum;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getP_imgnum() {
		return p_imgnum;
	}
	public void setP_imgnum(int p_imgnum) {
		this.p_imgnum = p_imgnum;
	}
	public String getTitle_name() {
		return title_name;
	}
	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
	@Override
	public String toString() {
		return "Kys_ImgVo [file_name=" + file_name + ", p_num=" + p_num + ", p_imgnum=" + p_imgnum + ", title_name="
				+ title_name + "]";
	}
	

	

}
