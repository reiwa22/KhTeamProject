package com.kh.team.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

@Service
public class JmReviewServiceImpl implements JmReviewService {

	@Inject
	private JmReviewDao jmReviewDao;
	
	
	
	@Override
	public List<JmReviewVo> selectReviewList() throws Exception {
		List<JmReviewVo> list = jmReviewDao.selectReviewList();
		return list;
	}



	@Override
	public JmReviewVo selectReviewInfo(int r_info ) throws Exception {
		JmReviewVo jmReviewVo = jmReviewDao.selectReviewInfo(r_info);
		
		
		jmReviewDao.updateViewCount(r_info);
		
		return jmReviewVo;
	}



	@Override
	public void insertReview(JmReviewVo jmReviewVo) throws Exception {
		
		int r_info = jmReviewDao.getNextVal();
		
		jmReviewVo.setR_info(r_info);
		
		System.out.println("jmReviewVo:"+jmReviewVo);
		jmReviewDao.insertReview(jmReviewVo);
		
		//attach 에 insert
		
		String[] files = jmReviewVo.getR_files();
		for(String file : files) {
			
			System.out.println("file :"+file);
			System.out.println("r_info :"+ r_info);
			
			jmReviewDao.insertReviewAttach(file, r_info);
			
			
			
		}
		
	}



	@Override
	public void updateReview(JmReviewVo jmReviewVo) throws Exception {
		
		int r_info = jmReviewVo.getR_info();
		System.out.println("r_info service:"+ r_info);
		
		
		
		jmReviewDao.updateReview(jmReviewVo);
		
		String[] files = jmReviewVo.getR_files();
		System.out.println("file service:"+files);
		for(String file: files ) {
			jmReviewDao.insertReviewAttach(file, r_info);
		}
		
		
		
		
	}



	@Override
	public void deleteReview(int r_info) throws Exception {
		jmReviewDao.deleteReview(r_info);
		
	}



	@Override
	public List<JmReviewVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmReviewVo> list = jmReviewDao.selectPaging(jmPagingDto);
		return list;
	}



	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return jmReviewDao.selectCount(jmPagingDto);
	}



	@Override
	public List<String> selectReviewInfoImage(int r_filesinfo) throws Exception {
		
		return jmReviewDao.selectReviewInfoImage(r_filesinfo);
	}



	



	

}
