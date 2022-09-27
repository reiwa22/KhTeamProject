package com.kh.team.lsh.service;

import java.util.List;

import com.kh.team.domain.LshBoardDto;
import com.kh.team.domain.LshBoardVo;

public interface LSH_BoardService {

	public List<LshBoardVo> list(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception;
	
	public LshBoardVo single(int p_num) throws Exception;

	public int getCount(LshBoardDto lshBoardDto, String p_main, String p_serve) throws Exception;
	
	public List<LshBoardVo> relationList(int p_num, String p_serve) throws Exception;
	
	public List<LshBoardVo> getImg(int p_num) throws Exception;
	
	public String getServe(int p_num) throws Exception;
	
	public List<LshBoardVo> getSize(int p_num) throws Exception;
	
}