package com.kh.team.lsh.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.LshBoardDto;
import com.kh.team.domain.LshBoardVo;
import com.kh.team.lsh.persistence.LSH_BoardDao;

@Service
public class LSH_BoardServiceImpl implements LSH_BoardService {

	@Inject
	private LSH_BoardDao boardDao;

	@Override
	public List<LshBoardVo> list(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception {
		List<LshBoardVo> list = boardDao.list(lshBoardDto, p_main, p_serve);
		return list;
	}
	
	@Override
	public LshBoardVo single(int p_num) throws Exception {
		boardDao.updateViewCnt(p_num);
		LshBoardVo boardVo = boardDao.single(p_num);
		return boardVo;
	}

	@Override
	public int getCount(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception {
		return boardDao.getCount(lshBoardDto, p_main, p_serve);
	}

	@Override
	public List<LshBoardVo> relationList(int p_num, String p_serve) throws Exception {
		return boardDao.relationList(p_num, p_serve);
	}

	@Override
	public List<LshBoardVo> getImg(int p_num) throws Exception {
		List<LshBoardVo> getImgList = boardDao.getImg(p_num);
		return getImgList;
	}

	@Override
	public String getServe(int p_num) throws Exception {
		return boardDao.getServe(p_num);
	}

	@Override
	public List<LshBoardVo> getSize(int p_num) throws Exception {
		return boardDao.getSize(p_num);
	}



}
