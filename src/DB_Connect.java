import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


public class DB_Connect {
	
		public DB_Connect() throws IOException {
			
			Properties p = new Properties();
			InputStream  is = new FileInputStream("dataConfig.properties");
			p.load(is);
			
			Connection connection = null;
			String databaseName ="";
			
			String url = p.getProperty("url" + databaseName);
			String password = p.getProperty("password");
			String username = p.getProperty("username");
					
			System.out.println(url);
			System.out.println(password);
			System.out.println(username);
			
			
			
			
			
			
	}

}
