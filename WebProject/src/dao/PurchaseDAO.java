package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import model.PurchaseBean;

public class PurchaseDAO extends DAO<PurchaseBean> {

	@Override
	protected PurchaseBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ
		return new PurchaseBean(
				(int)record.get("purchase_id"),
				(String)record.get("user_id"),
				(int)record.get("item_cd"),
				(String)record.get("purchase_date"),
				(int)record.get("purchase_quantity"),
				(int)record.get("drink_size_cd"),
				(int)record.get("drink_sugar_cd"),
				(int)record.get("ice_amount_cd"),
				(int)record.get("tapioka_kind_cd"),
				(int)record.get("tapioka_amount_cd"),
				(int)record.get("topping_cd")
				);
	}

	public List<PurchaseBean> findAll(){

		return new PurchaseDAO().executeQuery( conn -> conn.prepareStatement("SELECT * FROM purchase_history") );

	}
	public void creation(PurchaseBean pb) {//注文確定時、DBの履歴を更新
		//セッションスコープからDBに移す
				executeUpdate(conn -> {

					PreparedStatement pStmt = conn.prepareStatement("INSERT INTO purchase_history VALUES (?,?,?,?,?,?,?,?,?,?)");
					pStmt.setString(1, pb.getUserId());
					pStmt.setInt(2, pb.getItem());//Cd???
					pStmt.setString(3, pb.getPurchaseDate());//Date
					pStmt.setInt(4, pb.getPurchaseQuantity());
					pStmt.setInt(5, pb.getDrinkSize());
					pStmt.setInt(6, pb.getDrinkSugar());
					pStmt.setInt(7, pb.getIceAmount());
					pStmt.setInt(8, pb.getTapiokaKind());
					pStmt.setInt(9, pb.getTapiokaAmount());
					pStmt.setInt(10, pb.getTopping());
					return pStmt;

				});
	}

}
