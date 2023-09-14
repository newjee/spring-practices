package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public String hello02(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello03(String n) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		mav.addObject("name", n);

		return mav;
	}
	@RequestMapping("/hello4")
	public String hello04(String n, Model model) {

		model.addAttribute("name" ,n);
		return "/WEB-INF/views/hello3.jsp";
	}

	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {

		return "<h1>Hello Spring</h1>";
	}

	@RequestMapping("/hello6")
	public String hello6() {

		return "redirect:/hello";
	}

// 이렇게 하지 마세요
	@RequestMapping("/hello7")
	public String hello7(HttpServletRequest request) {

		return "redirect:/hello";
	}
}
