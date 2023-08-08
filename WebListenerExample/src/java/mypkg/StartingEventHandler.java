
package mypkg;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartingEventHandler implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Object is Created...................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("COntext Objext is Destroyed..........");
    }
}