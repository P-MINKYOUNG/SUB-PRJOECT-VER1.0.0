package com.water.Mulbburi.consumer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.consumer.dto.ConsumerDTO;

@Mapper

public interface ConsumerMapper {
	
	


	public int selectTotalCount(Map<String, String> searchMap);

	public List<ConsumerDTO> selectConsumerList(SelectCriteria selectCriteria);

}
