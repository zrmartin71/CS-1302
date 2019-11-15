package prob1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetProblems {

	public static void main(String[] args) {
		//prob 1 test
		Set<String> names= new HashSet<>();
		names.add("Max");
		names.add("Jenne");
		names.add("Grace");
		names.add("Jasmine");
		names.add("Bart");
		System.out.println("PROB 1 TEST:");
		removeLongName(names, 5);
		System.out.println("Expected: Max Jenn Grace Bart");
		System.out.print("Actual: ");
		for(String name : names) {
			System.out.print(name + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
		
		//prob 2 test
		Set<String> names2= new HashSet<>();
		names2.add("Max");
		names2.add("Jenne");
		names2.add("Grace");
		names2.add("Jasmine");
		names2.add("Bart");
		System.out.println("PROB 2 TEST:");
		System.out.println("Original list: Max Jenne Grace Jasmine Bart");
		Set<String> longNamesOnly = separateLongNames(names2, 4);
		System.out.print("List of names > len: ");
		for(String name : longNamesOnly) {
			System.out.print(name + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
		
		//prob 3 test
		Set<String> names3= new HashSet<>();
		names3.add("Max");
		names3.add("Jenne");
		names3.add("Grace");
		names3.add("Jasmine");
		names3.add("Bart");
		names3.add("Susannah");
		System.out.println("PROB 3 TEST:");
		System.out.println("Original list: Max Jenne Grace Jasmine Bart Susannah");
		Set<String> approvedNames = getNamesByLength(names3, 5, 7);
		System.out.print("List of names b/w len1 & len2: ");
		for(String name : approvedNames) {
			System.out.print(name + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
		
		//prob 4 test
		ArrayList<String> names4= new ArrayList<>();
		names4.add("Max");
		names4.add("Jenne");
		names4.add("Grace");
		names4.add("Jasmine");
		names4.add("Max");
		names4.add("Bart");
		System.out.println("PROB 4 TEST:");
		System.out.println("Original: " + names4);
		List<String> uniqueNames = getUniqueNames(names4);
		System.out.println("Uniques names: " + uniqueNames);
		System.out.print("\n");
		
		//prob 5 test
		Set<String> names5= new HashSet<>();
		names5.add("Max");
		names5.add("Jenne");
		names5.add("Grace");
		names5.add("Jasmine");
		names5.add("Mason");
		System.out.println("PROB 5 TEST:");
		System.out.println("Expected: Max, Jenne, Grace, Jenne");
		System.out.println("Actual: " + getNamesInCommon(names3, names5));
		System.out.print("\n");
		
		//prob 6 test
		Set<String> names6= new HashSet<>();
		names6.add("Bart");
		names6.add("Tiff");
		names6.add("Geo");
		names6.add("Jasmine");
		names6.add("Mason");
		System.out.println("PROB 6 TEST:");
		System.out.println("Expected: Bart, Tiff, Geo");
		System.out.println("Actual: " + justInFirst(names6, names5));
	}
	//prob 1
	public static void removeLongName(Set<String> names, int len) {
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			if(iter.next().length() > len) {
				iter.remove();
			}
		}
	}
	
	//prob 2
	public static Set<String> separateLongNames(Set<String> names, int len){
		Iterator<String> iter = names.iterator();
		Set<String> longNames = new HashSet<>();
		while(iter.hasNext()) {
			String name= iter.next();
			if(name.length() > len) {
				longNames.add(name);
				iter.remove();
			}
		}
		
		//for testing 
		System.out.print("Original list after removal: ");
		for(String name : names) {
			System.out.print(name + " ");
		}
		System.out.print("\n");
		
		return longNames;
	}
	
	//prob 3
	public static Set<String> getNamesByLength(Set<String> names, int len1, int len2){
		Set<String> approvedNames = new HashSet<>();
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			String name= iter.next();
			if(name.length() >= len1 && name.length() <= len2) {
				approvedNames.add(name);
			}
		}
		
		return approvedNames;
	}
	
	//prob 4
	public static List<String> getUniqueNames(List<String> names){
		Set<String> uniqueNamesSet = new HashSet<>(names);
		List<String> uniqueNamesAL = new ArrayList<>();
		
		Iterator<String> iter = uniqueNamesSet.iterator();
		while(iter.hasNext()) {
			String name= iter.next();
			uniqueNamesAL.add(name);
		}
	
		return uniqueNamesAL;
	}
	
	//prob 5
	public static Set<String> getNamesInCommon(Set<String> names1, Set<String> names2) {
		Set<String> commonNames = new HashSet<>(names1);
		commonNames.retainAll(names2);
		return commonNames;
	}
	
	//prob 6
	public static Set<String> justInFirst(Set<String> names1, Set<String> names2){
		Set<String> justFirst = new HashSet<>();
		Iterator<String> iter = names1.iterator();
		while(iter.hasNext()) {
			String name= iter.next();
			if(!(names2.contains(name))) {
				justFirst.add(name);
			}
		}
		
		return justFirst;
	}

}
