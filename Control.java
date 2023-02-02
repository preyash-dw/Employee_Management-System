package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Control {
	static boolean status=false;
static boolean insertEmployeeIntoDb(Employee employee) {
	try {
		Connection dbConnection=Databaseconnection.createConnection();
		String query="insert into employee(ename,ephone,edept)values(?,?,?)";
		//prepared statement
		
		PreparedStatement pstm=dbConnection.prepareStatement(query);
		pstm.setString(1, employee.getName());
		pstm.setString(2,employee.getPhone());
		pstm.setInt(3,employee.getDept());
		pstm.executeUpdate();
		status=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return status;
}
static Boolean deleteEmployeeFromDb(int eid) {
	
	Boolean statusOk = false;
	
	try {
		// creating connection
		Connection dbConnection = Databaseconnection.createConnection();
		
		String query = "delete from employee where eid = ?";
		
		// prepared statement 
		PreparedStatement pstm = dbConnection.prepareStatement(query);
		
		// setting parameters
		pstm.setInt(1, eid);

		
		//execute statement
		pstm.executeUpdate();
		
		statusOk = true;
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return statusOk;

}
static Boolean showAllEmployeeFromDb() {
	
	Boolean statusOk = false;
	
	try {
		// creating connection
		Connection dbConnection = Databaseconnection.createConnection();
		
		String query = "select * from employee";
		
		// Statement 
		Statement stm = dbConnection.createStatement();
				
		//execute statement
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()) {
		
			int id = rs.getInt("eid");
			String name = rs.getString("ename");
			String phone = rs.getString("ephone");
			int dept = rs.getInt("edept");
			
			Employee e = new Employee( name, phone, dept,id);
			System.out.println(e.toString());
		}
		statusOk = true;
	}		
	catch(Exception e) {
		e.printStackTrace();
	}
	return statusOk;
}
static Boolean retreiveEmployeeFromDb(int eid) {
	
	Boolean statusOk = false;
	
	try {
		// creating connection
		Connection dbConnection = Databaseconnection.createConnection();
		
		String query = "select * from employee where eid ="+eid;
		
		Statement stm = dbConnection.createStatement();
		
		
		//execute statement
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()) {
			String name = rs.getString("ename");
			String phone = rs.getString("ephone");
			int dept = rs.getInt("edept");
			
			Employee e = new Employee( name, phone, dept);
			System.out.println(e.toString());
		}
		statusOk = true;
		
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return statusOk;

}
static Boolean update(int eid,Scanner sc) {
	Boolean statusok=false;
	try {
		Connection dbConnection = Databaseconnection.createConnection(); 
		System.out.println("What do you want to update :");
		System.out.println("1.for name");
		System.out.println("2.for phone_no");
		System.out.println("3.for dept");
		System.out.println("choose any one :");
		int c=sc.nextInt();
		sc.nextLine();
		switch(c) {
		case 1:
		{
			try {
				System.out.println("Enter name");
				String name=sc.nextLine();
				
				String query = "update employee"+" set ename = ?"+" where eid = ?";
				PreparedStatement pstmt = dbConnection.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setInt(2, eid);
				pstmt.execute();
				
				System.out.println("After updation :");
				String query1="select *from employee where eid="+eid;
				Statement stm = dbConnection.createStatement();
				
				
				
				//execute statement
				ResultSet rs = stm.executeQuery(query1);
				
				while(rs.next()) {
					String nam = rs.getString("ename");
					String phone = rs.getString("ephone");
					int dept = rs.getInt("edept");
					
					Employee e = new Employee( nam, phone, dept);
					System.out.println(e.toString());
				}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			break;
		}
		
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return statusok;
}
}
