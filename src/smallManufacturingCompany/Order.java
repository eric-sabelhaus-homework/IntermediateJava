package smallManufacturingCompany;
//orderId, clientName and orderValue
public class Order {
	/**
	 * 
	 * Setting variables to be used throughout class
	 *  
	 */
	private String clientName = " ";
	private int orderID = 0;
	private int orderValue = 0;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public Order(String clientName, int orderID, int orderValue) {
		this.clientName = clientName;
		this.orderID = orderID;
		this.orderValue = orderValue;
	}
	/**
	 * get and set methods for Order ID value
	 * 
	 * @param int for order id
	 * 
	 * @return orderID
	 * 
	 * @throws Exception 
	 * 
	 */
	public int getOrderID(int id) throws Exception{
		orderID = id;
		
		return orderID;
	}
	public void setOrderID(int orderID) throws Exception{
		if(orderID < 0) {
			throw new Exception("Exception: Order ID cannot be less than 0!");
		}
		this.orderID = orderID;
	}
	/**
	 * @param 
	 * 
	 * @return clientName
	 *  
	 */
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * get and set methods for Order Value
	 * 
	 * @param args
	 * 
	 * @return OrderValue 
	 * 
	 * @throws Exception 
	 */
	public int getOrderValue(int value){

		orderValue = value;
		
		return orderValue;
	}
	public void setOrderValue(int orderValue) throws Exception{
		if(orderValue < 0) {
			throw new Exception("Exception: Order Value cannot be less than 0!");
		}
		this.orderValue = orderValue;
	}
	
	/**
	 * toString output method
	 *  
	 *  @return formated order information
	 *  
	 */
	public @Override String toString() {
		return "Client: " + clientName + "\nOrder ID#: " + orderID + "\nOrder Value: " + orderValue;  
	}
}
