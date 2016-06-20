package com.smartlab.library;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	protected Log log = LogFactory.getLog(this.getClass());

	/*@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		clearAuthenticationAttributes(request);
		
	}

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
        	log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    *//** Builds the target URL according to the logic defined in the main class Javadoc. *//*
    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        if (isUser) {
            return "/user";
        } else if (isAdmin) {
            return "/admin";
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }*/
	
private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		HttpSession session = request.getSession();		
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("uname", authUser.getUsername());  
        session.setAttribute("authorities", authentication.getAuthorities()); 
        
        /*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication);
		log.info("targetUrl value :: "+targetUrl);
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
 
	protected String determineTargetUrl(Authentication authentication) {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        log.info("authorities value :: "+authorities);
        if (authorities.contains("ROLE_ADMIN")) {
        	return "/admin";
        } else if (authorities.contains("ROLE_USER")) {
        	return "/user";
        } else {
            throw new IllegalStateException();
        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

}
