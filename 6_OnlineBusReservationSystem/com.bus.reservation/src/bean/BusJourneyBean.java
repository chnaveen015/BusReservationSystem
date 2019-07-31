package bean;

import java.sql.Date;
import java.sql.Time;

public class BusJourneyBean {
	int jid, bid, capacity, availableseats, cost;
	Date dateofBusTravel;
	Time timeOfArrival;

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getDateofBusTravel() {
		return dateofBusTravel;
	}

	public void setDateofBusTravel(Date dateofBusTravel) {
		this.dateofBusTravel = dateofBusTravel;
	}

	public Time getTimeOfArrival() {
		return timeOfArrival;
	}

	public void setTimeOfArrival(Time timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

}
