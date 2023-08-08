
package mypkg;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class StartingEventHandler implements ServletContextListener {

      private Connection con;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Created.....");
         try{
            con=mypkg.Utility.connect();
            ServletContext context = sce.getServletContext();
            context.setAttribute("dbcon", con);
             System.out.println("Connected Successfully in Context Initialized.....");
        }catch(Exception e)
        {
            System.out.println("Error in Establishing a connection");
        }
      
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed.....");
          try
        {
            con.close();
            System.out.println("Connection closed Successfully in Context Destroyed.....");
        }catch(SQLException e)
        {
             System.out.println("Error in Closing a connection");
        }
    }
}
