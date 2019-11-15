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

		results.add("getName() & getPayRate()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			String report = String.format("getName()=%s", e.getName());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			String report = String.format("getPayRate()=$%,.2f", e.getPayRate());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test01b() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getHours()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 2);
			e.setHours(1, 4);
			e.setHours(2, 6);
			e.setHours(6, 8);
			
			String report = String.format("getHours(1)=%.2f, getHours(6)=%.2f", e.getHours(1), e.getHours(6));
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test02() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getNumDaysWorked()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(5, 4);
			
			String report = String.format("getNumDaysWorked()=%d", e.getNumDaysWorked());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test03() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getTotalHours()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 8);
			e.setHours(1, 7.5);
			e.setHours(2, 8);
			e.setHours(5, 4);
			
			String report = String.format("getTotalHours()=%.2f", e.getTotalHours());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test04() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getWeekdayHours()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 8);
			e.setHours(1, 7.5);
			e.setHours(2, 8);
			e.setHours(5, 4);
			
			String report = String.format("getWeekdayHours()=%.2f", e.getWeekdayHours());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test05() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getWeekendHours()");
		results.add("5");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 8);
			e.setHours(1, 7.5);
			e.setHours(2, 8);
			e.setHours(5, 4);
			
			String report = String.format("getWeekendHours()=%.2f", e.getWeekendHours());
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test06() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getNumDaysWorked() et.al.-change hours several times");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Janice", 40.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(5, 4);
			e.setHours(1, 4);
			e.setHours(5, 2);
			
			String report = String.format("getNumDaysWorked()=%d, ", e.getNumDaysWorked());
			report += String.format("getTotalHours()=%.2f, ", e.getTotalHours());
			report += String.format("getWeekdayHours()=%.2f, ", e.getWeekdayHours());
			report += String.format("getWeekendHours()=%.2f", e.getWeekendHours());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test07() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- 0 weekday, 0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Waldo", 25.0);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test07b() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- <40 weekday, 0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Waldo", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test08() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- <40 weekday, >0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Rena", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(6, 8);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test09() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- =40 weekday, 0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Salvatore", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(3, 8);
			e.setHours(4, 8);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test10() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- >40 weekday, 0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Delia", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(3, 8);
			e.setHours(4, 10);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test11() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- >40 weekday, >0 weekend");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Nate", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(3, 8);
			e.setHours(4, 10);
			e.setHours(5, 2);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test12() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- =40 weekday, >0 weekend, 7 days");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Bisley", 25.0);
			e.setHours(0, 8);
			e.setHours(1, 8);
			e.setHours(2, 8);
			e.setHours(3, 8);
			e.setHours(4, 8);
			e.setHours(5, 2);
			e.setHours(6, 2);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test13() {
		ArrayList<String> results = new ArrayList<>();

		results.add("getPay()- <40 weekday, >0 weekend, 7 days");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Orin", 25.0);
			e.setHours(0, 4);
			e.setHours(1, 4);
			e.setHours(2, 4);
			e.setHours(3, 4);
			e.setHours(4, 4);
			e.setHours(5, 2);
			e.setHours(6, 2);
			
			String report = String.format("getPay()=$%,.2f", e.getPay());

			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test14() {
		ArrayList<String> results = new ArrayList<>();

		results.add("e1.merge(e2)");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Kathy", 25.0);
			for(int i=0; i<3; i++) e.setHours(i, 8);
			e.setHours(3, 2);
			
			Employee e2 = new Employee("Kathy", 25.00);
			e2.setHours(3, 4);
			e2.setHours(4,10);
			e.mergeEmployee(e2);
			
			String report = String.format("getNumDaysWorked()=%d, ", e.getNumDaysWorked());
			report += String.format("getTotalHours()=%.2f, ", e.getTotalHours());
			report += String.format("getWeekdayHours()=%.2f, ", e.getWeekdayHours());
			report += String.format("getWeekendHours()=%.2f", e.getWeekendHours());
			
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}

	public static ArrayList<String> test15() {
		ArrayList<String> results = new ArrayList<>();

		results.add("newWeek()");
		results.add("10");  // Problem worth (points)

		try{
			Employee e;
			e = new Employee("Kathy", 25.0);
			for(int i=0; i<7; i++) e.setHours(i, 8);
			e.newWeek();
			
			String report = String.format("getNumDaysWorked()=%d, ", e.getNumDaysWorked());
			report += String.format("getTotalHours()=%.2f, ", e.getTotalHours());
			report += String.format("getWeekdayHours()=%.2f, ", e.getWeekdayHours());
			report += String.format("getWeekendHours()=%.2f", e.getWeekendHours());
			
			results.add(report);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		
		return results;
	}
}
