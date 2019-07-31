package servletspack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CancelTicket;
import Dao.ReservationDao;
import bean.ReservationBean;

/**
 * Servlet implementation class CancelServlet
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ReservationBean r = new ReservationBean();
		r.setPnr(Integer.parseInt(request.getParameter(("pnr"))));
		boolean status = false;
		status = new CancelTicket().cancel(r);
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("CancelSuccessful.jsp");
			request.setAttribute("flag", 1);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("CancelSuccessful.jsp");
			request.setAttribute("flag", 0);
			rd.forward(request, response);
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
