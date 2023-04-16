package com.water.Mulbburi.inquiry.controller;



import java.util.HashMap;


import java.util.Map;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.water.Mulbburi.consumer.dto.ConsumerDTO;
import com.water.Mulbburi.consumer.service.ConsumerService;
import com.water.Mulbburi.inquiry.dto.InquiryDTO;
import com.water.Mulbburi.inquiry.service.InquiryService;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/inquiry")

public class InquiryController {
	
	private final InquiryService inquiryService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public InquiryController(InquiryService inquiryService, MessageSourceAccessor messageSourceAccessor) {
	this.inquiryService = inquiryService;	
	this.messageSourceAccessor = messageSourceAccessor;
	}
	
	  @GetMapping("/detail") public String selectFaqDetail(@RequestParam(defaultValue="1") int
			  no, Model model) {
		  
		  InquiryDTO inquiryDetail = inquiryService.selectInquiryDetail(no);
			log.info("[InquiryController] inquiryDetail : {}", inquiryDetail);
			
			model.addAttribute("inquiry", inquiryDetail);
		  
		  
		  
	  return "inquiry/inquiryDetail"; 
	  }
	 
	@GetMapping("/main")
	public String inquirymain(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		
		Map<String, Object> inquiryListAndPaging = inquiryService.selectInquiryList(searchMap, page);
		model.addAttribute("paging", inquiryListAndPaging.get("paging"));
		model.addAttribute("inquiryList", inquiryListAndPaging.get("inquiryList"));
		
		return "inquiry/inquiryList";
	}
	
	@GetMapping("/regist")
	public String regist() {
		
		return "inquiry/inquiryRegist";
		
	}
	/* 게시글 등록 컨트롤러 핸들러 메소드 */
	@PostMapping("/regist")
	public String registInquiry(InquiryDTO inquiry,@AuthenticationPrincipal MemberDTO member,
			RedirectAttributes rttr ) {
		inquiry.setWriter(member);
		log.info("[InquiryController] inquiry : {}", inquiry);
		
		inquiryService.registInquiry(inquiry);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("inquiry.regist"));
		
		return "redirect:/inquiry/main";
		
	}
	

}