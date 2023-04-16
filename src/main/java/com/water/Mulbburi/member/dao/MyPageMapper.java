package com.water.Mulbburi.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.member.dto.MemberDetailDTO;
import com.water.Mulbburi.member.dto.MemberExchangeDTO;
import com.water.Mulbburi.member.dto.MemberOrderDTO;
import com.water.Mulbburi.member.dto.MemberRefundDTO;



@Mapper
public interface MyPageMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<MemberOrderDTO> selectOrderList(Long memberNo);

	MemberOrderDTO selectOrderDetail(Long orderNo);

	int insertRefund(MemberRefundDTO refund);

	int insertExchange(MemberExchangeDTO exchange);

	Long selectSbNo(MemberExchangeDTO exchange);

	Long selectDetailOrder(MemberDetailDTO detail);
	
	
	
	
}
