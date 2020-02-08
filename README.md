# Java Username/Password Encryption
<img src="images/Java_MySQL.png" width="150">

This application focuses strategies used for ensuring the secure handling of sensitive data between GUIs and cloud-based databases. The development process is structured around two specific core principles centered on manipulating data securely using Java and MySQL:

* Strings in Java are immutable which means that we cannot change them using any high-level APIs. Any change on a String object will produce a new String, keeping the old one in memory. Therefore, sensitive data such as usernames, passwords should be stored in a char array (char[]) and not as a String. The contents of the char array can be destroyed after validation before garbage collection takes place.
```java
// Create password, username field and submit button using JSwing
JPasswordField text3 = new JPasswordField(10);
JPasswordField text4 = new JPasswordField(10);
JButton btn1 = new JButton("Submit");

btn2.addActionListener(new ActionListener() {
			
	public void actionPerformed(ActionEvent e) {
		char[] myUsername = text3.getPassword();            //Store username and password in char arrays
		char[] myPassword = text3.getPassword();
            
         	DB_Connect newLogin = new DB_Connect();             // Create instance of DB_Connect and pass new username
		checkLogin.db_insert(newUsername, newPassword);     // and password through db_retrieve method 
					
		text3.setText("");                                  // Remove username and password for char arrays
		text4.setText("");        
```


* Cryptographic hash functions should be applied to sensitive data prior to database storage. This application demonstrates the use of md5 hash functions within the MySQL INSERT statement.
```java
// Insert username and password into MySQL using md5 hash function
		
	public void db_insert(char[] newUsername, char[] newPassword) throws SQLException {
			
	String myQuery = "INSERT into encrypt_test.new_table (username, password) values (md5('" + String.copyValueOf(newUsername)+ "') , 			    md5('"+ String.copyValueOf(newPassword)+"'))";
	PreparedStatement ps = null;
			
	ps = connection.prepareStatement(myQuery);
        ps.executeUpdate();
		    
        connection.close();
			
	}
```
