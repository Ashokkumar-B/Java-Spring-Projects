package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.spring.model.UserDetails;
import com.test.spring.service.LoginService;

@Controller
public class LoginController {

	public static final Logger log=Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = {"/","/showLogin"}, method = RequestMethod.GET)
	public String showLogin(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info ("");
		return "loginPage";
	}
	
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public String validateLogin(ModelMap model,HttpServletRequest request,HttpServletResponse response, 
			String userName, String password ) throws Exception {
		log.info("");
		log.info("userName:: " +userName);
		UserDetails userDetails = loginService.validateUser ( userName, password );
		if( userDetails != null ) {
			log.info("Valid Login.Login Success");
			log.info("Valid user name :: " +userDetails.getUserName() );
			model.addAttribute ( "userDetails", userDetails );
			model.addAttribute ("loginStatus", "success");
			return "forward:/home";
		}
		
		model.put("loginStatus", "Invalid Credentials");
		return "loginPage";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout ( Model model, HttpSession session ) throws Exception {
		log.info ("");
		if ( session != null ) {
			session.invalidate();
		}
		model.addAttribute( "loginStatus", "Session expired. Please try again!" );
		return "loginPage";
	}
	
}
