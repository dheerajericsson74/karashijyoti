package com.sashakt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RequestController {
	
	@Value("${welcome.message:test}")
	private String message="Hello World";

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		
		System.out.println(" Called for index Method with mapping '/' ");
		ModelAndView mv = new ModelAndView("home");
		
//		mv.setViewName("welcome");
		mv.addObject("greeting","Hi hello from RequestController");
		
		System.out.println("Returns index Method with mapping '/'  mv.getViewName() ->  "+mv.getViewName());
		return mv;
	}
	
	@RequestMapping(value= {"/welcome"})
	public Model home(@RequestParam(value="name", required=false,defaultValue="World")String name,Model model) {
		System.out.println(" Called for index Method with mapping '/welcome' ");	
		model.addAttribute("name",name);
		model.addAttribute("greeting",this.message);
		
		
		model.asMap().forEach((k,v) -> System.out.println("Item : " + k + " value : " + v));
		System.out.println("Returns index Method with mapping '/welcome' -> welcome string ");
		return model;
	}
	
	 @RequestMapping("/test")
	    public String index1() {
	        return "Greetings from Spring Boot!";
	    }
}
