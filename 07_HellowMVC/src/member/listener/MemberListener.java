package member.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MemberListener
 *
 */
@WebListener
public class MemberListener implements HttpSessionListener {

		public static int activeSessions=0;
    /**
     * Default constructor. 
     */
    public MemberListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	activeSessions++;
    	System.out.println("create session : "+activeSessions);
    }
    

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	activeSessions--;
    	if(activeSessions<0){
    		activeSessions=0;
    	}
    	System.out.println("destoryed session : "+activeSessions);
    }
	
}
