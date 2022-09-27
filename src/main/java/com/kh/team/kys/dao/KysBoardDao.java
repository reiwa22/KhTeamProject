package com.kh.team.kys.dao;

import java.util.List;

import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.domain.Kys_ImgVo;
import com.kh.team.domain.Kys_productCountVo;
import com.kh.team.domain.Kys_salesVo;
import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.domain.Kys_BoardDto;


public interface KysBoardDao {
	
	//p_num 값 가져옴
	public int getNextVal() throws Exception;
	//게시물 리스트
	public List<Kys_BoardVo> boardList(Kys_BoardDto boardDto) throws Exception;
	//게시물 리스트 페이징
	public List<Kys_BoardVo> boardListPage(Kys_BoardDto boardDto) throws Exception;
	//등록 처리 폼
	public void boardInsert(Kys_BoardVo boardVo) throws Exception;
	//수정 처리폼
	public void boardUpdate(Kys_BoardVo boardVo) throws Exception;
	//삭제 처리
	public void boardDelete(int p_num) throws Exception;
	//삭제 복구
	public void boardRestoration(int p_num) throws Exception;
	//완전 삭제
	public void delete(int p_num) throws Exception;
	//게시물 보기
	public Kys_BoardVo boardSelectBy(int p_num) throws Exception;
	//게시물 select bar 검색
	public void selectByTow(String p_main,String p_serve) throws Exception;
	//삭제 처리된 게시물 
	public List<Kys_BoardVo> deleteList(Kys_BoardDto boardDto) throws Exception;
	//게시된 게시글 수
	public int getCount(Kys_BoardDto boardDto) throws Exception;
	//삭제된 게시글 수
	public int getDeleteCount(Kys_BoardDto boardDto) throws Exception;
	//이미지 파일 저장
	public void imgFile(String file_name,int p_num) throws Exception;
	public void titleImgFile(String title_name,int p_num) throws Exception;
	//이미지 파일 수정
	public void updateImgFile(String file_name,int p_num) throws Exception;
	public void updateTitleImg(String title_name,int p_num) throws Exception;
	
	//이미지 보기
	public List<Kys_ImgVo> imgSelectBy(int p_num) throws Exception;
	//이미지 삭제
	public void fileImgDelete(String filename) throws Exception;
	//사이즈 수량 등록
	public void insertProductCount(String p_size,int p_count,int p_num) throws Exception;
	//사이즈 수량 가져오기
	public List<Kys_productCountVo> selectProductCount(int p_num) throws Exception;
	//구매 요청 목록
	public List<CjhCartVo> salesAll(Kys_BoardDto boardDto) throws Exception;
	//배송현황 조회
	public void salesSerch(int p_status) throws Exception;
	
	//배송현황 카운트
	public int getSalesCount(Kys_BoardDto boardDto) throws Exception;
	
	//엑셀 추출
	public List<Kys_salesVo> exportToExcel() throws Exception;
	
	

}
