package com.kh.team.cjh.dao;

import java.util.List;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.LshBoardVo;

public interface CjhCartDao {
	
	//	장바구니에 추가
	public void insertCart(String u_id, int p_count, String p_size, LshBoardVo boardVo) throws Exception;

	//	장바구니 불러오기
	public List<CjhCartVo> getCart(String u_id) throws Exception;
	
	//	장바구니 삭제
	public void deleteCart(String u_id, int c_num) throws Exception;
	
	//	선택된 장바구니 삭제
	public void deleteCheckedCart(String u_id, int c_num) throws Exception;
	
	//	장바구니 갯수 불러오기
	public int getCountCart(String u_id) throws Exception;
	
	//	장바구니 갱신
	public void updateCart(String u_id, int p_count, int c_num) throws Exception;
	
	//	장바구니 중복시 갱신
	public void updateDupCart(String u_id, int p_count, String p_size, int p_num);
	
	//	장바구니 주문후 상태변경
	public void orderCartUpdate(String u_id) throws Exception;
	
	//	주문목록 불러오기
	public List<CjhCartVo> getOrder(String u_id, int p_status, CjhPagingDto pagingDto) throws Exception;
	
	//	주문목록 갯수 불러오기
	public int getCountOrder(String u_id, int p_status) throws Exception;
	
	//	장바구니 상품 확인
	public int checkCart(String u_id, String p_size, int p_num) throws Exception;
	
	//	상품 수량 감소
	public void minusCount(int p_num, String p_size, int p_count) throws Exception;
	
	//	배송완료 물품 구매확정하기
	public void comfirmOrder(int c_num) throws Exception;
	
	//	회원이 주문한 상품 갯수 불러오기
	public int getUserOrder(String u_id) throws Exception;
	
	// 상품 개수 구하기
	public int getPCount(int p_num, String p_size) throws Exception;
}
