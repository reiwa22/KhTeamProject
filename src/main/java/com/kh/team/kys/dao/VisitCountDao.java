package com.kh.team.kys.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;

public interface VisitCountDao {
	//홈페이지 방문자
	public void insertVisitor(KysVisitCountVo vo) throws Exception;
	//오늘 방문자
	public int visitNow() throws Exception;
	//총 방문자
	public int visitAll() throws Exception;
	//일별 데이터 가져오기
	public List<KysVisitCountVo> rodChart() throws Exception;
	//일일 매출 데이터
	public List<KysVisitCountVo> salesList() throws Exception;
	//주문목록 가져오기
	public List<KysVisitCountVo> orderList() throws Exception;
	//주문 상태 업뎃
	public void updateStatus(int p_status,int p_num,String u_id) throws Exception;
	

}
