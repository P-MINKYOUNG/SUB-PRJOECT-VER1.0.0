package com.water.Mulbburi.inquiry.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.faq.dao.FaqMapper;
import com.water.Mulbburi.faq.dto.FaqDTO;
import com.water.Mulbburi.inquiry.dao.InquiryMapper;
import com.water.Mulbburi.inquiry.dto.InquiryDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class InquiryService {
	private final InquiryMapper inquiryMapper;
	public InquiryService(InquiryMapper inquiryMapper) {
		this.inquiryMapper = inquiryMapper;
		
	}
	
public Map<String, Object> selectInquiryList(Map<String, String> searchMap, int page) {
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = inquiryMapper.selectTotalCount(searchMap);
		log.info("[InquiryService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 5;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[InquiryService] selectCriteria : {}", selectCriteria);
		
		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<InquiryDTO> inquiryList = inquiryMapper.selectInquiryList(selectCriteria);
		log.info("[InquiryService] inquiryList : {}", inquiryList);
		
		Map<String, Object>	inquiryListAndPaging = new HashMap<>();
		inquiryListAndPaging.put("paging", selectCriteria);
		inquiryListAndPaging.put("inquiryList", inquiryList);
		
		return inquiryListAndPaging;
	}
public InquiryDTO selectInquiryDetail(int no) {
	/* 2. 게시글 상세 내용 조회 후 리턴 */
	return inquiryMapper.selectInquiryDetail(no);
}
public void registInquiry(InquiryDTO inquiry) {
	
	inquiryMapper.insertInquiry(inquiry);
}
}