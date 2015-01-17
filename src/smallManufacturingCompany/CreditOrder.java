package smallManufacturingCompany;
/**
 * CreditOrder 
 * 
 *  Extends the Order class and includes an instance of interest 
 *  
 */
public class CreditOrder extends Order {
	/**
	 * 
	 * Setting variables to be used throughout class
	 *  
	 */
	private double interest = 0;
	private double creditOrderTotal;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public CreditOrder(String clientName, int orderID, int orderValue, double interest) {
		super(clientName,orderID,orderValue);
		// TODO Auto-generated constructor stub
		this.interest  = interest;
	}
	/**
	 * Get and set methods for interest
	 * 
	 * @param double for interest percentage
	 * @throws Exception 
	 * 
	 */
	public double getInterest(double percent) {
		interest = percent;
		
		return interest;
	}
	public void setInterest(double interest)  throws Exception{
		if(interest < 0) {
			throw new Exception("Exception: Interest cannot be less than 0!");
		}
		this.interest = interest;
	}
	/**
	 * 
	 * toString output
	 *  
	 */
	public @Override String toString() {
		return super.toString() + "\n Interest Percentage: " + interest;
	}
	/**
	 * @param int order value, double interest value
	 * 
	 * @return credit order plus 1 year worth of interest
	 * 
	 */
	public double getCreditOrderTotalValue(int value, double interest){
		int newValue = value;
		for (int month = 1; month <= 12; month++)
    	{
			newValue += value * Math.pow(1.0 + interest, month) - (value);
    	}
		
		creditOrderTotal = newValue;
		
		return creditOrderTotal;
	}
}
