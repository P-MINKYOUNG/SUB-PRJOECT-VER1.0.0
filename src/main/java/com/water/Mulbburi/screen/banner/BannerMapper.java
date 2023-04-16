package com.water.Mulbburi.screen.banner;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.file.FileDTO;

@Mapper
public interface BannerMapper {

	/* 배너 목록 삽입 */
	int insertBanner(BannerDTO bannerDTO);
	/* 파일 목록 삽입 */
	int insertFile(FileDTO attachment);

	/* 배너 목록 조회 */
	List<BannerDTO> selectAllBanner(SelectCriteria selectCriteria);
	int selectTotalCount();

	

}
