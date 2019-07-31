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

import Dao.AdminDao;
import bean.BasicDetailsBean;
import bean.BusJourneyBean;

/**
 * Servlet implementation class IncomeServlet
 */
@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncomeServlet() {
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
		BasicDetailsBean details = new BasicDetailsBean();
		details.setDateOfJourney((String) request.getParameter("date"));
		out.println(details.getDateOfJourney());
		ArrayList<BusJourneyBean> income = new AdminDao().getIncome(details);
		out.println(income);
		if (income != null) {
			RequestDispatcher rd = request.getRequestDispatcher("IncomeDetails.jsp");
			request.setAttribute("income", income);
			rd.forward(request, response);
		} else {
			out.println("no buses available too");
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
