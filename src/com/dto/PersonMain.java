package com.dto;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.FunctionalInterFace.Function;

public class PersonMain {
	public static void main(String[] args) {
		String FeMale = "female";
		List<Person> list = List.of(new Person(1, "john", "Male"), new Person(2, "Maria", "FeMale"),
				new Person(3, "Aisha", "FeMale"), new Person(4, "Alex", "Male"), new Person(5, "Alice", "FeMale"));
		// predicate For Female Value
		Predicate<Person> femalePredicate = person -> person.getGender().equalsIgnoreCase(FeMale) ;

Predicate<Person> multiPredicate= person->person.getGender().equalsIgnoreCase(FeMale) && person.getName().startsWith("A");
		Person pr = new Person();
		// ForEach Loop
		for (Person female : list) {
			System.out.println(isGenderValid(female.getGender()));
		}
System.out.println("_____________________________________");
System.out.println("Using Stream Api");
		
 
// StreamApi  Filter with Single Criteria
		list.stream().filter(femalePredicate).
      	collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("_____________________________________");
		System.out.println("Using Stream Api Multi condition Filter");
				
	
	//StreamApi  Filter with Multiple Criteria
list.stream().filter(multiPredicate).
	collect(Collectors.toList()).forEach(System.out::println);
	
System.out.println("_____________________________________");
System.out.println("Using Stream Api MAP Function");

	
	//StreamApi  Map(Give the value which we want to return ) function.....
//Note-we collect in set to return unique value
list.stream().map(person->person.getGender())
.collect(Collectors.toSet()).forEach(System.out::println);

System.out.println("_____________________________________");
System.out.println("Using Stream Api MAP Function count length");

list.stream().map(person->person.getName()
		.length()).forEach(System.out::println);



System.out.println("_____________________________________");
System.out.println("Using anyMatch()  check the value is Exist or not");
//check the Value Using anyMatch()
Predicate<Person> femailExist=person->person.getGender()=="FeMale";
boolean value= list.stream().anyMatch(femailExist);
System.out.println(value);


System.out.println("_____________________________________");


	}
	static boolean isGenderValid(String gender) {
		return gender.startsWith("M") && gender.length()==4;
	}
}
