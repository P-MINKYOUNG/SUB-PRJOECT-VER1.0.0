package com.water.Mulbburi.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.consumer.dto.ConsumerDTO;
import com.water.Mulbburi.faq.dto.FaqDTO;
import com.water.Mulbburi.file.FileDTO;

import com.water.Mulbburi.main.MainMapper;

import com.water.Mulbburi.screen.youtube.YoutubeDTO;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainService {

	private final MainMapper mainMapper;

	public MainService(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}

	public Map<String, Object> selectMyYoutube(Map<String, String> searchMap, int page) {

		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 3;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<YoutubeDTO> youtubeList = mainMapper.selectMyYoutube(selectCriteria);

		Map<String, Object> ytListAndPaging = new HashMap<>();
		ytListAndPaging.put("youtubeList", youtubeList);

		return ytListAndPaging;
	}

	public Map<String, Object> selectMyProd(Map<String, String> searchMap, int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 4;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<cartDTO> cartList = mainMapper.selectMyProd(selectCriteria);

		Map<String, Object> pdListAndPaging = new HashMap<>();
		pdListAndPaging.put("prodList", cartList);

		return pdListAndPaging;
	}

	public Map<String, Object> selectMyCom(Map<String, String> searchMap, int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 4;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<CommunityDTO> cmList = mainMapper.selectMyCom(selectCriteria);

		Map<String, Object> cmListAndPaging = new HashMap<>();
		cmListAndPaging.put("cmList", cmList);

		return cmListAndPaging;
	}

	public Map<String, Object> selectMyNotice(Map<String, String> searchMap, int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 7;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<ConsumerDTO> noticeList = mainMapper.selectMyNotice(selectCriteria);

		Map<String, Object> noticeListAndPaging = new HashMap<>();
		noticeListAndPaging.put("noticeList", noticeList);

		return noticeListAndPaging;
	}

	public Map<String, Object> selectMyFAQ(Map<String, String> searchMap, int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 7;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<FaqDTO> faqList = mainMapper.selectMyFAQ(selectCriteria);

		Map<String, Object> faqListAndPaging = new HashMap<>();
		faqListAndPaging.put("faqList", faqList);

		return faqListAndPaging;
	}

	public Map<String, Object> selectMyBanner(Map<String, String> searchMap, int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mainMapper.selectTotalCount(searchMap);

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 3;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<FileDTO> fileList = mainMapper.selectMyFile(selectCriteria);

		Map<String, Object> bannerListAndPaging = new HashMap<>();
		bannerListAndPaging.put("fileList", fileList);
		
		log.info("fileList", fileList);

		return bannerListAndPaging;
	}
}
