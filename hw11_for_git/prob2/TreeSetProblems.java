package prob2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetProblems {

	public static void main(String[] args) {
		//prob 7 test
		List<String> names5= new ArrayList<>();
		names5.add("Max");
		names5.add("Jenne");
		names5.add("Jasmine");
		names5.add("Grace");
		names5.add("Mason");
		Set<String> names6= new TreeSet<>();
		names6.add("Bart");
		names6.add("Tiff");
		names6.add("Geo");
		names6.add("Jasmine");
		names6.add("Mason");
		System.out.println("PROB 7 TEST:");
		System.out.println("Expected: 2, 4");
		System.out.println("Actual: " + getIndicesForMatches(names5, names6));
		System.out.print("\n");
		
		//prob 8 test
		Set<String> names8= new TreeSet<>();
		names8.add("Max");
		names8.add("Jenne");
		names8.add("Jasmine");
		names8.add("Grace");
		names8.add("Mason");
		System.out.println("PROB 8 TEST:");
		System.out.println("Expected:\nSet1 = Max, Jenne, Grace\nSet2 = Bart, Tiff, Geo");
		removeDuplicates(names8, names6);
		System.out.print("\n");
		
		//prob 9 test
		HashSet<Integer> nums = new HashSet<>();
		nums.add(6);
		nums.add(5);
		nums.add(10);
		nums.add(3);
		nums.add(14);
		System.out.println("PROB 9 TEST:");
		System.out.println("Original set before removal: " + nums);
		System.out.println("Expected: 6, 10, 14");
		System.out.println("Actual: " + getBig(nums, 5));
	}
	
	//prob 7
	public static Set<Integer> getIndicesForMatches(List<String> names, Set<String> namesSet){
		Set<Integer> matches = new TreeSet<>();
		for(String name : namesSet) {
			if(names.contains(name)) {
				matches.add(names.indexOf(name));
			}
		}
		
		return matches;
	}
	
	//prob 8
	public static void removeDuplicates(Set<String> names, Set<String> names2) {
		Set<String> commonNames = new TreeSet<>(names);
		commonNames.retainAll(names2);
		for(String name : commonNames) {
			if(names.contains(name) && names2.contains(name)) {
				names.remove(name);
				names2.remove(name);
			}
		}
		
		System.out.println("Actual: Set1= " + names + " Set2= " + names2);
	}
	
	//prob 9
	public static TreeSet<Integer> getBig(HashSet<Integer> nums, int t){
		TreeSet<Integer> bigNums= new TreeSet<>(nums);
		TreeSet<Integer> smallNums= new TreeSet<>(nums);
		Iterator<Integer> iter = nums.iterator();
		while(iter.hasNext()) {
			int num= iter.next();
			if(num <= t) {
				bigNums.remove(num);
			}
			
			if(num > t) {
				smallNums.remove(num);
			}
		}

		nums.remove(t);
		nums.removeAll(smallNums);
		//for testing
		System.out.println("Original set after removal: " + nums);
		
		return bigNums;
	}
	
	

}
