package servletspack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;
import bean.BasicDetailsBean;
import bean.BusJourneyBean;
import bean.ReservationBean;

/**
 * Servlet implementation class NoOfPassengersServlet
 */
@WebServlet("/NoOfPassengersServlet")
public class NoOfPassengersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoOfPassengersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ReservationBean reservation = new ReservationBean();
		BasicDetailsBean details = new BasicDetailsBean();
		reservation.setBid(Integer.parseInt(request.getParameter("bid")));
		reservation.setDateofJourney(Date.valueOf(request.getParameter("date")));
		out.println(reservation.getDateofJourney());
		ArrayList<ReservationBean> passenger = new AdminDao().getPassengers(reservation);
		if (passenger != null) {
			RequestDispatcher rd = request.getRequestDispatcher("passengers.jsp");
			request.setAttribute("passenger", passenger);
			rd.forward(request, response);
		} else {
			out.println("<h3>Zero Passengers are available</h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
