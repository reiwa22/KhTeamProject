package com.kh.team.jm;



import java.util.Enumeration;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.cjh.service.CjhCartService;
import com.kh.team.cjh.service.CjhPointService;
import com.kh.team.cjh.service.CjhUserService;
import com.kh.team.domain.CjhUserVo;
import com.kh.team.domain.JmEmailDto;
import com.kh.team.domain.JmMemberVo;
import com.kh.team.domain.JmPwEmailDto;

@Controller
@RequestMapping("/jm")
public class Jm_UserController {

	@Inject
	private JmMemberService jmMemberService;
	@Inject
	private CjhUserService userService;
	@Inject
	private CjhCartService cartService;
	@Inject
	private CjhPointService pointService;

	// 로그인 폼
	@RequestMapping(value = "/jm_login", method = RequestMethod.GET)
	public void jmLogin(String targetLocation, HttpSession session) throws Exception {
		System.out.println("targetLocation:" + targetLocation);
		session.setAttribute("targetLocation", targetLocation);
	}

	// 로그인 처리
	@RequestMapping(value = "/jm_login", method = RequestMethod.POST)
	public String jmLoginPost(String u_id, String u_pw,HttpSession session, RedirectAttributes rttr) throws Exception {
		/*System.out.println("jm_login, post");
		session.setAttribute("key1", "val1");*/
		
		boolean result = userService.login(u_id, u_pw);
		int count = cartService.getCountCart(u_id);
		String u_grade = jmMemberService.selectGrade(u_id);
		
		
		if (result == true) {
			//	해당 사용자가 있다면 아이디를 세션에 저장
			session.setAttribute("u_id", u_id);
			session.setAttribute("count", count);
			session.setAttribute("u_grade", u_grade);
			String targetLocation = (String)session.getAttribute("targetLocation");
			if (targetLocation != null && !targetLocation.equals("")) {
				session.removeAttribute("targetLocation");
				return "redirect:" + targetLocation;
			}
			
			Enumeration<String> enumer =  session.getAttributeNames();
			while (enumer.hasMoreElements()) {
				String key = enumer.nextElement();
				System.out.println("key:" + key);
			}
			 
			
			System.out.println("session:::::::::"+session);
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "fail");
		return "redirect:/jm/jm_login";

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String jmlogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/jm/jm_login";
	}

	// 회원가입 폼
	@RequestMapping(value = "/jm_signUp", method = RequestMethod.GET)
	public void jmSignUp() throws Exception {

	}

	@Inject
	private JavaMailSenderImpl mailSender;
	
	// 회원가입 처리
	@RequestMapping(value = "/jm_signUpRun", method = RequestMethod.POST)
	public String jmMemberSignUpRun(JmMemberVo vo ,JmEmailDto jmEmailDto) throws Exception {
		System.out.println("vo:" + vo);
		jmMemberService.insertMember(vo);
		pointService.signUpPoint(vo.getU_id());
		pointService.signUpUser(vo.getU_id()); 
		
		//메일보내기
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"utf-8");
					helper.setFrom(jmEmailDto.getFrom());
					helper.setTo(jmEmailDto.getTo());
					helper.setSubject(jmEmailDto.getSubject());
					helper.setText(jmEmailDto.getContents());
				}
			};
			mailSender.send(preparator);
		
		return "redirect:/jm/jm_login";
	}

	

	
	// 패스워드 찾기 폼 화면
		
		@RequestMapping(value = "/jm_userPw", method = RequestMethod.GET)
		public void userPwView(String u_id) throws Exception {
			
		}
	
	// 패스워드 찾기 데이터(이메일)
	@ResponseBody
	@RequestMapping(value = "/jm_userPwEmail", method = RequestMethod.GET)
	public JmPwEmailDto userPw(String u_id) throws Exception {
		System.out.println("u_id:" + u_id);
		JmPwEmailDto jmPwEmailDto=jmMemberService.selectPw(u_id);
		
		return jmPwEmailDto;

	}
	@ResponseBody
	@RequestMapping(value="/jm_selectIdCheck",method=RequestMethod.GET)
	public String selectId(String u_id)throws Exception{
		
		String id = jmMemberService.selectId(u_id);
		
		if(id !=null) {
			return "success";
		}
		
		
		return "fail";
	}
	
	
	
}
