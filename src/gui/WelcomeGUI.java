/**
 * 
 */
package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


/**
 * @author Eric
 *
 */
public class WelcomeGUI extends JFrame {
	//create text field
	private JTextField first = new JTextField();
	private JTextField last = new JTextField();
	private JTextField age = new JTextField();
	private JTextField output = new JTextField();
	//create button
	private JButton submit = new JButton("Submit");
	//create frames to hold data
	
	
	//construct GUI
	public WelcomeGUI() {
		JPanel textPanel = new JPanel(new GridLayout(4,2));
		textPanel.add(new JLabel("First Name:"));
		textPanel.add(first);
		textPanel.add(new JLabel("Last Name:"));
		textPanel.add(last);
		textPanel.add(new JLabel("Age:"));
		textPanel.add(age);
		textPanel.add(new JLabel("Answer:"));
		textPanel.add(output);
		textPanel.setBorder(new TitledBorder("Enter First name, Last name, and Age"));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(submit);
		
		add(textPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		submit.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String firstName = first.getText();
			String lastName = last.getText();
			String ageS = age.getText();
			int ageI = 0;
			try {
				ageI = Integer.parseInt(ageS);
				if (ageI < 0) {
					JOptionPane.showMessageDialog ( null, "Incorrect Age Format!!!");
					output.setText("Please enter a positive age amount");
				} else {
					output.setText("Welcome " + firstName + " " + lastName + " Of " + ageS + " Years Old");
				}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog ( null, "Incorrect Age Format!!!");
				output.setText("Please Enter whole number for age");
			}

		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WelcomeGUI frame = new WelcomeGUI();
		frame.pack();
		frame.setTitle("Welcome GUI");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(500,200);
	}

}
