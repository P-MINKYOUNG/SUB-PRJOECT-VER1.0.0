package com.water.Mulbburi.community.controller;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.water.Mulbburi.community.dto.AttachmentDTO;
import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.community.service.CommunityService;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Controller
@RequestMapping("/thumbnail")
public class ThumbnailController {
	
	
	
	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final CommunityService communityService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public ThumbnailController(CommunityService communityService, MessageSourceAccessor messageSourceAccessor) {
		this.communityService = communityService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@GetMapping("/regist")
	public String goRegist() {
		
		return  "thumbnail/thumbnailRegist";
	}
	
	@PostMapping("/regist")
	public String registThumbnail(CommunityDTO community, List<MultipartFile> attachImage, 
			@AuthenticationPrincipal MemberDTO member, RedirectAttributes rttr) {
		
		log.info("[ThumbnailController] community request : {}", community);
		log.info("[ThumbnailController] attachImage request : {}", attachImage);
		
		String fileUploadDir = IMAGE_DIR + "original";
		String thumbnailDir = IMAGE_DIR + "thumbnail";
		
		File dir1 = new File(fileUploadDir);
		File dir2 = new File(thumbnailDir);
		
		log.info("[ThumbnailController] dir1 : {}", dir1);
		log.info("[ThumbnailController] dir2 : {}", dir2);
		
		/* 디렉토리가 없을 경우 생성한다. */
		if(!dir1.exists() || !dir2.exists()) {
			dir1.mkdirs();
			dir2.mkdirs();
		}
		
		/* 업로드 파일에 대한 정보를 담을 리스트 */
		List<AttachmentDTO> attachmentList = new ArrayList<>();
		
		try {

			/* 4개의 input type=file이 서버로 전송 되어 List<MultipartFile> attachImage에 담겼다. */
			for (int i = 0; i < attachImage.size(); i++) {
				/* 첨부파일이 실제로 있는 경우에만 로직 수행 */
				if (attachImage.get(i).getSize() > 0) {

					String originalFileName = attachImage.get(i).getOriginalFilename();
					log.info("[ThumbnailController] originalFileName : {}", originalFileName);

					String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
					String savedFileName = UUID.randomUUID().toString() + ext;

					log.info("[ThumbnailController] savedFileName : {}", savedFileName);

					/* 서버의 설정 디렉토리에 파일 저장하기 */
					attachImage.get(i).transferTo(new File(fileUploadDir + "/" + savedFileName));
					
					/* DB에 저장할 파일의 정보 처리 */
					AttachmentDTO fileInfo = new AttachmentDTO();
					fileInfo.setOriginalName(originalFileName);
					fileInfo.setSavedName(savedFileName);
					fileInfo.setSavePath("/upload/original/");
					
					if(i == 0) {
						fileInfo.setFileType("TITLE");
						/* 대표 사진에 대한 썸네일을 가공해서 저장한다. */
						Thumbnails.of(fileUploadDir + "/" + savedFileName).size(300, 300)
						.toFile(thumbnailDir + "/thumbnail_" + savedFileName);
						fileInfo.setThumbnailPath("/upload/thumbnail/thumbnail_" + savedFileName);
					} else {
						fileInfo.setFileType("BODY");
					}
					attachmentList.add(fileInfo);
				}
			}
			
			log.info("[ThumbnailController] attachmentList : {}", attachmentList);
			
			community.setAttachmentList(attachmentList);
			community.setWriter(member);
			
			communityService.registThumbnail(community);
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("community.regist"));
			
		} catch (Exception e) {
			e.printStackTrace();
			/* 실패 시 이미 저장 된 파일을 삭제한다. */
			for(AttachmentDTO attachment : attachmentList) {
				
				File deleteFile = new File(attachment.getSavePath() + "/" + attachment.getSavedName());
				File deleteThumbnail = new File(thumbnailDir + "/thumbnail_" + attachment.getSavedName());
				
				deleteFile.delete();
				deleteThumbnail.delete();
			}
		}
		
		return "redirect:/thumbnail/list";
	}
	
	@GetMapping("/list")
	public String selectAllThumbnailList(@RequestParam(defaultValue="1") int page, Model model) {
		
		Map<String, Object> thumbnailListAndPaging = communityService.selectThumbnailList(page);
		model.addAttribute("paging", thumbnailListAndPaging.get("paging"));
		model.addAttribute("thumbnailList", thumbnailListAndPaging.get("thumbnailList"));
		
		return "thumbnail/thumbnailList";
	}
	
	@GetMapping("/detail")
	public String selectThumbnailDetail(Long no, Model model) {
		
		log.info("[ThumbnailController] request no : {}", no);
		
		CommunityDTO thumbnail = communityService.selectThumbnailDetail(no);
		
		log.info("[ThumbnailController] thumbnail : {}", thumbnail);
		
		model.addAttribute("thumbnail", thumbnail);
		
		return "thumbnail/thumbnailDetail";
	}
	
	
	
	
	
	
	

}