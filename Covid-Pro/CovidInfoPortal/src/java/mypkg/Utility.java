package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;


public class Utility {
    static Connection con;
   public static Connection connect()
   {
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root@123RK");
            
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       return con;
   }
}
