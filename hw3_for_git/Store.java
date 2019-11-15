package prob1;
import emps.Employee;


public class Store {
	
	public static void main(String[] args) {
		// Test to verify signatures correct.
		Store s = new Store();
		s.addEmp(new Employee("a",10.0));
		Employee e = s.getEmp(0);
		int numEmps = s.getNumEmps();
		double totHours = s.getTotalHours();
		double totPay = s.getTotalPay();
		Employee e2 = s.removeEmployee(0);
		String str = s.toString();
	}
	
	Employee emps[] = new Employee[20];
	private int numEmps= 0;
	
	public Employee[] addEmp(Employee e) { 
		for(int i= 0; i < emps.length;){
			if(emps[i] == null) {
				emps[i]= e;
				break;
			}
			i++;
		}		
		return emps;			
	}
		
	public Employee getEmp(int empPos) {
		return emps[empPos];
	}
	
	public int getNumEmps() {
		int count= numEmps;
		for(int i= 0; i < emps.length; i++) {
			if(emps[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public double getTotalHours(){
		double totHours= 0;
		for(int i= 0; i < emps.length; i++) {
			if(emps[i] != null) {
				totHours+= emps[i].getTotalHours();
			}
		}
		
		return totHours;
	}
	
	public double getTotalPay() {
		double totPay= 0;
		for(int i= 0; i < emps.length; i++) {
			if(emps[i] != null) {
				totPay+= emps[i].getPay(); 
			}
		}
		return totPay;
	}
	
	public Employee removeEmployee(int empPos) {
		Employee removedEmp= null;
		
		if(empPos > emps.length) {
			return null;
		}
		
		else if(empPos < emps.length) {
			for(int i= 0; i < emps.length-1; i++) {
				if(i == empPos) {
					removedEmp= emps[i];
					//emps[i]= emps[i+1];
				}
				emps[i]= emps[i+1];
			}
		}
		return removedEmp;
	}
	
	public String toString() {
		int numOfEmps= getNumEmps();
		double totHours= getTotalHours();
		double totPay= getTotalPay();
		String report= String.format("Payroll Report\n\nNum Employees: %d, Total hrs: %.2f, Total pay= $%,.2f\n",numOfEmps, totHours, totPay);
		return report;
	}
	
	

}
