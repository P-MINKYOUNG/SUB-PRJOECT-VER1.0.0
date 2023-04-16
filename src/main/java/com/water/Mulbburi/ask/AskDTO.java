package com.water.Mulbburi.ask;

import java.util.Date;

import lombok.Data;

@Data
public class AskDTO {
	
	private int inquiryNo;
	private String inquiryCategory;
	private String inquirySt;
	private String inquiryAnswer;
	private int administratorNo;
	private int memberNo;
	private Date inquiryAskTime;
	private Date inquiryAnswerTime;
	private String inquiryTitle;
	private String email;
	private String memberID;

}
