package com.water.Mulbburi.main;


import java.util.List;

import com.water.Mulbburi.faq.dto.FaqDTO;
import com.water.Mulbburi.member.dto.MemberDTO;
import com.water.Mulbburi.screen.youtube.YoutubeDTO;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;

import lombok.Data;

@Data
public class MainDTO {
	
	private YoutubeDTO youtubeDTO;
	private List<cartDTO> cartDTO;
	private List<MemberDTO> memberDTO;
	private List<FaqDTO> faqDTO;
}

