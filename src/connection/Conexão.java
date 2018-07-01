package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {
	public static java.sql.Connection faz_conexão() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/tainhaclickerdb?useSSL=false", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
}
