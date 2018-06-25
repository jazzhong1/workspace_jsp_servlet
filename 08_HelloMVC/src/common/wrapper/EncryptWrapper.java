package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key)
	{
		String value="";
		if(key!=null && ("password".equals(key)||"password_new".equals(key)))
		{
			value=super.getParameter(key);
			value=getSHA512(value);
			System.out.println("암호화 :"+ value);
		}
		else
		{
			value=super.getParameter(key);
		}
		return value;
	}
	
	private static String getSHA512(String password)
	{
		String sncPwd="";
		MessageDigest md=null;
		
		try {
			md= MessageDigest.getInstance("SHA-512");	
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		
		byte[] bytes=password.getBytes(Charset.forName("UTF-8"));
		
		md.update(bytes);
		
		sncPwd=Base64.getEncoder().encodeToString(bytes);
		
		return sncPwd;			
	}
}













