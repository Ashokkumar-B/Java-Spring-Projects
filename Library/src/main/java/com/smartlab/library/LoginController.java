package com.smartlab.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartlab.library.service.LoginService;

@Controller
public class LoginController {

	public static final Logger log=Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String showLogin(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info ("In Login Controller Home Page");		
        return "loginPage";
	}
	
	/*@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public String validateLogin(ModelMap model,HttpServletRequest request,HttpServletResponse response, 
			String userName, String password) throws Exception {
		
		log.info(" In");
		log.info("userName:: " +userName);
		UserDetails userDetails = loginService.validateUser ( userName, password );
		if( userDetails != null ) {
			log.info("Valid Login.Login Success");
			log.info("Valid user name :: " +userDetails.getUserName() );
			model.addAttribute ( "userDetails", userDetails );
			model.addAttribute ("loginStatus", "success");
			log.info("Valid user role :: " +userDetails.getUserrole());
			if(userDetails.getUserrole().equalsIgnoreCase("ROLE_ADMIN")){
				return "redirect:/admin";				
			} else {
				return "redirect:/user";
			}
		}		
		model.put("loginStatus", "Invalid Credentials");
		return "/admin";
	}*/
	
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
