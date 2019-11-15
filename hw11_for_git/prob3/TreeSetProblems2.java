package prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetProblems2 {
	
	public static void main(String[] args) {
		//prob 10 test
		TreeSet<Integer> nums = new TreeSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		TreeSet<Integer> nums2 = new TreeSet<>();
		nums2.add(5);
		nums2.add(6);
		nums2.add(7);
		System.out.println("PROB 10 TEST");
		System.out.println("Test 1:");
		System.out.println("Expected: Sum = 38");
		System.out.println("Actual: Sum = " + getSum(nums, nums2));
		System.out.println("Test 2:");
		TreeSet<Integer> nums3 = new TreeSet<>(nums2);
		TreeSet<Integer> nums4 = new TreeSet<>(nums);
		System.out.println("Expected: Sum = 38");
		System.out.println("Actual: Sum = " + getSum(nums3, nums4));
		System.out.print("\n");
		
		//prob 11 test
		List<Integer> locations = new ArrayList<>();
		locations.add(0);
		locations.add(2);
		locations.add(4);
		List<String> words = new ArrayList<>();
		words.add("kite");
		words.add("ant");
		words.add("dog");
		words.add("bat");
		words.add("apple");
		words.add("rat");
		System.out.println("PROB 11 TEST");
		System.out.println(words);
		System.out.println("Expected: apple, dog, kite");
		System.out.println("Actual: " + getWords(locations, words));
		System.out.print("\n");
		
		//prob 12 test
		System.out.println("PROB 12 TEST");
		System.out.println("Expected: apple, dog, kite");
		System.out.println("Actual: " + getWords2(locations, words));
		System.out.println("Expected after removal: ant, bat, rat");
		System.out.println("Actual after removal: " + words);
		System.out.print("\n");
	}
	
	//prob 10
	public static int getSum(TreeSet<Integer> nums, TreeSet<Integer> nums2) {
		int sum= 0;
		ArrayList<Integer> numsAL = new ArrayList<>(nums);
		ArrayList<Integer> numsAL2 = new ArrayList<>(nums2);
		
		if(nums.size() > nums2.size()) {
			for(int i= 0; i < numsAL2.size(); i++) {
				sum+= numsAL.get(i) * numsAL2.get(i);
			}
		}
		
		if(nums.size() < nums2.size()) {
			for(int i= 0; i < numsAL.size(); i++) {
				sum+= numsAL.get(i) * numsAL2.get(i);
			}
		}
		
		return sum;
	}
	
	//prob 11
	public static Set<String> getWords(List<Integer> locations, List<String> words){
		Set<String> alphbetizedWords = new TreeSet<>();
		for(int i= 0; i < locations.size(); i++) {
			alphbetizedWords.add(words.get(locations.get(i)));
		}
		
		return alphbetizedWords;
	}
	
	//prob 12
	public static Set<String> getWords2(List<Integer> locations, List<String> words){
		Set<String> alphbetizedWords = new TreeSet<>();
		for(int i= 0; i < locations.size(); i++) {
			alphbetizedWords.add(words.get(locations.get(i)));
		}
		
		words.removeAll(alphbetizedWords);
		
		return alphbetizedWords;
	}
}
