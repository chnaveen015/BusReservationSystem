package servletspack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BusDao;
import bean.BasicDetailsBean;
import bean.CostTicketBean;

/**
 * Servlet implementation class CheckReservationAvailability
 */
@WebServlet("/CheckReservationAvailability")
public class CheckReservationAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckReservationAvailability() {
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
		BasicDetailsBean details = new BasicDetailsBean();
		details.setSource(request.getParameter("source"));
		details.setDestination(request.getParameter("destination"));
		details.setNoOfSeats(Integer.parseInt(request.getParameter("noofseats")));
		details.setDateOfJourney(request.getParameter("dateofjourney"));
		PrintWriter out = response.getWriter();
		// out.println(details.getSource());
		// out.println(details.getDestination());
		// out.println(details.getNoOfSeats());
		// out.println(details.getDateOfJourney());
		ArrayList<CostTicketBean> arrayList = new BusDao().getNoOfbus(details);
		RequestDispatcher rd = request.getRequestDispatcher("buses.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("details", details);
		session.setAttribute("al", arrayList);
		request.setAttribute("arrayList", arrayList);
		if (arrayList.size() != 0) {
			rd.forward(request, response);

		} else
			response.sendRedirect("NoBuses.jsp");
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
