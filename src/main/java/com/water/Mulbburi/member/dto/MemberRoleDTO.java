package com.water.Mulbburi.member.dto;

import lombok.Data;

@Data
public class MemberRoleDTO {

	private int memberNo;
	private int authorityCode;
	
	private AuthorityDTO authority;
	
}
