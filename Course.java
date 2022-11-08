public class Course // service class
{
	// instance fields
	private int courseId;
	private int numCredits;
	private int grade;
	private String descrip;
	private String instructor;

	// constructor #1
	Course(int courseId, String descrip, String instructor)
	{
		this.courseId = courseId;
		this.descrip = descrip;
		this.instructor = instructor;
	}

	// constructor #2
	Course(int courseId, String descrip, String instructor, int numCredits)
	{
		this.courseId = courseId;
		this.descrip = descrip;
		this.instructor = instructor;
		this.numCredits = numCredits;
	}

	// getter/setter methods

	// courseId
	int getCourseId()
	{
		return(courseId);
	}
	void setCourseId(int id)
	{
		courseId = id;
	}

	// numCredits
	int getNumCredits()
	{
		return(numCredits);
	}
	void setNumCredits(int credits)
	{
		numCredits = credits;
	}

	// grade
	int getGrade()
	{
		return(grade);
	}
	void setGrade(int gra)
	{
		grade = gra;
	}

	// descrip
	String getDescrip()
	{
		return descrip;
	}
	void setDescrip(String des)
	{
		descrip = des;
	}

	// instructor
	String getInstructor()
	{
		return(instructor);
	}
	void setInstructor(String instr)
	{
		instructor = instructor;
	}

	// toString() method
	public String toString()
	{
		String data = 	"Course I.D.: " + courseId + "\n" +
						"Instructor Name: " + instructor  + "\n" +
						"Description: " + descrip + "\n" +
						"Number of Credits: " + numCredits + "\n" +
						"Grade: " + grade;
		return(data);
	}


}