package to_dos.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Create the CourseInformation class to generate information about the duration 
 * and fee of the course by using the Admission class to get the object of 
 * sub-classes by passing the required information like the course being applied for */
class CourseInformation {
	public static void main(String args[]) throws IOException {
		//TO-DO: Create new Admission object
		Admission admission = new Admission();
	 
		//TO-DO: Get user's input for the course's name
		System.out.print("Enter the course name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String courseName = br.readLine();
		br.close();
	 
		//TO-DO: Create new course with created Admission
		Course course = admission.admittingCourse(courseName);
		
		//TO-DO: Display the require duration in semesters, required fee per semester and for whole course
		System.out.print("Duration: ");
		course.getDuration();
		System.out.print("Required fee per semester: ");
		course.getFeePerSemester();
		System.out.print("Total: ");
		course.calculateTotalFee();
 
	}
}  