package com.kh.team.jm;


import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmPagingDto;


@Repository
public class JmContactDaoImpl implements JmContactDao {


public static final String NAMESPACE ="mappers.contact-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<JmContactVo> selectContactList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"selectContactList");
	}

	@Override
	public JmContactVo selectContactInfo(int c_info) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectContactInfo",c_info);
	}

	@Override
	public void insertContact(JmContactVo jmContactVo) throws Exception {
		System.out.println("Dao, jmContactVo:" + jmContactVo);
		
		
		
		sqlSession.insert(NAMESPACE+"insertContact",jmContactVo);
		
	}

	@Override
	public void updateContact(JmContactVo jmContactVo) throws Exception {
		System.out.println("jmContactVo::::::::::::::update"+jmContactVo);
		
		
		sqlSession.update(NAMESPACE+"updateContact",jmContactVo);
		
	}

	

	@Override
	public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		System.out.println(jmPagingDto);
		List<JmContactVo> list = sqlSession.selectList(NAMESPACE+"selectPaging",jmPagingDto);
		System.out.println("Dao, list:" + list);
		return list;
	}

	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectCount",jmPagingDto);
	}

	@Override
	public void updateViewCount(int c_info) throws Exception {
		 sqlSession.selectOne(NAMESPACE+"updateViewCount",c_info);
		
	}

	

	

	

}
