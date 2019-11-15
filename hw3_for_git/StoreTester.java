package prob1;

import emps.Employee;

public class StoreTester {

	public static void main(String[] args) {
		testOne();
		testTwo();
		double t3= testThree();
		System.out.println(t3 +"\n");
		double t4= testFour();
		System.out.printf("$%,.2f\n\n", t4);
		testFive();
		testSix();
		System.out.print("\n");
		testSeven();
		System.out.print("\n");
		testEight();
		
	}
	
	public static void testOne() {		//verifies employees have been added 
		Store t1= testOneHelper();
		System.out.println("TEST 1 OUTPUT:");
		
		for(int i= 0; i < t1.emps.length; i++) {
			if(t1.emps[i] != null) {
				System.out.println(t1.emps[i]);
			}
		}
		System.out.printf("Actual: "+ t1.getNumEmps() + " Expected: 2\n\n");
	}
	
	public static Store testOneHelper() {
		Store t1 = new Store();
		t1.addEmp(new Employee("Jessi",20.0));
		t1.addEmp(new Employee("Marcus", 22.0));
		return t1;
	}
	
	public static void testTwo() {		//Tests .getNumEmps method
		Store t2= new Store();
		t2.addEmp(new Employee("Sam", 17.0));
		t2.addEmp(new Employee("Smith", 112.0));
		t2.addEmp(new Employee("Juan", 51.0));
		t2.addEmp(new Employee("Maggie", 48.0));
		System.out.println("TEST 2 OUTPUT:");
		System.out.print("Number of Employees: " + t2.getNumEmps()+"\n\n");
	}
	
	public static double testThree() {	//Tests .getTotHours method
		Store t3= testThreeHelper();
		System.out.println("TEST 3 OUTPUT:");
		System.out.print("Total Employee Hours: ");
		return t3.getTotalHours();
	}
	
	public static Store testThreeHelper() {
		Store tTh= new Store();
		Employee e1= new Employee("Miguel", 20.0);
		e1.setHours(0, 8);
		e1.setHours(1, 8);
		e1.setHours(2, 8);
		e1.setHours(3, 8);
		e1.setHours(4, 8);
		e1.setHours(5, 3);
		e1.setHours(6, 2);
		
		Employee e2= new Employee("Phil", 20.0);
		e2.setHours(0, 8);
		e2.setHours(1, 8);
		e2.setHours(2, 8);
		e2.setHours(3, 8);
		e2.setHours(4, 8);
		e2.setHours(5, 2);
		e2.setHours(6, 0);
		
		tTh.addEmp(e1);
		tTh.addEmp(e2);
		
		return tTh;
	}
	
	public static double testFour() {	//tests .getTotPay method
		Store t4= testFourHelper();
		 System.out.println("TEST 4 OUTPUT:");
		 System.out.print("Total Employee Pay: ");
		 return t4.getTotalPay();
	}
	
	public static Store testFourHelper() {
		Store tester= new Store();
		Employee e1= new Employee("Mike", 20.0);
		e1.setHours(0, 0);
		e1.setHours(1, 8);
		e1.setHours(2, 8);
		e1.setHours(3, 8);
		e1.setHours(4, 8);
		e1.setHours(5, 8);
		e1.setHours(6, 0);
		
		Employee e2= new Employee("Pam", 50.0);
		e2.setHours(0, 0);
		e2.setHours(1, 0);
		e2.setHours(2, 0);
		e2.setHours(3, 0);
		e2.setHours(4, 0);
		e2.setHours(5, 0);
		e2.setHours(6, 10);
		
		Employee e3= new Employee("Roy", 30.0);
		e3.setHours(0, 0);
		e3.setHours(1, 0);
		e3.setHours(2, 0);
		e3.setHours(3, 0);
		e3.setHours(4, 0);
		e3.setHours(5, 0);
		e3.setHours(6, 0);
		
		tester.addEmp(e1);
		tester.addEmp(e2);
		tester.addEmp(e3);
		
		return tester;
	}
	
	public static void testFive() {		//tests .removeEmployee method
		Store t5= testFiveHelper();
		Store orig= testFiveHelper();
		System.out.println("TEST 5 OUTPUT:");
		System.out.println("Original:");
		for(int i= 0; i < orig.emps.length; i++) {
			if(orig.emps[i] != null) {
				System.out.println(orig.emps[i]);
			}
		}
		/*System.out.print("\n");
		System.out.println("New:");
		for(int i= 0; i < t5.emps.length; i++) {
			if(t5.emps[i] != null) {
				System.out.println(t5.emps[i]);
			}
		}*/
		System.out.print("\n");
		System.out.println("Removed Employee:\n" + t5.removeEmployee(1) + "\n");
		System.out.println("Employee in pos after shift: " + t5.getEmp(1));
		System.out.println("Actual num of Emps: "+ t5.getNumEmps() + "\n");
	}
	
