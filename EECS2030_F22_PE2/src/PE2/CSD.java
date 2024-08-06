package PE2;


import static org.junit.Assert.assertNotNull;

import java.util.*;

//COMPUTER SCIENCE DEPARTMENT (CSD)



/** 
 * Generates Exception for situations where there is no more space left in the particular array list
 * */
class NoSpaceException extends Exception {
	
	public NoSpaceException() {
		
		
	}
	
}


/** 
 * Generates Exception for situations where a TA has graduated and there is no one to replace them
 * */
class NoTAException extends Exception{
	
	public NoTAException() {
		
		
	}
	
}


/** 
 * Generates Exception for situations where there is no one to replace a particular TA 
 * */
class NoSpecialtyException extends Exception{
	
	public NoSpecialtyException() {
		
		
	}
	
}






/** 
 * Stores and handles all the members within the computer science department which is composed of students and academic workers
 * */
public class CSD{
	
	ArrayList<ChairPerson> chairPersonList = new ArrayList<>();
	ArrayList<Faculty> facultyList = new ArrayList<>();
	ArrayList<UGrad> UGradList = new ArrayList<>();
	ArrayList<Grad> GradList = new ArrayList<>();
	ArrayList<ProgramDirector> PDList = new ArrayList<>();
	

	/** 
	 * Constructs the CSD Object 
	 * @param a chair person object
	 * 
	 * */
	public CSD(ChairPerson chairPerson)  {
		
		
		if(chairPersonList.size()<=1) {
			
			chairPersonList.add(chairPerson);
			
		}
		
	}

