package com.water.Mulbburi.faq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.faq.dto.FaqDTO;

@Mapper

public interface FaqMapper {

	int selectTotalCount(Map<String, String> searchMap);

	FaqDTO selectFaqDetail(int no);

	List<FaqDTO> selectFaqList(SelectCriteria selectCriteria);

	void insertFaq(FaqDTO faq);
	
	



}
