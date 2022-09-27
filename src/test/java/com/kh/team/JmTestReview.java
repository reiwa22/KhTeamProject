package com.kh.team;



import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;
import com.kh.team.jm.JmContactDao;
import com.kh.team.jm.JmContactService;
import com.kh.team.jm.JmMemberService;
import com.kh.team.jm.JmReviewDao;
import com.kh.team.jm.JmReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JmTestReview {

	@Inject
	private JmReviewDao jmReviewDao;
	
	@Inject
	private JmReviewService jmReviewService;
	
	@Inject
	private JmMemberService jmMemberService;
	
	//리뷰게시판 리스트 조회 테스트
	@Test
	public void selectReviewList() throws Exception{
		jmReviewDao.selectReviewList();
	}
	//info 조회 테스트
	@Test
	public void selectList() throws Exception{
		jmReviewService.selectReviewInfo(3);
	}
	
	//게시판 글쓰기
	@Test
	public void insertReview()throws Exception{
		JmReviewVo vo = new JmReviewVo();
		
		vo.setR_id("123");
		vo.setR_subject("123");
		vo.setR_contents("123");
		vo.setR_star(11);
		vo.setR_item(1073);
		
		jmReviewDao.insertReview(vo);
		
	}
	
	// 리뷰 게시판 업데이트
	@Test
	public void updateReview()throws Exception{
		JmReviewVo vo = new JmReviewVo();
		
		
		vo.setR_info(123);
		vo.setR_subject("999");
		vo.setR_contents("999");
		vo.setR_star(11);
		//vo.setR_item(1073);
		
		jmReviewDao.updateReview(vo);
	}
	
	// 리뷰 게시판 업데이트(서비스)
		@Test
		public void updateReviewService()throws Exception{
			JmReviewVo vo = new JmReviewVo();
			
			
			vo.setR_info(123);
			vo.setR_subject("999");
			vo.setR_contents("999");
			vo.setR_star(11);
			//vo.setR_item(1073);
			
			jmReviewService.updateReview(vo);
		}
	
	//삭제 dao
		
		@Test
		public void deleteReview()throws Exception{
			jmReviewDao.deleteReview(32);
		}
		
		
		
		//삭제 service
		@Test
		public void deleteReviewService()throws Exception{
			jmReviewService.deleteReview(31);
		}
		
		
		//글목록 페이징
		@Test
		public void selectPaging()throws Exception{
			
			JmPagingDto jmPagingDto = new JmPagingDto();
			jmPagingDto.setSearchType("r_contents");
			
			
			
		}
		
		@Inject
		private JmContactDao jmContactDao;
		
		@Inject
		private JmContactService jmContactService;
		
		//contact 목록 조회
		@Test
		public void selectContactList() throws Exception{
			jmContactDao.selectContactList();
		}
		
		// contact 목록 조회
		@Test
		public void selectContactLists() throws Exception {
			jmContactService.selectContactList();
		}
		/*//테스트 contactManagerInsert
		@Test
		public void contactManagerInsert() throws Exception {
			
			JmContactVo jmContactVo =new JmContactVo();
			
			jmContactVo.setC_info(489);
			jmContactVo.setC_groupold(12);
			jmContactVo.setC_id("God");
			jmContactVo.setC_subject("하이");
			jmContactVo.setC_contents("안녕");
			
			
			
			jmMemberService.contactManagerInsert(jmContactVo);
		}*/
		
}
