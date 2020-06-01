package servlet;
//ユーザーページにリダイレクトするためのサーブレット
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public UserPage() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログイン済だったらユーザーページ、そうでなければログインページに飛ぶ
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			RequestDispatcher d = request.getRequestDispatcher("/Login");
			d.forward(request, response);
		}else {
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
		d.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
