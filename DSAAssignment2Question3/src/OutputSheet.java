/*
 * Writes Output sheet
 */
import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
public class OutputSheet {

	private static final String EXCEL_FILE_LOCATION = "OutputPrograms.xls";

	public static void main(String[] args) {

		CounsellingProcessOfCollege c = new CounsellingProcessOfCollege();
		Student[] student = c.allocateProgram();
		
		int i = 0;
		int number = student.length;
		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 3", 0);

			Label label = new Label(0, 0, "Name");
			excelSheet.addCell(label);
			
			label = new Label(1, 0, "Allocated Program");
			excelSheet.addCell(label);

			while(number != 0){
				label = new Label(0, i+1, student[i].name);
				excelSheet.addCell(label);
				
				label = new Label(1, i+1, student[i].allocatedProgram);
				excelSheet.addCell(label);
				
				i++;
				number--;
			}

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

