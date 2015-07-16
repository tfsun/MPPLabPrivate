package lesson9.labs.prob7b;

//import Employee;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;



public class MyTestForLab8Prob6 {

	//A
	Function<Employee,String> getName1 = (Employee x) -> x.getName(); 
	Function<Employee,String> getName2 = Employee::getName;
	
	//static Consumer<String> consumer = new Consumer<String>() {
	final Function<Employee,String> getName3 = new Function<Employee,String>() {
		@Override
		public String apply(Employee t) {
			// TODO Auto-generated method stub
			return t.getName();
		}
		
		
	};
	
	class Functionaaa implements Function<Employee,String> {
		@Override
		public String apply(Employee t) {
			// TODO Auto-generated method stub
			return t.getName();
		}
	};
	
	//B (Employee e,String s) -> e.setName(s)
	BiConsumer<Employee,String> setName1 = (Employee x, String name) -> x.setName(name);
	BiConsumer<Employee,String> setName2 = Employee::setName; 
	
	//C
	//(String s1,String s2) -> s1.compareTo(s2)
	BiFunction<String, String, Integer> compareTo1 =  (String s1,String s2) -> s1.compareTo(s2); 
	BiFunction<String, String, Integer> compareTo2 =  String::compareTo;
	
	//D (Integer x,Integer y) -> Math.pow(x,y)
	BiFunction<Integer, Integer, Double> pow1 =  (Integer x,Integer y) -> Math.pow(x,y); 
	BiFunction<Integer, Integer, Double> pow2 =  Math::pow; 
	
	//E (Apple a) -> a.getWeight()
	//Function<Apple,String> getName1 = (Apple x) -> x.getName(); 
	
	//F. (String x) -> Integer.parseInt(x);
	Function<String,Integer> parseInt1 = (String x) -> Integer.parseInt(x); 
	Function<String,Integer> parseInt2 = Integer::parseInt; 
	
	//G. EmployeeNameComparator comp = new EmployeeNameComparator();
	//(Employee e1, Employee e2) -> comp.compare(e1,e2)
	 //EmployeeNameComparator comp = new EmployeeNameComparator();
	
	class EmployeeNameComparator implements Comparator<Employee> { 
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getLastName());
		}
	}
	EmployeeNameComparator comp = new EmployeeNameComparator();
	BiFunction<Employee, Employee, Integer> compare1 =  (Employee e1, Employee e2) -> comp.compare(e1,e2);
	BiFunction<Employee, Employee, Integer> compare2 =  comp::compare;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTestForLab8Prob6 my = new MyTestForLab8Prob6();
		my.evaluator();
	}
	
	void evaluator() {
		Employee e1 = new Employee("aaa", "bbb", 100);
		Employee e2 = new Employee("ccc", "ddd", 200);
		System.out.println(getName1.apply(e1));
		System.out.println(getName2.apply(e1));
		
		setName1.accept(e1, "ccc");
		System.out.println(getName2.apply(e1));
	}
}
