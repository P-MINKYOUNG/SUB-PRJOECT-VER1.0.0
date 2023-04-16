package com.water.Mulbburi.calculator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalculatorController {

	private final CalculatorService calService;

	public static String filePath = "C:\\Users\\tofhd\\Desktop\\새 폴더\\Mulbburi";
	public static String fileNm = "calculator.xlsx";

	@Autowired
	public CalculatorController(CalculatorService calService) {
		this.calService = calService;
	}

	@GetMapping("/calculator")
	public String getDate(Model model, @RequestParam(required=false) String calDate, CalculatorDTO calDTO) {

		/*
		 * calDTO.setCalDate(calDate); Map<String, Object> calculList =
		 * calService.selectDate(calDTO); model.addAttribute("calList",
		 * calculList.get("calList"));
		 */

		return "calculator/05. calculator";
	}

	@PostMapping("excel")
	public String excel(@RequestParam String calDate, HttpServletResponse response) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("calculator data");
		Map<String, Object> data = calService.selectAllData(calDate);
		
		List<CalculatorDTO> calList = (List<CalculatorDTO>) data.get("calList");

		// 엑셀 파일에 데이터 추가
		int rowNum = 1;
		for (CalculatorDTO calculator : calList) {
		    Row row = sheet.createRow(rowNum++);
		    row.createCell(0).setCellValue(calculator.getAllMoney());
		    row.createCell(1).setCellValue(calculator.getCalCharge2());
		    row.createCell(2).setCellValue(calculator.getCalMoney2());
		}
		
		Font font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 30); // 글꼴 크기 변경
		
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		
		// 엑셀 파일 첫 번째 행에 헤더 추가
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("총 금액");
		header.createCell(1).setCellValue("수수료");
		header.createCell(2).setCellValue("정산 금액");
		
		sheet.setColumnWidth(0, 5000);
		sheet.setColumnWidth(1, 5000);
		sheet.setColumnWidth(2, 5000);
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition", "attachment; filename=calculator_data.xlsx");
	    OutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    workbook.close();
	    outputStream.flush();
	    outputStream.close();
		

		return "redirect:/calculator";
	}

}
