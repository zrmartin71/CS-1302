package prob2;

public class WarehouseTester {
// FYI: WH = warehouse

	public static void main(String [] args) {
		testOne(); //adds items to WH; tests getNumItems method & toString method
		System.out.print("\n");
		testTwo(); //tests getItem(String) method
		System.out.print("\n");
		testThree(); //test getItem(Item) method
		System.out.print("\n");
		testFour(); //tests total cost method
		System.out.print("\n");
		testFive(); //this will test the getRefrigeratedItems method
		System.out.print("\n"); 
		testSix(); //tests getTotalCostRefrigerated method
		System.out.print("\n");
		testSeven(); //tests remove method
	}
	
	public static void testOne() {
		Warehouse t1= new Warehouse();
		Item i1= new Item("Apples", 3.0);
		Item r1= new RefrigeratedItem("Milk", 1.0, 20.0);
		Item r2= new RefrigeratedItem(i1, 10.0);
		
		System.out.println("TEST 1 OUTPUT:");
		t1.addItem(i1);
		t1.addItem(r1);
		t1.addItem(r2);
		System.out.println("Expected # of items: 3 | Actual: " + t1.getNumItems());
		System.out.println(t1.toString());
	}
	
	public static void testTwo() {
		Warehouse t2= testTwoHelp();
		System.out.println("TEST 2 OUTPUT:");
		System.out.println("Expected: Name= Grapes, Cost= $1.00, Weight= 0.5");
		System.out.println("Actual: "+ t2.getItem("Grapes"));
	}
	
	public static Warehouse testTwoHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new Item("Bananas", 0.5));
		tester.addItem(new Item("Oranges", 0.5));
		tester.addItem(new Item("Apples", 0.5));
		tester.addItem(new Item("Peaches", 0.5));
		tester.addItem(new Item("Grapes", 0.5));
		
		return tester;
	}
	
	public static void testThree() {
		Warehouse t3= testThreeHelp();
		System.out.println("TEST 3 OUTPUT:");
		System.out.println("Expected: Name= Lemonade, Cost= $11.00, Weight= 2.50, Temp= 40.00 degrees");
		System.out.println("Actual: "+ t3.getItem(t3.items.get(0)));
	}
	
	public static Warehouse testThreeHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new RefrigeratedItem("Lemonade", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Orange Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Apple Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Peach Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Grape Juice", 2.5, 40));
		
		return tester;
	}
	
	public static void testFour() {
		Warehouse t4= testFourHelp();
		System.out.println("TEST 4 OUTPUT:");
		System.out.println("Expected total cost: $55.00 | Actual: " + t4.getTotalCost());
	}
	
	public static Warehouse testFourHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new RefrigeratedItem("Lemonade", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Orange Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Apple Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Peach Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Grape Juice", 2.5, 40));
		
		return tester;
	}
	
	public static void testFive() {
		Warehouse t5= testFiveHelp();
		System.out.println("TEST 5 OUTPUT:");
		System.out.println("Original AL:\n"+ t5.toString());
		//t5.getRefrigeratedItems();
		System.out.println("AL with only refrigerated items:\n" + t5.getRefrigeratedItems());
		
	}
	
	public static Warehouse testFiveHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new RefrigeratedItem("Lemonade", 2.5, 40));
		tester.addItem(new Item("Oranges", 2.5));
		tester.addItem(new RefrigeratedItem("Apple Juice", 2.5, 40));
		tester.addItem(new Item("Peachs", 2.5));
		tester.addItem(new RefrigeratedItem("Grape Juice", 2.5, 40));
		
		return tester;
	}
	
	public static void testSix() {
		Warehouse t6= testSixHelp();
		System.out.println("TEST 6 OUTPUT:");
		System.out.println("Expected Total Cost (Refrigerated): $33.00");
		System.out.printf("Actual Total Cost (Refrigerated): $%,.2f",t6.getTotalCostRefrigerated());
	}
	
	public static Warehouse testSixHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new RefrigeratedItem("Lemonade", 2.5, 40));
		tester.addItem(new Item("Oranges", 2.5));
		tester.addItem(new RefrigeratedItem("Apple Juice", 2.5, 40));
		tester.addItem(new Item("Peachs", 2.5));
		tester.addItem(new RefrigeratedItem("Grape Juice", 2.5, 40));
		
		return tester;
	}
	
	public static void testSeven() {
		Warehouse t7= testSevenHelp();
		System.out.println("TEST 7 OUTPUT");
		System.out.println("Origial WH:\n" + t7.toString() + "\n");
		System.out.println("Removed Item: " +t7.removeItem(t7.getItem("Banana Juice")) + "\n");
		System.out.println("New WH after removal:\n" + t7.toString());
	}
	
	public static Warehouse testSevenHelp() {
		Warehouse tester= new Warehouse();
		tester.addItem(new RefrigeratedItem("Banana Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Orange Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Apple Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Peach Juice", 2.5, 40));
		tester.addItem(new RefrigeratedItem("Grape Juice", 2.5, 40));
		
		return tester;
	}
	
}

