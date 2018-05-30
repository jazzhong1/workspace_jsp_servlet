/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2018-05-30 11:49:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import board.model.vo.Board;
import member.model.vo.Member;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/common/header.jsp", Long.valueOf(1527650776379L));
    _jspx_dependants.put("/views/common/footer.jsp", Long.valueOf(1526277498000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("board.model.vo.Board");
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
      out.write("\t");
 ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("board");
	int numPerPage=(int)request.getAttribute("numPerPage");
	int cPage=(int)request.getAttribute("cPage");
	String pageBar=(String)request.getAttribute("pageBar");
	
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//Member memberLoggedIn=(Member)request.getAttribute("memberLoggedIn");
	HttpSession session1 = request.getSession();
	//Member memberLoggedIn=(Member)(request.getSession().getAttribute("memberLoggedIn"));
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn"); //내장객체

	Cookie[] cookie = request.getCookies();
	boolean saveId = false;
	String userIdSaved = "";

	if (cookie != null) {
		for (Cookie c : cookie) {
			String key = c.getName();
			String value = c.getValue();
			if ("saveId".equals(key)) {
				saveId = true;
				userIdSaved = value;
			}
		}
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Hello MVC</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\">\r\n");
      out.write("<script>\r\n");
      out.write("\t//유효성 검사\r\n");
      out.write("\tfunction fn_login_validate() {\r\n");
      out.write("\t\tif ($(\"#userId\").val().trim().length == 0) {\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($(\"#password\").val.trim().length == 0) {\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<h1>Hello MVC</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t\t");

					if (memberLoggedIn == null) {
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- 함수가 false면 post로 안보내줌 -->\r\n");
      out.write("\t\t\t\t<form id=\"loginfrm\" action=\"");
      out.print(request.getContextPath());
      out.write("/login\"\r\n");
      out.write("\t\t\t\t\tmethod=\"post\" onsubmit=\"return fn_login_validate();\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"userId\" id=\"userId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"아이디\" value=\"");
      out.print(saveId ? userIdSaved : "");
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"비밀번호\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"submit\" value=\"로그인\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"checkbox\" name=\"saveId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"saveId\" ");
      out.print(saveId ? "checked" : "");
      out.write("> <label\r\n");
      out.write("\t\t\t\t\t\t\t\tfor=\"saveId\">아이디 저장</label>&nbsp;&nbsp; <input type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"회원가입\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/memberEnroll'\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<table id=\"logged-in\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(memberLoggedIn.getUserName());
      out.write("님 환영합니다.</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<!-- 페이지 위치 변경 url http://localhost:9090/06_HelloMVC/memberView-->\r\n");
      out.write("\t\t\t\t\t\t<!-- 쿼리스트링방식 ?변수명=값 여러개보낼때는 &-->\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"button\" value=\"내정보보기\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/memberView?userId=");
      out.print(memberLoggedIn.getUserId());
      out.write("';\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"button\" value=\"로그아웃\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/logout';\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 로그인 폼 작성 끝! -->\r\n");
      out.write("\t\t\t<!-- 메인메뉴 작성 -->\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"home\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">home</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"notice\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/noticeList\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"board\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/boardList\">게시판</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"photo-board\"><a href=\"#\">사진게시판</a></li>\r\n");
      out.write("\t\t\t\t\t");
 if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId())) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<li id=\"admin-member\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/memberList\">회원관리<span class=\"animate_line\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>\r\n");
      out.write("<section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<style>\r\n");
      out.write("\tsection#board-container{width:600px; margin:0 auto; text-align:center;}\r\n");
      out.write("\tsection#board-container h2{margin:10px 0;}\r\n");
      out.write("\ttable#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }\r\n");
      out.write("\ttable#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} \r\n");
      out.write("\t/*글쓰기버튼*/\r\n");
      out.write("\tinput#btn-add{float:right; margin: 0 0 15px;}\r\n");
      out.write("\t/*페이지바*/\r\n");
      out.write("\tdiv#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}\r\n");
      out.write("\tdiv#pageBar span.cPage{color: #0066ff;}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<section id=\"board-container\">\r\n");
      out.write("\t\t<h2>게시판 </h2>\r\n");
      out.write("\t\t<table id=\"tbl-board\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>번호</th>\r\n");
      out.write("\t\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t\t<th>작성일</th>\r\n");
      out.write("\t\t\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t\t\t<th>조회수</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t");

				if(list==null||list.isEmpty()){
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"9\" align=\"center\">검색결과가 없습니다.</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
}else{
				for(Board b:list){
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(b.getBoardNo());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/boardView?no=");
      out.print(b.getBoardNo());
      out.write('"');
      out.write('>');
      out.print(b.getBoardTitle());
      out.write("</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(b.getBoardWriter());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(b.getBoardDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
 if(b.getBoardOriginalFileName() != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<img alt=\"첨부파일\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/file.png\" width=16px>\r\n");
      out.write("\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(b.getBoardReadCount());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
 
				}
				}
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\t<div id=\"pageBar\" align=\"center\">");
      out.print(pageBar);
      out.write("</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\t<footer align='center'>\r\n");
      out.write("\t\t\t<p>&lt;CopyRight 2018.<strong>KH정보교육원</strong>All right reserved.&gt;</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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