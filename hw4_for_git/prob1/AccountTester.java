package prob1;

public class AccountTester {

	public static void main(String[] args) {
		//Tests for CheckingAccount (WD= withdraw)
		testOne(); //makes sure account is made properly
		System.out.print("\n");
		testTwo(); //tests deposit method
		System.out.print("\n");
		testThree(); //tests toString method
		System.out.print("\n");
		testFour(); //tests withdraw method: Single WD; no limit hit or balance check involved
		System.out.print("\n");
		testFive(); //tests ONLY get isLowBalance method
		System.out.print("\n");
		testSix(); //tests going over withdraw limit w/ bal > 100
		System.out.print("\n");
		testSeven(); //tests $2 WD limit fee
		System.out.print("\n");
		testEight(); //test $20 overdraft fee
		System.out.print("\n");
		testNine(); //tests overdraft fee & WD limit
		System.out.print("\n");
		testTen(); //tests endOfMonth method makes sure WDs are reset
		System.out.print("\n");
		testEleven(); //tests endOfMonth w/ low bal & 2WDs
		System.out.print("\n");
		testTwelve(); //tests endOfMonth w/ low bal and overdrafts it
		System.out.print("\n");
		
		//GCA tests start here
		testThirteen(); //makes sure GCA is made properly
		System.out.print("\n");
		testFourteen(); //tests WD limit
		System.out.print("\n");
		testFifteen(); //tests WD limit & overdraft fee
		System.out.print("\n");
		testSixteen(); //tests endOfMonth interest 
		System.out.print("\n");
		testSeventeen(); //tests endOfMonth w/ low bal, WD limit, & overdraft
	}
	
	public static void testOne() {
		CheckingAccount t1= new CheckingAccount(1,100);
		System.out.println("TEST 1 OUTPUT:");
		System.out.printf("Account %d balance: $%,.2f\n", t1.getId(), t1.getBalance());
	}
	
	public static void testTwo() {
		CheckingAccount t2= new CheckingAccount(2,100);
		System.out.println("TEST 2 OUTPUT:");
		System.out.printf("Previous balance: $%,.2f\n", t2.getBalance());
		t2.deposit(40);
		System.out.printf("New balance: $%,.2f\n", t2.getBalance());		
	}
	
	public static void testThree() {
		CheckingAccount t3= new CheckingAccount(3,100);
		System.out.println("TEST 3 OUTPUT:");
		System.out.println(t3.toString());
	}
	
	public static void testFour() {
		CheckingAccount t4= new CheckingAccount(4,150);
		System.out.println("TEST 4 OUTPUT:");
		System.out.println("Balance before withdraw: $150.00");
		t4.withdraw(50);
		System.out.println(t4.toString());
	}
	
	public static void testFive() {
		CheckingAccount t5= new CheckingAccount(5,10);
		System.out.println("TEST 5 OUTPUT:");
		System.out.println("Expected: True | Actual: " + t5.isLowBalance());
	}
	
	public static void testSix() {
		CheckingAccount t6= new CheckingAccount(6,350);
		System.out.println("TEST 6 OUTPUT:");
		System.out.println("Balance before withdraws: $350.00");
		t6.withdraw(50);
		t6.withdraw(50);
		t6.withdraw(50);
		t6.withdraw(50);
		System.out.println("Expected balance: $148.00");
		System.out.println(t6.toString());
	}
	
	public static void testSeven() {
		CheckingAccount t7= new CheckingAccount(7,50);
		t7.numWithdrawals= 3;
		System.out.println("TEST 7 OUTPUT:");
		System.out.println("Balance before fee deduction: $50.00");
		t7.withdraw(5);
		System.out.println("Expected: $43.00");
		System.out.println(t7.toString());
	}
	
	public static void testEight() {
		CheckingAccount t8= new CheckingAccount(8,200);
		System.out.println("TEST 8 OUTPUT:");
		System.out.println("Balance before overdraft: $200.00");
		t8.withdraw(300);
		System.out.println("Expected: $-120.00");
		System.out.println(t8.toString() + "\n");
		
		System.out.println("Part 2:");
		System.out.println("Expected after $80.00 withdraw: $-220.00");
		t8.withdraw(80);
		System.out.println(t8.toString());	
	}
	
