# Java Username/Password Encryption
<img src="images/Java_MySQL.png" width="150">

This application focuses strategies used for ensuring the secure handling of sensitive data between GUIs and cloud-based databases. The development process is structured around two specific core principles centered on manipulating data securely using Java and MySQL:

* Strings in Java are immutable which means that we cannot change them using any high-level APIs. Any change on a String object will produce a new String, keeping the old one in memory. Therefore, sensitive data such as usernames, passwords should be stored in a char array (char[]) and not as a String. The contents of the char array can be destroyed after validation before garbage collection takes place.

* Cryptographic hash functions should be applied to sensitive data prior to database storage. This application utilizes md5 hash functions within the MySQL INSERT statement.
