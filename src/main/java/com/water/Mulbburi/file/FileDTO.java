package com.water.Mulbburi.file;

import lombok.Data;

@Data
public class FileDTO {

	private int fileNo;
	private String fileoriginalName;
	private String filePath;
	private String fileSavedName;
	private String fileType;
	private int custom;
	private int sbNo;
	private Long memberNo;
	private int communityNo;
	private int reviewNo;
	private int bannerNo;

	/* private MemberDTO seller; */
	
}
