package com.water.Mulbburi.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.water.Mulbburi.community.dto.CommunityDTO;
import com.water.Mulbburi.community.dto.ReplyDTO;
import com.water.Mulbburi.community.service.CommunityService;
import com.water.Mulbburi.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/community")
public class CommunityController {
	

	private final CommunityService communityService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public CommunityController(CommunityService communityService, MessageSourceAccessor messageSourceAccessor) {
		this.communityService = communityService;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	@GetMapping("/list")
	public String communityList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[CommunityController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[CommunityController] searchMap : {}", searchMap);
		
		Map<String, Object> communityListAndPaging = communityService.selectCommunityList(searchMap, page);
		model.addAttribute("paging", communityListAndPaging.get("paging"));
		model.addAttribute("communityList", communityListAndPaging.get("communityList"));
		
		return "community/communityList";
	}
	
	@GetMapping("/detail")
	public String selectCommunityDetail(@RequestParam Long no, Model model) {
		
		CommunityDTO communityDetail = communityService.selectCommunityDetail(no);
		log.info("[CommunityController] communityDetail : {}", communityDetail);
		
		model.addAttribute("community", communityDetail);
		
		return "community/communityDetail";
	}
	
	@PostMapping("/registReply")
	public ResponseEntity<String> registReply(@RequestBody ReplyDTO registReply,
			@AuthenticationPrincipal MemberDTO member) {
		
		registReply.setWriter(member);	// 댓글 작성자는 로그인 유저이므로 설정
		log.info("[communityController] registReply : {}", registReply);
		
		communityService.registReply(registReply);		
		
		return ResponseEntity.ok("댓글 등록 완료");
	}
	
	@GetMapping("/loadReply")
	public ResponseEntity<List<ReplyDTO>> loadReply(ReplyDTO loadReply) {
		
		log.info("[CommunityController] loadReply : {}", loadReply);
		
		List<ReplyDTO> replyList = communityService.loadReply(loadReply);
		
		log.info("[CommunityController] replyList : {}", replyList);
		
		return ResponseEntity.ok(replyList);
	}
	
	@PostMapping("/removeReply")
	public ResponseEntity<String> removeReply(@RequestBody ReplyDTO removeReply) {
		
		log.info("[CommunityController] removeReply : {}", removeReply);
		
		communityService.removeReply(removeReply);
		
		return ResponseEntity.ok("댓글 삭제 완료");
		
	}
	
	@GetMapping("/regist")
	public String goRegist() {
		
		return "community/communityRegist";
	}
	
	/* 게시글 등록 컨트롤러 핸들러 메소드 */
	@PostMapping("/regist")
	public String registCommunity(CommunityDTO community, @AuthenticationPrincipal MemberDTO member,
			RedirectAttributes rttr) {
		
		community.setWriter(member);
		log.info("[communityController] community : {}", community);
		
		communityService.registCommunity(community);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("community.regist"));
		
		return "redirect:/community/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}