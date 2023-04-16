
package com.water.Mulbburi.product.dto;

import java.util.List;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;


@Data
public class ProductDTO {
	

//	private MemberDTO seller;				// 판매자(번호, 이름) - seller.memberNo seller.memberName
	private Long memberNo;					// 판매자(번호, 이름) - seller.memberNo seller.memberName
	private Long sbNo;						// 상품번호
	private String sbName;					// 상품명
	private Long sbPrice;					// 상품가격
	private CategoryDTO prodCategory;		// 카테고리(번호-이름)
	private Long sbIventory;				// 판매수량
	private String sbStatus;				// 상품상태
	private List<FileDTO> attachmentList;	// 사진파일저장
}