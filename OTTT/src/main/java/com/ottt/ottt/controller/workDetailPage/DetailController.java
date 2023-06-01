package com.ottt.ottt.controller.workDetailPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {
	
	@GetMapping(value = "/detailPage")
	public String workDetailPage() {
		return "/workDetailPage/workdetailpage";
	}
	
	@GetMapping(value = "/detailPage/review")
	public String workReview() {
			return "/workDetailPage/review";		
	}
	
	@GetMapping(value = "/detailPage/reply")
	public String reviewReply() {
			return "/workDetailPage/reply";		
	}

}
