package com.kh.team.jm;

import java.util.List;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmPagingDto;


public interface JmContactDao {

		//리뷰 게시판 목록 조회
		public List<JmContactVo> selectContactList() throws Exception; 
		
		//리뷰 게시판 info 조회	
		public JmContactVo selectContactInfo(int c_info) throws Exception;
		
		//게시판 글쓰기
		public void insertContact(JmContactVo jmContactVo)throws Exception;
		
		// 리뷰 게시판 업데이트 //받는거//파라미터(아규먼트)
		public void updateContact(JmContactVo jmContactVo)throws Exception;
		
			
		//글목록 페이징
		public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto)throws Exception;
		
		//게시글 수 조회
		public int selectCount(JmPagingDto jmPagingDto)throws Exception;
		
		//게시판 조회수 증가
		public void updateViewCount(int c_info)throws Exception;
		
		
		
		
		
	
	
	
	
}
