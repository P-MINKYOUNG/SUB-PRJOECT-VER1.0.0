package com.water.Mulbburi.member.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberExchangeDTO {
	
	private Long excNo;
	private String excReas;
	private String excQty;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ereptDate;
	private Long sbNo;
	private Long orderNo;
	private Long reasonNo;
	private String excStatus;
	
}