	public static void testNine() {
		CheckingAccount t9= new CheckingAccount(9,500);
		System.out.println("TEST 9 OUTPUT:");
		t9.withdraw(100);
		t9.withdraw(100);
		t9.withdraw(100);
		System.out.println("Expected balance after 3 withdrawls: $200.00\nActual: " + t9.toString());
		System.out.print("\n");
		t9.withdraw(300);
		System.out.println("Expected after 4th WD of $300: $-122.00\nActual: "+ t9.toString());
	}
	
	public static void testTen() {
		CheckingAccount t10= new CheckingAccount(10,654);
		t10.numWithdrawals= 3;
		System.out.println("TEST 10 OUTPUT:");
		t10.endOfMonth();
		System.out.println(t10.toString());
		
	}
	
	public static void testEleven() {
		CheckingAccount t11= testElevenHelp();
		System.out.println("TEST 11 OUTPUT:");
		t11.endOfMonth();
		System.out.println("Expected after service charge: $15.00");
		System.out.println(t11.toString());
	}
	
	public static CheckingAccount testElevenHelp() {
		CheckingAccount tester= new CheckingAccount(11,225);
		tester.withdraw(100);
		tester.withdraw(100);
		
		return tester;
	}
	
	public static void testTwelve() {
		CheckingAccount t12= testTwelveHelp();
		System.out.println("TEST 12 OUTPUT:");
		t12.endOfMonth();
		System.out.println("Expected after service charge and overdraft: $-25.00");
		System.out.println(t12.toString());
	}
	
	public static CheckingAccount testTwelveHelp() {
		CheckingAccount tester= new CheckingAccount(12,15);
		tester.withdraw(10);
		
		return tester;
	}
	
	public static void testThirteen() {
		GoldCheckingAccount t13= new GoldCheckingAccount(13,1000);
		System.out.println("TEST 13 OUTPUT:");
		System.out.println(t13.toString());
	}
	
	public static void testFourteen() {
		GoldCheckingAccount t14= new GoldCheckingAccount(14,1000);
		System.out.println("TEST 14 OUTPUT:");
		t14.numWithdrawals= 3;
		t14.withdraw(50);
		System.out.println("Expected after WD and WD limit: $948.00");
		System.out.println(t14.toString());
	}
	
	public static void testFifteen() {
		GoldCheckingAccount t15= testFifteenHelp();
		t15.withdraw(1100);
		System.out.println("TEST 15 OUTPUT:");
		System.out.println("Expected after all transactions: $-122.00");
		System.out.println(t15.toString());
	}
	
	public static GoldCheckingAccount testFifteenHelp() {
		GoldCheckingAccount tester= new GoldCheckingAccount(15,1200);
		tester.withdraw(50);
		tester.withdraw(50);
		tester.withdraw(100);
		
		return tester;
	}
	
	public static void testSixteen() {
		GoldCheckingAccount t16= new GoldCheckingAccount(16,1500);
		t16.numWithdrawals= 2;
		t16.endOfMonth();
		System.out.println("TEST 16 OUTPUT:");
		System.out.println("Expected after interest: $1515.00");
		System.out.println(t16.toString());
	}
	
	public static void testSeventeen() {
		GoldCheckingAccount t17= testSeventeenHelp();
		t17.withdraw(1100);
		System.out.println("TEST 17 OUTPUT:");
		t17.endOfMonth();
		System.out.println("Expected after all transactions: $-157.00");
		System.out.println(t17.toString());
	}
	
	public static GoldCheckingAccount testSeventeenHelp() {
		GoldCheckingAccount tester= new GoldCheckingAccount(17,1200);
		tester.withdraw(50);
		tester.withdraw(50);
		tester.withdraw(100);
		
		return tester;
	}

}