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
 * Servlet implementation class NoOfBusesServlet
 */
@WebServlet("/NoOfBusesServlet")
public class NoOfBusesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoOfBusesServlet() {
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

		BasicDetailsBean details = new BasicDetailsBean();
		details.setSource((String) request.getParameter("sources"));

		details.setDestination(request.getParameter("destinations"));

		int count = (int) new AdminDao().getCount(details);
		if (count != 0) {
			out.println("<h3>" + "No Of Buses Are:" + new AdminDao().getCount(details) + "</h3><a href=\"Admin.jsp\"><input type=\"button\" value=\"back\"></a>");
		} else {
			out.println("<h3>No Buses</h3><a href=\"Admin.jsp\"><input type=\"button\" value=\"back\"></a>");
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
