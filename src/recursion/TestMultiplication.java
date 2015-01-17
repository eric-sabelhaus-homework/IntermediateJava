package recursion;

import java.io.IOException;
import javax.swing.JOptionPane;

public class TestMultiplication {

	private static int num1;
	private static int num2;

	/**
	 * @param args
	 */
	public static int multIterative(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
	        return 0;
	    }
		
		int out = num1 * num2;
		
		return out;
		
	}
	
	
	public static int multRecursive(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
	        return 0;
		} else {
		    return num1 + multRecursive(num1, num2 - 1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int x = 0;
		do {
			try {
				String num1S = JOptionPane.showInputDialog("Enter 1st Integer");
			num1 = Integer.parseInt(num1S);
			if (num1 < 0) {
				JOptionPane.showMessageDialog ( null, "Please enter a positive integer");
			} else {
				x = 1;
			}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog ( null, "Please enter a whole number");
			}
		} while(x == 0);
		int z = 0;
		do {
			try {
				String num2S = JOptionPane.showInputDialog("Enter 2nd Integer");
				num2 = Integer.parseInt(num2S);
				if (num2 < 0) {
					JOptionPane.showMessageDialog ( null, "Please enter a positive integer");
				} else {
					z = 1;
				}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog ( null, "Please enter a whole number");
			}
		} while(z == 0);
		
		int answer1 = multIterative(num1, num2);
		int answer2 = multRecursive(num1, num2);
		
		System.out.println("The iterative result is: " + answer1 + "\nThe recursive result is: " + answer2);
		
		String output = "The iterative result is: " + answer1 + "\nThe recursive result is: " + answer2;

		
		JOptionPane.showMessageDialog ( null, output);
	}
	
	/*
	 * This is the discussion space
	 * 
	 * The iterative result is: 10000
	 * The recursive result is: 10000
	 * 
	 * The iterative result is: 1000000
	 * The recursive result is: 1000000
	 * 
	 * with 10000 you receive a stack overflow on the recursive output
	 * 
	 * java.lang.StackOverflowError
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:27)
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:30)
	 * 
	 * with 20000 you receive a stack overflow on the recursive output
	 * 
	 * java.lang.StackOverflowError
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:27)
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:30)
	 * 
	 * with 40000 you receive a stack overflow on the recursive output
	 * 
	 * java.lang.StackOverflowError
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:27)
	 * at recursion.TestMultiplication.multRecursive(TestMultiplication.java:30)
	 *
	 * The first two instances were not significantly smaller that the last 3, I believe
	 * that when the program tried to execute the recursive call to itself, it was literally 
	 * running down every equation to the base of the function, and the memory space flooded
	 * to an unacceptable level which would generate the overflow error. It was literally 
	 * trying to equate over 10,000 equations at once, which would flood the memory very quickly.
	 * 
	 */
}
