package smallManufacturingCompany;

import javax.swing.JOptionPane;

class TestOrders {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//initiate order input values for first two objects
		String name1 = JOptionPane.showInputDialog("Input Client Name:");
		String sID1 = JOptionPane.showInputDialog("Input Order ID:");
		String sValue1 = JOptionPane.showInputDialog("Input Order Value:");
		String sInterest1 = JOptionPane.showInputDialog("Input Credit Order Interest Value:");
		//convert input strings to int and double variables
		int id1 = Integer.parseInt(sID1);
		int value1 = Integer.parseInt(sValue1);
		double interest1 = Double.parseDouble(sInterest1);
		
		
		//instantiate order 1 and credit order 1
		Order ord1 = new Order(name1, id1, value1);
		CreditOrder cord1 = new CreditOrder(name1, id1, value1, interest1);
		
		//output toString values of newly instantiated objects
		System.out.println(ord1.toString());
		System.out.println(cord1.toString());
		
		//create order value from ord1 and cord1
		int orderAmt1 = ord1.getOrderValue(value1);
		double corderAmt1 = cord1.getCreditOrderTotalValue(value1, interest1);
		
		//print amounts gathered above
		System.out.println("Amount earned from Order: " + orderAmt1);
		System.out.println("Amount earned from Order: " + corderAmt1);
		
		
		//initiate order input values for new object
		String name2 = JOptionPane.showInputDialog("Input Client Name:");
		String sID2 = JOptionPane.showInputDialog("Input Order ID:");
		String sValue2 = JOptionPane.showInputDialog("Input Order Value:");
		String sInterest2 = JOptionPane.showInputDialog("Input Credit Order Interest Value:");
		
		//convert input strings to int and double variables
		int id2 = Integer.parseInt(sID2);
		int value2 = Integer.parseInt(sValue2);
		double interest2 = Double.parseDouble(sInterest2);
		
		//instantiate new credit order object from new values
		CreditOrder cord2 = new CreditOrder(name2, id2, value2, interest2);
		
		//output toString values of new credit order object 
		System.out.println(cord2.toString());
		//get order value of cord2
		double corderAmt2 = cord2.getCreditOrderTotalValue(value2, interest2);
		//print order value of cord2
		System.out.println("Amount earned from Order: " + corderAmt2);
		//logic check of whether the clients are the same or it cord2 is a new client 
		if (cord1.getClientName().equals(cord2.getClientName())) {
			System.out.println("Existing Credit Customer: " + cord2.getClientName());
		} else {
			System.out.println("New Credit Customer " + cord2.getClientName());
		}
		//determine the greatest profit to be earned between the two credit orders
		if (ord1.getOrderValue(value1) > cord2.getCreditOrderTotalValue(value2, interest2)) {
			System.out.println("Greatest profit earned from Order ID: " + ord1.getOrderID(id1) + "\t $" + orderAmt1);
		} else {
			System.out.println("Greatest profit earned from Order ID: " + cord2.getOrderID(id2) + "\t $" + corderAmt2);
		}
	}

}
