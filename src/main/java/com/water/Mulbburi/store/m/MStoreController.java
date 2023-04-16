package com.water.Mulbburi.store.m;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MStoreController {
	
	private MStoreService stService;
	
	@Autowired
	public MStoreController(MStoreService stService) {
		this.stService = stService;
	}
	
	/* 저장한 상품 목록 가져오기 */
	@GetMapping("store")
	public String selectMyProduct(@RequestParam(defaultValue="1") int page, /*@PathVariable("category") String category, */
				                   Model model) {

		Map<String, Object> stListAndPaging = stService.selectMyProduct(page/*, category*/);
		model.addAttribute("paging", stListAndPaging.get("paging"));
		model.addAttribute("storeList", stListAndPaging.get("storeList"));
		model.addAttribute("category", "product");
		
		return "store/04. store";
	}
	
	@GetMapping("select/flower")
	public String selectMyFlower(@RequestParam(defaultValue="1") int page, 
				                   Model model) {

		Map<String, Object> stListAndPaging = stService.selectMyFlower(page);
		model.addAttribute("paging", stListAndPaging.get("paging"));
		model.addAttribute("storeList2", stListAndPaging.get("storeList2"));
		model.addAttribute("category", "flower");
				
		return "store/04. store";
	}
	

	@GetMapping("select/terrarium")
	public String selectMyTerrarium(@RequestParam(defaultValue="1") int page, 
				                   Model model) {
		Map<String, Object> stListAndPaging = stService.selectMyTerrarium(page);
		model.addAttribute("paging", stListAndPaging.get("paging"));
		model.addAttribute("storeList3", stListAndPaging.get("storeList3"));
		model.addAttribute("category", "terarrium");
		
		return "store/04. store";
	}
	
	@GetMapping("select/herb")
	public String selectMyHerb(@RequestParam(defaultValue="1") int page, 
				                   Model model) {
		Map<String, Object> stListAndPaging = stService.selectMyHerb(page);
		model.addAttribute("paging", stListAndPaging.get("paging"));
		model.addAttribute("storeList4", stListAndPaging.get("storeList4"));
		model.addAttribute("category", "herb");
		
		return "store/04. store";
	}
	
	@GetMapping("select/etc")
	public String selectMyetc(@RequestParam(defaultValue="1") int page, 
				                   Model model) {
		Map<String, Object> stListAndPaging = stService.selectMyEtc(page);
		model.addAttribute("paging", stListAndPaging.get("paging"));
		model.addAttribute("storeList5", stListAndPaging.get("storeList5"));
		model.addAttribute("category", "etc");
		
		return "store/04. store";
	}
}
