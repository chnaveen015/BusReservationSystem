package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConnectionManagement.ConnectionProvider;
import bean.ReservationBean;

public class CancelTicket {

	public boolean cancel(ReservationBean r) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("select jid,cost,noOfSeats from reservation where pnr=?");
			preparedStatement.setInt(1, r.getPnr());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			r.setCost(resultSet.getInt("cost"));
			r.setNoOfSeats(resultSet.getInt("noOfSeats"));
			r.setJid(resultSet.getInt("jid"));
			preparedStatement = connection.prepareStatement("select * from busjourney where jid=?");
			preparedStatement.setInt(1, r.getJid());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int availableSeats = resultSet.getInt("available_seats");
			int ticketCost = resultSet.getInt("cost");
			preparedStatement = connection.prepareStatement("update busjourney set available_seats=?,cost=? where jid=?");
			preparedStatement.setInt(1, availableSeats + r.getNoOfSeats());
			preparedStatement.setInt(2, ticketCost - r.getCost());
			preparedStatement.setInt(3, r.getJid());
			int i = preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("delete  from reservation where pnr=?");
			preparedStatement.setInt(1, r.getPnr());
			int j = preparedStatement.executeUpdate();
			if (i != 0 && j != 0) {
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
