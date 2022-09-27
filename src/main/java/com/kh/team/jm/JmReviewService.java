package com.kh.team.jm;

import java.util.List;

import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

public interface JmReviewService {

	
	//리뷰 게시판 목록 조회
	public List<JmReviewVo> selectReviewList() throws Exception;
	
	//리뷰 게시판 info 조회	
	public JmReviewVo selectReviewInfo(int r_info ) throws Exception;
	
	//게시판 글쓰기
	public void insertReview(JmReviewVo jmReviewVo)throws Exception;
	
	// 리뷰 게시판 업데이트 
	public void updateReview(JmReviewVo jmReviewVo)throws Exception;
	
	//리뷰 게시판 삭제기능
	public void deleteReview(int r_info)throws Exception;
	
	//글목록 페이징
	public List<JmReviewVo> selectPaging(JmPagingDto jmPagingDto)throws Exception;
	
	//게시글 수 조회
	public int selectCount(JmPagingDto jmPagingDto)throws Exception;
	
	// 리뷰 게시판 info - 사진 전체 불러오기	
	public List<String> selectReviewInfoImage(int r_filesinfo)throws Exception;
	
	
	
	
	
	
}
