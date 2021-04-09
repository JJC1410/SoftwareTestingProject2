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
    	Iterator<Rental> rentalIterator = rentals.iterator();
    	String result = "Rentals: " + getName() + "\n";
    
    	for (Iterator<Rental> i = rentalIterator; i.hasNext();)
    	{
    	    double charge = 0;
    	    Rental rental = rentalIterator.next();

    	    charge = rental.charge();

    	    frequentRenterPoints = rental.frequentRenterPoints(frequentRenterPoints);
    	    //show figures for this rental
    	    result += rental.rentalLine();
    	    totalAmount += charge;
    	}

    	//add footer lines
    	result += "Total = $" + totalAmount + "\n";
    	result += "Frequent renter points = " + frequentRenterPoints + "\n";
    	return result + "---\n";
    }
    
}

