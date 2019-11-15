package prob2;

import java.util.Comparator;

public class SecurityComparator implements Comparator<Job> {
	@Override
	public int compare(Job j1 , Job j2) { 
		if(j1.getSecurityLevel() < j2.getSecurityLevel()) {
			return 1;
		}
		
		else if(j1.getSecurityLevel() > j2.getSecurityLevel()) {
			return -1;
		}
		
		else
			return j1.getPriority() - j2.getPriority();
	}
}
