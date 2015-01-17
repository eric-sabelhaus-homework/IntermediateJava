package finalProject;
/*
 *Author: Eric Sabelhaus
 *Class: ReadStoreShow
 *
 * Import dependencies
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/*
 * Define public class 
 */
public class ReadStoreShow {
	/*
	 * Initiate Private Static methods for array and string value
	 */
	private static String[] cols = null;
	private static String currentMin;
	/*
	 * Size checking method
	 */
	public static int sizeCheck(int i) throws Exception{
		if(i < 10) {
			throw new Exception("Exception: Too Few Colors Listed, Please list 10 Colors");
		} else if (i > 20) {
			throw new Exception("Exception: Too Many Colors Listed, Please List Fewer than 20 Colors");
		}
		return i;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * Read input file
		 */
		Scanner inFile = new Scanner(new File("ColorHexValues.txt"));
		/*
		 * Initialize ArrayLists
		 */
		ArrayList<String> colorsHex = new ArrayList<String>();
		ArrayList<String> colors = new ArrayList<String>(); {
			/**
			 * File only as many lines as are available into the list
			 */
			while (inFile.hasNextLine()){
				String currentLine = inFile.nextLine();
			    colors.add(currentLine);
			}
			
		}	

		
		/*
		 * Close input file
		 */
		inFile.close();
		
		
		/*
		 * Use size checking method
		 */	
		int size = 0;
		try {
			size = sizeCheck(colors.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Run for loop to generate Hex colors array
		 */
		for(int i = 0; i < size; i++){
			/**
			 * using the array list tools to sort the hex value into their own array list
			 */
			cols = colors.get(i).split(" ");
			colorsHex.add(cols[1]);
			
		}
		/*
		 *Print Hex Colors and Colors for comparison 
		 */
		System.out.println(colorsHex);
		System.out.println(colors);
		/*
		 * Sort through colors and arrange in ascending order by Hex value
		 */
		for(int x = 0; x < colors.size(); x++) {
			for(int y = x + 1; y < colors.size(); y++) {
				int result = colorsHex.get(y).compareTo(colorsHex.get(x));
				
				if(result > 0) {
					currentMin = colors.get(y);
					colors.remove(y);
					colors.add(currentMin);
				}
			}
		}
		/*
		 * Iterate the sorted list
		 */
		Iterator<String> paintBrush = colors.iterator();		
		while(paintBrush.hasNext()) {
			String out = paintBrush.next();
			System.out.println(out);
		}
	}


}