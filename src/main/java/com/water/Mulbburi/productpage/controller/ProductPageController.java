package com.water.Mulbburi.productpage.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.water.Mulbburi.member.dto.MemberDTO;
import com.water.Mulbburi.product.dto.ProductDTO;
import com.water.Mulbburi.productpage.DTO.ProductPageDTO;
import com.water.Mulbburi.productpage.service.ProductPageService;


@Controller
@RequestMapping("/product")
public class ProductPageController {

	private final ProductPageService productService;
	
	public ProductPageController(ProductPageService productService) {
		this.productService = productService;

	}
	
	@GetMapping("/list")
	public String productList(Model model) {

		
		
		model.addAttribute("pro",productService.selectProductList());
		System.out.println(model);
		return "productpage/productPage";

	}
	
	
	@GetMapping("/productPage")
	public String selectProductPage(@RequestParam int sbNo, Model model, @ModelAttribute ProductDTO productdto,
			  @AuthenticationPrincipal MemberDTO member) {

		
		ProductPageDTO product = productService.selectProductPageDetail(sbNo);
		Map<String, Object> StoreAndPaging = productService.attachmentList(sbNo);
		model.addAttribute("product", product);
		model.addAttribute("productList", StoreAndPaging.get("attachmentList"));
		
		
		return "productpage/productpage";
	}
	

}
