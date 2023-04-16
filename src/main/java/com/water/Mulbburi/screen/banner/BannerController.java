package com.water.Mulbburi.screen.banner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.water.Mulbburi.file.FileDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BannerController {

	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final BannerService bnService;

	@Autowired
	public BannerController(BannerService bnService) {
		this.bnService = bnService;
	}

	@GetMapping("/banner")
	public String banner() {
		return "screen/08-1. bannerControll";
	}

	/* 저장할 배너 목록 삽입 */
	@PostMapping("regist/banner")
	public String insertYoutube(@ModelAttribute BannerDTO bannerDTO, List<MultipartFile> attachImage) {

		/*파일 업로드*/
		String fileUploadDir = IMAGE_DIR + "original";
		
		File dir1 = new File(fileUploadDir);
		
		/* 디렉토리가 없을 경우 생성 */
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		
		List<FileDTO> attachmentList = new ArrayList<>();
		log.info("attachmentList {}", attachmentList);
		
			try {
				for (int i = 0; i < attachImage.size(); i++) {
					if (attachImage.get(i).getSize() > 0) {

						String originalFileName = attachImage.get(i).getOriginalFilename();
						
						String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
						String savedFileName = UUID.randomUUID().toString() + ext;

						/* 서버의 설정 디렉토리에 파일 저장하기 */
						attachImage.get(i).transferTo(new File(fileUploadDir + "/" + savedFileName));
						
						/* DB에 저장할 파일의 정보 처리 */
						FileDTO fileInfo = new FileDTO();
						fileInfo.setFileoriginalName(originalFileName);
						fileInfo.setFileSavedName(savedFileName);
						fileInfo.setFilePath("/upload/original/" + savedFileName);
						
						attachmentList.add(fileInfo);
					}
				}
				
				
				bannerDTO.setFileList(attachmentList);

				bnService.insertBanner(bannerDTO);
				
			} catch (Exception e) {
				e.printStackTrace();
				
				 /* 실패 시 이미 저장 된 파일을 삭제한다. */
				  for(FileDTO attachment : attachmentList) {
				  
				  File deleteFile = new File(attachment.getFilePath() + "/" +
				  attachment.getFileSavedName());
				  
				  deleteFile.delete(); }
				 
			}
		
		return "redirect:/banner";
	}
	
	/* 배너 목록 조회 */
	@GetMapping("screen/08-4. bannerList")
	public String selectAllYoutube(@RequestParam(defaultValue="1") int page, 
				                   @RequestParam(required=false) String searchCondition, 
				                   @RequestParam(required=false) String searchValue,
				                   Model model
) {

		
		
		Map<String, Object> bnListAndPaging = bnService.selectAllBanner(page);
		model.addAttribute("paging", bnListAndPaging.get("paging"));
		model.addAttribute("bannerList", bnListAndPaging.get("bannerList"));
		
		log.info("bannerList {]", bnListAndPaging.get("bannerList"));
		
		return "screen/08-4. bannerList";
	}
}
