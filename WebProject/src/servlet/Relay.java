package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/relay")
public class Relay extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("action").equals("menu")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/menu.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("userPage")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/userPage.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("login")) {

			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/login.jsp");
			d.forward(request, response);
		}

		if(request.getParameter("action").equals("modifyUserInfo")) {
			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/modifyUserInfo.jsp");
			d.forward(request, response);
}
		if(request.getParameter("action").equals("purchaceHistory")) {
			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/purchaceHistory.jsp");
			d.forward(request, response);
}

	}

}
