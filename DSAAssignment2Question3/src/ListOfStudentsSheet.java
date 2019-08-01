/*
 * Writes list of students with their options
 */
import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
public class ListOfStudentsSheet {

	private static final String EXCEL_FILE_LOCATION = "ListOfStudents.xls";

	public static void main(String[] args) {

		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 2", 0);

			Label label = new Label(0, 0, "Name");
			excelSheet.addCell(label);
			
			label = new Label(1, 0, "Option1");
			excelSheet.addCell(label);
			
			label = new Label(2, 0, "Option2");
			excelSheet.addCell(label);
			
			label = new Label(3, 0, "Option3");
			excelSheet.addCell(label);
			
			label = new Label(4, 0, "Option4");
			excelSheet.addCell(label);
			
			label = new Label(5, 0, "Option5");
			excelSheet.addCell(label);
			
		    label = new Label(0, 1, "A");
			excelSheet.addCell(label);

		    label = new Label(0, 2, "B");
			excelSheet.addCell(label);
			
			label = new Label(0, 3, "C");
			excelSheet.addCell(label);
			
			label = new Label(0, 4, "D");
			excelSheet.addCell(label);
			
			label = new Label(0, 5, "E");
			excelSheet.addCell(label);
			
			label = new Label(0, 6, "F");
			excelSheet.addCell(label);
			
			label = new Label(0, 7, "G");
			excelSheet.addCell(label);
			
			label = new Label(0, 8, "H");
			excelSheet.addCell(label);
			
			label = new Label(0, 9, "I");
			excelSheet.addCell(label);
			
			label = new Label(0, 10, "J");
			excelSheet.addCell(label);

			label = new Label(1, 1, "Technician");
			excelSheet.addCell(label);
			label = new Label(2, 1, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 1, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 1, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 1, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			label = new Label(1, 2, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(2, 2, "Dental");
			excelSheet.addCell(label);
			label = new Label(3, 2, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 2, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 2, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 3, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(2, 3, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 3, "Dental");
			excelSheet.addCell(label);
			label = new Label(4, 3, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 3, "Civil Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 4, "Dental");
			excelSheet.addCell(label);
			label = new Label(2, 4, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 4, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 4, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 4, "Computer Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 5, "Technician");
			excelSheet.addCell(label);
			label = new Label(2, 5, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 5, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 5, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 5, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 6, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(2, 6, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 6, "Dental");
			excelSheet.addCell(label);
			label = new Label(4, 6, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 6, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 7, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(2, 7, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 7, "Dental");
			excelSheet.addCell(label);
			label = new Label(4, 7, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 7, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 8, "Management");
			excelSheet.addCell(label);
			label = new Label(2, 8, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 8, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 8, "Dental");
			excelSheet.addCell(label);
			label = new Label(5, 8, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 9, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(2, 9, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 9, "Electrical Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 9, "Management");
			excelSheet.addCell(label);
			label = new Label(5, 9, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);
			
			
			label = new Label(1, 10, "Management");
			excelSheet.addCell(label);
			label = new Label(2, 10, "Civil Engineering");
			excelSheet.addCell(label);
			label = new Label(3, 10, "Computer Engineering");
			excelSheet.addCell(label);
			label = new Label(4, 10, "Dental");
			excelSheet.addCell(label);
			label = new Label(5, 10, "Electrical Engineering");
			excelSheet.addCell(label);
			

			myFirstWbook.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

