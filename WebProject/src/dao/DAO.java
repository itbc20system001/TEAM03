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

	//本番用のDB："jdbc:mariadb://localhost/tappy"
	//自分のDB："jdbc:mariadb://site.itbc20.xyz/tappy"
	private final String JDBC_URL = "jdbc:mariadb://localhost/tappy";
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
	public abstract T construct(Map<String, Object> record);

	//createSqlStatementによって作られたSQL文（問い合わせ）を実行し結果を返す
	public List<T> executeQuery(FunctionWithSQLException<Connection, PreparedStatement> createSqlStatement) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			ResultSet rs = createSqlStatement.apply(conn).executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			int columns = rsmd.getColumnCount();

			List<Map<String, Object>> records = new ArrayList<>();

			while (rs.next()) {
				Map<String, Object> record = new HashMap<>(columns);

				for (int i = 1; i <= columns; i++) {
					record.put(rsmd.getColumnName(i), rs.getObject(i));
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

	//createSqlStatementによって作られたSQL文（DBの変更）を実行し結果を返す
	public boolean executeUpdate(FunctionWithSQLException<Connection, PreparedStatement> createSqlStatement) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			int result = createSqlStatement.apply(conn).executeUpdate();

			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
