package com.kh.team.jm;

import java.util.List;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmPwEmailDto;
import com.kh.team.domain.Kys_BoardVo;

public interface JmMemberService {

	
		//로그인
		public boolean selectMemberUserIdPw(String u_id ,String u_pw) throws Exception;
		
		//세션 등급 가져오기
		public String selectGrade(String u_grade)throws Exception;
		
		
		
		
		//회원 가입
		public void insertMember(JmMemberVo vo) throws Exception;
		
		//관리자 페이지- 일반회원 리스트 조회
		public List<JmMemberVo> selectList() throws Exception;
		
		//관리자 페이지- 일반회원 개인별 조회
		public JmMemberVo selectByid(String u_id)throws Exception;
		
		
		//관리자 페이지- 일반회원 수정
		public void updateUser(JmMemberVo jmMemberVo)throws Exception;
		

		//관리자 페이지- 일반회원 삭제
		public void deleteUser(String u_id)throws Exception;
		

		//Q&A 게시판 관리자 답글달기
		public void contactManagerInsert(JmContactVo jmContactVo)throws Exception;
		
		//관리자 c_originnum 찾기 - Q&A 게시판 관리자 답글 달기  
		public int selectOriginNum(int c_originnum)throws Exception;
		
		//관리자 Q&A 게시판 삭제기능 
		public void deleteContact(int c_info)throws Exception;
		
		
		
		//비밀번호찾기(이메일)
		public JmPwEmailDto selectPw(String u_id)throws Exception;
		
		//아이디중복체크
		public String selectId(String u_id)throws Exception;
		
		
		//글 목록 페이징
		public List<JmMemberVo>selectUserPaging(JmPagingDto jmPagingDto)throws Exception; 
		
		
		//게시글 수 조회
		public int selectUserCount(JmPagingDto jmPagingDto)throws Exception;
		
		
		
		
}
