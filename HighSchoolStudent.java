public class HighSchoolStudent extends Student
{
	// constructor #1
	HighSchoolStudent(String first, String last)

	{
		super(first, last);

	}

	// constructor #2
	HighSchoolStudent(String first, String last, String address, String city, String state, String email)

	{
		super(first, last, address, city, state, email);

	}

	// override isGraduateEligible() abstract class
	boolean isGraduateEligible()
	{
		int validCourses = 0;
		for (int i = 0; i < courseCount; i++)
		{
			if(courseList[i].getGrade() > 65)
			{
				validCourses++;
			}
		}

		if (validCourses >= 24)
			return true;
		return false;
	}
}