package car;
//declare public class car
public class Car {
    //construct car to be set above
    Car(String newMake, String newModel, String newYear, String newPrice) {
    	make = newMake;
    	model = newModel;
    	year = newYear;
    	price = newPrice;
    }
	//initialize String values
    private String make = " ", model = " ", year = " ", price =" ";
    //get make
    public String getMake() {
    	return make;
    }
    //get model
    public String getModel() {
    	return model;
    }
    //get year
    public String getYear() {
    	return year;
    }
    //get price
    public String getPrice() {
    	return price;
    }
    //set make to what was gotten
    public void setMake(String newMake) {
    	make = newMake;
    }
    //set model to what was gotten
    public void setModel(String newModel) {
    	model = newModel;
    }
    //set year to what was gotten
    public void setYear(String newYear) {
    	year = newYear;
    }
    //set price to what was gotten
    public void setPrice(String newPrice) {
    	price = newPrice;
    }
    //create output with proper spacing
	public @Override String toString() {
		return make + " " + model + " " + year + " $" + price;
	}
}
