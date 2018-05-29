package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import common.wapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EcryptFilter
 */
@WebFilter(
		servletNames = { 
				"MemberEnrollServlet", 
				"MemberLoginServlet", 
				"MemberPasswordUpdateEndServlet"
		})
public class EcryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EcryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httprequest=(HttpServletRequest)request;
		//암호화 객체를 생성 		//컨테이너가 만든 request를 warpper클래스인 HttpServletRequest에 넣어준다.
		//형변환
		
		EncryptWrapper encryptWrapper=new EncryptWrapper(httprequest);
		//ServletRequest 다형성에 의해서 EncryptWrapper는 ServletRequest를 상속받기떄문에 chain.dofilter로 보낼수있다.
		//필터에서 
		
		chain.doFilter(encryptWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