	/** 
	 * getter for the chair person object which returns the only chairperson in the CSD
	 * @returns a chair person object
	 * 
	 * */
	public ChairPerson getChairPerson() {
		
		return chairPersonList.get(0);
	}
	
	
	/** 
	 * Hires faculty members by adding them to the faculty list and to the records within each Program director based on the subject
	 * @param takes in a faculty object representing a faculty member 
	 * @throws NoSpaceException if there is no more space left in the amount of members
	 * 
	 * */
	public void HireFaculty(Faculty f) throws NoSpaceException {
		
		
		if(facultyList.size()<=70 && (facultyList.contains(f) != true)) {
			
			facultyList.add(f);
			
			for(int i=0; i<PDList.size(); i++) {
				
				if((PDList.get(i).getNewFaculty().size()<25) && (PDList.get(i).getProgram().equals(f.getProgram()))) {
					
					PDList.get(i).setNewFaculty(f);
					facultyList.get(facultyList.size()-1).setPD(PDList.get(i));
					break;
				}
			
			}

		}else if(facultyList.contains(f) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
		
	}
	
	/** 
	 * Admits new students into the computer science department by recording each member in a List
	 * @param takes in a UGrad object representing an undergrad student 
	 * @throws NoSpaceException if there is no more space left in the amount of members
	 * 
	 * */

	public void AdmitStudent(UGrad s) throws NoSpaceException {
		
		
		
		if(UGradList.size()<=500 && (UGradList.contains(s) != true)) {
			
			UGradList.add(s);
			
			for(int i=0; i<facultyList.size(); i++) {
				
				if(facultyList.get(i).getAdvisingUgrads().size()<8) {
					
					facultyList.get(i).setAdvisingUgrads(s);
					UGradList.get(UGradList.size()-1).setAdvisor(facultyList.get(i));
					break;
				}
				
					
			}
			
			
			
		}else if(UGradList.contains(s) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
	}

	/** 
	 * a getter for the number of undergrad students 
	 * @returns the number of undergrad students in the UGradList
	 * 
	 * */
	public Integer getNumOfUGradStudents() {
		
		return UGradList.size();
	}
	
	/** 
	 * a getter for the number of graduate students 
	 * @returns the number of graduate students in the GradList
	 * 
	 * */
	public Integer getNumOfGradStudents() {
		
		return GradList.size();
	}

	
	/** 
	 * a getter for the list of faculty members
	 * @returns the faculty list
	 * 
	 * */
	public List<Faculty> getFaculty() {
		
		return facultyList;
	}
	
	/** 
	 * a getter for number of faculty members in the list
	 * @returns the number of faculty in the CSD
	 * 
	 * */
	public Integer getNumOfFaculty() {
		
		return facultyList.size();
	}

	/** 
	 * takes in a graduate student and assigns him to a TA position in a particular faculty member
	 * @param takes in a graduate student object 
	 * @throws NoSpaceExcpetion if there is no space for TA's in the GradList
	 * 
	 * */
	public void HireTA(Grad s) throws NoSpaceException {
		
		
		if(GradList.size()<=150 && (GradList.contains(s) != true)) {
			
			GradList.add(s);
			
			for(int i=0; i<facultyList.size(); i++) {
				
				if(facultyList.get(i).getTAs().size()<5) {
					
					facultyList.get(i).setTAs(s);
					GradList.get(GradList.size()-1).setAdvisor(facultyList.get(i));
					break;
				}
				
					
			}
			
			
			
		}else if(GradList.contains(s) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
		
	}

	
	/** 
	 * represents graduating undergrad student; student removed from CSD
	 * @param undergrad student object
	 * 
	 * */
	public void AlumnusUGrad(UGrad s) {
		
		UGradList.remove(s);
		
		for(int i=0; i<facultyList.size(); i++) {
			
			
			if(facultyList.get(i).getAdvisingUgrads().contains(s)) {
				
				facultyList.get(i).getAdvisingUgrads().remove(s);
				break;
			}
				
		}
		
		
	}

	
	/** 
	 * represents graduating graduate student; student removed from CSD
	 * @param grad student object
	 * 
	 * */
	public void AlumnusGrad(Grad s) throws NoTAException {
		
		
		
		GradList.remove(s);
		
		
		for(int i=0; i< facultyList.size(); i++) {
			
			if(facultyList.get(i).getTAs().contains(s)) {
				
				if(facultyList.get(i).getTAs().size() <=1) {
			
					throw new NoTAException(); 
			
				}
				
				break;
			}
			
		}
		
			
		for(int i=0; i<facultyList.size(); i++) {
			
			
			if(facultyList.get(i).getTAs().contains(s)) {
				
				facultyList.get(i).getTAs().remove(s);
				break;
			}
				
		}	
		
		
		
	}
	
	
	/** 
	 * returns a sorted collection of all the graduate students
	 * @return graduate student list
	 * 
	 * */
	public List<Grad> ExtractAllGradDetails() {
		
		Collections.sort(GradList);
		
		return GradList;
	}

	/** 
	 * returns a sorted collection of all the undergrad students
	 * @return undergrad student list
	 * 
	 * */
	public List<UGrad> ExtractAllUGradDetails() {
		
		Collections.sort( UGradList);	
		
		
		
		return UGradList;
	}

	/** 
	 * returns a sorted list of all faculty members 
	 * @return sorted list of faculty members
	 * 
	 * */
	public List<Faculty> ExtractAllFacultyDetails() {
		
		Collections.sort(facultyList);
		
		
		return facultyList;
	}

	
	/** 
	 * returns a sorted list of all faculty members of a particular program
	 * @param name of program 
	 * @return sorted list of faculty members of a program
	 * 
	 * */
	public List<Faculty> ExtractFacultyDetails(String programName) {
		
		ArrayList<Faculty> tempList = new ArrayList<>();
		
		for(Faculty f: facultyList) {
			
			if(f.getProgram().equals(programName)) {
				
				tempList.add(f);
			}
			
		}
		
		Collections.sort(tempList);
		
		return tempList;
		
	}

	/** 
	 * returns a sorted list of undergrad students of a particular faculty
	 * @param a particular faculty member
	 * @return sorted list of undergrad students
	 * 
	 * */
	public List<UGrad> ExtractAdviseesDetails(Faculty facultyName) {

		ArrayList<UGrad> tempList = new ArrayList<>();
		
		for(UGrad f: facultyName.getAdvisingUgrads()) {
			
			tempList.add(f);
			
		}
		
		Collections.sort(tempList);
		
		return tempList;
		
	}

	/** 
	 * returns a sorted list graduate students of a particular faculty who are TAs
	 * @param a particular faculty member
	 * @return sorted list of graduate students
	 * 
	 * */
	public List<Grad> ExtractTAsDetails(Faculty facultyName) {
		
		ArrayList<Grad> tempList = new ArrayList<>();
		
		for(Grad g: facultyName.getTAs()) {
			
			tempList.add(g);
			
		}
		
		Collections.sort(tempList);
		
		return tempList;
	}

	/** 
	 * takes in a program director object and assigns them a position in the computer science department 
	 * they are added to a PD(program director list)
	 * there must only be no more than 3 PDs, 1 for each subject 
	 * @param takes in a program director object
	 * @throws NoSpaceExcpetion if the number of program directors in the list is greater than 3
	 * 
	 * */
	public void addProgramDirector(ProgramDirector p) throws NoSpaceException {
		
		if(PDList.size()<=3 && (PDList.contains(p) != true)) {
			
			for(int i=0; i<PDList.size(); i++) {
				
				if(!(PDList.get(i).getProgram().equals("Computer Science")) || !(PDList.get(i).getProgram().equals("Software Engineering")) || !(PDList.get(i).getProgram().equals("Digital Media"))) {
					
					return;
					
				}
				
			}
				
				
			PDList.add(p);
			
			
		}else if(PDList.contains(p) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
	}
	
	
	
	/** 
	 * takes in a Faculty object representing a faculty member and and removes them from the faculty list
	 * all the undergrad advisees and graduate student TAs will need to be assigned to the next available faculty members
	 * @param takes in a faculty member object
	 * @throws NoSpaceExcpetion if there is no more space in any of the faculties 
	 * @throws NoSpecialtyException if there is no other faculty members left of a particular subject
	 * 
	 * */
	public void RetireFaculty(Faculty f) throws NoSpecialtyException, NoSpaceException{
		
		int counter = 0;
		
		for(int i=0; i<facultyList.size(); i++) {
			
			if(f.getProgram().equals(facultyList.get(i).getProgram())) {
				
				counter++;
				
				
			}
			
		}
		
		if(counter<=1) {
			
			throw new NoSpecialtyException();
			
		}
		
		
		for(int i=0; i<f.getAdvisingUgrads().size(); i++) {
			
			for(int j=0; j<facultyList.size(); j++) {
				
				if((facultyList.get(j).getAdvisingUgrads().size()<8) && !(facultyList.get(j).equals(f))) {
					
					facultyList.get(j).setAdvisingUgrads(f.getAdvisingUgrads().get(i));
					UGradList.get(UGradList.indexOf(f.getAdvisingUgrads().get(i))).setAdvisor(facultyList.get(j));
					break;
				}
				
			}
			
		}
		
		
		for(int i=0; i<f.getTAs().size(); i++) {
			
			for(int j=0; j<facultyList.size(); j++) {
				
				if((facultyList.get(j).getTAs().size()<5) && !(facultyList.get(j).equals(f))) {
					
					facultyList.get(j).setTAs(f.getTAs().get(i));
					GradList.get(GradList.indexOf(f.getTAs().get(i))).setAdvisor(facultyList.get(j));
					break;
				}
				
			}
			
		}
		
		
		for(int i=0; i<PDList.size(); i++) {
			
			if(PDList.get(i).getNewFaculty().contains(f)) {
				
				PDList.get(i).getNewFaculty().remove(PDList.get(i).getNewFaculty().indexOf(f));
				break;
			}
			
		}
		
		facultyList.remove(f);
		
			
			
			
		
		
	}


	
}


/** 
 * The abstract class that is the super classes of all other classes except the CSD class
 * contains only the instance variables used by the constructors of several of the subclasses 
 * */
//PERSON
abstract class Person{
	
	String firstName;
	String lastName;
	int age;
	String gender; 
	String address; 
	
	
}


/** 
 * The abstract class that is the super class of the Grad and UGrad subclasses
 * it implements the Comparable interface
 * */
//STUDENT
abstract class Student extends Person implements Comparable<Student>{
	
		int StudentID = 1000 + studentIDInc;
		static int studentIDInc;
		
		/** 
		 * returns the Student ID of a particular undergraduate or undergraduate student
		 * @return StudentID of a particular student 
		 * */
		public int getStudentID() {
			
			return StudentID;
			
		}
		
		
	
		/** 
		 * allows comparisons between object components to be done in a particular way
		 * we can override the general way a particular method works
		 * for example in the extract methods in the CSD class we used it to concatenate the first name within a sorted list
		 * here we are concatenating the first name and last name 
		 * @param pass a Student object which by definition includes both graduate and undergraduate students 
		 * @return an integer value 0 if the first string is equal to the second string, otherwise it returns -1 
		 * */

		
		@Override
		
		public int compareTo(Student student) {
			
			String StudentOne = this.firstName + "," + this.lastName;
			String StudentTwo = student.firstName + "," + student.lastName;
			
			return StudentOne.compareTo(StudentTwo);
			
		}
}


/** 
 * The Academics class is the super class of all the academic positions within the CSD 
 * */
//ACADEMICS
abstract class Academics extends Person{
	
	int EmployeeID = 100 + incramentEmp;
	static int incramentEmp = 0; 
	double salary;
	
	/** 
	 * is a getter for the Employee ID of the particular individual
	 * @return the integer value EmployeeID of the particular individual 
	 * */

	public int getEmployeeID() {
		
		return EmployeeID;
		
	}
	
	/** 
	 * is a setter for the particular individuals salary once hired by the CSD
	 * @param a double value representing the salary 
	 * */

	public void setSalary(double salary) {

		
		this.salary = salary;
		
	}
	
	
	
	/** 
	 * is a getter for the salary of the particular individual
	 * @return a double value representing the salary
	 * */

	public double getSalary() {
		
		return this.salary;
		
	}
	
	
	
	
	
}


/** 
 * The Administrator class is the super class of the program directors and chairperson 
 * */

//ADMINISTRATOR
abstract class Administrator extends Academics{
	
	
	
}

/** 
 * The ChairPerson class represents the one and only chairperson within the computer science department 
 * */

//CHAIRPERSON
class ChairPerson extends Administrator{
	
	
	/** 
	 *Is the constructor for the ChairPerson Object  
	 * @param A string representing the first name of the individual
	 * @param A string representing the last name of the individual
	 * @param An integer representing the individual's age 
	 * @param A string representing the gender
	 * @param A String representing the address 
	 * */

	public ChairPerson(String firstName, String lastName, int age, String gender, String address) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender; 
		this.address =  address; 
		incramentEmp++;
	
	}
	
	
	/**
	 * This method returns a string containing certain information about the individual
	 * The information includes the person's position (chair person), employeeID, salary, first name, last name, age, gender, and address
	 * @return the string containing the person's position (chair person), employeeID, salary, first name, last name, age, gender, and address
	 * */
	public String toString() {
		
		String output = null;
		
		
			
			output = String.format("Chair Person [[[%d, %.1f[%s, %s, %d, %s, %s]]]]", this.EmployeeID, this.getSalary(), this.firstName, this.lastName, this.age, this.gender, this.address);
	
		
		return output; 
		
	}
	
}


/**
 * This class represents the program director position in the computer science department 
 * */
//PROGRAMDIRECTOR
class ProgramDirector extends Administrator{
	
	String program;
	ArrayList<Faculty> newFacultyList = new ArrayList<>();
	
	/**
	 * Represents the constructor of the ProgramDiretor Object
	 * @param A string representing the first name of the individual
	 * @param A string representing the last name of the individual
	 * @param An integer representing the individual's age 
	 * @param A string representing the gender
	 * @param A String representing the address 
	 * */
	public ProgramDirector(String firstName, String lastName, int age, String gender, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender; 
		this.address =  address; 
		incramentEmp++;
	}

	/**
	 * represents the setter for the program of the program director
	 * the program director is responsible for managing either one of the three programs 
	 * @param A string representing the one of the three programs; Computer Science, Software Engineering, and Digital Technology 
	 * */
	public void setProgram(String program) {
		
		if((program.equals("Computer Science")) || (program.equals("Softare Engineering")) || (program.equals("Digital Technology"))){
			
			this.program = program;
			
		}
		
	}
	
	/**
	 * represents the getter for the program of the individual program director 
	 * @return returns the name of the program of the individual 
	 * */
	public String getProgram() {
		
		return this.program;
		
	}
	
	/**
	 * represents the setter of the faculty members that the Program Director is responsible for once hired by the CSD
	 * Once hired, faculty members within a particular program are added to the newFacultyList 
	 * @param  a particular faculty member object representing an individual faculty member 
	 * */
	public void setNewFaculty(Faculty f) throws NoSpaceException {
		
		if(newFacultyList.size()<= 25 && (newFacultyList.contains(f) != true)) {
			
			newFacultyList.add(f);
			
		}else if(newFacultyList.contains(f) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
	}
	
	/**
	 *represents the getter for the newFacultyList containing all the faculty members managed by a particular Program Director 
	 *@return  the newFacultyList containing all the faculty members managed by the PD
	 * */
	public List<Faculty> getNewFaculty() {
		
		return newFacultyList;
	}
	
	
	
}


/**
*The faculty class represents the class for the faculty members of the computer science department  
*It implements the comparable interface
*/
//FACULTY
class Faculty extends Academics implements Comparable<Faculty>{

	String program; 
	ProgramDirector PDName;
	ArrayList<UGrad> UGradAdvisorsList = new ArrayList<>();
	ArrayList<Grad> TAList = new ArrayList<>();
	
	/**
	 * Represents the constructor for the faculty object 
	 * @param A string representing the first name of the individual
	 * @param A string representing the last name of the individual
	 * @param An integer representing the individual's age 
	 * @param A string representing the gender
	 * @param A String representing the address 
	 */
	public Faculty(String firstName, String lastName, int age, String gender, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender; 
		this.address =  address; 
		incramentEmp++;
	}
	
	/**
	*Represents the setter for the program of the particular faculty member 
	*@param a string representing the program of the faculty member 
	*/
	public void setProgram(String program) {
		
			
			this.program = program;
			
		
	}
	

	/**
	*Represents the getter for the program of the particular faculty member 
	*@return the name of the program that the faculty member is apart of
	*/
	public String getProgram() {
		
		return this.program;
	}
	
	
	/**
	 * represents the setter of the undergraduate students that the faculty member is responsible for advising 
	 * once the student is admitted they will be added to the UGradAdvisorsList
	 * @param  a particular UGrad (undergraduate) object representing an individual undergraduate student
	 * */
	public void setAdvisingUgrads(UGrad s) throws NoSpaceException {
		
		if(UGradAdvisorsList.size()<= 8 && (UGradAdvisorsList.contains(s) != true)) {
			
			UGradAdvisorsList.add(s);
			
		}else if(UGradAdvisorsList.contains(s) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
	}
	
	/**
	 * Is the getter method for the UGradAdvisorsList
	 * @return the UGradAdvisorsList
	 * */
	public List<UGrad> getAdvisingUgrads() {
	
		return UGradAdvisorsList;
	}
	
	/**
	 * This method returns a string containing certain information about the individual faculty member
	 * The information includes the persons program, employeeID, salary, first name, last name, age, gender, and address
	 * @return the string containing the faculty member's, employeeID, salary, first name, last name, age, gender, and address
	 * */
	public String toString() {
		
		String output = null;
		
		if(this.program.equals("Computer Science")) {
			
			output = String.format("Faculty %s[[%d, %.1f[%s, %s, %d, %s, %s]]]", this.program, this.EmployeeID, this.salary, this.firstName, this.lastName, this.age, this.gender, this.address);
				
		}else if(this.program.equals("Software Engineering")) {
			
			output = String.format("Faculty %s[[%d, %.1f[%s, %s, %d, %s, %s]]]", this.program, this.EmployeeID, this.salary, this.firstName, this.lastName, this.age, this.gender, this.address);
				
		}else if(this.program.equals("Digital Tecnology")) {
			
			output = String.format("Faculty %s[[%d, %.1f[%s, %s, %d, %s, %s]]]", this.program, this.EmployeeID, this.salary, this.firstName, this.lastName, this.age, this.gender, this.address);
				
		}
		
		return output; 
		
	}
	
	/**
	 * represents the setter of the graduate students that the faculty member is responsible for managing
	 * this is where the TAs are hired
	 * once the student is admitted and hired they will be added to theTAList
	 * @param  a particular Grad (graduate) object representing an individual graduate student
	 * */
	public void setTAs(Grad s) throws NoSpaceException {
		
		if(TAList.size()<= 5 && (TAList.contains(s) != true)) {
			
			TAList.add(s);
			
		}else if(TAList.contains(s) == true){
			
			return;
			
		}else {
			
			throw new NoSpaceException();
			
		}
		
	}

	/**
	 * Is the getter method for the TAList
	 * @return the TAList
	 * */
	public List<Grad> getTAs() {
		
		return TAList;
	}

	/**
	 * Is the getter method responsible for returning the size of the UGradAdvisorsList
	 * @return the size UGradAdvisorsList
	 * */
	public Integer getNumOfAdvisingUGrads() {
		
		return UGradAdvisorsList.size();
	}

	/**
	 * Is the getter method responsible for returning the size of the TAList
	 * @return the size TAList
	 * */
	public Integer getNumOfTAs() {
		
		return TAList.size();
	}
	
	/**
	 * Is the setter method responsible for setting the program director name responsible for this particular faculty member
	 * @param the name of the program director 
	 * */
	public void setPD(ProgramDirector name) {
		
		this.PDName = name;
		
	}

	/**
	 * Is the getter method responsible for returning the name of the program director of the faculty member 
	 * @return the name of the program director 
	 * */
	public ProgramDirector getPD() {
		
		return PDName;
	}
	
	
	
	/** 
	 * allows comparisons between object components to be done in a particular way
	 * we can override the general way a particular method works
	 * for example in the extract methods in the CSD class we used it to concatenate the first name within a sorted list
	 * here we are concatenating the first name and last name 
	 * @param pass a Faculty object representing an individual faculty member  
	 * @return an integer value 0 if the first string is equal to the second string, otherwise it returns -1 
	 * */
	@Override
	public int compareTo(Faculty faculty) {
		
		String facultyOne = this.firstName + "," + this.lastName;
		String facultyTwo = faculty.firstName + "," + faculty.lastName;
		
		return facultyOne.compareTo(facultyTwo);
		
	}
}
	
/** 
 * This is the class representing the undergraduate students or the UGrad objects
 * */
//UNDERGRAD
class UGrad extends Student{
	
	Faculty advisorName;
	
	/**
	 * Represents the constructor for the UGrad object
	 * @param A string representing the first name of the individual
	 * @param A string representing the last name of the individual
	 * @param An integer representing the individual's age 
	 * @param A string representing the gender
	 * @param A String representing the address 
	 */
	public UGrad(String firstName, String lastName, int age, String gender, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address =  address; 
		studentIDInc++;
	}
	
	/**
	 * is the setter method responsible for setting the faculty member responsible for being the students advisor 
	 * @param a FAculty object representing an individual faculty member 
	 * */
	public void setAdvisor(Faculty name) {
		
		this.advisorName = name;
		
	}

	/**
	 * is the getter method responsible for getting the faculty member responsible for being the students advisor 
	 * @return a Faculty object representing an individual faculty member 
	 * */
	public Faculty getAdvisor() {
		
		return advisorName;
	}
	
	/**
	 * This method returns a string containing certain information about the individual student
	 * The information includes the student's undergraduate status, sudentID, first name, last name, age, gender, and address
	 * @return the string containing the Student's, studentID, first name, last name, age, gender, and address
	 * */
	public String toString() {
		
		String output = null;
		
		
		output = String.format("Undergraduate [%d[[%s, %s, %d, %s, %s]]]", this.StudentID, this.firstName, this.lastName, this.age, this.gender, this.address);
			
		
		
		return output; 
		
	}
	
	
}

/** 
 * This is the class representing the graduate students or the Grad objects
 * */
//GRAD
class Grad extends Student{
	
	Faculty advisorName;
	
	/**
	 * Represents the constructor for the Grad object
	 * @param A string representing the first name of the individual
	 * @param A string representing the last name of the individual
	 * @param An integer representing the individual's age 
	 * @param A string representing the gender
	 * @param A String representing the address 
	 */
	public Grad(String firstName, String lastName, int age, String gender, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address =  address; 
		studentIDInc++;
	}
	
	/**
	 * is the setter method responsible for setting the faculty member responsible for the student
	 * @param a Faculty object representing an individual faculty member 
	 * */
	public void setAdvisor(Faculty name) {
		
		this.advisorName = name;
		
	}

	/**
	 * is the getter method responsible for getting the faculty member responsible for the student 
	 * @return a Faculty object representing an individual faculty member 
	 * */
	public Faculty getAdvisor() {
		
		return advisorName;
	}
	
	
	/**
	 * This method returns a string containing certain information about the individual student
	 * The information includes the student's graduate status, sudentID, first name, last name, age, gender, and address
	 * @return the string containing the Student's, studentID, first name, last name, age, gender, and address
	 * */
	public String toString() {
		
		String output = null;
		
		
		output = String.format("Graduate [%d[[%s, %s, %d, %s, %s]]]", this.StudentID, this.firstName, this.lastName, this.age, this.gender, this.address);
			
		
		
		return output; 
		
	}
	
}










