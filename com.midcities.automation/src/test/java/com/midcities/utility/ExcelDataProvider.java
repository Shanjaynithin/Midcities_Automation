package com.midcities.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("Unable to read excel file" + e.getMessage());

		}

	}

	// By Sheet Index - String
	public String getStringCellData(int sheetIndex, int row, int cell) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}

	// By Sheet Name - String
	public String getStringCellData(String sheetName, int row, int cell) {

		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	// By Sheet Index - Numeric
	public double getNumericCellData(int sheetIndex, int row, int cell) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getNumericCellValue();
	}

	// By Sheet Name - Numeric
	public double getNumericCellData(String sheetName, int row, int cell) {

		return wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}

}
