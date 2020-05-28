package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//ユーザー変更が成功したかのフラグ
		boolean isModifySucceeded =true;

		if(isModifySucceeded) {
			//成功したらユーザーページにリダイレクト
			response.sendRedirect("/tappy/UserPage");
		}
		else {
			//失敗したらもう一度変更画面にフォワード
			request.getRequestDispatcher("/WEB-INF/jsp/modifyUserInfo.jsp").forward(request, response);
		}
	}

}
