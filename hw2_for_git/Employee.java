package prob1;

public class Employee {
	double[] hours = new double[7];
	String name;
	double payRate;
	
	public Employee(String name, double payRate) {
		this.name= name;
		this.payRate= payRate;		 		
	}
	
	public String getName() {
		return name;
	}
	
	public double getPayRate() {
		return payRate;
	}
	
	public double setHours(int day, double time){
		return this.hours[day] = time;  
	}
	
	public double getHours(int day) {
		return hours[day];
	}
	
	public int getNumDaysWorked() {
		int totalDaysWorked= 0;
		for(int i= 0; i < hours.length; i++) {
			if(hours[i] != 0) {
				totalDaysWorked++;
			}
		}
		return totalDaysWorked;
	}
	
	public double getTotalHours() {
		double totHours= 0;
		for(int i= 0; i < hours.length; i++) {
			totHours += hours[i];
		}
		
		return totHours;
	}
	
	public double getWeekdayHours() {
		double monToFri= 0;
		for(int i= 0; i < hours.length-2; i++) {
			monToFri += hours[i];
		}
		
		return monToFri;
	}
	
	public double getWeekendHours() {
		double satSun= 0;
		for(int i= 5; i < hours.length; i++) {
			satSun += hours[i];
		}
		
		return satSun;
	}
	
	public double getPay() {
		double totalPay= 0;
		double monToFri= getWeekdayHours();
		double satSun= getWeekendHours();
		int totalDaysWorked= getNumDaysWorked();
		double overtime= monToFri - 40;
		double timeAndHalf= timeAndHalf();
		
		if(monToFri <= 40) {
			monToFri= monToFri * payRate;
		}
		
		else if(monToFri > 40 && overtime > 0) {
			monToFri= monToFri - overtime;
			monToFri= monToFri * payRate;
			overtime= overtime * timeAndHalf;
			monToFri= monToFri + overtime;
		}
		
		satSun= (satSun * payRate) * 2;
		
		totalPay= monToFri + satSun;
		
		if(totalDaysWorked == 7) {
			totalPay= totalPay + 50;
		}
		
		return totalPay;
	}
	
	public double timeAndHalf(){
		double timeAndHalf= payRate * 1.5;
		return timeAndHalf;
	}
	
	public double[] mergeEmployee(Employee e2) {// possible problem here
		for(int i= 0; i < hours.length; i++) {
			hours[i] += e2.hours[i];
		}
		
		return hours;
	}
	
	public double[] newWeek() {
		for(int i= 0; i < hours.length; i++) {
			hours[i]= 0;
		}
		
		return hours;
	}
	
	public String toString() {
		int totalDaysWorked= getNumDaysWorked();
		double totHours= getTotalHours();
		double monToFri= getWeekdayHours();
		double satSun= getWeekendHours();
		double totalPay= getPay();
		
		String stub = String.format("PayStub\n--------\nName: %s, Pay Rate: $%.2f\nHours:",name, payRate);
		stub += String.format(" Mon: %.2f Tue: %.2f Wed: %.2f Thur: %.2f Fri: %.2f Sat: %.2f Sun: %.2f \n", hours[0], hours[1], hours[2], hours[3], hours[4], hours[5],hours[6]);
		stub += String.format("Days Worked: %d, Total Hours: %.2f \n", totalDaysWorked, totHours);
		stub += String.format("Weekday hours: %.2f, Weekend Hours: %.2f \n", monToFri, satSun);
		stub += String.format("Total Pay: $%.2f", totalPay);
				
		return stub;

	}
	
	


}
