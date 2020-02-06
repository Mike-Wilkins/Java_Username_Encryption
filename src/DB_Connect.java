import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;




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
		
// Retrieve name from MySQL
		
		public void db_retrieve(char[] myUsername, char[] myPassword) throws SQLException {
			
			//String userInput = DigestUtils.md5Hex(String.copyValueOf(myUsername));
			
			
			
			String myQuery = "SELECT username, password from encrypt_test.new_table WHERE username = md5('" + String.copyValueOf(myUsername)+ "') AND password = md5('" + String.copyValueOf(myPassword)+ "')";
			
			PreparedStatement ps = null;
			ResultSet rSet = null;
			
			ps = connection.prepareStatement(myQuery);
		    rSet = ps.executeQuery();
		    
		    
		    	if(rSet.next()) {
			    	// String[] name = {rSet.getString("username"), rSet.getString("password")};
			    	
			    		JOptionPane.showMessageDialog(null, "Login Validated", null, JOptionPane.PLAIN_MESSAGE);
			    		
			    } else {
			    		JOptionPane.showMessageDialog(null, "Invalid Login", null, JOptionPane.PLAIN_MESSAGE);
			  }
		    	
		    connection.close();
		    
			
		}

}
