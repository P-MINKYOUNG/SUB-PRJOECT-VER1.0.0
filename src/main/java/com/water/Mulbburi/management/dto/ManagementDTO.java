package com.water.Mulbburi.management.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ManagementDTO {

	/* (전체 관리) 주문날짜 주문번호 고객ID 상품명 총주문수량 총주문금액 */
	
	private Long orderNo;			// 주문번호
	private Date orderDate;			// 주문날짜
	private String orderName;		// 주문자명
	private String memberId;		// 고객ID
	private Long sbNo;				// 상품번호
	private String sbName;			// 상품명
	private Long orderAmount;		// 총주문수량
	private Long orderMoney;		// 총주문금액
	private Long DtorderAmount;		// 상세주문수량
	private Long DtorderMoney;		// 상세주문금액
	private String orderPhone;		// 주문자번호
	private String orderPostCode;	// 우편번호
	private String orderBsAddress;	// 주소
	private String orderDtAddress;	// 상세주소
	
	/* (결제 관리) 주문날짜 주문번호 고객ID 결제번호 입금자명 결제금액 */
	
	private Long payNo;				// 결제번호
	private String payName;			// 입금자명
	private Long payMoney;			// 결제금액
	private String payStatus;		// 입금상태
	
	/* (발송 관리) 주문날짜 주문번호 상품번호 상품명 총상품수량 고객ID 발송번호 */
	
	private Long delNo;				// 발송번호
	
	/* (환불 관리) 주문날짜 주문번호 고객ID 환불번호 사유번호 환불상세사유 은행 계좌번호 환불상태 */
	
	private Long refundNo;			// 환불번호
	private Long reasonNo;			// 사유번호
	private String refundReas;		// 상세사유
	private String refundStatus;	// 환불상태
	private String reasonBank;		// 은행
	private Long reasonAccount;		// 계좌번호
	
	/* (교환 관리) 주문날짜 주문번호 고객ID 교환신청일 교환번호 교환수량 사유번호 교환상세사유 */
	
	private Long excNo;				// 교환번호
	private Date ereptDate;			// 교환날짜
	private Long excQty;			// 교환수량
	private String excReas;			// 교환상세사유
	private String excStatus;			// 교환상태

}
