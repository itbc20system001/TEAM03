package dao;

import java.sql.SQLException;

@FunctionalInterface
public interface FunctionWithSQLException<T,U>{
	U apply(T value)throws SQLException;
}
