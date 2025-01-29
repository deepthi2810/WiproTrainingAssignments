package smc;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeManagement {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void assignGrade(Student student, Course course, double grade) {
        grades.add(new Grade(student, course, grade));
    }

    public double calculateGPA(Student student) {
        double totalGrades = 0;
        int count = 0;

        for (Grade grade : grades) {
            if (grade.getStudent().getStudentId() == student.getStudentId()) {
                totalGrades += grade.getGrade();
                count++;
            }
        }

        return count > 0 ? totalGrades / count : 0.0;
    }

    public void displayStudents() {
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayCourses() {
        System.out.println("Course List:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void displayGrades() {
        System.out.println("Grades List:");
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }

    
    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
