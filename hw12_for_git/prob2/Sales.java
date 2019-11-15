package prob2;

public class Sales{
	private int empId;
	private double sales;
	private int week;
	
	public Sales(int empId, double sales, int week) {
		this.empId = empId;
		this.sales = sales;
		this.week = week;
	}
	
	public int getEmpId() {
		return this.empId;
	}
	
	public double getSales() {
		return this.sales;
	}
	
	public int getWeek() {
		return this.week;
	}
	
	public String toString() {
		return String.format("Sales Object: sales= %.2f, id= %d, week= %d", getSales(), getEmpId(), getWeek());
	}
}
