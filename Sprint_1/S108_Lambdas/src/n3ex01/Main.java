package n3ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// Create a list with 10 students
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("John",20,"DB",3.75f));
		students.add(new Student("Ann",25,"PHP",8.4f));
		students.add(new Student("Alex",49,"Java",4.5f));
		students.add(new Student("Mary",22,"Js",9.5f));
		students.add(new Student("Simon",47,"HTML",10.0f));
		students.add(new Student("Aubrey",51,"DB",9.75f));
		students.add(new Student("George",56,"Cobol",8.5f));
		students.add(new Student("Andrew",42,"Js",5.0f));
		students.add(new Student("Linda",18,"PHP",9.5f));
		students.add(new Student("Imogen",32,"Java",6.75f));
		
		
		System.out.println("Show name and age of each student:");
		students.stream().forEach(stud -> System.out.println("Name: " + stud.getName() + ", Age: " + stud.getAge()));
		
		
		/* Filter list by students' name starting by 'a' and save them into a new list 
		and show it (everything with lambdas) */
		System.out.println("\nNew list of the students (their name start by 'A'): ");
		List<Student> studNameA = new ArrayList<Student>(); 
		studNameA = students.stream().filter(stud -> stud.getName().startsWith("A"))
						 	.collect(Collectors.toList());
		studNameA.forEach(stud -> System.out.println(stud));
		
		
		System.out.println("\nStudents with 5 or plus mark");
		students.stream().filter(stud -> stud.getMark() >= 5)
						 .forEach(System.out::println);
		
		System.out.println("\nStudents with 5 or plus mark and their subject isn't PHP");
		students.stream().filter(stud -> (stud.getMark() >= 5) && (stud.getSubject() != "PHP"))
		 				 .forEach(System.out::println);
	}

}
