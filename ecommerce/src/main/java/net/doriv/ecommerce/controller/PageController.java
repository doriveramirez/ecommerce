package net.doriv.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("StartMessage","Welcome to the MHP Shop!");
		return mav;
	}
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="StartMessage",required=false)String StartMessage) {
//		if(StartMessage == null) {
//			StartMessage = "Hello";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("StartMessage",StartMessage);
//		return mav;
//	}
//	@RequestMapping(value="/test/{StartMessage}")
//	public ModelAndView test(@PathVariable("StartMessage")String StartMessage) {
//		if(StartMessage == null) {
//			StartMessage = "Hello";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("StartMessage",StartMessage);
//		return mav;
//	}
}