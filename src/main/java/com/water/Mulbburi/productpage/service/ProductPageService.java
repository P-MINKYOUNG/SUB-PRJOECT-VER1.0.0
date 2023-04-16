package com.water.Mulbburi.productpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.productpage.DAO.ProductPageMapper;
import com.water.Mulbburi.productpage.DTO.ProductPageDTO;

@Service
public class ProductPageService {

	private final ProductPageMapper productMapper;
	
	public ProductPageService(ProductPageMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public ProductPageDTO selectProductPageDetail(int sbNo) {
		
		return productMapper.selectProductPageDetail(sbNo);
	}

	public ProductPageDTO selectProductList() {
		
		return productMapper.selectProductPageList();
	}

	public Map<String, Object> attachmentList(int sbNo) {
		List<FileDTO> attachmentList = productMapper.checkAllFile(sbNo);

		Map<String, Object> StoreAndPaging = new HashMap<>();
		StoreAndPaging.put("attachmentList", attachmentList);
		return StoreAndPaging;
	}


}