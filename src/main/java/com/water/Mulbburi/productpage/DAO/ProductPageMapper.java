package com.water.Mulbburi.productpage.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.productpage.DTO.ProductPageDTO;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;

@Mapper
public interface ProductPageMapper {

	ProductPageDTO selectProductPageDetail(int sbNo);

	ProductPageDTO selectProductPageList();

	List<FileDTO> checkAllFile(int sbNo);

	
}
