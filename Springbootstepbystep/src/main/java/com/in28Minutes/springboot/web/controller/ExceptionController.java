package com.in28Minutes.springboot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;


@Controller("error")
public class ExceptionController {
	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex){
		
	logger.error("Request: " + request.getRequestURL() + " raised " + ex);
	ModelAndView mv = new ModelAndView();

	mv.addObject("exception", ex.getLocalizedMessage());
	mv.addObject("url", request.getRequestURL());
	
	mv.setViewName("error");
	return mv;
}

}
