package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactBean;

/**
 * Servlet implementation class ContactSend
 */
@WebServlet("/ContactSend")
public class ContactSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//String kind = request.getParameter("kind");
		String exp = request.getParameter("exp");
		String cause = request.getParameter("cause");
		String message = request.getParameter("message");

		ContactBean cb = new ContactBean(exp, cause, message);


		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/contactComplete.jsp");
		d.forward(request, response);
	}

}
