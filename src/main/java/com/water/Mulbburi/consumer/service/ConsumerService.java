package com.water.Mulbburi.consumer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.consumer.dao.ConsumerMapper;
import com.water.Mulbburi.consumer.dto.ConsumerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional

public class ConsumerService {
	
	

	private final ConsumerMapper consumerMapper;
	
	
	

	public ConsumerService(ConsumerMapper consumerMapper) {
		this.consumerMapper = consumerMapper;
		
	}
	
public Map<String, Object> selectConsumerList(Map<String, String> searchMap, int page) {
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = consumerMapper.selectTotalCount(searchMap);
		log.info("[ConsuService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 8;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ConsumerService] selectCriteria : {}", selectCriteria);
		
		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<ConsumerDTO> consumerList = consumerMapper.selectConsumerList(selectCriteria);
		log.info("[ConsumerService] consumerList : {}", consumerList);
		
		Map<String, Object>	consumerListAndPaging = new HashMap<>();
		consumerListAndPaging.put("paging", selectCriteria);
		consumerListAndPaging.put("consumerList", consumerList);
		
		return consumerListAndPaging;
	}
	
	
	
}
