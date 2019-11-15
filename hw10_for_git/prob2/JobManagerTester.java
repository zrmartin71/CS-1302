package prob2;

public class JobManagerTester {

	public static void main(String[] args) {
		//Tests isEmpty method & offer method
		testOne();
		System.out.print("\n");
		//Tests setPriority method
		testTwo();
		System.out.print("\n");
		//Tests flush method
		testThree();
		
	}
	
	public static void testOne() {
		JobManager tester = new JobManager(true);
		System.out.println("TEST 1 OUTPUT:");
		System.out.println("Expected: Empty? true | Actual: Empty? " +tester.isEmpty());
		tester.jobs.offer(new Job(4,3));
		System.out.println("Expected: Empty? false | Actual: Empty? " +tester.isEmpty());
	}
	
	public static void testTwo() {
		JobManager tester = new JobManager(true);
		System.out.println("TEST 2 OUTPUT:");
		System.out.println("Original Priority: " + tester.getPriority());
		tester.setPriority(false);
		System.out.println("Expected: false | Actual: " +tester.getPriority());
	}
	
	public static void testThree() {
		JobManager tester = new JobManager(false); //security
		JobManager tester2 = new JobManager(true); //priority
		System.out.println("TEST 3 OUTPUT:");
		tester.jobs.offer(new Job(7,3));
		tester.jobs.offer(new Job(5,6));
		tester.jobs.offer(new Job(8,2));
		tester.jobs.offer(new Job(4,9));
		tester.jobs.offer(new Job(6,9));
		tester.jobs.offer(new Job(12,10));
		
		tester2.jobs.offer(new Job(7,3));
		tester2.jobs.offer(new Job(7,4));
		tester2.jobs.offer(new Job(5,6));
		tester2.jobs.offer(new Job(8,2));
		tester2.jobs.offer(new Job(4,9));
		tester2.jobs.offer(new Job(12,10));
		System.out.println("Queue Priority: " + tester.getPriority());
		System.out.println("Queue Priority 2: " + tester2.getPriority());
		System.out.println("ArrayList of jobs:" + tester.flush());
		System.out.println("ArrayList of jobs 2:" + tester2.flush());
	}
	
	public static void testFour() {
		JobManager tester = new JobManager(true);
		System.out.println("TEST 4 OUTPUT:");
		tester.jobs.offer(new Job(7,3));
		tester.jobs.offer(new Job(5,6));
		tester.jobs.offer(new Job(8,2));
		tester.jobs.offer(new Job(4,9));
		tester.jobs.offer(new Job(12,10));
		
	}

}
