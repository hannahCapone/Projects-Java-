public class StudentTest
{
	public static void main(String[] args)
	{
		// create student array that can hold both high school & college students
		Student[] stu = new Student[6];
		
		// add college students
		stu[0] = new CollegeStudent("Hannah", "Capone", "Boston", "Ma", "896 Shirley Street", "hancap1@gmail.com");
		stu[1] = new CollegeStudent("Francesca", "Capone", "Chicago", "Il", "22 Wave Ave", "hey@gmail.com");
		stu[2] = new CollegeStudent("Jennifer", "Capone", "Bronx", "Ny", "1 Arthur Ave", "banana444@gmail.com");

		// add high school students
		stu[3] = new HighSchoolStudent("Gary", "Capone", "Boston", "Ma", "123 Main Street", "fordham@gmail.com");
		stu[4] = new HighSchoolStudent("Sage", "D'Amelio", "Boston", "Ma", "77 Ingleside Ave", "sage@gmail.com");
		stu[5] = new HighSchoolStudent("Sydney", "Mignosa", "Boston", "Ma", "12 Crystal Cove Ave", "sydmig@gmail.com");
		
		// college courses
		Course one = new Course(1430, "Texts & Contexts: Postcolonial Literature", "Prof. Shu", 50);
		Course two = new Course(1431, "Discrete Structures II", "Prof. Liu", 40);
		Course three = new Course(1432, "History of Rock n' Roll", "Prof. Capone", 50);
		Course four = new Course(1433, "Spanish I", "Prof. Wright", 40);

		// high school courses
		Course a = new Course(10, "Bio", "Mr. Brown");
		Course b = new Course(11, "Chem", "Mr. Chris");
		Course c = new Course(12, "Environmental Science", "Mr. B");
		Course d = new Course(13, "Physics", "Mrs. Jen");
		Course e = new Course(14, "Computer Science", "Ms. Downes");
		Course f = new Course(15, "Statistics", "Miss. Cook");
		Course g = new Course(16, "Calculus", "Mr. Al");
		Course h = new Course(17, "Trigonometry", "Mrs. Brown");
		Course i = new Course(18, "Algebra I", "Mrs. Shanty");
		Course j = new Course(19, "Algebra II", "Ms. Norris");
		
		// assign courses to students
		stu[0].addCourse(one);
		stu[0].addCourse(two);
		stu[0].addCourse(three);
		stu[0].gradeCourse(1430, 95);
		stu[0].gradeCourse(1431, 95);
		stu[0].gradeCourse(1432, 95);

		stu[1].addCourse(three);
		stu[1].addCourse(four);

		stu[2].addCourse(three);
		stu[2].addCourse(four);
		stu[2].gradeCourse(1432, 95);

		stu[3].addCourse(a);
		stu[3].addCourse(b);
		stu[3].addCourse(c);
		stu[3].addCourse(d);
		stu[3].addCourse(e);
		stu[3].addCourse(f);
		stu[3].addCourse(g);
		stu[3].addCourse(h);
		stu[3].addCourse(i);
		stu[3].gradeCourse(10, 99);
		stu[3].gradeCourse(11, 99);
		stu[3].gradeCourse(12, 99);
		stu[3].gradeCourse(13, 99);
		stu[3].gradeCourse(10, 99);
		stu[3].gradeCourse(14, 99);
		stu[3].gradeCourse(15, 99);
		stu[3].gradeCourse(16, 99);
		stu[3].gradeCourse(17, 99);
		
		stu[4].addCourse(j);

		stu[5].addCourse(j);
		
		// final output
		for(int z = 0; z < 6; z++)
		{
			System.out.println(stu[z].toString());
			System.out.println();
		}
	}
}