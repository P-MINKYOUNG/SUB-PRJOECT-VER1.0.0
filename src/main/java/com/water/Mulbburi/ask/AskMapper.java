package com.water.Mulbburi.ask;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;

@Mapper
public interface AskMapper {

	int selectTotalCount();
	List<AskDTO> selectAllAsk(SelectCriteria selectCriteria);
	
	AskDTO selectMyEmail(int inquiryNo);

	void updateAnswer(AskDTO askDTO);

}
