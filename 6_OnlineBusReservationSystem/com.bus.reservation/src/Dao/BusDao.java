package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionManagement.ConnectionProvider;
import bean.BasicDetailsBean;
import bean.CostTicketBean;
import bean.ReservationBean;
import bean.BusJourneyBean;

public class BusDao {
	public ArrayList getSources() {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> source = new ArrayList<String>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("select distinct source from costticket");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			do {

				source.add(resultSet.getString("source"));
			} while (resultSet.next());
			return source;
		} catch (Exception e) {
				System.out.println(e);
		}
		return null;

	}

	public ArrayList getDestinations() {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> destination = new ArrayList<String>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("select distinct destination from costticket");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			do {

				destination.add(resultSet.getString("destination"));
			} while (resultSet.next());
			return destination;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public ArrayList<CostTicketBean> getNoOfbus(BasicDetailsBean details) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CostTicketBean> arrayList = new ArrayList<CostTicketBean>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement("select *   from costticket where source=? and destination=?");
			preparedStatement.setString(1, details.getSource());
			preparedStatement.setString(2, details.getDestination());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CostTicketBean costTicketBean = new CostTicketBean();
				costTicketBean.setBid(Integer.parseInt(resultSet.getString("bid")));
				costTicketBean.setBtype(resultSet.getString("btype"));
				costTicketBean.setCost(Integer.parseInt(resultSet.getString("cost")));
				costTicketBean.setDestination(resultSet.getString("destination"));
				costTicketBean.setSource(resultSet.getString("source"));
				costTicketBean = checkSeats(costTicketBean, details);
				if (costTicketBean.getAseats() != 0 && (!arrayList.contains(costTicketBean.getJid())))
					arrayList.add(costTicketBean);
			}
			return arrayList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public CostTicketBean checkSeats(CostTicketBean costTicketBean, BasicDetailsBean details) {
		try {
			Connection connection = ConnectionProvider.getCon();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select  *  from busjourney where bid=? and date=? and available_seats>?");
			preparedStatement.setInt(1, costTicketBean.getBid());
			preparedStatement.setDate(2, details.getDateOfJourney());
			preparedStatement.setInt(3, details.getNoOfSeats());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				costTicketBean.setJid(resultSet.getInt("jid"));
				costTicketBean.setAseats(resultSet.getInt("available_seats"));
				costTicketBean.setTime(resultSet.getTime("time"));
				return costTicketBean;
			} else {
				costTicketBean.setAseats(0);
				return costTicketBean;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}