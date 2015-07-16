package lesson11.labs.prob5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondSmallest {
    public static void secondSmallest(List<? extends Number> numbers){
        double smallest1 = numbers.get(0).doubleValue();
        double smallest2 = numbers.get(0).doubleValue();

        int size = numbers.size();
        for (int index = 1; index < size - 1; index++) {
            double current =numbers.get(index).doubleValue();

            if(smallest1 > current){
                smallest2 = smallest1;
                smallest1 = current;
            }
            else if( current != smallest1 && smallest2>current){
                smallest2 = current;
            }
        }
        System.out.println(smallest2);
//        return smallest2;
    }
    

    public static <T extends Comparable<T>> T secondSmallest2(List<T> list){
    	T smallest = list.get(0);
    	T secondSmallest = list.get(1);
    	return secondSmallest;
    }
    public static <T> T secondSmallest3(List<T> list, Comparator<T> comp){
        T smallest1= list.get(0);
        T smallest2 =list.get(1);

        return smallest2;
    }
    
    // why it's super in Comparator?
    public static <T> T secondSmallest4(List<? extends T> list, Comparator<? super T> comp){
    	T smallest1 = list.get(0);
    	T smallest2 = list.get(0);

        for (int i=1; i< list.size();i++){
            T current= list.get(i);
            if(comp.compare(current,smallest1)<0){
                smallest2=smallest1;
                smallest1=current;
            }
            else if(current != smallest1 && comp.compare(current,smallest2)<0){
                smallest2 = current;
            }
        }
        return smallest2;
    }
    
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>(){
            {
                add(-1);
                add(1);
                add(8);
                add(-5);
                add(-1);
                add(-5);
                add(4);
            }
        };

        List<Double> doubles = new ArrayList<Double>(){
            {
                add(-1.1);
                add(1.1);
                add(8.0);
                add(-5.0);
                add(-1.1);
                add(-5.0);
                add(4.2);
            }
        };

        secondSmallest(integers);
        secondSmallest(doubles);
        Comparator<Integer> cmps = new Comparator<Integer>(){
			@Override
			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
        };
        System.out.println("Use Comparator:" + secondSmallest4(integers, cmps));

    }
}
