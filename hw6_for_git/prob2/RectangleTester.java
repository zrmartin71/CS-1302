package prob2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RectangleTester {
	private static final String IN_FILE_NAME = "src\\prob2\\rectangles.txt";
	private static final String OUT_FILE_NAME = "src\\prob2\\illegalRectangle.txt";
	protected static ArrayList<Rectangle> recs= new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		File inFile= new File(IN_FILE_NAME);
		File outFile= new File(OUT_FILE_NAME);
		String line= "";
		String[] splitter= null;
		double width= 0;
		double length= 0;
				
		Scanner input = new Scanner(inFile);
		PrintWriter output = new PrintWriter(outFile);

		if(args.length == 2) {
			input = new Scanner(new File(args[0]));
			output = new PrintWriter(new File(args[1]));
		}
		
		try {
			while(input.hasNext()) {
				line= input.nextLine();
				splitter= line.split(" ");
				for(int i= 0; i < splitter.length; i++) {
					/*double*/ width= Double.parseDouble(splitter[0]);
					/*double*/ length= Double.parseDouble(splitter[1]);
					Rectangle r = new Rectangle(width, length);
					recs.add(r);
					continue;
				}
			}
			input.close();
		}
		
		catch(IllegalRectangleException ire){
			System.out.println(ire);
			output.printf("Illegal Rectangle: Width= %.2f, Height= %.2f, Area= %.2f", ire.getWidth(), ire.getHeight(), ire.getArea());
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		finally {
			System.out.println(recs);
			System.out.println("Recs size= " + recs.size());
			System.out.println(line);
			System.out.println("Width= " + width);
			System.out.println("Length= " + length);
		}
		output.close();
	}

}
