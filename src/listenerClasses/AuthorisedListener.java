package listenerClasses;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AuthorisedListener
 *
 */
@WebListener
public class AuthorisedListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public AuthorisedListener() {
        // TODO Auto-generated constructor stub
    }
    
    private static int totalActiveSessions;
 	
    public static int getTotalActiveSession(){
  	return totalActiveSessions;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
   	 totalActiveSessions++;
   		System.out.println("sessionCreated - add one session into counter");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
   	 totalActiveSessions--;
   		System.out.println("sessionDestroyed - deduct one session from counter");
    }
	
}
