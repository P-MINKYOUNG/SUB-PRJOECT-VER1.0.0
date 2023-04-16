package com.water.Mulbburi.inquiry.dto;

import java.util.Date;

import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;

@Data
public class InquiryDTO{

	private int inquiryNo;
	private String inquiryTitle;
	private String inquiryCategory;
	private String content;
	private String inquiryAnswer;
	private int adminstratorNo;
	private int memberNo;
	private Date inquiryAskTime;
	private Date inquiryAnswerTime;
	private int reasonNo;
	private String email;
	public void setWriter(MemberDTO member) {		
	} 
}