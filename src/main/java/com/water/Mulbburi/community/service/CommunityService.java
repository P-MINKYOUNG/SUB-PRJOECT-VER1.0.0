package com.water.Mulbburi.community.service;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.community.dao.CommunityMapper;
import com.water.Mulbburi.community.dto.AttachmentDTO;
import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.community.dto.ReplyDTO;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CommunityService {
	
	private final CommunityMapper communityMapper;
	
	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	
	
	
public Map<String, Object> selectCommunityList(Map<String, String> searchMap, int page) {
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = communityMapper.selectTotalCount(searchMap);
		log.info("[CommunityService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 10;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[CommunityService] selectCriteria : {}", selectCriteria);
		
		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<CommunityDTO> communityList = communityMapper.selectCommunityList(selectCriteria);
		log.info("[CommunityService] communityList : {}", communityList);
		
		Map<String, Object> communityListAndPaging = new HashMap<>();
		communityListAndPaging.put("paging", selectCriteria);
		communityListAndPaging.put("communityList", communityList);
		
		return communityListAndPaging;
	}

	public CommunityDTO selectCommunityDetail(Long no) {
	
		
		/* 2. 게시글 상세 내용 조회 후 리턴 */
		return communityMapper.selectCommunityDetail(no);
	}

	
	
	
	
	
	
	
	
	
	
	public void registReply(ReplyDTO reply) {
		
		communityMapper.insertReply(reply);
		
	}

	public List<ReplyDTO> loadReply(ReplyDTO reply) {
		
		return communityMapper.selectReplyList(reply);
	}

	public void removeReply(ReplyDTO reply) {
		
		communityMapper.deleteReply(reply);
		
	}


	public void registThumbnail(CommunityDTO community) {
		
		/* 1. Board 테이블에 데이터 저장 */
		communityMapper.insertContent(community);
		
		/* 2. Attachment 테이블에 데이터 저장(첨부된 파일만큼) */
		for(AttachmentDTO attachment : community.getAttachmentList()) {
			communityMapper.insertAttachment(attachment);
		}
		
	}

	public Map<String, Object> selectThumbnailList(int page) {
		
		int totalCount = communityMapper.selectThumbnailTotalCount();
		log.info("[ThumbmailService] totalCount : {}", totalCount);
		
		int limit = 9;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[ThumbmailService] selectCriteria : {}", selectCriteria);
		
		List<CommunityDTO> thumbnailList = communityMapper.selectThumbnailCommunityList(selectCriteria);
		log.info("[ThumbmailService] thumbnailList : {}", thumbnailList);
		
		Map<String, Object> thumbnailListAndPaging = new HashMap<>();
		thumbnailListAndPaging.put("paging", selectCriteria);
		thumbnailListAndPaging.put("thumbnailList", thumbnailList);
		
		return thumbnailListAndPaging;
	}

	public CommunityDTO selectThumbnailDetail(Long no) {
				
		return communityMapper.selectThumbnailCommunityDetail(no);
	}




	public void registCommunity(CommunityDTO community) {
		
		
	}

	
	

	
	
	
	
	
	
	
	
	
	
}