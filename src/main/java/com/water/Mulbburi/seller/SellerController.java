package com.water.Mulbburi.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {
	
	@GetMapping("siren")
	public String siren() {
		return "/seller/06-1. sellerSiren";
	}
	
	@GetMapping("accept")
	public String accept() {
		return "/seller/06-2. sellerAccept";
	}
	
	@GetMapping("acceptDetail")
	public String acceptDetail() {
		return "/seller/06-3. sellerAcceptDetail";
	}
	
	@GetMapping("sirenDetail")
	public String sirenDetail() {
		return "/seller/06-4. sellerSirenDetail";
	}
	
}
