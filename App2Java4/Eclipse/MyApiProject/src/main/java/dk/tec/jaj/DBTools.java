package dk.tec.jaj;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools 
{
	private String connectionStr = 
			"jdbc:sqlserver://TEC-8220-LA0028;databaseName=WebApiDB; encrypt=true;trustServerCertificate=true;";
	private Connection conn;
	private Statement stmt;

	private void connect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connectionStr, "sa", "1234");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Elev getElevById(int id)
	{
		connect();
		
		Elev elev = null;
		
		String selectStr = "Select * from Elev where id = " + id;
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			if(result.next())
			{
				elev = new Elev();
				elev.id = result.getInt("id");
				elev.navn = result.getString("navn");
				elev.elevJob = result.getString("elevJob");
			}
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return elev;
	}
}





