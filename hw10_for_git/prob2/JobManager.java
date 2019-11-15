package prob2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobManager {
	Queue<Job> jobs;
	boolean isPriority;
	
	public JobManager(boolean isPriority) {
		this.isPriority= isPriority;
		if(isPriority == true) {
			jobs= new PriorityQueue<Job>(new PriorityComparator());
		}
		else {
			jobs= new PriorityQueue<Job>(new SecurityComparator());
		}
	}
	
	public void offer(Job job) {
		jobs.offer(job);
	}
	
	public Job peek() {
		return jobs.peek();
	}
	
	public Job poll() {
		return jobs.poll();
	}
	
	public void setPriority(boolean isPriority) {
		this.isPriority= isPriority;
		Queue<Job> jobsTemp;

        if(isPriority) {
        	jobsTemp = new PriorityQueue<Job>(new PriorityComparator());
        }

        else {
        	jobsTemp = new PriorityQueue<Job>(new SecurityComparator());
        }
          
        jobsTemp.addAll(jobs);
        jobs = jobsTemp;
	}
	
	public boolean getPriority() {
		return this.isPriority;
	}
	
	public boolean isEmpty() {
		return jobs.isEmpty();
	}
	
	public ArrayList<Job> flush(){
		ArrayList<Job> jobsArray = new ArrayList<>();
		jobsArray.addAll(jobs);
		jobs.clear();
		return jobsArray;
	}
}
