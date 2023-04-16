package com.water.Mulbburi.management.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.water.Mulbburi.management.dto.ManagementDTO;
import com.water.Mulbburi.management.service.ManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/management")
public class ManagementController {
	
	private final ManagementService managementService;
	
	public ManagementController(ManagementService managementService) {
		this.managementService = managementService;
	}

	/* 주문 관리 - 전체 */
	
	@GetMapping("/orderAll")
	public String checkorderAll(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {	

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> orderAllAndPaging = managementService.checkOrderAll(searchMap, page);
		model.addAttribute("paging", orderAllAndPaging.get("paging"));
		model.addAttribute("orderAll", orderAllAndPaging.get("orderAll"));
		
		log.info("[ManagementController] paging : {}", orderAllAndPaging.get("paging"));
		log.info("[ManagementController] orderAll : {}",  orderAllAndPaging.get("orderAll"));
		
		return "management/orderAll";
	}
	
	@GetMapping("/orderDetail")
	public String checkOrderDetail(@RequestParam(required = false) Long orderNo, Model model) {
		
		ManagementDTO orderDetail = managementService.checkOrderDetail(orderNo);
		log.info("[ManagementController] orderDetail : {}", orderDetail);
		
		model.addAttribute("management", orderDetail);
		
		return "management/orderDetail";
	}
	
	/* 주문 관리 - 결제 */
	
	@GetMapping("/waitPay")
	public String waitpay(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> PaymentAndPaging = managementService.checkWaitPay(searchMap, page);
		model.addAttribute("paging", PaymentAndPaging.get("paging"));
		model.addAttribute("waitPay", PaymentAndPaging.get("waitPay"));
		
		log.info("[ManagementController] paging : {}", PaymentAndPaging.get("paging"));
		log.info("[ManagementController] waitPay : {}",  PaymentAndPaging.get("waitPay"));
		
		return "management/waitPay";
	}

	@PostMapping("/compPay")
	public String compleatepay(@RequestParam("orderNo[]") String[] orderNo) throws Exception {

		log.info("{}",Arrays.toString(orderNo));
		
		managementService.modifyCompPay(orderNo);
		   
		return "redirect:/management/compPay";
	}
	
	@GetMapping("/compPay")
	public String comppay(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> PaymentAndPaging = managementService.checkCompPay(searchMap, page);
		model.addAttribute("paging", PaymentAndPaging.get("paging"));
		model.addAttribute("compPay", PaymentAndPaging.get("compPay"));
		
		log.info("[ManagementController] paging : {}", PaymentAndPaging.get("paging"));
		log.info("[ManagementController] compPay : {}",  PaymentAndPaging.get("compPay"));
		
		return "management/compPay";
	}
	
	/*
	@PostMapping("/compPay")
	public String compleatepay(@RequestParam("orderNo[]") String[] orderNo) throws Exception {

		log.info("{}",Arrays.toString(orderNo));
		
		managementService.modifyCompPay(orderNo);
		   
		return "management/compPay";
	}
	 */
	
	/* 주문 관리 - 배송 */
	
	@GetMapping("/waitSend")
	public String waitsend(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {	
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> SendAndPaging = managementService.checkWaitSend(searchMap, page);
		model.addAttribute("paging", SendAndPaging.get("paging"));
		model.addAttribute("waitSend", SendAndPaging.get("waitSend"));
		
		log.info("[ManagementController] paging : {}", SendAndPaging.get("paging"));
		log.info("[ManagementController] waitSend : {}",  SendAndPaging.get("waitSend"));
		
		return "management/waitSend";
	}

	@GetMapping("/compSend")
	public String compsend() {	
		return "management/compSend";
	}
	
	/* 주문 관리 - 환불 */
	
	@GetMapping("/waitRef")
	public String waitrefund(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {	
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> RefundAndPaging = managementService.checkWaitRef(searchMap, page);
		model.addAttribute("paging", RefundAndPaging.get("paging"));
		model.addAttribute("waitRef", RefundAndPaging.get("waitRef"));
		
		log.info("[ManagementController] paging : {}", RefundAndPaging.get("paging"));
		log.info("[ManagementController] waitRef : {}",  RefundAndPaging.get("waitRef"));

		return "management/waitRef";
	}

	@GetMapping("/compRef")
	public String comprefund() {	
		return "management/compRef";
	}
	
	/* 주문 관리 - 교환 */
	
	@GetMapping("/waitExc")
	public String waitexchange(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {	

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		Map<String, Object> ExchangeAndPaging = managementService.checkWaitExc(searchMap, page);
		model.addAttribute("paging", ExchangeAndPaging.get("paging"));
		model.addAttribute("waitExc", ExchangeAndPaging.get("waitExc"));
		
		log.info("[ManagementController] paging : {}", ExchangeAndPaging.get("paging"));
		log.info("[ManagementController] waitExc : {}", ExchangeAndPaging.get("waitExc"));
		
		return "management/waitExc";
	}

	@GetMapping("/compExc")
	public String compexchange() {	
		return "management/compExc";
	}
}