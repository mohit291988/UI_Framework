package com.uiFramework.companyName.projectName.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.companyName.projectName.helper.assertion.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get Sheet name from workbook;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count no of active rows in active sheet
			int totalRow = sheet.getLastRowNum();
			System.out.println(totalRow);

			// count no of active columns in row
			short totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new String[totalRow][totalColumn];

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext())
				;
			// for every row, we need to iterator over columns
			{
				i++;
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					CellType type = cell.getCellType();
					switch (type) {
					case STRING:
						dataSets[i][j] = cell.getStringCellValue();
						break;

					case NUMERIC:
						// can't use getNumericCellValue() method and throwing mismatched error
						dataSets[i][j] = cell.getNumericCellValue();
						break;

					case BOOLEAN:
						// can't use getNumericCellValue() method and throwing mismatched error
						dataSets[i][j] = cell.getNumericCellValue();
						break;

					case FORMULA:
						dataSets[i][j] = cell.getCellFormula();

					default:
						System.out.println("no matching enum type found");
						break;

					}
				}
			}
			return dataSets;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
