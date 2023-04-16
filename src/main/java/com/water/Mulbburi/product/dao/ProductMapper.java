package com.water.Mulbburi.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.product.dto.ProductDTO;

@Mapper
public interface ProductMapper {

	
	  /* 상품 삽입 */ 
	  void prodRegist(ProductDTO product);
	  
	  /* 파일 삽입 */
	  void insertFile(FileDTO attachment);
	 
	  /* 전체 목록 조회 */
	  int checkProdTotalCount();
	  List<ProductDTO> checkAllproduct(SelectCriteria selectCriteria);

	  /* 파일 사진 조회 */
	  List<FileDTO> checkAllFile(SelectCriteria selectCriteria);

}
