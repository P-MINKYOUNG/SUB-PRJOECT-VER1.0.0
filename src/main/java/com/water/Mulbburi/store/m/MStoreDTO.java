package com.water.Mulbburi.store.m;

import java.util.List;

import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;

@Data
public class MStoreDTO {
	
	private int sbNo;
	private String sbName;
	private int sbPrice;
	private int memberNo;
	private int prodCategoryNo;
	private int sbInventory;
	private String sbStatus;
	private String memberName;

}
