package com.water.Mulbburi.order.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.order.DTO.OrderDTO;
import com.water.Mulbburi.order.DTO.OrderItemDTO;

@Mapper
public interface OrderMapper {

	int savedOrder(OrderDTO orderDTO);

	int deleteCart(OrderDTO orderDTO);

	void savedOrderdetail(OrderItemDTO orderItem);

	
}
