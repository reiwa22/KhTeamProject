package com.kh.team.cjh.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.cjh.dao.CjhCartDao;
import com.kh.team.cjh.dao.CjhUserDao;
import com.kh.team.domain.CjhPointVo;
import com.kh.team.domain.CjhUserVo;

@Service
public class CjhUserServiceImpl implements CjhUserService {
	
	@Inject
	private CjhUserDao userDao;
	
	//	로그인
	@Override
	public boolean login(String u_id, String u_pw) throws Exception {
		CjhUserVo vo = userDao.selectMemberByIdAndPw(u_id, u_pw);
		if (vo != null) {
			return true;
		}
		return false;
	}

	//	내정보 불러오기
	@Override
	public CjhUserVo selectUser(String u_id) throws Exception {
		CjhUserVo userVo = userDao.selectUser(u_id);
		return userVo;
	}

	//	로그인 아이디 확인
	@Override
	public CjhUserVo selectMemberById(String u_id) {
		return userDao.selectMemberById(u_id);
	}

	//	내정보 수정
	@Override
	public void updateUser(CjhUserVo userVo) throws Exception {
		userDao.updateUser(userVo);
	}

	//	회원 탈퇴
	@Override
	public void quitUser(String u_id) throws Exception {
		userDao.quitUser(u_id);
	}

	//	비밀번호 확인
	@Override
	public int checkPw(String u_id, String u_pw) throws Exception {
		return userDao.checkPw(u_id, u_pw);
	}


}
