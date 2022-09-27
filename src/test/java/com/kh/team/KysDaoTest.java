package com.kh.team;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.domain.Kys_BoardDto;
import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.kys.dao.KysBoardDao;
import com.kh.team.kys.dao.VisitCountDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class KysDaoTest {
	
	@Inject
	private KysBoardDao boardDao;
	
	@Inject
	private VisitCountDao visitDao; 
	  
	//게시물 리스트
	
	
	//등록 처리 폼
	@Test
	public void boardInsert() throws Exception{
		Kys_BoardVo boardVo = new Kys_BoardVo();
		boardVo.setP_content("상품내용3");
		boardVo.setP_main("상의");
		boardVo.setP_serve("맨투맨");
		boardVo.setP_name("낡은 맨투맨3");
		boardVo.setP_price(152410);
		boardDao.boardInsert(boardVo);
	}
	
	//수정 처리폼
	@Test
	public void testBoardUpdate() throws Exception{
		Kys_BoardVo boardVo = new Kys_BoardVo();
		boardVo.setP_name("맨투맨 제목 수정3");
		boardVo.setP_content("맨투맨 내용수정 3");
		boardVo.setP_price(3333333);
		boardVo.setP_num(1);
		boardDao.boardUpdate(boardVo);
	}
	
	//삭제 
	@Test
	public void boardDelete() throws Exception{
		boardDao.boardDelete(3);
	}
	//삭제 복구
	@Test
	public void restoration() throws Exception{
		boardDao.boardRestoration(1342);
	}
	
	//게시물 보기
	@Test
	public void boardSelectBy() throws Exception{
		boardDao.boardSelectBy(1);
	}
	
	@Test
	public void selectByTow() throws Exception{
		boardDao.selectByTow("S", "SR");
	}
	@Test
	public void visitAll() throws Exception{
	
		visitDao.visitAll();
	}
	@Test
	public void rodChart() throws Exception{
		visitDao.rodChart();
	}

}
