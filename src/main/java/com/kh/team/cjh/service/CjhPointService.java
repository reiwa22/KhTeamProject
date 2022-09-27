package com.kh.team.cjh.service;

import java.util.List;

import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.CjhPointVo;

public interface CjhPointService {

	//	회원가입시 포인트 지급 (포인트)
	public void signUpPoint(String u_id) throws Exception;
	
	//	회원가입시 포인트 지급 (유저)
	public void signUpUser(String u_id) throws Exception;
	
	//	포인트 사용
	public void usePoint(String u_id, int totalPrice) throws Exception;
	
	//	유저의 포인트추가
	public void getPoint(String u_id, int totalPrice) throws Exception;
	
	//	결제시 포인트 차감
	public void minusPoint(String u_id, int totalPrice) throws Exception;
	
	//	결제시 포인트 적립
	public void plusPoint(String u_id, int totalPrice) throws Exception;
	
	//	총 적립 포인트
	public int getTotalPoint(String u_id) throws Exception;
	
	//	총 사용 포인트
	public int getUsePoint(String u_id) throws Exception;
	
	//	포인트 정보 불러오기
	public List<CjhPointVo> listPoint(String u_id, int point_code, CjhPagingDto pagingDto) throws Exception;
	
	//	포인트 정보 불러오기
//	public List<CjhPointVo> listPoint(String u_id, CjhPagingDto pagingDto) throws Exception;
	
	//	유저 포인트 정보 불러오기
	public int getUserPoint(String u_id) throws Exception;
	
	//	포인트 갯수
	public int getPointCount(String u_id, int point_code) throws Exception;
	
}
