package prob1;

public class RecursionExamples {

	public static void main(String[] args) {
		//Prob 1a
		System.out.println("PROBLEM 1A OUTPUT:");
		System.out.printf("sumSeries result= %.2f\n", sumSeries(5)); 
		System.out.print("\n");
		//Prob 1b
		System.out.println("PROBLEM 1B OUTPUT:");
		printReverse("789456123",3);
		System.out.print("\n");
		System.out.print("\n");
		//Prob 1c
		System.out.println("PROBLEM 1C OUTPUT:");
		printReverse2("789456123",3);
		System.out.print("\n");
		System.out.print("\n");
		//Prob 1d
		System.out.println("PROBLEM 1D OUTPUT:");
		System.out.printf("countDigits results= %d\n", countDigits("abc123",2,5));
		System.out.printf("countDigits results= %d\n", countDigits("2a15963bc4",3,7));
		System.out.print("\n");
		//Prob 1e
		System.out.println("PROBLEM 1E OUTPUT:");
		System.out.printf("countCode results= %d\n", countCode("Dac", "ac"));
		System.out.printf("countCode results= %d\n", countCode("Dac12ac", "ac"));
//		System.out.printf("countCode results= %d\n", countCode("acacac", "ac"));
		System.out.print("\n");
		
	}
	
	public static double sumSeries(int n) {
		//System.out.println("n= " + n);
		if(n == 0) {
			return 1;
		}
		
		else {
			if(n % 2 != 0) { //if odd
				return sumSeries(n-1)/n;
			}
				//if even
			return -sumSeries(n-1)/n;
		}
	}

	public static void printReverse(String s, int n) {
//		System.out.println("n= " + n);
//		System.out.println("s is: " + s);
//		System.out.println("s length= " + s.length());
		if(s.length() < n || n == 0) {
			System.out.print(s);
		}
		
		else {
			System.out.print(s.substring(s.length()-n, s.length()));
			s= s.substring(0, s.length()-n);
			printReverse(s, n-1);
		}
	}

	public static void printReverse2(String s, int n) {
		printReverse2(s,n,s.length());
	}

	private static void printReverse2(String s, int n, int loc) {
		if(loc < n) {
			System.out.print(s.substring(0,loc));
		}
		
		else {
			System.out.print(s.substring(loc-n, loc));
			s= s.substring(0, loc-n);
			printReverse(s, n-1);
		}
	}

	public static int countDigits(String s, int low, int high) { //still broken
		return countDigits2(s, low, high, 0); 
	}
	
	public static int countDigits2(String s, int low, int high, int count) {
		//System.out.println("Low= " + low);
		if(low == high || high > s.length()) {
			return count;
		}
				
		else {
			s= s.substring(0, high);
			if(Character.isAlphabetic(low)== true) {
				return countDigits2(s, low+1, high, count);
			}				
			return countDigits2(s, low+1, high, count+1);
		}
	}

	public static int countCode(String msg, String code ) {
		int count= countCode(msg, code, 0);	
		return count;
	}

	private static int countCode(String msg, String code, int pos ) {
		if(pos == msg.length()-1) {
			return 1;
		}
		
		else if (!(msg.contains(code))) {
			return -1;
		}
		
		else {
			return countCode(msg, code, pos+1);
		}
		
	}
}
