package com.water.Mulbburi.screen.youtube;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class YoutubeController {
	
	private final YoutubeService ytService;
	
	@Autowired
	public YoutubeController(YoutubeService ytService) {
		this.ytService = ytService;
	}


	/* 유투브 목록 조회 화면 */
	@GetMapping("/youtube")
	public String youtubeList() {
		return "screen/08-2. youtubeControll";
	}
	
	/* 저장할 유투브 목록 삽입 */
	@PostMapping("/regist")
	public String insertYoutube(@ModelAttribute YoutubeDTO youtubeDTO) {
		
		
		ytService.insertYoutube(youtubeDTO);
		
		return "redirect:/youtube";


	}
	


	/* 저장한 유투브 목록 가져오기 */
	@GetMapping("select/youtube")
	public String selectAllYoutube(@RequestParam(defaultValue="1") int page, 
				                   Model model
) {

		Map<String, Object> ytListAndPaging = ytService.selectAllYoutube(page);
		model.addAttribute("paging", ytListAndPaging.get("paging"));
		model.addAttribute("youtubeList", ytListAndPaging.get("youtubeList"));	
		
		log.info("paging {}", ytListAndPaging.get("paging"));
			
		return "screen/08-3. youtubeList";
	}
	
	/* 게시일이 되면 삭제하기 */
	@GetMapping("delete/youtube")
	public String deleteYoutube(@ModelAttribute YoutubeDTO youtubeDTO) {
		
	  ytService.deleteYoutube(youtubeDTO);
	  
	  return "redirect:/youtube";
	  
	}
}

