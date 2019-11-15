package prob2;

import java.util.ArrayList;

public class BinarySearchTester {

	public static int binarySearch( ArrayList<Blob> blobs, Blob bKey1, Blob bKey2 ) {
		int key= bKey1.getCoolnessFactor() + bKey2.getCoolnessFactor();
		int low = 0;
		int high = blobs.size();
		return binarySearchHelp(blobs, low, high, key);
	}
	
	private static int binarySearchHelp(ArrayList<Blob> blobs, int low, int high, int key) {
		int mid= (high+low)/2;
		if(mid == blobs.size()-1 || low > high) {
			return -1;
		}
//		System.out.println("Key= " + key);
		if(key == (blobs.get(mid).getCoolnessFactor() + blobs.get(mid+1).getCoolnessFactor())) {
//			System.out.println("Mid + (mid+1) clNess = " + (blobs.get(mid+1).getCoolnessFactor()+blobs.get(mid).getCoolnessFactor()));
			if(mid % 2!= 0) {

				return -1;
			}

			return blobs.indexOf(blobs.get(mid));
			
		}
		
		else if(key < (blobs.get(mid).getCoolnessFactor() + blobs.get(mid+1).getCoolnessFactor())) {
			high= mid-1;
			return binarySearchHelp(blobs, low, high, key);
		}
		
		else {
			low= mid +1;
			return binarySearchHelp(blobs, low, high, key);
		}
	}

	public static void main( String[] args ) {
		// Sample code to create a sorted Blob list with 5 twins (10 elements).
		// You should make sure your code works with other numbers of twins.
		ArrayList<Blob> blobs = buildBlobList(5);
		printBlobList(blobs);
		System.out.print(binarySearch(blobs, blobs.get(5), blobs.get(8)));
	}

	// You may use this method to build and return a sorted Blob
	// list based on sum of coolness factor for each of the twins.
	// Creates "numTwins" twins (i.e. 2*numTwins elements)
	private static ArrayList<Blob> buildBlobList(int numTwins) {
		ArrayList<Blob> blobs = new ArrayList<>();
		int cNess = 2;
		for(int i=1; i<=numTwins; i++) {
			Blob b1 = new Blob(cNess);
			cNess+=2;
			Blob b2 = new Blob(cNess--);
			blobs.add(b1);
			blobs.add(b2);
		}
		return blobs;
	}

	// You may use this method to print a blob list in a way that
	// emphasizes the twins and the sum of their coolness factors.
	private static void printBlobList(ArrayList<Blob> blobs) {
		StringBuilder sb = new StringBuilder("Sorted Blob list:\n");
		for(int i=0; i<blobs.size(); i+=2) {
			int cNess1 = blobs.get(i).getCoolnessFactor();
			int cNess2 = blobs.get(i+1).getCoolnessFactor();
			int twinPower = cNess1 + cNess2;
			sb.append(String.format("B(%d)+B(%d)=%d, ", cNess1, cNess2, twinPower));
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
	}
}
