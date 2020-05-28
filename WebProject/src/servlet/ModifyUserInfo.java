package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー情報変更ページに移動
		request.getRequestDispatcher("/WEB-INF/modifyUserInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォームから送られてきた変更情報をもとにMemberBeanを作成
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		String userLName = request.getParameter("user_l_name");
		String userFName = request.getParameter("user_f_name");
		String password = request.getParameter("password");
		String prefecture = request.getParameter("prefecture");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");

		MemberBean newUser = new MemberBean(userId,userLName,userFName,password,prefecture,address,tel,mail);
		MemberBean oldMember = (MemberBean)request.getSession().getAttribute("user");

		//ユーザー変更が成功したかのフラグを受け取る
		boolean isModifySucceeded =ModifyUserInfoLogic.modify(newUser);

		if(isModifySucceeded) {
			//成功したらユーザーページにリダイレクト
			response.sendRedirect("/tappy/UserPage");
		}
		else {
			//変更失敗フラグをリクエストスコープに格納
			request.setAttribute("modifyFailed", true);
			//失敗したらもう一度変更画面にフォワード
			request.getRequestDispatcher("/WEB-INF/jsp/modifyUserInfo.jsp").forward(request, response);
		}
	}

}
