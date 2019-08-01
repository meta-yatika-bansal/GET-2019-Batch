/*
 * Reads student list
 */
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ReadStudentsListFromExcel {

	private static final String EXCEL_FILE_LOCATION = "ListOfStudents.xls";

	public Queue readStudents() {
		 Queue students = new Queue();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);
			for(int i = 1 ; i < sheet.getRows() ; i++){
				
				Student student = new Student();
				Cell cell1 = sheet.getCell(0, i);
				student.name = cell1.getContents();

				Cell cell2 = sheet.getCell(1, i);
				student.options.add(cell2.getContents());
				
				Cell cell3 = sheet.getCell(2, i);
				student.options.add(cell3.getContents());
				
				Cell cell4 = sheet.getCell(3, i);
				student.options.add(cell4.getContents());
				
				Cell cell5 = sheet.getCell(4, i);
				student.options.add(cell5.getContents());
				
				Cell cell6 = sheet.getCell(5, i);
				student.options.add(cell6.getContents());
				students.addToQueue(student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
		
		return students;
	}
}
