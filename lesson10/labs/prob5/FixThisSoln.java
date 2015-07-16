package lesson10.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThisSoln {
	List<String> processList(List<String> list) {

	    return list.stream()
	    		   //.map((String t) -> FunctionWithException.unchecked((String x) -> doNothingIfShort(x)).apply(t))
	               .map((String t) -> FunctionWithException.unchecked((String x) -> doNothingIfShort(x)).apply(t))
	    		   .collect(Collectors.toList());
	}
	
	 
	String doNothingIfShort(String input) throws InputTooLongException {
		System.out.println("2222222222222222");
	    if (input.length() > 3) throw new InputTooLongException();
	    else return input;
	}
	
	public static void main(String[] args) {
		FixThisSoln ft = new FixThisSoln();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet","jjjjjj");
		System.out.println(ft.processList(words1));
	}
	
	class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;
		public InputTooLongException() {
			super("Must be length 3 or less");
		}
		public InputTooLongException(String s) {
			super(s);
		}
		public InputTooLongException(Throwable t) {
			super(t);
		}
	}
}
