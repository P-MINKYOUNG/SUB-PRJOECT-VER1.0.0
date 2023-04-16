package com.water.Mulbburi.inquiry.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.inquiry.dto.InquiryDTO;

@Mapper
public interface InquiryMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<InquiryDTO> selectInquiryList(SelectCriteria selectCriteria);

	InquiryDTO selectInquiryDetail(int no);

	void insertInquiry(InquiryDTO inquiry);


	
}
