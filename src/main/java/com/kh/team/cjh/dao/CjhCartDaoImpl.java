package com.kh.team.cjh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.LshBoardVo;

@Repository
public class CjhCartDaoImpl implements CjhCartDao {
	
	private static final String NAMESPACE = "mappers.cjhcart-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	//	장바구니 추가하기
	@Override
	public void insertCart(String u_id, int p_count, String p_size, LshBoardVo boardVo) throws Exception {
		int p_num = boardVo.getP_num();
		String p_name = boardVo.getP_name();
		String p_content = boardVo.getP_content();
		int p_price = boardVo.getP_price();
		String p_main = boardVo.getP_main();
		String p_serve = boardVo.getP_serve();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_num", p_num);
		paramMap.put("p_name", p_name);
		paramMap.put("p_content", p_content);
		paramMap.put("p_price", p_price);
		paramMap.put("p_count", p_count);
		paramMap.put("p_size", p_size);
		paramMap.put("p_main", p_main);
		paramMap.put("p_serve", p_serve);
		sqlSession.insert(NAMESPACE + "insertCart", paramMap);
	}

	//	장바구니 불러오기
	@Override
	public List<CjhCartVo> getCart(String u_id) throws Exception {
		List<CjhCartVo> list = sqlSession.selectList(NAMESPACE + "getCart", u_id);
		return list;
	}

	//	장바구니 삭제
	@Override
	public void deleteCart(String u_id, int c_num) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("c_num", c_num);
		sqlSession.delete(NAMESPACE + "deleteCart", paramMap);
	}
	
	//	선택된 장바구니 삭제
	@Override
	public void deleteCheckedCart(String u_id, int c_num) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("c_num", c_num);
		sqlSession.delete(NAMESPACE + "deleteCheckedCart", paramMap);
	}

	//	장바구니 갯수 불러오기
	@Override
	public int getCountCart(String u_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCountCart", u_id);
	}

	//	장바구니 갱신
	@Override
	public void updateCart(String u_id, int p_count, int c_num) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_count", p_count);
		paramMap.put("c_num", c_num);
		sqlSession.update(NAMESPACE + "updateCart", paramMap);
	}
	
	//	장바구니 중복시 갱신
	@Override
	public void updateDupCart(String u_id, int p_count, String p_size, int p_num) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_count", p_count);
		paramMap.put("p_size", p_size);
		paramMap.put("p_num", p_num);
		sqlSession.update(NAMESPACE + "updateDupCart", paramMap);
	}

	//	주문하기 후  장바구니 상태변경
	@Override
	public void orderCartUpdate(String u_id) throws Exception {
		sqlSession.delete(NAMESPACE + "orderCartUpdate", u_id);
	}

	//	주문목록 불러오기
	@Override
	public List<CjhCartVo> getOrder(String u_id, int p_status, CjhPagingDto pagingDto) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_status", p_status);
		paramMap.put("pagingDto", pagingDto);
		return sqlSession.selectList(NAMESPACE + "getOrder", paramMap);
	}
	
	//	주문목록 갯수 구하기
	@Override
	public int getCountOrder(String u_id, int p_status) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_status", p_status);
		return sqlSession.selectOne(NAMESPACE + "getCountOrder", paramMap);
	}

	//	장바구니 상품확인
	@Override
	public int checkCart(String u_id, String p_size, int p_num) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("p_size", p_size);
		paramMap.put("p_num", p_num);
		return sqlSession.selectOne(NAMESPACE + "checkCart", paramMap);
	}

	//	결제시 상품개수 차감
	@Override
	public void minusCount(int p_num, String p_size, int p_count) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("p_size", p_size);
		paramMap.put("p_num", p_num);
		paramMap.put("p_count", p_count);
		sqlSession.update(NAMESPACE + "minusCount", paramMap);
	}

	//	구매확정 버튼
	@Override
	public void comfirmOrder(int c_num) throws Exception {
		sqlSession.update(NAMESPACE + "confirmOrder", c_num);
	}

	//	회원이 주문한 상품 갯수 불러오기
	@Override
	public int getUserOrder(String u_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getUserOrder", u_id);
	}

	//	상품 개수 구하기
	@Override
	public int getPCount(int p_num, String p_size) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("p_num", p_num);
		paramMap.put("p_size", p_size);
		return sqlSession.selectOne(NAMESPACE + "getPCount", paramMap);
	}

}
