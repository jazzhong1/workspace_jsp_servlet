package common.wapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper  extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value="";
		if(key!=null &&(("password").equals(key))||("password_new").equals(key)) {
			value=super.getParameter(key);
			value=getSH512(value);
			System.out.println("암호화 : "+value);
		}
		else {
			value=super.getParameter(key);
			System.out.println(value);
		}
		return value;
	}
	
	private static String getSH512(String password){
		String sncPwd="";
		//암호화한것을 넣는 변수;
		MessageDigest md=null;
		//암호화 할수있는 객체생성
		try {
			md=MessageDigest.getInstance("SHA-512");
			//알고리즘을 가져온다.

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes=password.getBytes(Charset.forName("UTF-8"));
		//한글이 꺠질수도 있기때문에 명시해주는것이 좋다.
		
		md.update(bytes);
		
		sncPwd=Base64.getEncoder().encodeToString(bytes);
		
		return sncPwd;
	}
	//고정된 형식이기때문에 


}
