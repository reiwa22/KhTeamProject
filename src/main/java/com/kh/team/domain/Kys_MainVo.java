package com.kh.team.domain;

public class Kys_MainVo {
	private String main_code;
	private String main_name;
	
	private String size_type;
	public Kys_MainVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kys_MainVo(String main_code, String main_name, String size_type) {
		super();
		this.main_code = main_code;
		this.main_name = main_name;
		this.size_type = size_type;
	}



	public String getMain_code() {
		return main_code;
	}
	public void setMain_code(String main_code) {
		this.main_code = main_code;
	}
	public String getMain_name() {
		return main_name;
	}
	public void setMain_name(String main_name) {
		this.main_name = main_name;
	}

	public String getSize_type() {
		return size_type;
	}

	public void setSize_type(String size_type) {
		this.size_type = size_type;
	}

	@Override
	public String toString() {
		return "Kys_MainVo [main_code=" + main_code + ", main_name=" + main_name + ", size_type=" + size_type + "]";
	}
	

}
