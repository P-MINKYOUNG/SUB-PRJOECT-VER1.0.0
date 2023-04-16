package com.water.Mulbburi.member.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberRefundDTO {
	
	private Long refundNo;
	private Long orderNo;
	private String refundReas;
	private String refundStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date refundStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date refundComDate;
	private Long reasonNo;
	private String reasonBank;
	private String reasonAccount;
	
}
