package com.nit.sf.datastorage;

import java.util.Scanner;

import com.nit.sf.db.School;
import com.nit.sf.pojo.Student;

public class SchoolFrontOffice {
	public static void main(String[] args) {
// HashMap<Student, Address> map = new HashMap<>();
// 
// map.put(new Student(101, "S1", "CJ", 2500), new Address(1, "C1"));
// map.put(new Student(101, "S1", "AJ", 3500), new Address(1, "C1"));
// map.put(new Student(101, "S1", "Oracle", 1500), new Address(1, "C1"));
// map.put(new Student(102, "S2", "AJ", 3500), new Address(1, "C1"));
// map.put(new Student(102, "S2", "Oracle", 1500), new Address(1, "C1"));
// map.put(new Student(102, "S2", "cj", 2500), new Address(1, "C1"));
// map.put(new Student(102, "S2", "Cj", 2500), new Address(1, "C1"));
// 
// System.out.println(map);
		School school = new School();
		System.out.println(school);
		Scanner scn = new Scanner(System.in);
		loop: while (true) {
			System.out.println("\nChoose one option");
			System.out.println(" 1. Join student");
			System.out.println(" 2. Select All students");
			System.out.println(" 3. Select students from one course");
			System.out.println(" 4. Select one student");
			System.out.println(" 5. Remove All Students");
			System.out.println(" 6. Remove one course all Students");
			System.out.println(" 7. Remove one Student");
			System.out.println(" 8. Exit");
			System.out.print("Enter option: ");
			int option = scn.nextInt();
			scn.nextLine();
			switch (option) {
			case 1: { // Join Student
				Student s = new Student();
				System.out.print("Enter sno\t:");
				s.setSno(scn.nextInt());
				scn.nextLine();
				System.out.print("Enter sname\t:");
				s.setSname(scn.nextLine());
				System.out.print("Enter course\t:");
				s.setCourse(scn.nextLine());
				System.out.print("Enter fee\t:");
				s.setFee(scn.nextDouble());
				school.join(s);
				System.out.println(school);
				break;
			}
			case 2: { // Select All students
				var studentsMap = school.getStudents();
// studentsMap.forEach(new BiConsumer<String, Set<Student>>() {
// public void accept(String s, Set<Student> set) {
// System.out.println(s + "="+ set+"\n");
// };
// });
				studentsMap.forEach((key, value) -> {
					System.out.println(key + "=" + value + "\n");
				});
				break;
			}
			case 3: { // Select students from one course
				System.out.print("Enter course: ");
				String course = scn.nextLine();
				var studentsEnumereation = school.getStudents(course);
				while (studentsEnumereation.hasMoreElements()) {
					Student s = studentsEnumereation.nextElement();
					System.out.print(s);
				}
				System.out.println();
				break;
			}
			case 4: { // Select one student
				System.out.print("Enter sno\t: ");
				int sno = scn.nextInt();
				scn.nextLine();
				System.out.print("Enter course\t: ");
				String course = scn.nextLine();
				var student = school.getStudent(sno, course);
				System.out.println(student);
				break;
			}
			case 5: {// Remove All Students
				school.delete();
				break;
			}
			case 6: { // Remove one course all Students
				System.out.print("Enter course\t: ");
				String course = scn.nextLine();
				school.delete(course);
				break;
			}
			case 7: { // Remove one Student
				System.out.print("Enter sno\t: ");
				int sno = scn.nextInt();
				scn.nextLine();
				System.out.print("Enter course\t: ");
				String course = scn.nextLine();
				school.delete(sno, course);
				break;
			}
			case 8: {
				System.out.println("Thank You, See You Soon");
				break loop;
			}
			default: {
				System.out.println("Invalid option");
			}
			}
		}
	}
}
