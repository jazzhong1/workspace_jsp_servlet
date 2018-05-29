/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2018-05-29 14:58:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import java.util.ArrayList;
import notice.model.vo.Notice;
import java.util.List;
import member.model.vo.Member;

public final class noticeView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/common/header.jsp", Long.valueOf(1527599366075L));
    _jspx_dependants.put("/views/common/footer.jsp", Long.valueOf(1526393390403L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("notice.model.vo.Notice");
    _jspx_imports_classes.add("org.apache.jasper.tagplugins.jstl.core.ForEach");
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");

	Notice n = (Notice) request.getAttribute("notice");

	String loc = request.getContextPath() + "/noticeList";
	//목록으로 보내기위해

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	//Member memberLoggedIn=(Member)request.getAttribute("memberLoggedIn");
	//HttpSession session1=request.getSession();
	//Member memberLoggedIn=(Member)(request.getSession().getAttribute("memberLoggedIn"));
	Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");
	//애초에 null이기때문에 jsp가 수행된다.
	String userSaveId="";
	boolean saveId=false;
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			String key=c.getName();
			String value=c.getValue();
			if(key.equals("saveId")){	
				saveId=!saveId;
				userSaveId=value;
			}
		}
		
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Hello MVC</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\">\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction fn_login_validate()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif($(\"#userId\").val().trim().length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($(\"#password\").val().trim().length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<h1>Hello MVC</h1>\r\n");
      out.write("\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t");
 if(memberLoggedIn==null) { 
      out.write("\t\t<!-- 처음에는 null일까? -->\r\n");
      out.write("\t\t\t<!-- 로그인 폼 작성 -->\r\n");
      out.write("\t\t\t<form id=\"loginFrm\" action=\"");
      out.print(request.getContextPath());
      out.write("/login.do\" method=\"post\" onsubmit=\"return fn_login_validate();\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"userId\" id=\"userId\" placeholder=\"아이디\" value=\"");
      out.print(saveId?userSaveId:"");
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password\" placeholder=\"비밀번호\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"submit\" value=\"로그인\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print(saveId?"checked":"");
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"saveId\">아이디저장</label>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" value=\"회원가입\" \r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/memberEnroll.do'\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 띄어쓰기 있으면안됨. -->\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t");
 }
		else {
		
      out.write("\t\r\n");
      out.write("\t\t\t<table id=\"logged-in\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( memberLoggedIn.getMemberName() );
      out.write("님 환영합니다.</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"button\" value=\"내정보보기\" \r\n");
      out.write("\t\t\t\t\t  onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/memberView?userId=");
      out.print( memberLoggedIn.getMemberId());
      out.write("';\">\r\n");
      out.write("\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t<!--userId라는 키값에 member.getid해서 보낸것-->\r\n");
      out.write("\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t<!-- 쿼리스트링방식 ?변수명=값 여러개보낼때는 &-->\r\n");
      out.write("\t\t\t\t\t </td> \r\n");
      out.write("\t\t\t\t\t<td><input type=\"button\" value=\"로그아웃\" \r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/logout.do';\">\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 로그인 폼 작성 끝! -->\r\n");
      out.write("\t<!-- 메인 메뉴 -->\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t<li class=\"home\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">home</a></li>\r\n");
      out.write("\t\t\t<li id=\"notice\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/noticeList\">공지사항</a></li>\r\n");
      out.write("\t\t\t<li id=\"board\"><a href=\"#\">게시판</a></li>\r\n");
      out.write("\t\t\t<li id=\"photo-board\"><a href=\"#\">사진게시판</a></li>\r\n");
      out.write("\t\t\t");
 if(memberLoggedIn!=null && memberLoggedIn.getMemberId().equals("admin")){
      out.write("\r\n");
      out.write("\t\t\t<li id=\"admin-member\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/memberList\">회원관리<span class=\"animate_line\"></span></a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t<!-- if문 로직을쓸때는 jsp 태그에서 ==Tmwldksgsmsek.> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t\r\n");
      out.write("<section>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<div id=\"notice-container\">\r\n");
      out.write("\t<table id=\"tbl-notice\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t<td>");
      out.print(n.getNotice_title() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t<td>");
      out.print(n.getNotice_writer() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t<td>");
if(n.getFilePath()!=null){
      out.write("\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/noticeFileDownload?filePath=\"");
      out.print(n.getFilePath() );
      out.write("><img alt='첨부파일' src='");
      out.print(request.getContextPath());
      out.write("/image/file.png' width='16px'></a>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"목록으로\" onclick=\"location.href='");
      out.print(loc);
      out.write("'\">\r\n");
      out.write("\t\t");
if(memberLoggedIn!=null&&(memberLoggedIn.getMemberId()).equals("admin")) 
					  { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type='button' value='수정하기' onclick='fn_updateNotice()'>\r\n");
      out.write("\t\t\t\t\t\t<input type='button' value='삭제하기' onclick='fn_deleteNotice()'>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t function fn_updateNotice() {\r\n");
      out.write("\t\t\t location.href=\"");
      out.print(request.getContextPath());
      out.write("/noticeUpdate?no=");
      out.print(n.getNotice_no());
      out.write("\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t function fn_deleteNotice() {\r\n");
      out.write("\t\t\t location.href=\"");
      out.print(request.getContextPath());
      out.write("/noticedelete?no=");
      out.print(n.getNotice_no());
      out.write("\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\t<footer align='center'>\r\n");
      out.write("\t\t\t<p>&lt;CopyRight 2018.<strong>KH정보교육원</strong>All right reserved.&gt;</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<!--aaa -> -->");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
