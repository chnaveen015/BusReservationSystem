package Dao;

import bean.BasicDetailsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionManagement.ConnectionProvider;
import bean.BusJourneyBean;
import bean.CostTicketBean;
import bean.ReservationBean;

public class AdminDao {

	public ArrayList<BusJourneyBean> getIncome(BasicDetailsBean details) {
		// TODO Auto-generated method stub
		try {
			ArrayList<BusJourneyBean> arrayList = new ArrayList<BusJourneyBean>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select *   from busjourney where date=?");
			preparedStatement.setDate(1, details.getDateOfJourney());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BusJourneyBean journey = new BusJourneyBean();
				journey.setBid(resultSet.getInt("bid"));
				journey.setAvailableseats(resultSet.getInt("available_seats"));
				journey.setCost(resultSet.getInt("cost"));
				journey.setDateofBusTravel(resultSet.getDate("date"));
				arrayList.add(journey);
			}
			return arrayList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<ReservationBean> getPassengers(ReservationBean reservation) {
		// TODO Auto-generated method stub
		System.out.println(reservation.getBid() + " " + reservation.getDateofJourney());
		try {
			ArrayList<ReservationBean> arrayList = new ArrayList<ReservationBean>();
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select *   from reservation where bid=? and date=?");
			preparedStatement.setInt(1, reservation.getBid());
			preparedStatement.setDate(2, reservation.getDateofJourney());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				ReservationBean passenger = new ReservationBean();
				passenger.setBid(resultSet.getInt("bid"));
				passenger.setBtype(resultSet.getString("bustype"));
				passenger.setDateofJourney(resultSet.getDate("date"));
				passenger.setCost(resultSet.getInt("cost"));
				passenger.setTime(resultSet.getTime("time"));
				passenger.setPnr((resultSet.getInt("pnr")));
				passenger.setJid(resultSet.getInt("jid"));
				passenger.setNoOfSeats(resultSet.getInt("noOfSeats"));
				passenger.setDestination(resultSet.getString("destination"));
				passenger.setSource(resultSet.getString("source"));
				passenger.setName(resultSet.getString("name"));
				passenger.setIdproof(resultSet.getString("idproof"));
				arrayList.add(passenger);
				System.out.println(arrayList);
			}
			if (arrayList.size() != 0)
				return arrayList;
			else
				return null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public int getCount(BasicDetailsBean details) {
		// TODO Auto-generated method stub
		int count = 0;
		try {

			Connection connection = ConnectionProvider.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(
					// "select count(bid) from costticket where source=? and destination=?");
					"select count(bid) from busjourney where bid in(select bid from costticket where source=? and destination=?) and date>=\"2019-07-30\" and date<=\"2019-08-01\"");
			preparedStatement.setString(1, details.getSource());
			preparedStatement.setString(2, details.getDestination());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				count = Integer.parseInt(resultSet.getString(1));

			if (count != 0)
				return count;

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}
