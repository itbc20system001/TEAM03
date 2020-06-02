package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.RegisterLogic;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		d.forward(request, response);

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

		int passwordSize = password.length();

		//パスワードの正規表現
		if (!(password.matches("[a-zA-Z0-9]*"))) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			request.setAttribute("message", true);
			d.forward(request, response);
		} else if((mail.matches("[^@]*"))||((!(mail.matches("[a-zA-Z0-9]*"))))){
		//何か言ってた気がする
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			request.setAttribute("mailfalse", true);
			d.forward(request, response);

			//合っていれば登録処理へ
		}else {

		//MemberBeanに受け取った情報を詰める
		MemberBean mb = new MemberBean(userId, userLName, userFname, password, prefecture, address, tel, mail);

		//RegisterLogic.javaのメソッドexecute（仮）を呼び出して、戻り値を受け取る
		RegisterLogic rl = new RegisterLogic();

		boolean b = rl.execute(mb);

		//OKなら会員登録完了画面へ、問題があればregister.jspに戻る
			if (b == true) {
			//これフォワードでなくリダイレクトしたほうがいいのでは…？
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/registerComplete.jsp");
			d.forward(request, response);
			} else {
			//失敗したらもう一度登録画面へ
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			request.setAttribute("registerFailed", true);
			d.forward(request, response);
			}

	}
	}

}
