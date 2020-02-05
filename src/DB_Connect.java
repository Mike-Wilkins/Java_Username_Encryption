import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class DB_Connect {
	
		static Connection connection = null;
		static String databaseName ="";
	
		public DB_Connect() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			
			Properties p = new Properties();
			InputStream  is = new FileInputStream("dataConfig.properties");
			p.load(is);
			
			
			String url = p.getProperty("url" + databaseName);
			String password = p.getProperty("password");
			String username = p.getProperty("username");
					
			Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
			connection = DriverManager.getConnection(url, username, password);
				
	}
		
// Insert user name and password into MySQL
		
		public void db_insert(char[] newUsername, char[] newPassword) throws SQLException {
			
			System.out.println(newUsername);
			
			String myQuery = "INSERT into encrypt_test.new_table (username, password) values (md5('" + String.copyValueOf(newUsername)+ "') , md5('"+ String.copyValueOf(newPassword)+"'))";
			PreparedStatement ps = null;
			
			ps = connection.prepareStatement(myQuery);
		    ps.executeUpdate();
		    
		    connection.close();
			
		}
		
		

}
