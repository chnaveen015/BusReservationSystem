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

import Dao.ReservationDao;
import bean.BasicDetailsBean;
import bean.CostTicketBean;
import bean.ReservationBean;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
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
		ReservationDao reservationdao = new ReservationDao();
		r.setJid((Integer.parseInt(request.getParameter("id"))));
		BasicDetailsBean details = new BasicDetailsBean();
		HttpSession session = request.getSession();
		details = (BasicDetailsBean) session.getAttribute("details");
		ArrayList<CostTicketBean> ctb = (ArrayList<CostTicketBean>) session.getAttribute("al");
		r = reservationdao.copyDetails(ctb, r);
		r.setSource(details.getSource());
		r.setDestination(details.getDestination());
		r.setNoOfSeats(details.getNoOfSeats());
		out.println(r.getJid());
		r.setName(request.getParameter("Name"));
		r.setDateofJourney(details.getDateOfJourney());
		r.setPnr(reservationdao.getPnr());

		r.setIdproof((request.getParameter("idProof")));

		boolean status = true;
		status = new ReservationDao().reserve(r);
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("successfull.jsp");
			request.setAttribute("reserved", r);
			rd.forward(request, response);
		} else
			out.println("failed to Reserve");

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
