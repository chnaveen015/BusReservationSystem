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

import Dao.BusDao;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Userservlet() {
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
		BusDao bd = new BusDao();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String operation = (String) request.getParameter("operation");
		if (operation.equals("ReserveTicket")) {
			out.println("hello");
			ArrayList<String> source = new BusDao().getSources();
			ArrayList<String> destination = new BusDao().getDestinations();

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");

			request.setAttribute("sources", source);
			request.setAttribute("destination", destination);

			requestDispatcher.forward(request, response);
		} else if (operation.equals("CancelTicket")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cancel.jsp");
			requestDispatcher.forward(request, response);
		} else if (operation.equals("viewticket")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewticket.jsp");
			requestDispatcher.forward(request, response);
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
