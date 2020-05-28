package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomizeBean;
import model.CustomizeLogic;

/**
 * Servlet implementation class Customize
 */
@WebServlet("/Customize")
public class Customize extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customize() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
			DBからトッピングの内容を持ってきてスコープに保存する処理を書く
			一度だけ動かせばそれで終わりかもしれない
		 */
		//ロジックをインスタンス化（Staticmethodにできないかなぁ）
		CustomizeLogic customizeLogic = new CustomizeLogic();

		//カスタマイズのListを作成
		List<CustomizeBean> iceList = new ArrayList<>();
		List<CustomizeBean> topiokaTypeList = new ArrayList<>();
		List<CustomizeBean> topiokaAmountList = new ArrayList<>();
		List<CustomizeBean> sugarList = new ArrayList<>();
		List<CustomizeBean> drinkSizeList = new ArrayList<>();
		List<CustomizeBean> toppingList = new ArrayList<>();

		//ListにDBの値を格納　引数はハードコーディングしか無理かな？
		iceList = customizeLogic.makeCustomizeList("ice_amount", "ice_amount_cd", "mst_ice_amount");
		drinkSizeList = customizeLogic.makeCustomizeList("drink_size", "drink_size_cd", "mst_drink_size");
		topiokaAmountList = customizeLogic.makeCustomizeList("tapioka_amount", "tapioka_amount_cd", "mst_tapioka_amount");
		topiokaTypeList = customizeLogic.makeCustomizeList("tapioka_kind", "tapioka_kind_cd", "mst_tapioka_kind");
		sugarList = customizeLogic.makeCustomizeList("drink_sugar", "drink_sugar_cd", "mst_drink_sugar");
		toppingList = customizeLogic.makeCustomizeList("topping", "topping_cd", "mst_topping");


		RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/customize.jsp");
		rdp.forward(request, response);
	}

}
