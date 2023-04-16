package com.water.Mulbburi.screen.banner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.water.Mulbburi.common.paging.Pagenation;
import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.file.FileDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BannerService {
	
	private final BannerMapper bnMapper;

	@Autowired
	public BannerService(BannerMapper bnMapper) {
		this.bnMapper = bnMapper;
	}

	public Map<String, Object> selectAllBanner(int page) {
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = bnMapper.selectTotalCount();
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 8;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 3;
				
		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<BannerDTO> bannerList = bnMapper.selectAllBanner(selectCriteria);
		
		Map<String, Object> bnListAndPaging = new HashMap<>();
		bnListAndPaging.put("bannerList", bannerList);
		bnListAndPaging.put("paging", selectCriteria);
		
		log.info("bannerList {]", bnListAndPaging.get("bannerList"));
	
		
		return bnListAndPaging;
	}

	public void insertBanner(BannerDTO bannerDTO) {
		
		/* 1. banner 테이블에 데이터 저장 */
		bnMapper.insertBanner(bannerDTO);
		
		log.info("bannerDTO : {}", bannerDTO);
		log.info("fileList {}", bannerDTO.getFileList());
		
		/* 2. file 테이블에 데이터 저장(첨부된 파일만큼) */
		for(FileDTO attachment : bannerDTO.getFileList()) {
			bnMapper.insertFile(attachment);
		}

	}

}
