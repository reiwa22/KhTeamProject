package com.kh.team.lsh.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.LshBoardDto;
import com.kh.team.domain.LshBoardVo;

@Repository
public class LSH_BoardDaoImpl implements LSH_BoardDao {

	private static final String NAMESPACE = "mappers.lshboard-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<LshBoardVo> list(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("lshBoardDto", lshBoardDto);
		paramMap.put("p_main", p_main);
		paramMap.put("p_serve", p_serve);
		return sqlSession.selectList(NAMESPACE + "list", paramMap);
	}
	
	
	@Override
	public LshBoardVo single(int p_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "single", p_num);
	}


	@Override
	public int getCount(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("lshBoardDto", lshBoardDto);
		paramMap.put("p_main", p_main);
		paramMap.put("p_serve", p_serve);
		return sqlSession.selectOne(NAMESPACE + "getCount", paramMap);
	}


	@Override
	public void updateViewCnt(int p_num) throws Exception {
		sqlSession.update(NAMESPACE + "updateViewCnt", p_num);
	}


	@Override
	public List<LshBoardVo> relationList(int p_num, String p_serve) throws Exception {
		Map<Object, Object> paramMap = new HashMap<>();
		paramMap.put("p_num", p_num);
		paramMap.put("p_serve", p_serve);
		return sqlSession.selectList(NAMESPACE + "relationList", paramMap);
	}


	@Override
	public List<LshBoardVo> getImg(int p_num) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getImg", p_num);
	}


	@Override
	public String getServe(int p_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getServe", p_num);
	}

	@Override
	public List<LshBoardVo> getSize(int p_num) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getSize", p_num);
	}

}
