package com.ottt.ottt.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.user.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService us;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String home(Model m, HttpServletRequest request, HttpSession session) {
		
		if(session.getAttribute("id") != null) {		

			String user_id = (String) session.getAttribute("id");
			
			try {
				UserDTO userDTO = us.getUser(user_id);
				m.addAttribute(userDTO);			
				
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}
			
		
	return "home";
	}	
	
}