package com.water.Mulbburi.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.water.Mulbburi.file.FileDTO;

@Mapper
public interface FileMapper {
	
	List<FileDTO> selectAllFile();
	
	/* 파일 업로드 */
	void insertBanner(FileDTO fileDTO);


}
