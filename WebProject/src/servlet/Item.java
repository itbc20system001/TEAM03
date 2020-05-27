package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Item() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//item.jspからドリンクの値を受け取る（方法が分からん）

		//ドリンクの値をスコープに保存

		//customizeに処理を投げる
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customize.jsp");
		dispatcher.forward(request, response);
	}

}
