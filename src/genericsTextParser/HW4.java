package genericsTextParser;

/*
 * author: Eric Sabelhaus
 */

//import dependencies
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class HW4 {
	/**
	 * Declare Main method
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * Read input file
		 */
		Scanner inFile = new Scanner(new File("/Users/Eric/Documents/Names.txt"));
		ArrayList<String> names = new ArrayList<String>(); {
			/**
			 * File only as many lines as are available into the list
			 */
			while (inFile.hasNextLine()){
				String currentLine = inFile.nextLine();
			    names.add(currentLine);
			}
		}
		/*
		 * Close input file
		 */
		inFile.close();
		/*
		 * Display unsorted list
		 */
		System.out.println(names);
		/**
		 * Sort the list
		 */
		Collections.sort(names);
		/*
		 * Display sorted list with duplicates
		 */
		System.out.println(names);
		/**
		 * For loops used to parse the duplicates
		 */
		int size = names.size();
		for(int i = 0; i < size; i++) { 
			for (int j = i + 1; j < size; j++) {
				/**
				 * using the list methods to sort and remove duplicates
				 */
				if (names.get(j).equals(names.get(i))) {
					names.remove(j);
					j--;
					size--;
				}
				
			}
			
		}
		/**
		 * Print the list
		 */
		System.out.println(names);
	}
}


