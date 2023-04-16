package com.water.Mulbburi.order.DTO;

import lombok.Data;

@Data
public class OrderItemDTO {
	/* 주문번호 */
	private long orderNo;
	/* 상품번호 */
	private int sbNo;
	/* 주문수량 */
	private int sbCount;
	public void addOrderItem(long orderNo) {
		this.orderNo = orderNo;
		
	}
	
	
	
}
