package bean;

import java.sql.Date;

public class BasicDetailsBean {
	String source, destination;
	int noOfSeats;
	String dateOfJourney;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Date getDateOfJourney() {
		return Date.valueOf(dateOfJourney);
	}

	public void setDateOfJourney(String dateofjourney) {
		this.dateOfJourney = dateofjourney;
	}
}
