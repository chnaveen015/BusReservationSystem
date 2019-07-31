package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import ConnectionManagement.ConnectionProvider;
import bean.CostTicketBean;
import bean.ReservationBean;

public class ReservationDao {

	public ReservationBean copyDetails(ArrayList<CostTicketBean> costTicketBean, ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		for (CostTicketBean costTicket : costTicketBean) {
			if (costTicket.getJid() == reservationBean.getJid()) {
				reservationBean.setBid(costTicket.getBid());
				reservationBean.setBtype(costTicket.getBtype());
				reservationBean.setCost(costTicket.getCost());
				reservationBean.setTime(costTicket.getTime());
				return reservationBean;
			}
		}
		return null;
	}

	public boolean reserve(ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		try {
			// ArrayList<CostTicketBean> al=new ArrayList<CostTicketBean>();
			Connection connection = ConnectionProvider.getCon();
			System.out.println(reservationBean.getJid());
			PreparedStatement ps = connection.prepareStatement("select *  from busjourney where jid=?");
			ps.setInt(1, reservationBean.getJid());
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int Aseats = resultSet.getInt("available_seats");
			int cost = resultSet.getInt("cost");
			int updatedAseats = Aseats - reservationBean.getNoOfSeats();
			int updatedCost = cost + reservationBean.getNoOfSeats() * reservationBean.getCost();
			ps = connection.prepareStatement("update busjourney set available_seats=?,cost=? where jid=?");
			ps.setInt(1, updatedAseats);
			ps.setInt(2, updatedCost);
			ps.setInt(3, reservationBean.getJid());
			int j = ps.executeUpdate();
			ps = connection.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, reservationBean.getPnr());
			ps.setInt(2, reservationBean.getJid());
			ps.setInt(3, reservationBean.getBid());
			ps.setString(4, reservationBean.getName());
			ps.setString(5, reservationBean.getIdproof());
			ps.setInt(6, reservationBean.getNoOfSeats());
			ps.setString(7, reservationBean.getSource());
			ps.setString(8, reservationBean.getDestination());
			ps.setDate(9, reservationBean.getDateofJourney());
			ps.setTime(10, reservationBean.getTime());
			ps.setString(11, reservationBean.getBtype());
			ps.setInt(12, reservationBean.getCost() * reservationBean.getNoOfSeats());
			int i = ps.executeUpdate();
			if (j != 0 && i != 0) {

				return true;
			} else
				return false;
		} catch (Exception e) {

		}

		return false;
	}

	public int getPnr() {
		// TODO Auto-generated method stub
		Random reservationBean = new Random();
		int pnr = reservationBean.nextInt(60000) + 10000;
		return pnr;
	}

	public ReservationBean getTicket(ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		try {
			ArrayList<ReservationBean> arrayList = new ArrayList<ReservationBean>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement ps = connection.prepareStatement("select *   from reservation where pnr=?");
			ps.setInt(1, reservationBean.getPnr());
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {

				ReservationBean passenger = new ReservationBean();
				passenger.setBid(resultSet.getInt("bid"));
				passenger.setDateofJourney(resultSet.getDate("date"));
				passenger.setBtype(resultSet.getString("bustype"));
				passenger.setCost(resultSet.getInt("cost"));
				passenger.setTime(resultSet.getTime("time"));
				passenger.setPnr((resultSet.getInt("pnr")));
				passenger.setJid(resultSet.getInt("jid"));
				passenger.setNoOfSeats(resultSet.getInt("noOfSeats"));
				passenger.setDestination(resultSet.getString("destination"));
				passenger.setSource(resultSet.getString("source"));
				passenger.setName(resultSet.getString("name"));
				passenger.setIdproof(resultSet.getString("idproof"));
				return passenger;
			} else
				return null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
