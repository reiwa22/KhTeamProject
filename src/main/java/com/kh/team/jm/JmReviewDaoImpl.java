package com.kh.team.jm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

@Repository
public class JmReviewDaoImpl implements JmReviewDao {

	public static final String NAMESPACE ="mappers.review-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<JmReviewVo> selectReviewList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"selectReviewList");
	}

	@Override
	public JmReviewVo selectReviewInfo(int r_info) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectReviewInfo",r_info);
	}

	@Override
	public void insertReview(JmReviewVo jmReviewVo) throws Exception {
		System.out.println("Dao, jmReviewVo:" + jmReviewVo);
		
		if (jmReviewVo.getR_files() != null && jmReviewVo.getR_files()[0] != null) {
			jmReviewVo.setR_file(jmReviewVo.getR_files()[0]);
		}
		
		sqlSession.insert(NAMESPACE+"insertReview",jmReviewVo);
		
	}

	@Override
	public void updateReview(JmReviewVo jmReviewVo) throws Exception {
		System.out.println("jmReviewVo::::::::::::::update"+jmReviewVo);
		String[] r_files = jmReviewVo.getR_files();
		if (r_files != null && !r_files[0].equals("")) {
			String r_file = r_files[0];
			jmReviewVo.setR_file(r_file);
		}
		
		sqlSession.update(NAMESPACE+"updateReview",jmReviewVo);
		
	}

	@Override
	public void deleteReview(int r_info) throws Exception {
		sqlSession.delete(NAMESPACE+"deleteReview",r_info);
		
	}

	@Override
	public List<JmReviewVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		System.out.println(jmPagingDto);
		List<JmReviewVo> list = sqlSession.selectList(NAMESPACE+"selectPaging",jmPagingDto);
		System.out.println("Dao, list:" + list);
		return list;
	}

	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectCount",jmPagingDto);
	}

	@Override
	public void updateViewCount(int r_info) throws Exception {
		 sqlSession.selectOne(NAMESPACE+"updateViewCount",r_info);
		
	}

	@Override
	public void insertReviewAttach(String r_files, int r_filesinfo) throws Exception {
		
		Map<String, Object> pramMap = new HashMap<>();
		
		pramMap.put("r_files", r_files);
		pramMap.put("r_filesinfo", r_filesinfo);
		
		sqlSession.insert(NAMESPACE+"insertReviewAttach",pramMap);
		
	}

	@Override
	public int getNextVal() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getNextVal");
	}

	@Override
	public List<String> selectReviewInfoImage(int r_filesinfo) throws Exception {
		
		List<String> strList = sqlSession.selectList(NAMESPACE+"selectReviewInfoImage",r_filesinfo);
		return strList;
	}

}
