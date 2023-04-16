package com.water.Mulbburi.ask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AskService {

	private final AskMapper askMapper;

	public AskService(AskMapper askMapper) {
		this.askMapper = askMapper;
	}

	public Map<String, Object> selectAllAsk(int page) {

		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = askMapper.selectTotalCount();

		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 5;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */

		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<AskDTO> askList = askMapper.selectAllAsk(selectCriteria);

		Map<String, Object> askListAndPaging = new HashMap<>();

		askListAndPaging.put("askList", askList);
		askListAndPaging.put("paging", selectCriteria);

		return askListAndPaging;
	}

	public void updateAnswer(AskDTO askDTO) {

		askMapper.updateAnswer(askDTO);
		
	}

//	public Map<String, Object> selectMyInquiry(int inquiryNo) {
//		
//		List<AskDTO> askList = askMapper.selectMyInquiry(inquiryNo);
//		
//		Map<String, Object> askListAnd = new HashMap();
//		
//		askListAnd.put("askList", askList);
//		
//		return askListAnd;	
//	}
}
