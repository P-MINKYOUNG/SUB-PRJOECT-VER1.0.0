package com.water.Mulbburi.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.order.DAO.OrderMapper;
import com.water.Mulbburi.order.DTO.OrderDTO;
import com.water.Mulbburi.order.DTO.OrderItemDTO;

@Service
@Transactional
public class orderService {
	
	private final OrderMapper order;
	
	public orderService(OrderMapper order) {
		this.order = order;
	}

	public void saveOrder(OrderDTO orderDTO) {
		System.out.println(orderDTO);
		order.savedOrder(orderDTO);
		for (OrderItemDTO orderItem : orderDTO.getOrderDetail()) {
	        orderItem.addOrderItem(orderDTO.getOrderNo());
	        order.savedOrderdetail(orderItem);
	    }
		
		order.deleteCart(orderDTO); 
		
	}

}
