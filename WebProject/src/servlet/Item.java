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
//セッションスコープ（仮）にある個別アイテムの情報をとってくる
//item.jspに投げる
    public Item() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//itemList.jspから処理が投げられる
		//item.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//ドリンクの値をスコープに保存

		//customizeに処理を投げる　嘘。違った。
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customize.jsp");
		//dispatcher.forward(request, response);
	}

}
