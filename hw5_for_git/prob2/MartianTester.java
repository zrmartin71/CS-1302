package prob2;


public class MartianTester {
	//FYI: Test 8 does a re-test for the compareTo method
	//FYI2: Test Zero Martians are used in most tests plus additional Martians
	//add a test where you try to add a clone to the AL

	public static void main(String[] args) throws CloneNotSupportedException {
		testOne(); //tests Martian toString method
		System.out.print("\n");
		testTwo(); //tests Martian equals method
		System.out.print("\n");
		testThree(); //tests Martian compareTo method
		System.out.print("\n");
		testFour(); //tests Martian clone method
		System.out.print("\n");
		testFive(); //tests addMartian method and setVolume method
		System.out.print("\n");
		testSix(); //tests groupSpeak method
		System.out.print("\n");
		testSeven(); //tests groupTeleport method
		System.out.print("\n");
		testEight(); //tests getNumMartians/Teleporters methods and MartianAt method
		System.out.print("\n");
		testNine(); //tests getTeleporterAt method
		System.out.print("\n");
		testTen(); //tests getMartianWithId method
		System.out.print("\n");
		testEleven(); //tests getMartianClosestTo method
		System.out.print("\n");
		testTwelve(); //tests removeMartian method
		System.out.print("\n");
		testThirteen(); //tests sort method
		System.out.print("\n");
		testFourteen(); //tests obliterate method
		System.out.print("\n");
		testFifteen();
	}
	

	
	public static void testOne() {
		MartianManager t1 = new MartianManager();
		System.out.println("TEST 1 OUTPUT:");
		System.out.println("Expected: Red Martian - id= 1, vol= 1 | Actual: " + t1.r1.toString());
	}
	
	public static void testTwo() {
		MartianManager t2 = new MartianManager();
		System.out.println("TEST 2 OUTPUT:");
		System.out.println("Expected: True | Actual: " + t2.r2.equals(t2.g2));
		System.out.println("Expected: False | Actual: " + t2.r2.equals(t2.r1));
	}
	
	public static void testThree() {
		MartianManager t3 = new MartianManager();
		System.out.println("TEST 3 OUTPUT:");
		System.out.println("Expected: -1 | Actual: " + t3.r1.compareTo(t3.r2));
	}
	
	public static void testFour() throws CloneNotSupportedException {
		MartianManager t4 = new MartianManager();
		System.out.println("TEST 4 OUTPUT:");
		System.out.println("Expected: Green martian - id= 1, vol= 1 | Actual: " + t4.g1.clone());
	}
	
	public static void testFive() {
		MartianManager t5 = testFiveHelp();
		System.out.println("TEST 5 OUTPUT:");
		t5.addMartian(new RedMartian(3));
		t5.r1.setVolume(3);
		t5.addMartian(new GreenMartian(3));
		System.out.println("Expected: Red Martian - id= 1, vol= 3 | Actual: "+ t5.r1.toString());
		System.out.println("Expected: Red Martian - id= 3, vol= 1 | Actual: " + t5.martians.get(4).toString());
		System.out.println("Expected: Green martian - id= 1, vol= 1, Green martian - id= 2, vol= 1 Green martian - id= 3, vol= 1| Actual:\n" + t5.teleporters.toString());
	
	}
	
	public static MartianManager testFiveHelp() {
		MartianManager tester = new MartianManager();
		tester.martians.add(tester.g1);
		tester.martians.add(tester.g2);
		tester.teleporters.add(tester.g1);
		tester.teleporters.add(tester.g2);
		tester.martians.add(tester.r1);
		tester.martians.add(tester.r2);
		
		return tester;
	}
	
	public static void testSix() {
		MartianManager t6 = testSixHelp();
		System.out.println("TEST 6 OUTPUT:");
		System.out.print(t6.groupSpeak());
	}
	
	public static MartianManager testSixHelp() {
		MartianManager tester = new MartianManager();
		tester.martians.add(tester.g1);
		tester.martians.add(tester.g2);
		tester.teleporters.add(tester.g1);
		tester.teleporters.add(tester.g2);
		tester.martians.add(tester.r1);
		tester.martians.add(tester.r2);
		
		return tester;
	}
	
	public static void testSeven() {
		MartianManager t7 = testSevenHelp();
		t7.addMartian(new GreenMartian(3));
		System.out.println("TEST 7 OUTPUT:");
		System.out.println("Expected:\nid= 1 teleporting to Mars\nid= 2 teleporting to Mars\nid= 3 teleporting to Mars\n");
		System.out.println("Actual:\n" + t7.groupTeleport("Mars"));
		
	}
	
	public static MartianManager testSevenHelp() {
		MartianManager tester = new MartianManager();
		tester.martians.add(tester.g1);
		tester.martians.add(tester.g2);
		tester.teleporters.add(tester.g1);
		tester.teleporters.add(tester.g2);
		tester.martians.add(tester.r1);
		tester.martians.add(tester.r2);
		
		return tester;
	}
	
