package com.kh.team.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

@Service
public class JmContactServiceImpl implements JmContactService {

	@Inject
	private JmContactDao jmContactDao;
	
	
	
	@Override
	public List<JmContactVo> selectContactList() throws Exception {
		List<JmContactVo> list = jmContactDao.selectContactList();
		return list;
	}



	@Override
	public JmContactVo selectContactInfo(int c_info ) throws Exception {
		JmContactVo jmContactVo = jmContactDao.selectContactInfo(c_info);
		
		
		jmContactDao.updateViewCount(c_info);
		
		return jmContactVo;
	}



	@Override
	public void insertContact(JmContactVo jmContactVo) throws Exception {
		
		
		
		
		
		
		jmContactDao.insertContact(jmContactVo);
		
		
			
			
			
		
		
	}



	@Override
	public void updateContact(JmContactVo jmContactVo) throws Exception {
		
		
		
		
		
		jmContactDao.updateContact(jmContactVo);
		
		
		
		
		
		
	}



	




	@Override
	public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmContactVo> list = jmContactDao.selectPaging(jmPagingDto);
		return list;
	}



	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return jmContactDao.selectCount(jmPagingDto);
	}



	



	



	



}
