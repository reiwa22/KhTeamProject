package com.kh.team.kys.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.kys.service.VisitCountService;

@RestController
@RequestMapping("/visit")
public class KysVisitCountController  {
	@Inject
	private VisitCountService service;
	
	@RequestMapping(value = "/visitall",method = RequestMethod.GET)
	public void visitAll(HttpSession session) throws Exception{
		
		int totalcnt = service.visitAll();
//		int totalcnt = all.getTotalCnt();
//		System.out.println(totalcnt);
		session.setAttribute("totalcnt", totalcnt);
	}
	@RequestMapping(value = "/rodChart")
	public JSONObject rodChart() throws Exception{
	
		return service.rodChart();
	}
	@RequestMapping(value="/salesList")
	public JSONObject salesList() throws Exception{
		
		return service.salesList();
	}
}
