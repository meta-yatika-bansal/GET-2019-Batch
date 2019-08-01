/*
 * Writes list of programs
 */
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
public class ListOfProgramsSheet {

	private static final String EXCEL_FILE_LOCATION = "ListOfPrograms.xls";

	public static void main(String[] args) {

		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			Label label = new Label(0, 0, "Name");
			excelSheet.addCell(label);

			label = new Label(0, 1, "Technician");
			excelSheet.addCell(label);

			label = new Label(1, 0, "Capacity");
			excelSheet.addCell(label);

			Number number = new Number(1, 1, 1);
			excelSheet.addCell(number);

			label = new Label(0, 2, "Civil Engineering");
			excelSheet.addCell(label);

			number = new Number(1, 2, 1);
			excelSheet.addCell(number);

			label = new Label(0, 3, "Management");
			excelSheet.addCell(label);

			number = new Number(1, 3, 1);
			excelSheet.addCell(number);

			label = new Label(0, 4, "Electrical Engineering");
			excelSheet.addCell(label);

			number = new Number(1, 4, 1);
			excelSheet.addCell(number);

			label = new Label(0, 5, "Electro-Mechanical Engineering");
			excelSheet.addCell(label);

			number = new Number(1, 5, 1);
			excelSheet.addCell(number);

			label = new Label(0, 6, "Computer Engineering");
			excelSheet.addCell(label);

			number = new Number(1, 6, 1);
			excelSheet.addCell(number);

			label = new Label(0, 7, "Dental");
			excelSheet.addCell(label);

			number = new Number(1, 7, 1);
			excelSheet.addCell(number);

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

