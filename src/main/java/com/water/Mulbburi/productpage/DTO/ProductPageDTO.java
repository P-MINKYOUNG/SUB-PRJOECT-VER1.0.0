package com.water.Mulbburi.productpage.DTO;

import java.util.List;

import com.water.Mulbburi.file.FileDTO;

import lombok.Data;

@Data
public class ProductPageDTO {

	/* 상품 번호 */
	private int sbNo;
	/* 상품 이름 */
	private String sbName;
	/* 상품 가격 */
	private int sbPrice;
	/* 상품 카테고리 */
	private int prodCategoryNo;
	/* 상품 상태 */
	private String sbStatus;
	/* 상품 이미지 */
	private List<FileDTO> fileList;
	/* 판매자 번호 */
	private long memberNo;
	/* 판매업체 이름 */
	private String sellerName;
	/* 회원 상세주소 */
	private String dtAddress;
	/* 회원 기본주소 */
	private String bsAddress;
	/* 회원 우편번호 */
	private String postCode;
	/* 판매자 전화번호 */
	private String phone;
	/* 판매자 이메일 */
	private String email;
	/* 판매자 이름 */
	private String memberName;
	/* 판매자 사업자 번호 */
	private String businessNo;
}
