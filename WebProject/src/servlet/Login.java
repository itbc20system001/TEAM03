package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;
import model.MemberBean;

/**
 * Servlet implementation class kanagawaTestServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		MemberBean loginUser =  LoginLogic.login(
				request.getParameter("user_id"),
				request.getParameter("password"));


		if(loginUser != null) {
			//ログイン成功したら・・・
			//ログインユーザーをセッションスコープに入れる
			request.getSession().setAttribute("user", loginUser);
			//トップページにリダイレクト
			response.sendRedirect("/tappy/");
		}
		else {
			//失敗したらもう一度ログイン画面にフォワード
			request.setAttribute("loginFailed", true);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

}
