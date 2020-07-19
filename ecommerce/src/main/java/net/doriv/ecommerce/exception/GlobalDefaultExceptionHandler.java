package net.doriv.ecommerce.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "The page doesn't exist.");
		mav.addObject("errorDescription", "You shouldn't be here.");
		mav.addObject("title", "404 Error page");
		return mav;
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView NotFoundException() {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "It doesn't exist.");
		mav.addObject("errorDescription", "You shouldn't be here.");
		mav.addObject("title", "404 Error page");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "Error.");
		mav.addObject("errorDescription", ex.toString());
		mav.addObject("title", "404 Error page");
		return mav;
	}
}
