package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex�o {
	public static java.sql.Connection faz_conex�o() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/tainhaclickerdb?useSSL=false", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
}
