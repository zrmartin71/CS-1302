package prob1;

public class EmployeeDriver {

	public static void main(String[] args) {
		Employee e1= new Employee("James", 25);
			e1.setHours(0,8);
			e1.setHours(1,8);
			e1.setHours(2,8);
			e1.setHours(3,8);
			e1.setHours(4,10);
			e1.setHours(5,2);
			e1.setHours(6,2);
			System.out.println(e1);
			
			Employee e2= new Employee("Jessi", 25);
			e2.setHours(0,8);
			e2.setHours(1,8);
			e2.setHours(2,0);
			e2.setHours(3,8);
			e2.setHours(4,0);
			e2.setHours(5,2);
			e2.setHours(6,2);
			System.out.println(e2);
			
			System.out.println("Employee merger");
			System.out.println(e1.mergeEmployee(e2));
			
	
	}

}
