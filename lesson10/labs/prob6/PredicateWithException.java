package lesson10.labs.prob6;


import java.util.function.Predicate;



@FunctionalInterface
public interface PredicateWithException<T> {
	
		boolean test(T t) throws Exception;
		
		public static <T> Predicate<T> unchecked(PredicateWithException<T> p) {
			return t -> {	
				try {
					System.out.println("111111111111111111111111");
					System.out.println("pppppp="+p.getClass().getName());
					System.out.println("ttttttt=" + t.getClass().getName());
					return p.test(t);
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			};
		}
	
}
