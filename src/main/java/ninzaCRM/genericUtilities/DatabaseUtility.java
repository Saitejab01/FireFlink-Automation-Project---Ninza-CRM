package ninzaCRM.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	private Connection connection;
	public Connection getDatabaseConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/work","root","root");
		return connection;
	}
	
	public void closeDatabaseConnection() throws SQLException {
		connection.close();
	}
	
	public ResultSet getDataFromDatabase(String tableName) throws SQLException {
		Statement statement = null;
		ResultSet res = null;
		try {
			statement = connection.createStatement();
			res=statement.executeQuery("select * from "+tableName);
		} catch (Exception e) {
			System.out.println("date is from user_details and "+tableName+" not found");
			res=statement.executeQuery("select * from user_details");
		}
		return res;
	}
	public ResultSet getDataFromDatabase(String tableName,String username) throws SQLException {
		Statement statement = null;
		ResultSet res = null;
		try {
			statement = connection.createStatement();
			res=statement.executeQuery("select * from "+tableName+" where username="+username);
		} catch (Exception e) {
			System.out.println("date is from user_details and "+tableName+" not found");
			res=statement.executeQuery("select * from user_details"+" where username="+username);
		}
		return res;
	}
	
	public int writeDataIntoDatabase(int UserId,String UserName,String firstName,String lastName,String gender,String password,int status) throws SQLException {
		Statement statement = connection.createStatement();
		int num=statement.executeUpdate("insert into table user_details values("+UserId+","+UserName+","+firstName+","+lastName+","+gender+","+password+","+status+");");
		return num;
	}
}
