package Util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException {

		exceldatafetch1();

	}

	public static Object[][] exceldatafetch1() throws IOException {

		FileInputStream fil = new FileInputStream("C:\\Users\\Arpitha\\Desktop\\SDET\\TestData.xlsx");
		XSSFWorkbook wrkbk = new XSSFWorkbook(fil);
		XSSFSheet sheet = wrkbk.getSheetAt(0);

		int totalrows = sheet.getLastRowNum();
		Row row = sheet.getRow(1);
		int totalcol = row.getLastCellNum();

		Object[][] data = new Object[totalrows + 1][totalcol];

		for (int i = 0; i < totalrows + 1; i++) {
			for (int j = 0; j < totalcol; j++) {

				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}

		wrkbk.close();
		return data;

	}

}
