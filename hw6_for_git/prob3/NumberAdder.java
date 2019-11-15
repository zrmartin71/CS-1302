package prob3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberAdder {
	      
	private static final String IN_FILE_NAME = "src\\prob3\\values.txt";
	protected static ArrayList<String> nums= new ArrayList<>();
	 
	public static void main(String[] args) throws FileNotFoundException {
	            
	             String inFileName = IN_FILE_NAME;
	             // In case file name is passed in
	             if(args.length == 2) {
	                    inFileName = args[0];
	             }
	 
	             System.out.println("Sum=" + getSum(inFileName));
	}
	      
	public static int getSum(String inFileName) {
		File readNums= new File(inFileName); 
		String num= "";
		int sum= 0;
		int numOfSkips= 0;

		try {
			Scanner input = new Scanner(readNums);
			while(input.hasNext()) {
				num= input.nextLine();
				if(num.startsWith("s")) {
					numOfSkips= Integer.parseInt(num.substring(1));					
					for(int i= 0; i < numOfSkips; i++) {
						num= input.nextLine();
					}
					continue;
				}
				
				nums.add(num);
			}
			input.close();
		}
		
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		catch(IOException f) {
			System.out.println(f);
		}
		
		for(int i= 0; i < nums.size(); i++) {
			sum+= Integer.parseInt(nums.get(i));
		}
		
		return sum;
	}     
}

