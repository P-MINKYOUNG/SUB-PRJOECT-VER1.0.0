package com.water.Mulbburi.faq.controller;

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

import com.water.Mulbburi.faq.dto.FaqDTO;
import com.water.Mulbburi.faq.service.FaqService;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/faq")

public class FaqController {
	
	private final FaqService faqService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public FaqController(FaqService faqService, MessageSourceAccessor messageSourceAccessor) {
	this.faqService = faqService;	
	this.messageSourceAccessor = messageSourceAccessor;
	}
	
	
	
	  @GetMapping("/detail") public String selectFaqDetail(@RequestParam(defaultValue="1") int
			  no, Model model) {
		  
		  FaqDTO faqDetail = faqService.selectFaqDetail(no);
			log.info("[FaqController] faqDetail : {}", faqDetail);
			
			model.addAttribute("faq", faqDetail);
		  
		  
		  
	  return "faq/faqDetail"; 
	  }
	 
	@GetMapping("/main")
	public String faqmain(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		
		Map<String, Object> faqListAndPaging = faqService.selectFaqList(searchMap, page);
		model.addAttribute("paging", faqListAndPaging.get("paging"));
		model.addAttribute("faqList", faqListAndPaging.get("faqList"));
		
		return "faq/faqList";
	}
	
	@GetMapping("/regist")
	public String regist() {
		
		return "faq/faqRegist";
		
	}
	
	/* 게시글 등록 컨트롤러 핸들러 메소드 */
	@PostMapping("/regist")
	public String registFaq(FaqDTO faq,@AuthenticationPrincipal MemberDTO member,
			RedirectAttributes rttr ) {
		faq.setWriter(member);
		log.info("[FaqController] faq : {}", faq);
		
		faqService.registFaq(faq);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("faq.regist"));
		
		return "redirect:/faq/main";
		
	}
	

}
