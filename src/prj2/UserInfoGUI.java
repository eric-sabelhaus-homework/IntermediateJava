/**
 * Displays the input given by the user
 */
package prj2;

//import dependancies
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;


/**
 * @author Eric
 *
 */
public class UserInfoGUI extends JFrame {
	//create text field
	private JTextField first = new JTextField();
	private JTextField last = new JTextField();
	private JTextField age = new JTextField();
	//create radio buttons
	private JRadioButton m = new JRadioButton("Male");
	private JRadioButton f = new JRadioButton("Female");
	//create button
	private JButton submit = new JButton("Submit");
	//create an array of all US states
	private String[] states = {"Alabama" , "Alaska" , "American Samoa" , "Arizona" , "Arkansas" ,
			"California" , "Colorado" , "Connecticut" , "Delaware" , "District of Columbia" , 
			"Florida" , "Georgia" , "Guam" , "Hawaii" , "Idaho" , "Illinois" , "Indiana" , 
			"Iowa" , "Kansas" , "Kentucky" , "Louisiana" , "Maine" , "Maryland" , "Massachusetts" , 
			"Michigan" , "Minnesota" , "Mississippi" , "Missouri" , "Montana" , "Nebraska" , 
			"Nevada" , "New Hampshire" , "New Jersey" , "New Mexico" , "New York" , 
			"North Carolina" , "North Dakota" , "Northern Marianas Islands" , "Ohio" , "Oklahoma" , 
			"Oregon" , "Pennsylvania" , "Puerto Rico" , "Rhode Island" , "South Carolina" , 
			"South Dakota" , "Tennessee" , "Texas" , "Utah" , "Vermont" , "Virginia" , 
			"Virgin Islands" , "Washington" , "West Virginia" , "Wisconsin" , "Wyoming"};
	//create JTextArea
	protected JTextArea output = new JTextArea(null , 5, 20);
	//create combo box of states
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox jcbo = new JComboBox(states);
	//initialize string for current state, defaulted to the first state in the list in case nothing is selected
	private String currentState = "Alabama";
	//Initialize gender string
	private String gender = "";
	//construct GUI
	public UserInfoGUI() {
		
		//construct text panels
		JPanel textPanel = new JPanel(new GridLayout(3,3));
		textPanel.add(new JLabel("First Name:"));
		textPanel.add(first);
		textPanel.add(new JLabel("Last Name:"));
		textPanel.add(last);
		textPanel.add(new JLabel("Age:"));
		textPanel.add(age);
		textPanel.setBorder(new TitledBorder("Enter First name, Last name, and Age"));
		add(textPanel, BorderLayout.CENTER);
		
		//construct radio button panel
		JPanel rButtonPanel = new JPanel(new GridLayout(1,1));
		rButtonPanel.add(m);
		rButtonPanel.add(f);
		rButtonPanel.setBorder(new TitledBorder("Select Gender"));
		add(rButtonPanel, BorderLayout.NORTH);
		
		//construct button group
		ButtonGroup sex = new ButtonGroup();
		sex.add(m);
		sex.add(f);
		
		//settings for text area
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(false);
		output.setForeground(Color.black);
		output.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		//construct output panel
		JPanel outputPanel = new JPanel(new GridLayout(1,1));
		outputPanel.add(output);
		outputPanel.setBorder(new TitledBorder("Info Received"));
		add(outputPanel, BorderLayout.SOUTH);
		
		//construct submit button panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(submit);
		add(buttonPanel, BorderLayout.EAST);
		
		//add combo box
		add(jcbo, BorderLayout.WEST);
		
		//action listener for male gender selection
		m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setGender();
			}
		});
		
		//action listener for female gender selection
		f.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setGender();
			}
		});
		
		//action listener for combo box
		jcbo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setSelectedState(jcbo.getSelectedIndex());
			}
		});
		
		//action listener for gui execution
		submit.addActionListener(new ButtonListener());
	
	}
	
	//return the string of the current gender
	private String setGender() {
		if (m.isSelected()) {
			gender = (m.isSelected() ? "Male" : "");
		} else {
			gender = (f.isSelected() ? "Female" : "");
		} 
		return gender;
	}
	
	//return the string of the current state
	public String setSelectedState(int index){
		currentState = states[index];
		return currentState;
	}
	
	//execute the gui with all arguments and conditional parameters
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
				} else if (firstName != null && firstName.length() == 0) {
					output.setText("Please enter a first name");
				} else if (lastName != null && lastName.length() == 0) {
					output.setText("Please enter a last name");
				} else if (gender != null && gender.length() == 0){
					output.setText("Please Select a Gender");
				} else {				
					output.setText("First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + ageS + " Years Old" + "\nGender: " + gender + "\nState of Residence: " + currentState);
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
	
	//main method to initiate the GUI
	public static void main(String[] args) {
		UserInfoGUI frame = new UserInfoGUI();
		frame.pack();
		frame.setTitle("User Info");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(800,400);
	}

}
