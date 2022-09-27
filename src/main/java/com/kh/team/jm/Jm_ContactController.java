package com.kh.team.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.JmContactVo;
import com.kh.team.domain.JmPagingDto;
import com.kh.team.domain.JmReviewVo;

@Controller
@RequestMapping("/jm")
public class Jm_ContactController {

	
	@Inject
	private JmContactService jmContactService;
	
	
	//Contact 게시판 리스트 -페이징 
	@RequestMapping(value="/jm_contact" ,method=RequestMethod.GET)
	public String jmContact(JmPagingDto jmPagingDto,  Model model) throws Exception{
		
		jmPagingDto.setPageInfo();
		
		int totalCount = jmContactService.selectCount(jmPagingDto);
		
		jmPagingDto.setTotalCount(totalCount);
		
		List<JmContactVo> list = jmContactService.selectPaging(jmPagingDto);
		System.out.println("jm_Contact, list:" + list);
		System.out.println(jmPagingDto);
		
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);
		return "jm/jm_contact";
		
	}
	
	//Contact 게시판 info 조회
	@RequestMapping(value="/jm_contactInfo/{c_info}", method=RequestMethod.GET)
		public String jmContactInfo(@PathVariable("c_info") int c_info, Model model)throws Exception{
			JmContactVo jmContactVo = jmContactService.selectContactInfo(c_info);
			
			
			model.addAttribute("jmContactVo",jmContactVo);
			return "/jm/jm_contactInfo";
	}
	
	//Contact 게시판 글쓰기 폼
	@RequestMapping(value="/jm_insertContactForm" ,method=RequestMethod.GET)
	public void insertInfoForm()throws Exception{
		
	}
	
	//Contact 게시판 글쓰기 작업
	@RequestMapping(value="/jm_insertContactRun",method=RequestMethod.POST)
	public String insertContactRun(JmContactVo jmContactVo, Model model)throws Exception{
		System.out.println("jm_insertContactRun, jmContact:" + jmContactVo);
		
			jmContactService.insertContact(jmContactVo);
			model.addAttribute("jmContactVo", jmContactVo);
		return "redirect:/jm/jm_contact";
	}
	
	//Contact 게시판 업데이트  폼
	@RequestMapping(value="/jm_updateContact",method=RequestMethod.GET)
	public void updateContactForm(int c_info, Model model )throws Exception{
		
		JmContactVo jmContactVo = jmContactService.selectContactInfo(c_info);
		
		System.out.println("jmContactVo, contact:"+jmContactVo);
		
		
		model.addAttribute("jmContactVo",jmContactVo);
		
	}
	//Contact 게시판 업데이트 런
	@RequestMapping(value="/jm_updateContactRun",method=RequestMethod.POST)
	public String updateContactRun(JmContactVo jmContactVo)throws Exception{
		
		System.out.println("jm_updateContactRun, jmContactVo:" + jmContactVo);
		jmContactService.updateContact(jmContactVo);
		
		return "redirect:/jm/jm_contact";
	}
	
	
	
	
	
	
	
	
	
	
	
}
