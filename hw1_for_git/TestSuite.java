package prob1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * These are the test cases for this assignment. You will probably want to comment all but the first test, 
 * methods: test01 and helper01 as you work on the first required method, StringExamples.isLevel1(pwd).
 * Then, as you work on the next required methods, uncomment out the next test method. Some test methods
 * have a helper method which is generally immediately below the test method.
 * 
 * Important: If your code doesn't compile against this class then it means that you have either the
 * signature or return type of the method incorrect. If you don't fix that then the problem (or part
 * of a problem will receive no credit.
 */

public class TestSuite {

	public static ArrayList<String> test01() {
		ArrayList<String> results = new ArrayList<>();

		String[] pwds = {"abc", "abc 123", "&&&&##", "&&&#45", "**aaaa", "ttt333",
				"BBBBBB", "222^2BB", "c$aBju", "Bgg%2+"};

		results.add("isLevel1()");
		results.add("12.5");  // Problem worth (points)

		for(String pwd : pwds) helper01(pwd,results);
		return results;
	}

	private static void helper01(String pwd, ArrayList<String> results) {
		try{
			String output = String.format("isLevel1(%s)=%b", pwd, StringExamples.isLevel1(pwd));
			results.add(output);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

	}

	public static ArrayList<String> test02() {
		ArrayList<String> results = new ArrayList<>();

		String[] pwds = {"abc", "abc 123AA", "&&&&##", "&&&#45", "**aaaa", "ttt333",
				"BBBBBB", "222^2BB", "c$aBju", "Bgg%2+"};

		results.add("isLevel2()");
		results.add("12.5");  // Problem worth (points)

		for(String pwd : pwds) helper02(pwd,results);
		return results;
	}

	private static void helper02(String pwd, ArrayList<String> results) {
		try{
			String output = String.format("isLevel2(%s)=%b", pwd, StringExamples.isLevel2(pwd));
			results.add(output);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

	}

	public static ArrayList<String> test03() {
		ArrayList<String> results = new ArrayList<>();

		String[] sentences = {"The", "The red", "The red king", "The red king has the ring"};

		results.add("reverseWords()");
		results.add("25");  // Problem worth (points)

		for(String sentence : sentences) helper03(sentence,results);
		return results;
	}

	private static void helper03(String sentence, ArrayList<String> results) {
		try{
			String rev = StringExamples.reverseWords(sentence).trim();
			String output = String.format("reverseWords(%s)=%s", sentence, rev);
			results.add(output);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

	}

	public static ArrayList<String> test04() {
		ArrayList<String> results = new ArrayList<>();

		String[][] input = {
				{"*", "%"},
				{"abc", "def"},
				{"ab^c", "d**ef"},
				{"123", "456"},
				{"1&23", "456"},
				{"abc", "123"},
				{"abc", "123", "efg"},
				{"abc", "1*23", "efg"},
				{"ab1b12", "cab3b1", "%*d443a"},
		};

		results.add("getUniqueCharsAndDigits()");
		results.add("25");  // Problem worth (points)

		for(String[] ary : input) helper04(ary,results);
		return results;
	}

	private static void helper04(String[] ary, ArrayList<String> results) {
		try{
			String res = StringExamples.getUniqueCharsAndDigits(ary).trim();
			String output = String.format("getUniqueCharsAndDigits(%s)=%s", Arrays.toString(ary), res);
			results.add(output);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

	}

	public static ArrayList<String> test05() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getSmallestSalary()");
		results.add("20");  // Problem worth (points)

		try{
		 	String[] names = {"Jed", "Keisha", "Jaylen"};
			int[] ages = {22, 33, 44};
			double[] salaries = {68992.92430, 48339.23423, 121042.04328};
			String strNames = Arrays.toString(names);
			String strAges = Arrays.toString(ages);
			String strSalaries = Arrays.toString(salaries);
			String strSmallest = StringExamples.getSmallestSalaryString(names, ages, salaries);
			String report = String.format("getSmallestSalary(%s,%s,%s)=%s", strNames, strAges, strSalaries, strSmallest);

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test06() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getSmallestSalary()-only 1 in array");
		results.add("5");  // Problem worth (points)

		try{
			String[] names = {"Jed"};
			int[] ages = {22};
			double[] salaries = {12.42};
			String strNames = Arrays.toString(names);
			String strAges = Arrays.toString(ages);
			String strSalaries = Arrays.toString(salaries);
			String strSmallest = StringExamples.getSmallestSalaryString(names, ages, salaries);
			String report = String.format("getSmallestSalary(%s,%s,%s)=%s", strNames, strAges, strSalaries, strSmallest);

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

}
