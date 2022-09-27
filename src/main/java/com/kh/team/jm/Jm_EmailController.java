package com.kh.team.jm;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;


import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.JmEmailDto;

@Controller
@RequestMapping("/email")
public class Jm_EmailController {

	@Inject
	private JavaMailSenderImpl mailSenderImpl;
	
	//비밀번호 찾기 메일
	@RequestMapping(value="/sendPwMail" , method=RequestMethod.POST)
	public String sendPwMail(JmEmailDto jmEmailDto ,RedirectAttributes rttr) throws Exception{
		
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
		mailSenderImpl.send(preparator);
		rttr.addFlashAttribute("to",jmEmailDto.getTo());
		return "/jm/jm_userPw";
	}
	
	
	
	
}
