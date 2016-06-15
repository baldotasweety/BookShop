

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;  
	class Insert{  
	public static void main(String args[]){  
	try{  
	//step1 load the driver class  
	Class.forName("org.h2.Driver");  
	  
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(  
	"jdbc:h2:tcp://localhost/~/test", "sa", "");  
	  
	//step3 create the statement object  
	Statement stmt=con.createStatement();
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Give the book ID");
	String id=br.readLine();
	int r =Integer.parseInt(id);
	
	
	System.out.println("Give the bookname");
	String name=br.readLine();
	
	System.out.println("Give the category id ");
	String ct=br.readLine();
	int s =Integer.parseInt(ct);
	
	System.out.println("Give the supplier id ");
	String sup=br.readLine();
	int c =Integer.parseInt(sup);
	
	System.out.println("Give the stock ");
	String st=br.readLine();
	int stc =Integer.parseInt(st);
	
	
	
	System.out.println("Inserting records into the table...");
    stmt.executeUpdate("INSERT INTO BOOKS " +
                 "VALUES ('"+r+"','"+name+"','"+s+"','"+c+"','"+stc+"')");
   
 
    System.out.println("Inserted records into the table...");
    stmt.close();
    con.close();

 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }
	}
	}
