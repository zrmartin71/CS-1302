package prob1;

import java.util.Map;
import java.util.TreeMap;

public class MapProblems1 {

	public static void main(String[] args) {
		//swapKeyValue test
		//test w/ no dups
		TreeMap<Character, Integer> tMap = new TreeMap<>();
		tMap.put('A', 8);
		tMap.put('B', 6);
		tMap.put('C', 4);
		tMap.put('G', 7);
		tMap.put('L', 5);
		tMap.put('P', 2);
		tMap.put('R', 1);
		tMap.put('V', 3);
		TreeMap<Integer, String> tMap2 = swapKeyValue(tMap);
		System.out.println("Output of tMap2 no dups: " + tMap2);
		
		//test w/ dups
		TreeMap<Character, Integer> tMap3 = new TreeMap<>();
		tMap3.put('A', 8);
		tMap3.put('B', 2);
		tMap3.put('C', 4);
		tMap3.put('G', 2);
		tMap3.put('L', 8);
		tMap3.put('P', 2);
		tMap3.put('R', 1);
		tMap3.put('V', 3);
		TreeMap<Integer, String> tMap4 = swapKeyValue(tMap3);
		System.out.println("Output of tMap4 w/ dups: " + tMap4);
		

	}
	
	public static TreeMap<Integer, String> swapKeyValue(TreeMap<Character, Integer> tMap){ //still needs work
		TreeMap<Integer, String> tMap2 = new TreeMap<Integer, String>();
		
		for(Character key : tMap.keySet()) {
			Character map2Value = key;
			int map2Key = tMap.get(key);
			if(!tMap2.containsKey(map2Key)) {
				//String str = tMap2.get(map2Key);
				//System.out.println(str);
				tMap2.put(map2Key, map2Value.toString());
			}
			
			else {
				String str = tMap2.get(map2Key) + map2Value;
				tMap2.put(map2Key, str);
			}
			
		}
	
		return tMap2;
	}

}
