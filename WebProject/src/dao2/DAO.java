package dao2;

import java.sql.CallableStatement;
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

	private final String JDBC_URL = "jdbc:mariadb://localhost/tappy";//"jdbc:mariadb://localhost/tappy";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";
	private String sql;



	public DAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

	//record(カラム名、値)をもとにクラス（Beanなど）のインスタンスを作成する
	public abstract  T construct(Map<String,Object> record);


	public  List<T> executeQuery(PreparedStatement pStmt){

		try {

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

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public boolean executeUpdate(CallableStatement cStmt) {

		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){

			int result = cStmt.executeUpdate();

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


	public PreparedStatement getPStmt() {
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){

			return  conn.prepareStatement(sql);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}


