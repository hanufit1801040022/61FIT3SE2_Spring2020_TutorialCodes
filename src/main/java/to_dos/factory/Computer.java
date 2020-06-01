package to_dos.factory;

// Create the Computer class that extends Course abstract class 
class Computer extends Course {
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	public void getDuration() {
		duration = 9;
		System.out.println(duration + " semesters");
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
	public void getFeePerSemester() {
		fee = 1400;
		System.out.println("$" + fee);
	}
} 
