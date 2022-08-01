package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getfileinputstream() {
		String path = System.getProperty("user.dir"+"\\src\\test\\java\\data\\UserData.xlsx");
		File srcfile = new File(path);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data File not Found, check file path");
			System.exit(0);
		}

		return fis;

	}public Object[][] getexceldata() throws IOException{
		fis = getfileinputstream();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalrows = sheet.getLastRowNum()+1;
		int totalcols = 4;
		String [][] arrayexceldata = new String [totalrows][totalcols];
		for (int i = 0; i < totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayexceldata[i][j] = row.getCell(j).toString();
				wb.close();
			}
		}

		return arrayexceldata;
	}
}
