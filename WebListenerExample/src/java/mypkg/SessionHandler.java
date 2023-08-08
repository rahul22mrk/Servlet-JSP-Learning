package mypkg;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionHandler implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("One new user is joined...........");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
         System.out.println("One user is leaving..........");
    }
}
