package common.wapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		//기본생성자.
		super(request);
		//자체가 request가 된다.
	}
	
	@Override
	public String getParameter(String key){
		//패스워드가 키값이랑 같았을떄
		String value="";
		if(key!=null && ("password".equals(key))||("password_new").equals(key)){
			//key에 값이있고 key값이 password와 같을경우.
			value=super.getParameter(key);
			//key가 삽입되게 
							//키값과 같을경우 속성값을 가져와 value에 태입
			value=getSHA512(value);
							//대입한 값을 value에 태입
			System.out.println("암호화 : "+value);
			
		}
		else{
			value=super.getParameter(key);
			//key가 password가 아닐겨우
		}
		return value;
	}

	private static String getSHA512(String password) {
		String sncPwd="";
		MessageDigest md=null;

		try {
			md=MessageDigest.getInstance("SHA-512");
							//알고리즘을 가져온다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		byte[] bytes=password.getBytes(Charset.forName("UTF-8"));
		//바이트단위로 모든걸 처리한다.			//인코딩값을 UTF-8로 맞춰주기위해 사용한다.
		md.update(bytes);
		sncPwd=Base64.getEncoder().encodeToString(bytes);
				//Base64인코더로
				//64비트를 이용해서 byte값을.string로 바꿔준다.

		return sncPwd;
	}
	
	//고정된 형식이기때문에 

}
