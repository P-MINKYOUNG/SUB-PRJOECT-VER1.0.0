package com.water.Mulbburi.community.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.community.dto.AttachmentDTO;
import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.community.dto.ReplyDTO;

@Mapper

public interface CommunityMapper {

	void insertReply(ReplyDTO reply);

	List<ReplyDTO> selectReplyList(ReplyDTO reply);

	void deleteReply(ReplyDTO reply);

	void insertContent(CommunityDTO community);

	void insertAttachment(AttachmentDTO attachment);

	int selectThumbnailTotalCount();

	List<CommunityDTO> selectThumbnailCommunityList(SelectCriteria selectCriteria);	

	CommunityDTO selectThumbnailCommunityDetail(Long no);

	int selectTotalCount(Map<String, String> searchMap);

	CommunityDTO selectCommunityDetail(Long no);

	List<CommunityDTO> selectCommunityList(SelectCriteria selectCriteria);

	

	
	





}