	public static Store testFiveHelper() { 
		Store tester= new Store();
		tester.addEmp(new Employee("Jessi",20.0));
		tester.addEmp(new Employee("Marcus", 22.0));
		tester.addEmp(new Employee("Jhene", 22.0));
		tester.addEmp(new Employee("Chef", 22.0));
		return tester;
	}
	
	public static void testSix() {
		Store t6= testSixHelper();
		System.out.println("TEST 6 OUTPUT:");
		System.out.println(t6.toString());
		for(int i= 0; i < t6.emps.length; i++) {
			if(t6.emps[i] != null) {
				System.out.println(t6.emps[i]);
			}
		}
	}
	
	public static Store testSixHelper() {		//tests .toString method
		Store tester= new Store();
		
		Employee e1= new Employee("Mike", 20.0);
		e1.setHours(0, 0);
		e1.setHours(1, 8);
		e1.setHours(2, 8);
		e1.setHours(3, 8);
		e1.setHours(4, 8);
		e1.setHours(5, 8);
		e1.setHours(6, 0);
		
		Employee e2= new Employee("Pam", 50.0);
		e2.setHours(0, 0);
		e2.setHours(1, 0);
		e2.setHours(2, 0);
		e2.setHours(3, 0);
		e2.setHours(4, 0);
		e2.setHours(5, 0);
		e2.setHours(6, 10);
		
		Employee e3= new Employee("Roy", 30.0);
		e3.setHours(0, 0);
		e3.setHours(1, 0);
		e3.setHours(2, 0);
		e3.setHours(3, 0);
		e3.setHours(4, 0);
		e3.setHours(5, 0);
		e3.setHours(6, 0);
		
		tester.addEmp(e1);
		tester.addEmp(e2);
		tester.addEmp(e3);
		
		return tester;
	}
	
	public static void testSeven() {		//tries to add another emp to full arr
		Store t7= testSevenHelper();		//and returns num of emp in arr
		t7.addEmp(new Employee("Victor",20.0));
		System.out.println("TEST 7 OUTPUT:");
		System.out.printf("Num of Emps in arr: %d\n", t7.getNumEmps());
	}
	
	public static Store testSevenHelper() {
		Store tester= new Store();
		tester.addEmp(new Employee("A",20.0));
		tester.addEmp(new Employee("B",20.0));
		tester.addEmp(new Employee("C",20.0));
		tester.addEmp(new Employee("D",20.0));
		tester.addEmp(new Employee("E",20.0));
		tester.addEmp(new Employee("F",20.0));
		tester.addEmp(new Employee("G",20.0));
		tester.addEmp(new Employee("H",20.0));
		tester.addEmp(new Employee("I",20.0));
		tester.addEmp(new Employee("J",20.0));
		tester.addEmp(new Employee("K",20.0));
		tester.addEmp(new Employee("L",20.0));
		tester.addEmp(new Employee("M",20.0));
		tester.addEmp(new Employee("N",20.0));
		tester.addEmp(new Employee("O",20.0));
		tester.addEmp(new Employee("P",20.0));
		tester.addEmp(new Employee("Q",20.0));
		tester.addEmp(new Employee("R",20.0));
		tester.addEmp(new Employee("S",20.0));
		tester.addEmp(new Employee("T",20.0));
		
		return tester;
	}
	
	
	public static void testEight() {		//removes an employee then adds one right after
		Store t8= testEightHelper();		//then returns num of emps before and after removal
		System.out.println("TEST 8 OUTPUT:");
		System.out.printf("Original num of emps: %d\n", t8.getNumEmps());
		t8.removeEmployee(3);
		System.out.printf("Num of emps after removal: %d\n", t8.getNumEmps());
		t8.addEmp(new Employee("Newbie", 20.0));
		System.out.printf("Current num of emps: %d", t8.getNumEmps());
	}
	
	public static Store testEightHelper() {
		Store tester= new Store();
		tester.addEmp(new Employee("A",20.0));
		tester.addEmp(new Employee("B",20.0));
		tester.addEmp(new Employee("C",20.0));
		tester.addEmp(new Employee("D",20.0));
		tester.addEmp(new Employee("E",20.0));
		tester.addEmp(new Employee("F",20.0));
		tester.addEmp(new Employee("G",20.0));
		
		return tester;
	}
	

}
