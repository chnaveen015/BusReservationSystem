package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import ConnectionManagement.ConnectionProvider;
import bean.Details;
import bean.LoginBean;

public class LoginDao {
	public boolean validate(LoginBean bean) {
		try {
			Connection connection = ConnectionProvider.getCon();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username=? and password=?");

			preparedStatement.setString(1, bean.getUsername());
			preparedStatement.setString(2, bean.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;

	}

}
