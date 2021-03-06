package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.ModifyUserInfoLogic;

/**
 * Servlet implementation class ModifyUserInfo
 */
@WebServlet("/ModifyUserInfo")
public class ModifyUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ユーザー情報変更ページに移動
		request.getRequestDispatcher("/WEB-INF/modifyUserInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		//フォームから送られてきた変更情報をもとにMemberBeanを作成
		request.setCharacterEncoding("UTF-8");
		//String userId = request.getParameter("user_id");
		String userLName = request.getParameter("user_l_name");
		String userFName = request.getParameter("user_f_name");
		//String password = request.getParameter("password");
		String prefecture = request.getParameter("prefecture");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");

		//メールアドレスの正規表現
		if ((mail.matches("[^@]*")) || ((!(mail.matches("[-_a-zA-Z0-9@.]*"))))) {
			request.setAttribute("mailfalse", true);
			request.getRequestDispatcher("/WEB-INF/jsp/modifyUserInfo.jsp").forward(request, response);
		} else {

			MemberBean oldMember = (MemberBean) request.getSession().getAttribute("user");
			MemberBean newUser = new MemberBean(oldMember.getUserId(), userLName, userFName, oldMember.getPassword(),
					prefecture, address, tel, mail);

			//ユーザー変更が成功したかのフラグを受け取る
			boolean isModifySucceeded = ModifyUserInfoLogic.modify(oldMember, newUser);

			if (isModifySucceeded) {
				//成功したら新しいユーザー情報をセッションスコープに保存
				session.setAttribute("user", newUser);
				//ユーザーページにリダイレクト
				response.sendRedirect("/tappy/UserPage");
			} else {
				//変更失敗フラグをリクエストスコープに格納
				request.setAttribute("modifyFailed", true);
				//失敗したらもう一度変更画面にフォワード
				request.getRequestDispatcher("/WEB-INF/jsp/modifyUserInfo.jsp").forward(request, response);
			}

		}
	}

}
