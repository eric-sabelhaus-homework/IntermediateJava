/**
 * 
 */
package hw3;

import javax.swing.JOptionPane;
/**
 * @author Eric Sabelhaus
 *
 */
class CheckValue {
	private static int number;
	private static String s;

	public static void main(String[] args) {
		/*
		 * Create boolean for do while statement
		 */
		boolean isCorrect = false;
		do {
			/*
			 * Try to output the integer formed from string s
			 * if it is outside of the correct parameters, it will not be accepted
			 * the program will loop until a correct value is accepted for s
			 */
			try {
				s = JOptionPane.showInputDialog(null, "Input initialization value as whole number between 9 and 99");
				number = Integer.parseInt(s);
				//less than 9?
				if (number < 9) {
					System.out.println("Invalid Input: " + s);
				//greater than 99?
				} else if (number > 99){
					System.out.println("Invalid Input: " + s);
				//Exit loop
				} else {
					isCorrect = true;
				}
			//error handling using exception	
			} catch(NumberFormatException ex) {
					System.out.println("Invalid Input: " + s);
			}
		//while statement parameters
		} while(isCorrect == false);
		//Print final output 
		System.out.println("Thank you. Initialization completed");
	}
}
