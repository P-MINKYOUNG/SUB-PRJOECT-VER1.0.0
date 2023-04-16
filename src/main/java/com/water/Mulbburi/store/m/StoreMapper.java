package com.water.Mulbburi.store.m;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.common.paging.SelectCriteria;
import com.water.Mulbburi.screen.youtube.YoutubeDTO;

@Mapper
public interface StoreMapper {

	int selectTotalCount();
	List<MStoreDTO> selectMyDayuk(SelectCriteria selectCriteria);
	List<MStoreDTO> selectMyFlower(SelectCriteria selectCriteria);
	List<MStoreDTO> selectMyTerrarium(SelectCriteria selectCriteria);
	List<MStoreDTO> selectMyHerb(SelectCriteria selectCriteria);
	List<MStoreDTO> selectMyETC(SelectCriteria selectCriteria);

}
