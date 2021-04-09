
public class Report 
{

    //add header lines
	public String headerLine(String name) 
	{
		// TODO Auto-generated method stub
		return ("Rentals: " + name + "\n");
	}
	
	//add footer lines
	public String footerLine(double totalAmount, int frequentRenterPoints) 
	{
		// TODO Auto-generated method stub
		return ("Total = $" + totalAmount + "\n"
				+ "Frequent renter points = " + frequentRenterPoints + "\n"
				+ "---\n");
	}

	public String rentalLine(int daysRented, String title, double charge) 
	{
		// TODO Auto-generated method stub
		return (daysRented + 
    			" days of '" + title+
    			"' $" + String.valueOf(charge) + "\n");
	}
}
