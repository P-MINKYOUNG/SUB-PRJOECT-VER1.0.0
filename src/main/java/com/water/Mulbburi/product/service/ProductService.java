package com.water.Mulbburi.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.product.dao.ProductMapper;
import com.water.Mulbburi.product.dto.ProductDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductService {

	private final ProductMapper productMapper;


	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public void registProduct(ProductDTO product) {
	  
		productMapper.prodRegist(product);
		  
		for (FileDTO attachment : product.getAttachmentList()) {
		productMapper.insertFile(attachment); 
		} 
		
	}

	
	public Map<String, Object> checkProducList(int page) {

		
		int totalCount = productMapper.checkProdTotalCount();
		log.info("[ProductService] totalCount : {}", totalCount);
		
		int limit = 4; 
		int buttonAmount = 3;
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[ProductService] selectCriteria : {}", selectCriteria);
		
		List<ProductDTO> productList = productMapper.checkAllproduct(selectCriteria);
		log.info("[ProductService] productList : {}", productList);
		
		Map<String, Object> StoreAndPaging = new HashMap<>();
		StoreAndPaging.put("paging", selectCriteria); 
		StoreAndPaging.put("productList", productList);
		
		return StoreAndPaging;
	}

	public Map<String, Object> attachmentList(int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = productMapper.checkProdTotalCount();

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 3;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<FileDTO> attachmentList = productMapper.checkAllFile(selectCriteria);

		Map<String, Object> StoreAndPaging = new HashMap<>();
		StoreAndPaging.put("attachmentList", attachmentList);
		
		log.info("attachmentList", attachmentList);

		return StoreAndPaging;
	}

		
	
}