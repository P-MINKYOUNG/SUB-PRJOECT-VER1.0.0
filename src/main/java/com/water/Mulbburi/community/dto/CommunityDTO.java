package com.water.Mulbburi.community.dto;

import java.util.Date;
import java.util.List;

import com.water.Mulbburi.community.dto.AttachmentDTO;
import com.water.Mulbburi.community.dto.ReplyDTO;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;

@Data

public class CommunityDTO {
	
	private int communityNo;
	private String communityTitle;
	private String communityStory;
	private Date communityWriteDate;
	private Date communityUpdateDate;
	private Date communityDeleteDate;
	private MemberDTO writer;	
	private int custom;	
	private int memberNo;
	private List<ReplyDTO> replyList;
	private List<AttachmentDTO> attachmentList;
	private String memberId;
	

	
	
	
	
	
	
	
	
	
	

}

