package com.BackPackerXl.blog.hadner;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class ConntrollException {
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
 @ExceptionHandler(Exception.class)
  public ModelAndView exceptionHander(HttpServletRequest request , Exception e) throws Exception {
	   
	     logger.error("Request URL :{},Exception : {}",request.getRequestURI(),e);
	     if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class) !=null) {
	    	 throw e;
	     }
	     ModelAndView vw = new ModelAndView();
	     vw.addObject("url",request.getRequestURI());
	     vw.addObject("exception", e);
	     vw.setViewName("error/error");
	     return vw;
  }
}
