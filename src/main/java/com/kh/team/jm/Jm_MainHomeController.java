package com.kh.team.jm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jm")
public class Jm_MainHomeController {

	//about
	@RequestMapping(value="/jm_about" ,method=RequestMethod.GET)
	public void jm_About() throws Exception {
	}   

	
}
