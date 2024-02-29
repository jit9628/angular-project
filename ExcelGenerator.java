package com.epds.epdsorder.component;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.w3c.dom.css.CSSStyleSheet;

import com.epds.epdsorder.entity.ManagementProfile;

@Component
public class ExcelGenerator {
	private List<ManagementProfile> profileslist;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelGenerator(List<ManagementProfile> profileslist) {
		this.profileslist = profileslist;
		System.out.println("Excel Datas Are " + profileslist);
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("profile");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		style.setFillBackgroundColor(IndexedColors.BLUE_GREY

				.getIndex());
		// style.setFillPattern(style.getFillPattern().SOLID_FOREGROUND);
		createCell(row, 0, "ID", style);
		createCell(row, 1, "PROFILE", style);

	}

	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		sheet.autoSizeColumn(columnCount); // auto size your column
		Cell cell = row.createCell(columnCount);
		if (valueOfCell instanceof Integer) {
			cell.setCellValue((Integer) valueOfCell);
		} else if (valueOfCell instanceof Long) {
			cell.setCellValue((Long) valueOfCell);
		} else if (valueOfCell instanceof String) {
			cell.setCellValue((String) valueOfCell);
		} else {
			cell.setCellValue((Boolean) valueOfCell);
		}
		cell.setCellStyle(style);

	}

//	write deta into sheet each column cell
	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();

		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		;
		for (ManagementProfile record : profileslist) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getProfile_id(), style);
			createCell(row, columnCount++, record.getAboutyourprofile(), style);
		}
	}

	// chabge cell style

	public static void changeCellBackgroundColor(Cell cell) {
		CellStyle cellStyle = cell.getCellStyle();
		if (cellStyle == null) {
			cellStyle = cell.getSheet().getWorkbook().createCellStyle();
		}
		cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		cellStyle.setFillPattern(FillPatternType.NO_FILL);
		cell.setCellStyle(cellStyle);
	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
