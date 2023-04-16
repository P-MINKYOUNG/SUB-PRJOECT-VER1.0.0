package com.water.Mulbburi.calculator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.water.Mulbburi.calculator.CalculatorMapper;
import com.water.Mulbburi.order.DTO.OrderDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalculatorService {
	
	private final CalculatorMapper calMapper;
	
	public CalculatorService(CalculatorMapper calMapper) {
		this.calMapper = calMapper;
	}
	

	public Map<String, Object> selectAllData(String calDate) {
		
		List<CalculatorDTO> calList = calMapper.selectAllCal(calDate);
		
		Map<String, Object> calculList = new HashMap<>();
		calculList.put("calList", calList);
		
		return calculList;
	}

}
