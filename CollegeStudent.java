public class CollegeStudent extends Student
{
	// constructor #1
	public CollegeStudent(String first, String last)

	{
		super(first, last);

	}

	// contstructor #2
	public CollegeStudent(String first, String last, String address, String city, String state, String email)

	{
		super(first, last, address, city, state, email);

	}

	// override isGraduateEligible() abstract class
	boolean isGraduateEligible()
	{
		int validCredits = 0;
		for (int i = 0; i < courseCount; i++)
		{
			if(courseList[i].getGrade() > 70)
			{
				validCredits += courseList[i].getNumCredits();
			}
		}

		if (validCredits >= 132)
			return true;
		return false;
	}
}