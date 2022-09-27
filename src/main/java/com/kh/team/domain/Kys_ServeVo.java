package com.kh.team.domain;

public class Kys_ServeVo {
	private String serve_code;
	private String serve_name;
	private String main_code;
	public Kys_ServeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kys_ServeVo(String serve_code, String serve_name, String main_code) {
		super();
		this.serve_code = serve_code;
		this.serve_name = serve_name;
		this.main_code = main_code;
	}
	public String getServe_code() {
		return serve_code;
	}
	public void setServe_code(String serve_code) {
		this.serve_code = serve_code;
	}
	public String getServe_name() {
		return serve_name;
	}
	public void setServe_name(String serve_name) {
		this.serve_name = serve_name;
	}
	public String getMain_code() {
		return main_code;
	}
	public void setMain_code(String main_code) {
		this.main_code = main_code;
	}
	@Override
	public String toString() {
		return "Kys_ServeVo [serve_code=" + serve_code + ", serve_name=" + serve_name + ", main_code=" + main_code
				+ "]";
	}
	
}
