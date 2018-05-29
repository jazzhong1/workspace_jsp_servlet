package member.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MemberListener implements HttpSessionListener {
	
	public static int activeSession;

    public MemberListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	activeSession++;
    	System.out.println("creative activeSession : "+activeSession);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	activeSession--;
    	if(activeSession<0){
    		activeSession=0;
    	}
    	System.out.println("destroye activeSession : "+activeSession);
    }
	
}
