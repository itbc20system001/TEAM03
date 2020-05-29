package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.OrderCompleteLogic;
import model.OrderDetailBean;

/**
 * Servlet implementation class OrderComplete
 */
@WebServlet("/OrderComplete")
public class OrderComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//注文内容一覧をセッションスコープから取得
		//List<OrderDetailBean> orderList =  (List<OrderDetailBean>)session.getAttribute("orderList");

		//注文内容一覧のテスト用データ
		List<OrderDetailBean> orderList =new ArrayList<>();
		orderList.add(new OrderDetailBean(
				2,
				13,
				2,
				1,
				2,
				1,
				2,
				1
				));

		//ログインしているユーザーを取得
		MemberBean member = (MemberBean)session.getAttribute("user");

		//各注文内容を購入履歴に保存
		orderList.forEach(od -> OrderCompleteLogic.leaveOrder(od, member));

		//履歴に保存し終わったら注文内容一覧を空にする
		session.setAttribute("orderList", new ArrayList<OrderDetailBean>());

		//注文完了画面にフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/orderComplete.jsp").forward(request, response);


	}

}
