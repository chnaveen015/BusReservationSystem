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
import Dao.ReservationDao;
import bean.BasicDetailsBean;
import bean.ReservationBean;

/**
 * Servlet implementation class ViewTicket
 */
@WebServlet("/ViewTicket")
public class ViewTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewTicket() {
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
		reservation.setPnr(Integer.parseInt(request.getParameter("pnr")));
		ReservationBean ticket = new ReservationDao().getTicket(reservation);
		if (ticket != null) {
			RequestDispatcher rd = request.getRequestDispatcher("Ticket.jsp");
			request.setAttribute("details", ticket);
			rd.forward(request, response);
		} else {
			out.println("<h3>enter valid Pnr</h3><br><a href=\"Welcome.jsp\"><input type=\"button\" value=\"back\"></a>");
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
