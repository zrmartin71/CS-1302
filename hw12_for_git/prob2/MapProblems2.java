package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapProblems2 {

	public static void main(String[] args) {
		//workedBoth test
		System.out.println("WorkedBoth Test Output");
		HashMap<Integer, Double> week1 = new HashMap<>();
		week1.put(43, 100.10);
		week1.put(19, 200.50);
		week1.put(7, 300.25);
		week1.put(28, 110.00);
		HashMap<Integer, Double> week2 = new HashMap<>();
		week2.put(92, 200.00);
		week2.put(28, 190.00);
		week2.put(7, 100.75);
		week2.put(51, 200.25);
		week2.put(63, 100.10);
		Map<Integer, Double> workedBothWeeks = workedBoth(week1, week2);
		System.out.println("Employees that worked both weeks:\n" + workedBothWeeks);
		System.out.print("\n");
		
		//onlyWorkedOne test
		System.out.println("OnlyWorkedOne Test Output");
		HashMap<Integer, Double> week3 = new HashMap<>(week1);
		HashMap<Integer, Double> week4 = new HashMap<>(week2);
		Map<Integer, Double> workedOneWeek = onlyWorkedOne(week3, week4);
		System.out.println("Employees that worked one week:\n" + workedOneWeek);
		System.out.print("\n");
		
		//sortSale test
		System.out.println("SortSale Test Output");
		List<Map<Integer, Integer>> listOfMaps = new ArrayList<>();
		HashMap<Integer, Integer> w1 = new HashMap<>();
		w1.put(1, 50);
		w1.put(2, 300);
		w1.put(3, 200);
		HashMap<Integer, Integer> w2 = new HashMap<>();
		w2.put(2, 50);
		w2.put(3, 25);
		HashMap<Integer, Integer> w3 = new HashMap<>();
		w3.put(1, 25);
		w3.put(3, 25);
		w3.put(4, 50);
//		HashMap<Integer, Integer> w4 = new HashMap<>();
//		w4.put(5, 13);
//		w4.put(6, 300);
		listOfMaps.add(w1);
		listOfMaps.add(w2);
		listOfMaps.add(w3);
//		listOfMaps.add(w4);
		for( Sales result : sortSale(listOfMaps)) {
			System.out.println(result);
		}
	}
	
	public static Map<Integer, Double> workedBoth(HashMap<Integer, Double> week1, HashMap<Integer, Double> week2 ){
		Map<Integer, Double> outputMap = new TreeMap<Integer, Double>();
		for(int key : week1.keySet()) {
			if(week2.containsKey(key)) {
				outputMap.put(key, week2.get(key) + week1.get(key));
			}
		}
		
		return outputMap;
	}
	
	public static Map<Integer, Double> onlyWorkedOne(HashMap<Integer, Double> week1, Map<Integer, Double> week2 ){
		Map<Integer, Double> outputMap = new TreeMap<Integer, Double>();
		for(int key : week1.keySet()) {
			if(!(week2.containsKey(key))) {
				outputMap.put(key, week1.get(key));
			}
		}
		
		for(int key : week2.keySet()) {
			if(!(week1.containsKey(key))) {
				outputMap.put(key, week2.get(key));
			}
		}
		return outputMap;
	}
	
	public static List<Sales> sortSale(List<Map<Integer, Integer>> listOfMaps){
		List<Sales> sortedSales= new ArrayList<>();
		for(int i= 0; i < listOfMaps.size(); i++) {
			Map<Integer, Integer> inputMap = listOfMaps.get(i);
			for(int key : inputMap.keySet()) {
				Sales newSale = new Sales(key, inputMap.get(key), i+1);
				sortedSales.add(newSale);
			}
		}
		
		Collections.sort(sortedSales, new SalesComparator());
		
		return sortedSales;
	}

}
