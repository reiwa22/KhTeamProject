package com.kh.team;


import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.kys.service.VisitCountService;


@Controller
public class HomeController  {
	
	@Inject
	private VisitCountService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) throws Exception {
		//홈페이지 방문자 카운트
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
//				System.out.println(wac);
				HttpServletRequest req =((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
				KysVisitCountVo vo = new KysVisitCountVo();
				vo.setVisit_ip(req.getRemoteAddr());
				int visitAll = service.visitAll();
				int visitNow = service.visitNow();
				session.setAttribute("visitAll", visitAll);
				session.setAttribute("visitNow", visitNow);
				Enumeration<String> list = session.getAttributeNames();
				//세션에 들어있는 리스트 목록
//				while (list.hasMoreElements()) {
//					String ls = list.nextElement();
//					System.out.println("ls : "+ls);
//				}
				service.insertVisitor(vo);
	

	
		return "home";

	}

	
}
