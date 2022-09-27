package com.kh.team.kys.service;

import java.util.List;

import com.kh.team.domain.Kys_MainVo;
import com.kh.team.domain.Kys_ServeVo;

public interface KysServeService {
	//게시판 소주제 리스트
	public List<Kys_ServeVo> serveList() throws Exception;
	
	//소주제 항목 1개 가져오기
	public Kys_ServeVo OenServeList(String serve_code) throws Exception;
	
	//게시판 소주제 리스트
	public List<Kys_MainVo> mainList() throws Exception;
	
	//소주제 항목 1개 가져오기
	public Kys_MainVo OenMain(String main_code) throws Exception;
	//사이즈 종류
	public List<Kys_MainVo> dress_size(String main_code) throws Exception;
}
