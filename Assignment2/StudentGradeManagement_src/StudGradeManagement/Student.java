package smc;

public class Student 
{
	private int StudentId;
	private String Sname;
	
	public Student(int studentId, String sname) {
		super();
		StudentId = studentId;
		Sname = sname;
	}
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", Sname=" + Sname + "]";
	}
	

}
