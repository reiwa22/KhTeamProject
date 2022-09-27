package com.kh.team.kys.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.Kys_MainVo;
import com.kh.team.domain.Kys_ServeVo;

@Repository
public class KysMainDaoImpl implements KysMainDao {
	
	private final String NAMESPACE = "mappers.kysmain-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<Kys_MainVo> mainList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "mainList");
	}

	@Override
	public Kys_MainVo OenMain(String main_code) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"OenMain",main_code);
	}
	@Override
	public List<Kys_ServeVo> serveList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "serveList");

	}
	//1개 가져오기
	@Override
	public Kys_ServeVo OenServeList(String serve_code) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"OenServeList",serve_code);
		

	}

	@Override
	public List<Kys_MainVo> dress_size(String main_code) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"dress_size",main_code);
	}

}
