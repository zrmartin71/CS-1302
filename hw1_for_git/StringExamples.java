package prob1;

import java.util.Arrays;

public class StringExamples {
	public static void main(String[] args) {
		
	}


	//Methods 1 & 2
	
	public static boolean isLevel1(String password) {
		int count= 0;
		if(longEnough(password)&& noSpace(password)) {
			if(hasUc(password)) count++;
			if(hasLc(password)) count++;
			if(hasDigit(password)) count++;
			if(count >=2)
				return true;
		}
		return false;
	}
	
	public static boolean isLevel2(String password) {
		if(longEnough(password)&& noSpace(password)&&
				hasUc(password)&&
				hasLc(password)&&
				hasDigit(password))
				return true;
		return false;
	}
	
	public static boolean longEnough(String pw) {
		if(pw.length() >= 6)
			return true;
		
		return false;
	}
	
	public static boolean noSpace(String pw) {
		for(int i= 0; i < pw.length(); i++) {
			if(Character.isWhitespace(pw.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasUc(String pw) {
		for(int i= 0; i < pw.length(); i++ ) {
			if(Character.isUpperCase(pw.charAt(i))) {
				return true;
			}
		}	
		return false;	
	}
	
	public static boolean hasLc(String pw) {
		for(int i= 0; i < pw.length(); i++) {
			if(Character.isLowerCase(pw.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasDigit(String pw) {
		for(int i= 0; i < pw.length(); i++) {
			if(Character.isDigit(pw.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	//Method 3
	public static String reverseWords(String str) {
		String str2= "";
		int temp= str.length()-1;
		
		for(int i= str.length()-1; i > 0; i--) {
				if(Character.isWhitespace(str.charAt(i))) {
					str2 += str.substring(i, temp+1) + " ";
						temp= i;
				 }            
 		}
      
      str2 += str.substring(0, temp+1);
      str2= str2.replaceAll("\\s+", " ");
		return str2;
	}



	//Method 4
	public static String getUniqueCharsAndDigits(String[] arr) {
		String str= Arrays.toString(arr);
      String str2= "";
     
      for(int j= 0; j < str.length(); j++){
			if(Character.isLetter(str.charAt(j))) {
				str2 += str.charAt(j);
					if(Character.isDigit(str.charAt(j))) {
						str2 += str.charAt(j);
					}
			}
       }
      
		for(int i= 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				str2 += str.charAt(i);
					if(Character.isLetter(str.charAt(i))) {
						str2 += str.charAt(i);
					}
			}
		}
		
		String noDupStr= removeDups(str2);
		
		return noDupStr;
	}
	
	public static String removeDups(String str){
		String str2= "";
		for(int i= 0; i < str.length(); i++) {
			if(!(str2.contains(String.valueOf(str.charAt(i))))){
				str2 += String.valueOf(str.charAt(i));
			}
		}
		return str2;
	}
	
	//Method 5
	public static String getSmallestSalaryString(String[] names, int[] ages, double[] salaries) {
		int smallSalIndex= smallestSal(salaries);
		
		return String.format("Smallest salary:$%,.2f, Name:%s, age:%d" , salaries[smallSalIndex], names[smallSalIndex], ages[smallSalIndex]);
	}
		
		
	public static int smallestSal(double[] salaries) {
		int smallSalIndex= 0;
		double maxSal= 0;
				
      for(int i= 0; i < salaries.length; i++) {
		if(salaries[i] > maxSal) {
				maxSal= salaries[i];
			}
         
        if(salaries[i] < maxSal) {            
            smallSalIndex= i;
         }  
      }
      
		return smallSalIndex;
	}

	
}
