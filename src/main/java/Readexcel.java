import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {

	
	public static void main(String[] args) {
		try {
			File file = new File("D:\\ReadExcel.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			Map<Integer, Object[]> output = new TreeMap<Integer, Object[]>();

			output.put(1, new Object[] { "Name", "Percentage" });
			
			readexcel(output, workbook);

			writeexcel(output, workbook);
 
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void writeexcel(Map<Integer, Object[]> output, XSSFWorkbook workbook) throws IOException {
		if (workbook.getSheetIndex("Output") != -1) {
			int index = workbook.getSheetIndex("Output");
			workbook.removeSheetAt(index);
		}
		XSSFSheet outputsheet = workbook.createSheet("Output");

		Set<Integer> keyid = output.keySet();
		int rowid = 0;
		XSSFRow row;

		for (Integer key : keyid) {

			row = outputsheet.createRow(rowid++);
			Object[] objectArr = output.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);

			}
			FileOutputStream out = new FileOutputStream(new File("D:\\ReadExcel.xlsx"));
			workbook.write(out);
		}

		System.out.println("Done");
	}

	static void readexcel(Map<Integer, Object[]> output, XSSFWorkbook workbook) {
		XSSFSheet datasheet = workbook.getSheet("Marksheet");
		int noOfrows = datasheet.getLastRowNum();

		int index = 2;
		for (int rowindex = 1; rowindex <= noOfrows; rowindex++) {
			double x = datasheet.getRow(rowindex).getCell(1).getNumericCellValue();

			float marks = (float) x;
			float total = 1000;
			float temp = (float) (marks / total) * 100;

			String perc = String.valueOf(temp);

			if (marks > 350) {

				XSSFCell s = datasheet.getRow(rowindex).getCell(0);
				String name = s.toString();

				output.put(index, new Object[] { name, perc });
				index++;
			}

		}
	}
}