	public static void testEight() {
		MartianManager t8 = testSevenHelp();
		System.out.println("TEST 8 OUTPUT:");
		System.out.println("Expected num of Martians: 4 | Actual: " + t8.getNumMartians());
		System.out.println("Expected num of Teleporters: 2 | Actual: " + t8.getNumTeleporters() + "\n");
		t8.addMartian(new GreenMartian(3));
		t8.addMartian(new RedMartian(3));
		t8.addMartian(new RedMartian(4));
		System.out.println("Expected num of Martians: 6 | Actual: " + t8.getNumMartians());
		System.out.println("Expected num of Teleporters: 3 | Actual: " + t8.getNumTeleporters() + "\n");
		
		System.out.println("Part Two- getMartianAt(5):");
		System.out.println("Expected: Red Martian - id= 4, vol= 1 | Actual: " + t8.getMartianAt(5));
	}
	
	public static MartianManager testEightHelp() {
		MartianManager tester = new MartianManager();
		tester.martians.add(tester.g1);
		tester.martians.add(tester.g2);
		tester.teleporters.add(tester.g1);
		tester.teleporters.add(tester.g2);
		tester.martians.add(tester.r1);
		tester.martians.add(tester.r2);
		
		return tester;
	}
	
	public static void testNine() {
		MartianManager t9 = testNineHelp();
		System.out.println("TEST 9 OUTPUT:");
		System.out.println("Expected: Green Martian - id= 2, vol= 1 | Actual: " + t9.getMartianAt(1));
	}
	
	public static MartianManager testNineHelp() {
		MartianManager tester = new MartianManager();
		tester.martians.add(tester.g1);
		tester.martians.add(tester.g2);
		tester.teleporters.add(tester.g1);
		tester.teleporters.add(tester.g2);
		tester.martians.add(tester.r1);
		tester.martians.add(tester.r2);
		
		return tester;
	}
	
	public static void testTen() {
		MartianManager t10 = testTenHelp();
		System.out.println("TEST 10 OUTPUT:");
		t10.addMartian(new RedMartian(5));
		System.out.println("Expected: Red Martian - id= 5, vol= 1 | Actual: " + t10.getMartianWithId(2));
	}
	
	public static MartianManager testTenHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(3));
		tester.addMartian(new RedMartian(4));
		return tester;
	}
	
	public static void testEleven() {
		MartianManager t11 = testElevenHelp();
		System.out.println("TEST 11 OUTPUT:");
		System.out.println("Expected: Red Martian - id= 9, vol= 1 | Actual: " + t11.getMartianClosestTo(10));
	}
	
	public static MartianManager testElevenHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(6));
		tester.addMartian(new RedMartian(9));
		tester.addMartian(new RedMartian(13));
		tester.addMartian(new RedMartian(18));
		return tester;
	}
	
	public static void testTwelve() {
		MartianManager t12 = testTwelveHelp(); 
		System.out.println("TEST 12 OUTPUT:");
		System.out.println("Orignial List:");
		System.out.println(t12.groupSpeak());
		System.out.println("Expected: True | Actual: " + t12.removeMartian(9));
		System.out.println("Expected: True | Actual: " + t12.removeMartian(5) + "\n");
		System.out.println("After Removal:");
		System.out.print(t12.groupSpeak());
		
	}
	
	public static MartianManager testTwelveHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(6));
		tester.addMartian(new RedMartian(9));
		tester.addMartian(new RedMartian(13));
		tester.addMartian(new RedMartian(18));
		tester.addMartian(new GreenMartian(5));
		return tester;
	}
	
	public static void testThirteen() throws CloneNotSupportedException {
		MartianManager t13 = testThirteenHelp();
		System.out.println("TEST 13 OUTPUT:");
		System.out.println("Orignial List:");
		System.out.println(t13.martians.toString() + "\n");
		System.out.println("Sorted List:");
		System.out.println(t13.sortedMartians());
	}
	
	public static MartianManager testThirteenHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(3));
		tester.addMartian(new RedMartian(11));
		tester.addMartian(new GreenMartian(5));
		tester.addMartian(new GreenMartian(1));
		return tester;
	}
	
	public static void testFourteen() {
		MartianManager t14 = testFourteenHelp();
		System.out.println("TEST 14 OUTPUT:");
		System.out.println("Orignial Martians List:");
		System.out.println(t14.martians.toString() + "\n");
		System.out.println("Orignial Teleporters List:");
		System.out.println(t14.teleporters.toString() + "\n");
		t14.obliterateTeleporters();
		System.out.println("After Obliteration:");
		System.out.println("Martians List:");
		System.out.println(t14.martians.toString());
		System.out.println("Teleporters List:");
		System.out.println(t14.teleporters.toString());
		
		
	}
	
	public static MartianManager testFourteenHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(3));
		tester.addMartian(new RedMartian(11));
		tester.addMartian(new GreenMartian(5));
		tester.addMartian(new GreenMartian(1));
		return tester;
	}
	
	public static void testFifteen() throws CloneNotSupportedException {
		MartianManager t15 = testFifteenHelp();
		MartianManager clone= (MartianManager) t15.clone();
		System.out.println("TEST 15 OUTPUT:");
		System.out.println("Test 15 Martians Speak:\n" + t15.groupSpeak());
		System.out.println("Clone Test 15 Martians Speak:\n" + clone.groupSpeak());
	}
	
	public static MartianManager testFifteenHelp() {
		MartianManager tester = new MartianManager();
		tester.addMartian(new RedMartian(3));
		tester.addMartian(new RedMartian(11));
		tester.addMartian(new GreenMartian(5));
		tester.addMartian(new GreenMartian(1));
		return tester;
	}

}
