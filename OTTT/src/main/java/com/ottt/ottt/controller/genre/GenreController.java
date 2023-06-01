package com.ottt.ottt.controller.genre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genre")
public class GenreController {

	@GetMapping("/animation")
	public String animation() {
		return "/genre/animation";
	}
	
	@GetMapping("/drama")
	public String drama() {
		return "/genre/drama";
	}
	
	@GetMapping("/interest")
	public String interest() {
		return "/genre/interest";
	}
	
	@GetMapping("/movie")
	public String movie() {
		return "/genre/movie";
	}
}
