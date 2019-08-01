/*
 * Represents Counseling Process of College
 */
import java.util.*;
public class CounsellingProcessOfCollege {

	ReadProgramsListFromExcel read = new ReadProgramsListFromExcel();
	List<Program> programs = read.readProgram();
	
	/**
	 * Allocates Program to students
	 * @return list of students
	 */
	public Student[] allocateProgram(){
		try{
			ReadStudentsListFromExcel read = new ReadStudentsListFromExcel();
			Queue students = read.readStudents();
			Queue studentFinal = new Queue();

			for(Student student : students.showQueue()){
				boolean flag = false;
				for(int i = 0 ; i < student.options.size() ; i++){
					if(ifCapacity(student.options.get(i))){
						flag = true;
						student.allocatedProgram = student.options.get(i);
						students.deleteFromQueue();
						studentFinal.addToQueue(student);
						break;
					}
				}
				if(!flag){
					student.allocatedProgram = "NA";
					students.deleteFromQueue();
					studentFinal.addToQueue(student);
				}
			}

			return studentFinal.showQueue();
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Checks if the program has capacity
	 * @param name is the name of program
	 * @return true or false accordingly
	 */
	private boolean ifCapacity(String name){
		try{
			for(Program option : programs){
				if(name.equals(option.name)){
					if(option.capacity != 0){
						option.capacity--;
						return true;
					}else{
						return false;
					}
				}
			}

			return false;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}
