package com.water.Mulbburi.management.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.management.dto.ManagementDTO;

@Mapper
public interface ManagementMapper {

	/* 전체관리 */
	
	int OcheckTotalCount(Map<String, String> searchMap);

	List<ManagementDTO> checkOrderAllList(SelectCriteria selectCriteria);

	List<ManagementDTO> checkOrderDetail();

	ManagementDTO checkOrderDetail(Long orderNo);

	/* 결제관리 */
	
	int PcheckTotalCount(Map<String, String> searchMap);
	
	List<ManagementDTO> checkWaitPayList(SelectCriteria selectCriteria);
	
	List<ManagementDTO> checkCompPayList(SelectCriteria selectCriteria);
	
	void modifyCompPay(String[] orderNo);

	
	int ScheckTotalCount(Map<String, String> searchMap);

	List<ManagementDTO> checkWaitSendList(SelectCriteria selectCriteria);

	List<ManagementDTO> checkWaitRefList(SelectCriteria selectCriteria);

	int RcheckTotalCount(Map<String, String> searchMap);

	int EcheckTotalCount(Map<String, String> searchMap);

	List<ManagementDTO> checkWaitExcList(SelectCriteria selectCriteria);

}
