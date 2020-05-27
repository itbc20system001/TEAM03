package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//処理
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//register.jspから登録情報を受け取る
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		String userLName = request.getParameter("user_l_name");
		String userFname = request.getParameter("user_f_name");
		String password = request.getParameter("password");
		String prefecture = request.getParameter("prefecture");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");

		//DAOで何かをしてデータベースに登録

		//登録できているかの確認

		//OKなら会員登録画面へ、問題があればregister.jspに戻る
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/registerComplete.jsp");
		d.forward(request, response);

		doGet(request, response);
	}

}
