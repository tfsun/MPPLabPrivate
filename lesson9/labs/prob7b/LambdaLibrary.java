package lesson9.labs.prob7b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//class EmployeeComparator implements Comparator<String>	{
//	@Override
//	public int compare(String e1, String e2) {
//		return e1.compareTo(e2);
//	}
//}



public class LambdaLibrary {
	public static final TriFunction<List<Employee>, Integer, Character, String> SEARCHNAME 
		=  (list, minSalary, ch) -> list.stream().filter(e -> e.getSalary() > minSalary)
										.filter(e -> e.getLastName().charAt(0) > ch )
										.map(e -> e.getFirstName() + " " + e.getLastName())
										.sorted()
										.collect(Collectors.joining(","));
		
//	public static final TriFunction<List<Employee>, Integer, Character, List<String>> SEARCHNAME1
//		= (list, minSalary, ch) -> list.stream().filter(e -> e.getSalary() > minSalary)
//										.filter(e -> e.getLastName().charAt(0) > ch )
//										.map(e -> e.getFirstName() + " " + e.getLastName())
//										.sorted()
//										.collect(Collectors.toList());

	static	Comparator<String> strComp1 = (s1,s2) -> s1.compareTo(s2);
	static	Comparator<String> strComp2 = String::compareTo;	
	public static final TriFunction<List<Employee>, Integer, Character, List<String>> SEARCHNAME1
		= new TriFunction<List<Employee>, Integer, Character, List<String>>() {
			
			@Override
			public List<String> apply(List<Employee> s, Integer t, Character u) {
				List<String> employees = new ArrayList<String>();
				for (Employee employee : s) {
					if (employee.getSalary()>t && employee.getLastName().charAt(0)>u) {
						employees.add(employee.firstName + " " + employee.getFirstName() );
					}
				}
				//Collections.sort(employees, new EmployeeComparator());
				employees.sort(strComp2);
				return employees;
			}
			
		};
		
}
