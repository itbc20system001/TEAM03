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

		System.out.println("ddd");
		if(request.getParameter("action").equals("menu")) {
			
			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/menu.jsp");
			d.forward(request, response);
		}
		
	}

}
