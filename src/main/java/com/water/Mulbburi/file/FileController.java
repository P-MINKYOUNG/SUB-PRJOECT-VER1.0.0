package com.water.Mulbburi.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.water.Mulbburi.screen.banner.BannerDTO;
import com.water.Mulbburi.screen.banner.BannerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	private final BannerService bnService;

	@Autowired
	public FileController(BannerService bnService) {
		this.bnService = bnService;
	}

}
