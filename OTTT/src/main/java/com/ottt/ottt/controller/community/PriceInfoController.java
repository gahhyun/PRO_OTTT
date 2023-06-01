package com.ottt.ottt.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class PriceInfoController {
	//price_info
		@GetMapping(value = "/priceInfoTving")
		public String priceInfoTving() {
				return "/community/price_info/price_tving";		
		}
		
		@GetMapping(value = "/priceInfoCoupang")
		public String priceInfoCoupang() {
				return "/community/price_info/price_coupang";		
		}
		
		@GetMapping(value = "/priceInfoDisney")
		public String priceInfoDisney() {
				return "/community/price_info/price_disneyplus";		
		}
		
		@GetMapping(value = "/priceInfoNetflix")
		public String priceInfoNetflix() {
				return "/community/price_info/price_netflix";		
		}
		
		@GetMapping(value = "/priceInfoWatcha")
		public String priceInfoWatcha() {
				return "/community/price_info/price_watcha";		
		}
		
		@GetMapping(value = "/priceInfoWavve")
		public String priceInfoWavve() {
				return "/community/price_info/price_wavve";		
		}
		
}
