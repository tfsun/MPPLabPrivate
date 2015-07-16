package lesson11.labs.prob5;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenericHandle {
	static <T extends Comparable<T>> T SecondSmall(List<T> list) {
		T Small = list.get(0);
		T Small2  = list.get(0);
		int i = 0;
		for (; i < list.size(); i++) {
			T t = list.get(i);
			if (t.compareTo(Small) < 0) {
				Small2 = Small;
				Small = t;
				break;
			}
			else if (t.compareTo(Small) > 0) {
				Small2 = t;
				break;
			}
		}
		System.out.println("i="+i);	

		for (; i < list.size(); i++) {
			T t = list.get(i);
			if (t.compareTo(Small) < 0) {
				Small2 = Small;
				Small = t;
			}
			else if (t.compareTo(Small2) < 1){
				Small2 = t;
			}			
		} 
		return Small2;
	}
	static <T> T SecondSmall4(List<? extends T> list, Comparator<? super T> comp) {
		T Small = list.get(0);
		T Small2  = list.get(0);
		int i = 0;
		for (; i < list.size(); i++) {
			T t = list.get(i);
			if (comp.compare(t, Small) < 0) {
				Small2 = Small;
				Small = t;
				break;
			}
			else if (comp.compare(t, Small) > 0) {
				Small2 = t;
				break;
			}
		}
		System.out.println("i="+i);	

		for (; i < list.size(); i++) {
			T t = list.get(i);
			if (comp.compare(t, Small) < 0) {
				Small2 = Small;
				Small = t;
			}
			else if (comp.compare(t, Small2) < 1){
				Small2 = t;
			}			
		} 
		return Small2;
	}


	
	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1,55,2,3,66,77);
		System.out.println(SecondSmall(ints));
		
		
		Comparator<Integer> cmps = new Comparator<Integer>(){
			@Override
			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
		};
		System.out.println(SecondSmall4(ints,cmps));

	}

}
