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

@WebFilter(
		servletNames = { 
				"MemberLoginServlet",
				"MemberPasswordUpdateEndServlet"
		})
public class EcryptFilter implements Filter {

    public EcryptFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest)request;
		
		EncryptWrapper encryptWrapper=new EncryptWrapper(httprequest);
		
		chain.doFilter(encryptWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
