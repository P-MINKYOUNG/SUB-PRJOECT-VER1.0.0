package com.water.Mulbburi.screen.youtube;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class YoutubeDTO {

	private int ytNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ytWriteDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ytDeleteDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ytPostDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ytEndDate;
	private long memberNo;
	private String ytPath;
	private String ytName;
	
}
