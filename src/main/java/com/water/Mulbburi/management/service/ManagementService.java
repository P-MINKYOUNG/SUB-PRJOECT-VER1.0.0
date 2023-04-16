package com.water.Mulbburi.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.management.dao.ManagementMapper;
import com.water.Mulbburi.management.dto.ManagementDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ManagementService {

	private final ManagementMapper managementMapper;

	public ManagementService(ManagementMapper managementMapper) {
		this.managementMapper = managementMapper;
	}

	public Map<String, Object> checkOrderAll(Map<String, String> searchMap, int page) {

		int totalCount = managementMapper.OcheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);

		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> orderAll = managementMapper.checkOrderAllList(selectCriteria);
		log.info("[ManagementService] orderAll : {}", orderAll);

		Map<String, Object> orderAllAndPaging = new HashMap<>();
		orderAllAndPaging.put("paging", selectCriteria);
		orderAllAndPaging.put("orderAll", orderAll);
		
		return orderAllAndPaging;

	}

	public ManagementDTO checkOrderDetail(Long orderNo) {
		
		return managementMapper.checkOrderDetail(orderNo);
	}

	public Map<String, Object> checkWaitPay(Map<String, String> searchMap, int page) {

		int totalCount = managementMapper.PcheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);

		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> waitPay = managementMapper.checkWaitPayList(selectCriteria);
		log.info("[ManagementService] waitPay : {}", waitPay);

		Map<String, Object> PaymentAndPaging = new HashMap<>();
		PaymentAndPaging.put("paging", selectCriteria);
		PaymentAndPaging.put("waitPay", waitPay);
		
		return PaymentAndPaging;
	}

	public Map<String, Object> checkCompPay(Map<String, String> searchMap, int page) {

		int totalCount = managementMapper.PcheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);

		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> compPay = managementMapper.checkCompPayList(selectCriteria);
		log.info("[ManagementService] compPay : {}", compPay);

		Map<String, Object> PaymentAndPaging = new HashMap<>();
		PaymentAndPaging.put("paging", selectCriteria);
		PaymentAndPaging.put("compPay", compPay);
		
		return PaymentAndPaging;
	} 
	
	public Map<String, Object> checkWaitSend(Map<String, String> searchMap, int page) {
		
		int totalCount = managementMapper.ScheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);

		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> waitSend = managementMapper.checkWaitSendList(selectCriteria);
		log.info("[ManagementService] waitSend : {}", waitSend);

		Map<String, Object> SendAndPaging = new HashMap<>();
		SendAndPaging.put("paging", selectCriteria);
		SendAndPaging.put("waitSend", waitSend);	
		
		return SendAndPaging;
	}

	public Map<String, Object> checkWaitRef(Map<String, String> searchMap, int page) {

		int totalCount = managementMapper.RcheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);
		
		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> waitRef = managementMapper.checkWaitRefList(selectCriteria);
		log.info("[ManagementService] waitRef : {}", waitRef);

		Map<String, Object> RefundAndPaging = new HashMap<>();
		RefundAndPaging.put("paging", selectCriteria);
		RefundAndPaging.put("waitRef", waitRef);	
		
		return RefundAndPaging;
	}

	public Map<String, Object> checkWaitExc(Map<String, String> searchMap, int page) {

		int totalCount = managementMapper.EcheckTotalCount(searchMap);
		log.info("[ManagementService] totalCount : {}", totalCount);
		
		int limit = 2;
		int buttonAmount = 3;

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[ManagementService] selectCriteria : {}", selectCriteria);

		List<ManagementDTO> waitExc = managementMapper.checkWaitExcList(selectCriteria);
		log.info("[ManagementService] waitExc : {}", waitExc);

		Map<String, Object> ExchangeAndPaging = new HashMap<>();
		ExchangeAndPaging.put("paging", selectCriteria);
		ExchangeAndPaging.put("waitExc", waitExc);
		
		return ExchangeAndPaging;
	}

	public void modifyCompPay(String[] orderNo) {

		managementMapper.modifyCompPay(orderNo);
	  
	}

}

