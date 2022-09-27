package com.kh.team.kys.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.Kys_MainVo;
import com.kh.team.domain.Kys_ServeVo;
import com.kh.team.kys.service.KysServeService;

@Controller
@RequestMapping("/serve")
public class KysServeController {
	
	@Inject
	private KysServeService serveService;
	
	
	//메인 항목
//	@RequestMapping(value = "/manager_main", method = RequestMethod.GET)
//	public String mainList(Model model) throws Exception{
//	
//	
//	}
//	//서브 항목
//	@RequestMapping(value = "/manager_main",method = RequestMethod.GET)
//	public void serveList(Model model) throws Exception{
//
//		
//		
//	}
	
}
