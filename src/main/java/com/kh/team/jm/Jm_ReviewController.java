package com.kh.team.jm;

import java.util.List;

import javax.inject.Inject;

import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

@Controller
@RequestMapping("/jm")
public class Jm_ReviewController {

	
	@Inject
	private JmReviewService jmReviewService;
	
	
	//리뷰 게시판 리스트 -페이징 
	@RequestMapping(value="/jm_reviewForm" ,method=RequestMethod.GET)
	public String jmReviewForm(JmPagingDto jmPagingDto,  Model model) throws Exception{
		
		jmPagingDto.setPageInfo();
		
		int totalCount = jmReviewService.selectCount(jmPagingDto);
		
		jmPagingDto.setTotalCount(totalCount);
		
		List<JmReviewVo> list = jmReviewService.selectPaging(jmPagingDto);
		System.out.println("jm_reviewForm, list:" + list);
		System.out.println(jmPagingDto);
		
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);
		return "jm/jm_reviewForm";
		
	}
	
	//리뷰 게시판 info 조회
	@RequestMapping(value="/jm_reviewInfo/{r_filesinfo}", method=RequestMethod.GET)
		public String jmReviewInfo(@PathVariable("r_filesinfo")  int r_filesinfo, Model model)throws Exception{
			JmReviewVo jmReviewVo = jmReviewService.selectReviewInfo(r_filesinfo);
			
			List<String> images = jmReviewService.selectReviewInfoImage(r_filesinfo);
			System.out.println("images: " + images);
			model.addAttribute("images",images);
			model.addAttribute("jmReviewVo",jmReviewVo);
			return "/jm/jm_reviewInfo";
	}
	
	//리뷰 게시판 글쓰기 폼
	@RequestMapping(value="/jm_insertReviewForm" ,method=RequestMethod.GET)
	public void insertInfoForm()throws Exception{
		
	}
	
	//리뷰 게시판 글쓰기 작업
	@RequestMapping(value="/jm_insertReviewRun",method=RequestMethod.POST)
	public String insertReviewRun(JmReviewVo jmReviewVo, Model model)throws Exception{
		System.out.println("jm_insertReviewRun, jmReviewVo:" + jmReviewVo);
		/*String[] r_files = jmReviewVo.getR_files();
		for (String file : r_files) {
			System.out.println(file);
		}*/
			jmReviewService.insertReview(jmReviewVo);
			model.addAttribute("jmReviewVo", jmReviewVo);
		return "redirect:/jm/jm_reviewForm";
	}
	
	//리뷰 게시판 업데이트  폼
	@RequestMapping(value="/jm_updateReview",method=RequestMethod.GET)
	public void updateReviewForm(int r_info, Model model )throws Exception{
		
		JmReviewVo jmReviewVo = jmReviewService.selectReviewInfo(r_info);
		List<String> images = jmReviewService.selectReviewInfoImage(r_info);
		
		
		
		model.addAttribute("jmReviewVo",jmReviewVo);
		model.addAttribute("images",images);
	}
	//리뷰 게시판 업데이트 런
	@RequestMapping(value="/jm_updateReviewRun",method=RequestMethod.POST)
	public String updateReviewRun(JmReviewVo jmReviewVo)throws Exception{
		
		System.out.println("jm_updateReviewRun, jmReviewVo:" + jmReviewVo);
		jmReviewService.updateReview(jmReviewVo);
		
		return "redirect:/jm/jm_reviewForm";
	}
	
	//리뷰 게시판 삭제 기능
	@RequestMapping(value="/jm_deleteReview/{r_info}",method=RequestMethod.GET)
	public String deleteReview(@PathVariable("r_info")  int r_info)throws Exception{
		jmReviewService.deleteReview(r_info);
		
		return "redirect:/jm/jm_reviewForm";
	}
	
	
	
	
	
	
	
	
	
}
