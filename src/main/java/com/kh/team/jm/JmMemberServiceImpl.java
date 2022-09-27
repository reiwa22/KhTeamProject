package com.kh.team.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CjhUserVo;
import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmPwEmailDto;
import com.kh.team.domain.Kys_BoardVo;

@Service
public class JmMemberServiceImpl implements JmMemberService {

	@Inject
	private JmMemberDao jmMemberDao;
	
	//로그인
	@Override
	public boolean selectMemberUserIdPw(String u_id,String u_pw)  throws Exception{
		
		JmMemberVo vo = jmMemberDao.selectMemberUserIdPw(u_id, u_pw);
		System.out.println("loginVo:"+vo);
		if ( vo !=null) {
			return true;
		}
		
		
		return false;
	}
	//회원가입
	@Override
	public void insertMember(JmMemberVo vo) throws Exception{
		System.out.println(vo);
		jmMemberDao.insertMember(vo);

	}
	//관리자페이지- 일반 유저 리스트
	@Override
	public List<JmMemberVo> selectList() throws Exception {
		List<JmMemberVo> list = jmMemberDao.selectList();
		
		return list;
		
	}
	//관리자페이지- 일반 유저 개인별 정보 조회
	@Override
	public JmMemberVo selectByid(String u_id) throws Exception {
		JmMemberVo jmMemberVo = jmMemberDao.selectByid(u_id);
		return jmMemberVo;
	}
	//관리자페이지- 일반 유저 업데이트
	@Override
	public void updateUser(JmMemberVo jmMemberVo) throws Exception {
		jmMemberDao.updateUser(jmMemberVo);
		
	}
	//관리자페이지- 일반 유저 삭제
	@Override
	public void deleteUser(String u_id) throws Exception {
		jmMemberDao.deleteUser(u_id);
		
	}
	//비밀번호 찾기(이메일)
	@Override
	public JmPwEmailDto selectPw(String u_id) throws Exception {
		return jmMemberDao.selectPw(u_id);
	}
	@Override
	public String selectId(String u_id) throws Exception {
		
		return jmMemberDao.selectId(u_id);
	}
	//페이징
	@Override
	public List<JmMemberVo> selectUserPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmMemberVo> list = jmMemberDao.selectUserPaging(jmPagingDto);
		return list;
	}
	//총 게시글 수
	@Override
	public int selectUserCount(JmPagingDto jmPagingDto) throws Exception {
		
		return jmMemberDao.selectUserCount(jmPagingDto);
	}
	@Override
	public String selectGrade(String u_grade) throws Exception {
		
		
		
		return jmMemberDao.selectGrade(u_grade);
	}
	//관리자 Q&A 답글달기
	@Override
	public void contactManagerInsert(JmContactVo jmContactVo) throws Exception {
		jmMemberDao.contactManagerInsert(jmContactVo);
		
	}
	@Override
	public int selectOriginNum(int c_originnum) throws Exception {
		
		return jmMemberDao.selectOriginNum(c_originnum);
	}
	@Override
	public void deleteContact(int c_info) throws Exception {
		jmMemberDao.deleteContact(c_info);
		
	}
	
	

}
