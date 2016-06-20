package com.smartlab.library;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */	
	@RequestMapping(value = {"/home"})
    public String homePage(Model model) {
		logger.info("Entered into home");        
        return "home";
    }
    
    @RequestMapping(value = {"/user"})
    public String userPage(Model model) {
    	logger.info("Entered into user page");        
        return "user";
    }
    
    @RequestMapping(value = {"/admin"})
    public String adminPage(Model model) {
    	logger.info("Entered into admin page");        
        return "admin";
    }
    
    @RequestMapping(value = {"/login"})
	public ModelAndView getLoginForm(
			@RequestParam(required = false) String authfailed, String logout) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		}
		return new ModelAndView("loginPage", "message", message);
	}
    
    @RequestMapping(value = {"/403page"})
    public String errorPage(Model model) {
    	logger.info("Entered into 403 page");        
        return "403page";
    }
    
    @RequestMapping(value = {"/sessionTimeout"})
    public String sessionTimeoutPage(Model model) {
    	logger.info("Entered into session Timeout page");        
        return "sessionTimeout";
    }
	
}
