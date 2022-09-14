package pmsgui;

import java.sql.*;

public class Conn {
	Connection conn;
	Statement st;
	public Conn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_management_system", "root", "root");
		st = conn.createStatement();
	}
}
