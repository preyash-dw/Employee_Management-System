package employee;
import java.sql.DriverManager;
import java.sql.Connection;

public class Databaseconnection {
static Connection con;
static Connection createConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost/example";
		String user="unknown";
		String password="12345";
		
		con=DriverManager.getConnection(url, user, password);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
