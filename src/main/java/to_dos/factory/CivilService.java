package to_dos.factory;

// Create the CivilService class that extends Course abstract class 
class CivilService extends Course {
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	public void getDuration() {
		duration = 5;
		System.out.println(duration + " semesters");
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
	public void getFeePerSemester() {
		fee = 1250;
		System.out.println("$" + fee);
	}
}