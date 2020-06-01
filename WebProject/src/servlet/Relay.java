package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/relay")
public class Relay extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("action").equals("menu")) {

			RequestDispatcher d= request.getRequestDispatcher("/ItemList");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("contact")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/jsp/contact.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("userPage")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("user") == null) {
				RequestDispatcher d = request.getRequestDispatcher("Login");
				d.forward(request, response);
			}else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
			d.forward(request, response);
			}
		}

		if(request.getParameter("action").equals("login")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("logout")) {

			RequestDispatcher d= request.getRequestDispatcher("/Logout");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("register")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/jsp/regiter.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("modifyUserInfo")) {
			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/jsp/modifyUserInfo.jsp");
			d.forward(request, response);
}
		if(request.getParameter("action").equals("purchaseHistory")) {
			RequestDispatcher d= request.getRequestDispatcher("/PurchaseHistory");
			d.forward(request, response);
}

	}

}
