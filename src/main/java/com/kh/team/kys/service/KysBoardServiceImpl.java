package com.kh.team.kys.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.Kys_BoardDto;
import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.domain.Kys_ImgVo;
import com.kh.team.domain.Kys_productCountVo;
import com.kh.team.domain.Kys_salesVo;
import com.kh.team.kys.dao.KysBoardDao;

@Service
public class KysBoardServiceImpl implements KysBoardService {
	
	@Inject
	private KysBoardDao boardDao;
	//리스트
	@Override
	public List<Kys_BoardVo> boardList(Kys_BoardDto boardDto) throws Exception {
		List<Kys_BoardVo> list =  boardDao.boardList(boardDto);
		return list;
	}
	//등록
	@Override
	public void boardInsert(Kys_BoardVo boardVo) throws Exception {
		int p_num = boardDao.getNextVal();
		boardVo.setP_num(p_num);
		boardDao.boardInsert(boardVo);
		String title_name = boardVo.getTitle_name();
			boardDao.titleImgFile(title_name, p_num);
		
		String[] files = boardVo.getP_files();
		for (String file_name : files) {
			boardDao.imgFile(file_name, p_num);
		}
		System.out.println("boardVo insert : "+boardVo);
		String[] p = null;
		p = boardVo.getP_size();
		
		if ( p !=null || !p.equals("")) {
		for(int i = 0 ; i < p.length ; i++ ) {
			String[] p_size = boardVo.getP_size();
			int[] p_count = boardVo.getP_count();
			System.out.println("service / insert / p_size : " + p_size);
			System.out.println("service / insert / p_count : " + p_count);
			boardDao.insertProductCount(p_size[i], p_count[i], p_num);
		}
		}
	}
	//수정 처리
	@Override
	public void boardUpdate(Kys_BoardVo boardVo) throws Exception {
		int p_num = boardVo.getP_num();
		boardDao.boardUpdate(boardVo);
		String title_name = boardVo.getTitle_name();
		System.out.println("update / service / vo :"+boardVo);
		boardDao.updateTitleImg(title_name, p_num);
		String[] files = null;
		files = boardVo.getP_files();
		
		if(files != null) {
			for (String file_name : files) {
				boardDao.imgFile(file_name, p_num);
				return;
			}
		}
	}

	@Override
	public void boardDelete(int p_num) throws Exception {
		boardDao.boardDelete(p_num);
	}
	//게시물 1개 불러오기
	@Override
	public Kys_BoardVo boardSelectBy(int p_num) throws Exception {
			return boardDao.boardSelectBy(p_num);
		
	}
	@Override
	public int getCount(Kys_BoardDto boardDto) throws Exception {
		
		return boardDao.getCount(boardDto);
	}
	@Override
	public List<Kys_BoardVo> pageList(Kys_BoardDto boardDto) throws Exception {
		return boardDao.boardListPage(boardDto);
	}
	@Override
	public List<Kys_BoardVo> deleteList(Kys_BoardDto boardDto) throws Exception {
		List<Kys_BoardVo> list = boardDao.deleteList(boardDto);
		return list;
	}
	@Override
	public int getDeleteCount(Kys_BoardDto boardDto) throws Exception {
		
		return boardDao.getDeleteCount(boardDto);
	}
	@Override
	public void boardRestoration(int p_num) throws Exception {
		boardDao.boardRestoration(p_num);
		
	}
	
	@Override
	public void delete(int p_num) throws Exception {
		boardDao.delete(p_num);
		
	}
	@Override
	public List<Kys_ImgVo> imgSelectBy(int p_num) throws Exception {
		List<Kys_ImgVo> listImg = boardDao.imgSelectBy(p_num);
		return listImg;
	}
	@Override
	public void fileImgDelete(String filename) throws Exception {
		 boardDao.fileImgDelete(filename);
		
	}
	@Override
	public List<Kys_productCountVo> selectProductCount(int p_num) throws Exception {
		 List<Kys_productCountVo> prodcutCountList = boardDao.selectProductCount(p_num);
		return prodcutCountList;
	}
	@Override
	public List<CjhCartVo> salesAll(Kys_BoardDto boardDto) throws Exception {
		List<CjhCartVo> list = boardDao.salesAll(boardDto);
//		System.out.println("list service : " +list);
		return list;
	}
	@Override
	public int getSalesCount(Kys_BoardDto boardDto) throws Exception {
		
		return boardDao.getSalesCount(boardDto);
	}
	@Override
	public List<Kys_salesVo> exportToExcel() throws Exception {
		List<Kys_salesVo> list = boardDao.exportToExcel();
		System.out.println("서비스 : " +list);
		return list;
	}
	
}
