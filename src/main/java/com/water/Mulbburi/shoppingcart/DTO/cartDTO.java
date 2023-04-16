package com.water.Mulbburi.shoppingcart.DTO;

import java.util.List;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.Data;

@Data
public class cartDTO {

	/* 장바구니 번호 */
	private int pcNo;
	/* 회원번호 */
	private long memberNo;
	/* 상품번호 */
	private int sbNo;
	/* 상품수량 */
	private int pcAmount;
	/* 상품이름 */
	private String sbName;
	/* 상품가격 */
	private int sbPrice;
	/* 총가격 */
	private int totalPrice;
	/* 상품이미지 */
	private List<FileDTO> imageList;
	private String memberName;
	
	public void initTotal() {
		this.totalPrice = this.sbPrice*this.pcAmount;
	}
	
	
	
}
