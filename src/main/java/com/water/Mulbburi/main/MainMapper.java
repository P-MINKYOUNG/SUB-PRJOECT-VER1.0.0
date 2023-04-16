package com.water.Mulbburi.main;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.consumer.dto.ConsumerDTO;
import com.water.Mulbburi.faq.dto.FaqDTO;
import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.screen.youtube.YoutubeDTO;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;

@Mapper
public interface MainMapper {

	int selectTotalCount(Map<String, String> searchMap);
	List<YoutubeDTO> selectMyYoutube(SelectCriteria selectCriteria);
	List<cartDTO> selectMyProd(SelectCriteria selectCriteria);
	List<CommunityDTO> selectMyCom(SelectCriteria selectCriteria);
	List<FaqDTO> selectMyFAQ(SelectCriteria selectCriteria);
	List<ConsumerDTO> selectMyNotice(SelectCriteria selectCriteria);
	List<FileDTO> selectMyFile(SelectCriteria selectCriteria);

}
