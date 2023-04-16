package com.water.Mulbburi.order.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.Mulbburi.member.dto.MemberDTO;
import com.water.Mulbburi.order.DTO.OrderDTO;
import com.water.Mulbburi.order.service.orderService;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;
import com.water.Mulbburi.shoppingcart.service.cartService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private cartService cartService;
	private final orderService orderService;
	
	public OrderController(cartService cartService, orderService orderService) {
		this.cartService = cartService;
		this.orderService = orderService;
	}

	@GetMapping("/order")
	public String getOrder(Model model, @ModelAttribute("cartList") List<cartDTO> cartList) {
		model.addAttribute("cartList",cartList);
		return "order/order";
	}
	
	@PostMapping("/payment")
	public String processPayment(@AuthenticationPrincipal MemberDTO member,
								 @RequestBody OrderDTO order) {
	   
		System.out.println(order);
		order.setMemberNo(member.getMemberNo());
		orderService.saveOrder(order);
		
		
	    return "redirect:/";
	}
	
	
}
