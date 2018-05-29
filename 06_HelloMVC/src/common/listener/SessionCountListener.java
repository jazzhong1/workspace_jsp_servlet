package common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCountListener
 *
 */
@WebListener
public class SessionCountListener implements HttpSessionListener {
	private static int activeSessions;
    /**
     * Default constructor. 
     */
    public SessionCountListener() {
       
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { //세션이 연결이되면 생성
         activeSessions++;
         System.out.println("create! : activeSessions:"+activeSessions);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
       activeSessions--;
       System.out.println("destroyed : session : "+activeSessions);
    }
	
}
