package to_dos.builder;

//Create the Student class with a static nested (inner class)
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	private String course;

	// TO-DO: Implement the constructor
	public Student(StudentBuilder studentBuilder) {
		this.id = studentBuilder.id;
		this.firstName = studentBuilder.firstName;
		this.lastName = studentBuilder.lastName;
		this.age = studentBuilder.age;
		this.phone = studentBuilder.phone;
		this.address = studentBuilder.address;
		this.course = studentBuilder.course;
	}

	// TO-DO: Implement GETTERs & SETTERs for given attributes
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// TO-DO: Implement toString() method to display student's information
	@Override
	public String toString() {
		return getClass().getSimpleName() + ":<id=" + id + ",firstName=" + firstName + ",lastName=" + lastName + ",age="
				+ age + ",address=" + address + ",course=" + course + ">";
	}

	// Create the StudentBuilder inner class
	public static class StudentBuilder {
		// TO-DO: Initialize the similar attributes with Student class
		private int id;
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;
		private String course;

		// TO-DO: Implement the constructor
		public StudentBuilder(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		// TO-DO: Implement the 3 below methods
		public StudentBuilder withOptionalAge(int age) {
			this.age = age;
			return this;
		}

		public StudentBuilder withOptionalPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public StudentBuilder withOptionalAddress(String address) {
			this.address = address;
			return this;
		}

		public Student buildStudent() {
			validateStudentData();
			return new Student(this);
		}

		private boolean validateStudentData() {
			// Validation process, check if student is registered in the database
			return true;
		}
	}
}
