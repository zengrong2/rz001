/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-27 10:27:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.system.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fztree_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/js/jquery-1.7.2.js\"></script>\r\n");
      out.write("\t<link type=\"text/css\" rel=\"stylesheet\" href=\"plugins/zTree/2.6/zTreeStyle.css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"plugins/zTree/2.6/jquery.ztree-2.6.min.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("<table style=\"width:100%;\" border=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td style=\"width:15%;\" valign=\"top\" bgcolor=\"#F9F9F9\">\r\n");
      out.write("\t\t\t<div style=\"width:15%;\">\r\n");
      out.write("\t\t\t\t<ul id=\"leftTreedd\" class=\"tree\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td style=\"width:85%;\" valign=\"top\" >\r\n");
      out.write("\t\t\t<iframe name=\"treeFrame\" id=\"treeFrame\" frameborder=\"0\" src=\"");
      out.print(basePath);
      out.write("/pdtType.do?ptid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ptid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"margin:0 auto;width:100%;height:100%;\"></iframe>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\t\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(top.hangge());\r\n");
      out.write("\t\tvar zTree;\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\tvar setting = {\r\n");
      out.write("\t\t\t    showLine: true,\r\n");
      out.write("\t\t\t    checkable: false\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\tvar zTreeNode = eval(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zTreeNode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(");\r\n");
      out.write("\t\t\tzTree = $(\"#leftTreedd\").zTree(setting, zTreeNode);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction treeFrameT(){\r\n");
      out.write("\t\t\tvar hmainT = document.getElementById(\"treeFrame\");\r\n");
      out.write("\t\t\tvar bheightT = document.documentElement.clientHeight;\r\n");
      out.write("\t\t\thmainT .style.width = '100%';\r\n");
      out.write("\t\t\thmainT .style.height = (bheightT-26) + 'px';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttreeFrameT();\r\n");
      out.write("\t\twindow.onresize=function(){  \r\n");
      out.write("\t\t\ttreeFrameT();\r\n");
      out.write("\t\t};\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
