package com.kh.team.kys.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.Kys_MainVo;
import com.kh.team.domain.Kys_ServeVo;
import com.kh.team.kys.dao.KysMainDao;

@Service
public class KysServeServiceImpl implements KysServeService {
	@Inject
	private KysMainDao mainDao;

	@Override
	public List<Kys_ServeVo> serveList() throws Exception {
		 List<Kys_ServeVo> serveList = mainDao.serveList();
		return serveList;

	}

	@Override
	public Kys_ServeVo OenServeList(String serve_code) throws Exception {
		 return null;

	}

	@Override
	public List<Kys_MainVo> mainList() throws Exception {
		List<Kys_MainVo> mainList = mainDao.mainList();
		return mainList;
	}

	@Override
	public Kys_MainVo OenMain(String main_code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kys_MainVo> dress_size(String main_code) throws Exception {
		
		return mainDao.dress_size(main_code);
	}

}
