public class Rental 
{

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) 
    {
		this.movie = movie;
		this.daysRented = daysRented;
    }

    public double charge()
    {
    	return movie.charge(daysRented);
    }
    
    public int frequentRenterPoints(int frequentRenterPoints)
    {	
	    frequentRenterPoints ++;
	    // add bonus for a two day new release rental
	    if (this.movie.isNewRelease() && this.daysRented > 1) 
	    {
	   		frequentRenterPoints ++;
	   	}
		return frequentRenterPoints;
    }
    
    // new method rentalLine()
    public String rentalLine(Report report)
    {
    	return report.rentalLine(this.daysRented, this.movie.getTitle(), this.charge());
    }
}

