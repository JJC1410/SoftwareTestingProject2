public class Rental 
{

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) 
    {
		this.movie = movie;
		this.daysRented = daysRented;
    }

    public int getDaysRented() 
    {
    	return daysRented;
    }

    public Movie getMovie() 
    {
    	return movie;
    }

    public double charge()
    {
    	return movie.charge(daysRented);
    }
    
    public int frequentRenterPoints(int frequentRenterPoints)
    {	
	    frequentRenterPoints ++;
	    // add bonus for a two day new release rental
	    if (this.movie.isNewRelease() && this.getDaysRented() > 1) 
	    {
	   		frequentRenterPoints ++;
	   	}
		return frequentRenterPoints;
    }
}

