package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public abstract class DAO<T> {

	private final String JDBC_URL = "jdbc:mariadb://localhost/tappy";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";



	public DAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

	//SQLを実行した結果であるrsからデータを取り出す処理
	public abstract  T construct(Map<String,Object> record);


	public  List<T> executeQuery(PreparedStatement pStmt){

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			ResultSet rs = pStmt.executeQuery();

			ResultSetMetaData rsmd =  rs.getMetaData();

			int columns = rsmd.getColumnCount();

			List<Map<String,Object>> records = new ArrayList<>();

			while(rs.next()) {
				Map<String,Object> record = new HashMap<>(columns);

				for(int i=1; i <= columns;i++) {
					record.put(rsmd.getColumnName(i),rs.getObject(i));
				}

				records.add(record);
			}

			return records.stream()
					.map(this::construct)
					.collect(Collectors.toList());

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}

	}

	public boolean executeUpdate(PreparedStatement pStmt) {

		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){

			int result = pStmt.executeUpdate();

			if(result!=1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}
/*
public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();



		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, text FROM mutter";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Mutter mutter = new Mutter(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("text"));

				mutterList.add(mutter);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}*/

/*	public boolean create(Mutter mutter) {



		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){

			String sql = "INSERT INTO MUTTER(name, text) VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			int result = pStmt.executeUpdate();

			if(result!=1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

}