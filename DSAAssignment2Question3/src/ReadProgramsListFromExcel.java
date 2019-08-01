/*
 * Reads program list
 */
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadProgramsListFromExcel {

	private static final String EXCEL_FILE_LOCATION = "ListOfPrograms.xls";

	public List<Program> readProgram(){
		List<Program> programs = new ArrayList<>();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);
			for(int i = 1 ; i < sheet.getRows() ; i++){
				
				Program program = new Program();
				Cell cell1 = sheet.getCell(0, i);
				program.name = cell1.getContents();

				Cell cell2 = sheet.getCell(1, i);
				program.capacity = Integer.parseInt(cell2.getContents());
				programs.add(program);
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
		
		return programs;
	}
}
