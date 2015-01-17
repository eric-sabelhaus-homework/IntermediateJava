package hw3;

/**
 * @author Eric Sabelhaus
 *
 */
public interface WarehouseOperations {
	/*
	 * I believe an a double should represent the add to and deliver from values
	 * these variables are constantly changing numeric values, and may require 
	 * double values, depending on the type of stock they provide
	 * 
	 * I would think that stock has to be maintained somewhere, hence why this should be an array
	 * 
	 * The number returned should be based off what is currently available in a document
	 * that is directly edited by programs using this interface. 
	 * 
	 * A superclass would interact with the file, and in turn, act appropriately based off the interface
	 * 
	 */
	public abstract double[] addToStock(double amount, int[] currentStock, int stockNumber, boolean isEmpty);
	public abstract double[] deliverFromStock(double amount, int[] currentStock, int stockNumber, boolean isEmpty);
	
	/*
	 * These two methods are set as booleans because they denote when your stock is full
	 * or empty, and a true or false value would be based off the contents of a Master Stock array
	 * or document 
	 * 
	 * This value would be parsed based on the current stock in the warehouse, the stock number being referenced
	 * and the maximum stock in the master array from a whatever document is used
	 * 
	 * The is empty doesn't need to rely on the master array, and can be based of a zero value at current
	 * stock, based off the stock number
	 * 
	 */
	public abstract boolean isFullStock(int[] currentStock, int stockNumber, int[] maxStock);
	public abstract boolean isEmptyStock(int[] currentStock, int stockNumber);

}
