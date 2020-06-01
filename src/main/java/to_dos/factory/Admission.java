package to_dos.factory;

// Create the Admission class to generate object of sub-classes
class Admission {
	// use admittingCourse method to get object of type Course
	public Course admittingCourse(String courseName) {
		//TO-DO: if courseName is null => return null
		if (courseName == null) {
			return null;
		}
		 
		//TO-DO: if courseName is similar to 1 of 3 sub-class's name => return corresponding objects
		switch (courseName.toLowerCase()) {
			case "computer":
				return new Computer();
			case "civilservice":
				return new CivilService();
			case "health":
				return new Health();
		}
	 
		//return null for default
		return null;
	}
} 