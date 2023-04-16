package com.water.Mulbburi.community.dto;


import java.util.Date;

import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;

@Data
public class ReplyDTO {

	 private Long no;
	    private Long refBoardNo;
	    private String body;
	    private MemberDTO writer;		            // MemberTable과 join하는 경우 1:1 조인이 될 것이기 때문에 MemberDTO 타입으로 생성
	    private String status;
	    private Date createdDate;
	    public void setWriter(MemberDTO member) {
		
	}
	
	

}
