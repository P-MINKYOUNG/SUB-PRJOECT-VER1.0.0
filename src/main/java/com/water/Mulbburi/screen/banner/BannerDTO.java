package com.water.Mulbburi.screen.banner;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.water.Mulbburi.file.FileDTO;

import lombok.Data;

@Data
public class BannerDTO {
	
	private int bannerNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bannerGenDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bannerDelDate;
	private int memberNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bannerPostDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bannerEndDate;
	private List<FileDTO> fileList;

}
