package com.kh.team.kys.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.domain.Kys_BoardDto;
import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.domain.Kys_ImgVo;
import com.kh.team.domain.Kys_productCountVo;
import com.kh.team.domain.Kys_salesVo;


@Repository
public class KysBoardDaoImpl implements KysBoardDao {
	
	private final String NAMESPACE = "mappers.kysboard-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public int getNextVal() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getNextVal");
	}
	
	@Override
	public List<Kys_BoardVo> boardList(Kys_BoardDto boardDto) throws Exception {
		
		return sqlSession.selectList(NAMESPACE +"boardList");
	}
	
	//등록
	@Override
	public void boardInsert(Kys_BoardVo boardVo) throws Exception {
		sqlSession.insert(NAMESPACE + "boardInsert", boardVo);
	}

	@Override
	public void boardUpdate(Kys_BoardVo boardVo) throws Exception {
		sqlSession.update(NAMESPACE+"boardUpdate",boardVo);
	}
	// 삭제
	@Override
	public void boardDelete(int p_num) throws Exception {
		sqlSession.update(NAMESPACE + "boardDelete",p_num);
	}
	//게시물 내용 보기
	@Override
	public Kys_BoardVo boardSelectBy(int p_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardSelectBy",p_num);
	}
	@Override
	public void selectByTow(String p_main, String p_serve) throws Exception {
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("p_main", p_main);
		paraMap.put("p_serve", p_serve);
		sqlSession.selectList(NAMESPACE+"selectByTow",paraMap);
	}
	//게시물 페이징
	@Override
	public List<Kys_BoardVo> boardListPage(Kys_BoardDto boardDto) throws Exception {
		List<Kys_BoardVo> pageList = sqlSession.selectList(NAMESPACE+"boardListPage",boardDto);
		return pageList;
	}
	//삭제처리된 게시물 복구
	@Override
	public List<Kys_BoardVo> deleteList(Kys_BoardDto boardDto) throws Exception {
		return sqlSession.selectList(NAMESPACE+"deleteList",boardDto);
		
	}
	//게시된 게시글 수
		@Override
		public int getCount(Kys_BoardDto boardDto) throws Exception {
			return sqlSession.selectOne(NAMESPACE+"getCount",boardDto);
		
		}
		//삭제된 게시글 수
		@Override
		public int getDeleteCount(Kys_BoardDto boardDto) throws Exception {
			return sqlSession.selectOne(NAMESPACE+"getDeleteCount",boardDto);
		}
		//삭제 복구
		@Override
		public void boardRestoration(int p_num) throws Exception {
			sqlSession.update(NAMESPACE+"boardRestoration",p_num);
		}
		//완전 삭제
		@Override
		public void delete(int p_num) throws Exception {
			sqlSession.delete(NAMESPACE+"delete",p_num);
			
		}
		//이미지 파일 저장
		@Override
		public void imgFile(String file_name, int p_num) throws Exception {
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("file_name", file_name);
			paramMap.put("p_num", p_num);
			sqlSession.insert(NAMESPACE+"imgFile",paramMap);
			
		}

		@Override
		public List<Kys_ImgVo> imgSelectBy(int p_num) throws Exception {
			List<Kys_ImgVo> list = sqlSession.selectList(NAMESPACE+"imgSelectBy",p_num);
			return list;
		}

		@Override
		public void fileImgDelete(String filename) throws Exception {
			sqlSession.delete(NAMESPACE+"fileImgDelete",filename);
			
		}
		//타이틀 이미지
		
		@Override
		public void titleImgFile(String title_name, int p_num) throws Exception {
			Map<String, Object> paramMap= new HashMap<>();
			paramMap.put("title_name", title_name);
			paramMap.put("p_num", p_num);
			sqlSession.insert(NAMESPACE+"titleImgFile",paramMap);
		}

		@Override
		public void insertProductCount(String p_size,int p_count,int p_num) throws Exception {
			Map<String,Object> parammap = new HashMap<>();
			parammap.put("p_size", p_size);
			parammap.put("p_count", p_count);
			parammap.put("p_num", p_num);
			sqlSession.insert(NAMESPACE+"insertProductCount",parammap);
			
			
		}

		@Override
		public List<Kys_productCountVo> selectProductCount(int p_num) throws Exception {
			return 	sqlSession.selectList(NAMESPACE+"selectProductCount",p_num);
		}

		@Override
		public List<CjhCartVo> salesAll(Kys_BoardDto boardDto) throws Exception {
		List<CjhCartVo> pageList = 	sqlSession.selectList(NAMESPACE+"salesAll",boardDto);
//		System.out.println("pageList DAO:"+pageList);
			return pageList;
		}
		//배송현황 검색
		@Override
		public void salesSerch(int p_status) throws Exception {
			
			
		}

		@Override
		public int getSalesCount(Kys_BoardDto boardDto) throws Exception {
			
			return sqlSession.selectOne(NAMESPACE+"getSalesCount",boardDto);
		}

		@Override
		public void updateImgFile(String file_name, int p_num) throws Exception {
			Map<String,Object> parammap = new HashMap<>();
			parammap.put("file_name", file_name);
			parammap.put("p_num", p_num);
			sqlSession.update(NAMESPACE+"updateImgFile",parammap);			
		}

		@Override
		public void updateTitleImg(String title_name, int p_num) throws Exception {
			Map<String,Object> parammap = new HashMap<>();
			parammap.put("title_name", title_name);
			parammap.put("p_num", p_num);
			sqlSession.update(NAMESPACE+"updateTitleImg",parammap);				
		}
		//엑셀
		@Override
		public List<Kys_salesVo> exportToExcel() throws Exception {
			
			return sqlSession.selectList(NAMESPACE+"exportToExcel");
		}

	


}
