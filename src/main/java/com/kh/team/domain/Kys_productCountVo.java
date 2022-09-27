package com.kh.team.domain;

import java.util.Arrays;

public class Kys_productCountVo {
	private String p_size;
	private int p_count;
	private int p_num;
	
	public Kys_productCountVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kys_productCountVo(String p_size, int p_count, int p_num) {
		super();
		this.p_size = p_size;
		this.p_count = p_count;
		this.p_num = p_num;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	@Override
	public String toString() {
		return "Kys_productCountVo [p_size=" + p_size + ", p_count=" + p_count + ", p_num=" + p_num + "]";
	}

	
}
