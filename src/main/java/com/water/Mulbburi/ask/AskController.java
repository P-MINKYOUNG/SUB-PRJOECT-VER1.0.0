package com.water.Mulbburi.ask;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.water.Mulbburi.ask.AskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AskController {

	private final AskService askService;

	public AskController(AskService askService) {
		this.askService = askService;
	}

	@GetMapping("ask")
	public String askControll() {
		return "ask/12.askControll";
	}

	@GetMapping("askoneAnswer")
	public String oneAnswer() {
		return "/ask/12-4. oneAskAnswer";
	}

	@GetMapping("askone")
	public String askOne(@RequestParam(defaultValue = "1") int page, Model model) {

		Map<String, Object> askListAndPaging = askService.selectAllAsk(page);
		model.addAttribute("paging", askListAndPaging.get("paging"));
		model.addAttribute("askList", askListAndPaging.get("askList"));

		return "ask/12-1. oneAsk";
	}

	   
   @PostMapping("/askoneAnswer")
	   public String updateAnswer(@RequestParam int inquiryNo, Model model, AskDTO askDTO) {
		   
	   		askDTO.setInquiryNo(inquiryNo);
	        askService.updateAnswer(askDTO);
	        
		   return "redirect:askoneAnswer";
	   }
	   

	@GetMapping("notice")
	public String notice() {
		return "ask/12-2. notice";
	}

	@GetMapping("FAQ")
	public String FAQ() {
		return "ask/12-3. FAQ";
	}
}
