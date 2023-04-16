
package com.water.Mulbburi.file;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.file.FileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FileService {

	private final FileMapper fileMapper;
	
	public FileService(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}

	public List<FileDTO> selectFile() {

        return null;

        
    }

	public void registFile(FileDTO fileDTO) {
		
		fileMapper.insertBanner(fileDTO);
		
	}
	
	
	

}
