import java.util.*;

public class Customer
{
    private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) 
    {
    	this.name = name;
    }
    
    public String getName() 
    {
    	return name;
    }

    public void addRental(Rental arg) 
    {
    	rentals.add(arg);
    }
    
    public String statement() 
    {
    	double totalAmount = 0;
    	int frequentRenterPoints = 0;
    	Iterator rentalIterator = rentals.iterator();
    	String result = "Rentals: " + getName() + "\n";
    
    	while (rentalIterator.hasNext()) 
    	{
    	    double charge = 0;
    	    Rental rental = (Rental) rentalIterator.next();

    	    charge = rental.charge();

    	    // add frequent renter points
    	    frequentRenterPoints ++;
    	    // add bonus for a two day new release rental
    	    if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
    		rental.getDaysRented() > 1) 
    	    {
    	   		frequentRenterPoints ++;
    	   	}

    	    //show figures for this rental
    	    result += rental.getDaysRented() +
    		" days of '" + rental.getMovie().getTitle() +
    		"' $" + String.valueOf(charge) + "\n";
    	    totalAmount += charge;
    	}
    	//add footer lines
    	result += "Total = $" + totalAmount + "\n";
    	result += "Frequent renter points = " + frequentRenterPoints + "\n";
    	return result + "---\n";
        }


}

