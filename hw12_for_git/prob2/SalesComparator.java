package prob2;

import java.util.Comparator;

public class SalesComparator implements Comparator<Sales>{ //get help with comparator

	@Override
	public int compare(Sales s1, Sales s2) {
		if(s1.getSales() > s2.getSales()) {
			return 1;
		}
		
		else if(s1.getSales() < s2.getSales()){
			return -1;
		}
		
		else
			return s1.getEmpId() - s2.getEmpId();
	}
	
}
