package com.kh.team.kys.service;

import java.util.List;
import java.util.Map;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.Kys_BoardDto;
import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.domain.Kys_ImgVo;
import com.kh.team.domain.Kys_productCountVo;
import com.kh.team.domain.Kys_salesVo;


public interface KysBoardService {
	
	//게시물 리스트
		
	public List<Kys_BoardVo> boardList(Kys_BoardDto boardDto) throws Exception;
		//등록  
		public void boardInsert(Kys_BoardVo boardVo) throws Exception;
		//수정 
		public void boardUpdate(Kys_BoardVo boardVo) throws Exception;
		//삭제 처리
		public void boardDelete(int p_num) throws Exception;
		//삭제 복구
		public void boardRestoration(int p_num) throws Exception;
		//게시물 보기
		public Kys_BoardVo boardSelectBy(int p_num) throws Exception;
		//게시된 게시글 수
		public int getCount(Kys_BoardDto boardDto) throws Exception;
		//게시글 페이징
		public List<Kys_BoardVo> pageList(Kys_BoardDto boardDto) throws Exception;
		//삭제 처리된 게시물 
		public List<Kys_BoardVo> deleteList(Kys_BoardDto boardDto) throws Exception;
		//게시된 게시글 수
		public int getDeleteCount(Kys_BoardDto boardDto) throws Exception;
		//완전 삭제
		public void delete(int p_num) throws Exception;
		//이미지 보기
		public List<Kys_ImgVo> imgSelectBy(int p_num) throws Exception;
		//수정 이미지 삭제
		public void fileImgDelete(String filename) throws Exception;
		//사이즈 수량 가져오기
		public List<Kys_productCountVo> selectProductCount(int p_num) throws Exception;
		//구매 요청 목록
		public List<CjhCartVo> salesAll(Kys_BoardDto boardDto) throws Exception;
		//배송현황 카운트
		public int getSalesCount(Kys_BoardDto boardDto) throws Exception;
		//엑셀추출
		public List<Kys_salesVo> exportToExcel() throws Exception;
}
