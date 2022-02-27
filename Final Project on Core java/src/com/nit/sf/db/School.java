package com.nit.sf.db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.nit.sf.pojo.Student;

public class School {
	// Data Base Table code
	private HashMap<String, Set<Student>> map;

	public School() {
		deserialize();
	}

//Insert row code 
	public void join(Student s) {
		Set<Student> hs = map.get(s.getCourse());
		if (hs == null) {
			hs = new HashSet<>();
			hs.add(s);
			map.put(s.getCourse(), hs);
		} else {
			hs.add(s);
		}
		serialize();
		System.out.println("Student data is saved successfully");
	}

//Select without where retrieving all students
	public Map<String, Set<Student>> getStudents() {
		return map;
	}

//Select with where retrieving all students of a course
	public Enumeration<Student> getStudents(String course) {
		return Collections.enumeration(map.get(course));
	}

//Select with where means retrieving for particular student 
	public Student getStudent(int sno, String course) {
		Set<Student> set = map.get(course);
		// imperative approach -means complete code your are developing
//     for(Student ele : hs) {
//    if(ele.getSno() == sno) {
//    return ele;
//    }
//     }
// hs.stream()
// .filter(new Predicate<Student>() {
// @Override
// public boolean test(Student ele) {
// return ele.getSno() == sno;
// }
// });
		// Declarative approach -means functional based LE code
		// you are not writing complete code, you are calling predefined method
		// by passing only coding with the help of LE
		return set.stream().filter(ele -> ele.getSno() == sno).findFirst().get();
	}

//Delete all students
	public void delete() {
		map.clear();
		serialize();
		System.out.println("All students are removed");
	}

//Delete with where all students in a particular course
	public void delete(String course) {
		map.remove(course);
		serialize();
		System.out.println("All students are removed from the givne course ");
	}

//Delete with where one particular student 
	public void delete(int sno, String course) {
		Student s = new Student();
		s.setCourse(course);
		s.setSno(sno);
		Set<Student> hs = map.get(course);
		hs.remove(s);
		serialize();
		System.out.println("student object is removed");
	}

	// Deserialization
	@SuppressWarnings("unchecked")
	private void deserialize() {
		try (FileInputStream fis = new FileInputStream("studentDB.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object obj = ois.readObject();
			map = (HashMap<String, Set<Student>>) obj;
		} catch (IOException e) {
			e.printStackTrace();
			map = new HashMap<>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// serialization
	private void serialize() {
		try (FileOutputStream fos = new FileOutputStream("studentDB.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return map.toString();
	}
}