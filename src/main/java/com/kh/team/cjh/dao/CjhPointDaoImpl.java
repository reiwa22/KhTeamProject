package com.kh.team.cjh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.CjhPointVo;

@Repository
public class CjhPointDaoImpl implements CjhPointDao {
	
	private static final String NAMESPACE = "mappers.cjhpoint-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	//	회원가입시 포인트 지급 (포인트)
	@Override
	public void signUpPoint(String u_id) throws Exception {
		sqlSession.insert(NAMESPACE + "signUpPoint", u_id);
	}
	
	//	회원가입시 포인트 지금 (유저)
	@Override
	public void signUpUser(String u_id) throws Exception {
		sqlSession.update(NAMESPACE + "signUpUser", u_id);
	}
	
	//	유저의 포인트 차감
	@Override
	public void usePoint(String u_id, int totalPrice) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("totalPrice", totalPrice);
		sqlSession.update(NAMESPACE + "usePoint", paramMap);
	}

	//	유저의 포인트 적립
	@Override
	public void getPoint(String u_id, int totalPrice) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("totalPrice", (int)(totalPrice * 0.01));
		sqlSession.update(NAMESPACE + "getPoint", paramMap);
	}
	
	//	결제시 포인트 차감
	@Override
	public void minusPoint(String u_id, int totalPrice) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("totalPrice", totalPrice);
		sqlSession.selectOne(NAMESPACE + "minusPoint", paramMap);
	}

	//	결제시 포인트 적립
	@Override
	public void plusPoint(String u_id, int totalPrice) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("totalPrice", (int)(totalPrice * 0.01));
		sqlSession.selectOne(NAMESPACE + "plusPoint", paramMap);
	}
	
	//	총 적립 포인트
	@Override
	public int getTotalPoint(String u_id) throws Exception {
		if (sqlSession.selectOne(NAMESPACE + "getTotalPoint", u_id) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(NAMESPACE + "getTotalPoint", u_id);
		}
	}

	//	총 사용 포인트
	@Override
	public int getUsePoint(String u_id) throws Exception {
		if (sqlSession.selectOne(NAMESPACE + "getUsePoint", u_id) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(NAMESPACE + "getUsePoint", u_id);
		}
	}

	//	유저 포인트 목록
	@Override
	public List<CjhPointVo> listPoint(String u_id, int point_code, CjhPagingDto pagingDto) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("point_code", point_code);
		paramMap.put("pagingDto", pagingDto);
		List<CjhPointVo> list = sqlSession.selectList(NAMESPACE + "listPoint", paramMap);
		return list;
	}
	
//	유저 포인트 목록
//	@Override
//	public List<CjhPointVo> listPoint(String u_id, CjhPagingDto pagingDto) throws Exception {
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("u_id", u_id);
//		paramMap.put("pagingDto", pagingDto);
//		List<CjhPointVo> list = sqlSession.selectList(NAMESPACE + "listPoint", paramMap);
//		return list;
//	}

	//	유저 포인트 목록
	@Override
	public int getUserPoint(String u_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getUserPoint", u_id);
	}

	//	포인트 갯수
	@Override
	public int getPointCount(String u_id, int point_code) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("point_code", point_code);
		return sqlSession.selectOne(NAMESPACE + "getPointCount", paramMap);
	}





}
