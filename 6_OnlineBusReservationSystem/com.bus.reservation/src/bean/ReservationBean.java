package bean;

import java.sql.Date;
import java.sql.Time;

public class ReservationBean {
	private static final String Date = null;
	int pnr, jid, bid, noOfSeats, cost;
	long phno;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	String name, idproof, source, destination, btype;
	Date dateofJourney;
	Time time;

	public int getPnr() {
		return pnr;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public Date getDateofJourney() {
		return dateofJourney;
	}

	public void setDateofJourney(Date dateofJourney) {
		this.dateofJourney = dateofJourney;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

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

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		String Date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
