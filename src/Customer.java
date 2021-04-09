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
    	return statement(new TextReport());
    }
    
    public String statement(TextReport report) 
    {
    	double totalAmount = 0;
    	int frequentRenterPoints = 0;
    	Iterator<Rental> rentalIterator = rentals.iterator();
    	
    	String result = report.headerLine(getName());
    
    	for (Iterator<Rental> i = rentalIterator; i.hasNext();)
    	{
    	    double charge = 0;
    	    Rental rental = rentalIterator.next();

    	    charge = rental.charge();

    	    frequentRenterPoints = rental.frequentRenterPoints(frequentRenterPoints);
    	    //show figures for this rental
    	    result += rental.rentalLine(report);
    	    totalAmount += charge;
    	}

    	return result + report.footerLine(totalAmount, frequentRenterPoints);
    }

//	public String htmlStatement() 
//	{
//		// TODO Auto-generated method stub
//		return statement(new HtmlReport());
//	}   
}

