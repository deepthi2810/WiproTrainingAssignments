package smc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentGradeManagement sgm = new StudentGradeManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Display Students");
            System.out.println("6. Display Courses");
            System.out.println("7. Display Grades");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    sgm.addStudent(new Student(studentId, studentName));
                    break;

                case 2: 
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    sgm.addCourse(new Course(courseId, courseName));
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int studentIdForGrade = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter course ID: ");
                    int courseIdForGrade = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); 

                    Student studentForGrade = null;
                    for (Student student : sgm.getStudents()) {
                        if (student.getStudentId() == studentIdForGrade) {
                            studentForGrade = student;
                            break;
                        }
                    }

                    Course courseForGrade = null;
                    for (Course course : sgm.getCourses()) {
                        if (course.getCourseId() == courseIdForGrade) {
                            courseForGrade = course;
                            break;
                        }
                    }

                    if (studentForGrade != null && courseForGrade != null) {
                        sgm.assignGrade(studentForGrade, courseForGrade, grade);
                        System.out.println("Grade assigned successfully.");
                    } else {
                        System.out.println("Invalid student ID or course ID.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter student ID to calculate GPA: ");
                    int studentIdForGPA = scanner.nextInt();
                    scanner.nextLine(); 
                    Student studentForGPA = null;
                    for (Student student : sgm.getStudents()) {
                        if (student.getStudentId() == studentIdForGPA) {
                            studentForGPA = student;
                            break;
                        }
                    }

                    if (studentForGPA != null) {
                        double gpa = sgm.calculateGPA(studentForGPA);
                        System.out.println("GPA for " + studentForGPA.getSname() + " is: " + gpa);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5: 
                    sgm.displayStudents();
                    break;

                case 6: 
                    sgm.displayCourses();
                    break;

                case 7: 
                    sgm.displayGrades();
                    break;

                case 8: 
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
