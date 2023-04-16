package com.water.Mulbburi.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.water.Mulbburi.file.FileDTO;
import com.water.Mulbburi.member.dto.MemberDTO;
import com.water.Mulbburi.product.dto.ProductDTO;
import com.water.Mulbburi.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Controller
@RequestMapping("/store")
public class ProductController {

	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/prodInq")
	public String prodinquiry() {	
		return "store/prodInq";
	}
	
	@GetMapping("/prodMod")
	public String prodmodify() {	
		return "store/prodMod";
	}

	@GetMapping("/prodReg")
	public String prodregist() {	
		
		return "store/prodReg";
	}	

	@PostMapping("/prodReg")
	public String registprod(@ModelAttribute ProductDTO product, List<MultipartFile> attachImage,
			@AuthenticationPrincipal MemberDTO member) {
		
//		log.info("[ProductController] product request : {}", product);
//		log.info("[ProductController] attachImage request : {}", attachImage);
		
		/* 파일 사진 업로드 */
		String fileUploadDir = IMAGE_DIR + "original";
		String productDir = IMAGE_DIR + "product";
	
		File dir1 = new File(fileUploadDir);
		File dir2 = new File(productDir);
		
//		log.info("[ProductController] dir1 : {}", dir1);
//		log.info("[ProductController] dir2 : {}", dir2);
		
		/* 디렉토리가 없을 경우 생성한다. */
		if(!dir1.exists() || !dir2.exists()) {
			dir1.mkdirs();
			dir2.mkdirs();
		}
	
		/* 업로드 파일에 대한 정보를 담을 리스트 */
		List<FileDTO> attachmentList = new ArrayList<>();
		
		try {
		
			for (int i = 0; i < attachImage.size(); i++) {
				if (attachImage.get(i).getSize() > 0) {
					
					String originalFileName = attachImage.get(i).getOriginalFilename();
					log.info("[ProductController] originalFileName : {}", originalFileName);
					
					String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
					String savedFileName = UUID.randomUUID().toString() + ext;
					
					log.info("[ProductController] savedFileName : {}", savedFileName);
					
					attachImage.get(i).transferTo(new File(fileUploadDir + "/" + savedFileName));
					
					FileDTO fileInfo = new FileDTO();
					fileInfo.setFileoriginalName(originalFileName);
					fileInfo.setFileSavedName(savedFileName);
					fileInfo.setFilePath("/upload/original/");
					
					

					if(i == 0) {
						fileInfo.setFileType("MAIN");
						/* 대표 사진에 대한 썸네일을 가공해서 저장한다. */
						Thumbnails.of(fileUploadDir + "/" + savedFileName).size(600, 600)
						.toFile(productDir + "/product_" + savedFileName);
						fileInfo.setFilePath("/upload/product/product_" + savedFileName);
					} else {
						fileInfo.setFileType("DETAIL");
						Thumbnails.of(fileUploadDir + "/" + savedFileName).size(1000, 13410)
						.toFile(productDir + "/product_" + savedFileName);
						fileInfo.setFilePath("/upload/product/product_" + savedFileName);
					}
					
					attachmentList.add(fileInfo);
				}
				
			}

			log.info("[ProductController] attachmentList : {}", attachmentList);

			product.setAttachmentList(attachmentList);
			product.setMemberNo(member.getMemberNo());
			System.out.println(product);
			
			productService.registProduct(product);
			
			System.out.println(member);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			/* 실패 시 이미 저장 된 파일을 삭제한다. */
			for(FileDTO attachment : attachmentList) {
				
				File deleteFile = new File(attachment.getFilePath() + "/" + attachment.getFileSavedName());
				File deleteProduct = new File(productDir + "/product_" + attachment.getFileSavedName());
				
				deleteFile.delete();
				deleteProduct.delete();
			}
		
		}

		return "redirect:/store/store";
	}
	
	/* 등록 상품 목록 조회 */
	
	  @GetMapping("/store") 
	  public String store(@RequestParam(defaultValue="1") int page, 
			  @RequestParam(required=false) String searchCondition, 
			  @RequestParam(required=false) String searchValue, 
			  @ModelAttribute ProductDTO product,
			  @AuthenticationPrincipal MemberDTO member,
			  Model model) {
	  
		  log.info("[ProductController] member plz : {}", member);
		  log.info("[ProductController] product plz 1 : {}", product);
		  
		  Map<String, Object> StoreAndPaging = productService.attachmentList(page);
		  model.addAttribute("paging", StoreAndPaging.get("paging"));
		  model.addAttribute("productList", StoreAndPaging.get("productList"));
		  model.addAttribute("attachmentList", StoreAndPaging.get("attachmentList"));
		  
		  log.info("[ProductController] model : {}", model);
		  
		  product.setMemberNo(member.getMemberNo());
		  
		  log.info("[ProductController] product plz 2 : {}", product);
			
	  return "store/store"; 
	  
	  }
	 
}