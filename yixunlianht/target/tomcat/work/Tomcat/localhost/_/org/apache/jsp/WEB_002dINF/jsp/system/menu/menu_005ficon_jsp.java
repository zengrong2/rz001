/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-28 03:11:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.system.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_005ficon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/system/menu/../index/foot.jsp", Long.valueOf(1504314937630L));
    _jspx_dependants.put("/WEB-INF/jsp/system/menu/../index/top.jsp", Long.valueOf(1504314937633L));
  }

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
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<!-- jsp文件头和头部 -->\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pd.SYSNAME}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</title>\r\n");
      out.write("\t\t<meta name=\"description\" content=\"\" />\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n");
      out.write("\t\t<!-- bootstrap & fontawesome -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"static/ace/css/bootstrap.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"static/ace/css/font-awesome.css\" />\r\n");
      out.write("\t\t<!-- page specific plugin styles -->\r\n");
      out.write("\t\t<!-- text fonts -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"static/ace/css/ace-fonts.css\" />\r\n");
      out.write("\t\t<!-- ace styles -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"static/ace/css/ace.css\" class=\"ace-main-stylesheet\" id=\"main-ace-style\" />\r\n");
      out.write("\t\t<!--[if lte IE 9]>\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"static/ace/css/ace-part2.css\" class=\"ace-main-stylesheet\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t\t<!--[if lte IE 9]>\r\n");
      out.write("\t\t  <link rel=\"stylesheet\" href=\"static/ace/css/ace-ie.css\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t\t<!-- inline styles related to this page -->\r\n");
      out.write("\t\t<!-- ace settings handler -->\r\n");
      out.write("\t\t<script src=\"static/ace/js/ace-extra.js\"></script>\r\n");
      out.write("\t\t<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->\r\n");
      out.write("\t\t<!--[if lte IE 8]>\r\n");
      out.write("\t\t<script src=\"static/ace/js/html5shiv.js\"></script>\r\n");
      out.write("\t\t<script src=\"static/ace/js/respond.js\"></script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- /section:basics/navbar.layout -->\r\n");
      out.write("\t<div class=\"main-container\" id=\"main-container\">\r\n");
      out.write("\t\t<!-- /section:basics/sidebar -->\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t<div class=\"main-content-inner\">\r\n");
      out.write("\t\t\t\t<div class=\"page-content\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div id=\"zhongxin\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<form action=\"menu/editicon.do\" name=\"menuForm\" id=\"menuForm\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"MENU_ID\" id=\"menuId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pd.MENU_ID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"MENU_ICON\" id=\"MENU_ICON\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"MENU_ICONColor\" id=\"MENU_ICONColor\" value=\"black\"/>\r\n");
      out.write("\t\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<table id=\"dynamic-table\" class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"center\" style=\"cursor:pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"black\"><label onclick=\"setcolor('black');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"red\"><label onclick=\"setcolor('red');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"green\"><label onclick=\"setcolor('green');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"orange\"><label onclick=\"setcolor('orange');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"purple\"><label onclick=\"setcolor('purple');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"pink\"><label onclick=\"setcolor('pink');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"blue\"><label onclick=\"setcolor('blue');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"grey\"><label onclick=\"setcolor('grey');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"brown\"><label onclick=\"setcolor('brown');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"white\"><label onclick=\"setcolor('white');\"><input name=\"form-field-radioc\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<table id=\"dynamic-table\" class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"center\" style=\"cursor:pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-adjust ');\"><i class=\"menu-icon fa fa-adjust \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-asterisk ');\"><i class=\"menu-icon fa fa-asterisk \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-ban');\"><i class=\"menu-icon fa fa-ban\"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bar-chart-o ');\"><i class=\"menu-icon fa fa-bar-chart-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-barcode ');\"><i class=\"menu-icon fa fa-barcode \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-flask ');\"><i class=\"menu-icon fa fa-flask \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-beer ');\"><i class=\"menu-icon fa fa-beer \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bell-o ');\"><i class=\"menu-icon fa fa-bell-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bell ');\"><i class=\"menu-icon fa fa-bell \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bolt ');\"><i class=\"menu-icon fa fa-bolt \"></i>&nbsp;&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-book ');\"><i class=\"menu-icon fa fa-book \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bookmark ');\"><i class=\"menu-icon fa fa-bookmark \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa  fa-bookmark-o ');\"><i class=\"menu-icon fa  fa-bookmark-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-briefcase ');\"><i class=\"menu-icon fa fa-briefcase \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-bullhorn ');\"><i class=\"menu-icon fa fa-bullhorn \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-calendar ');\"><i class=\"menu-icon fa fa-calendar \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-camera ');\"><i class=\"menu-icon fa fa-camera \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-camera-retro ');\"><i class=\"menu-icon fa fa-camera-retro \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-certificate ');\"><i class=\"menu-icon fa fa-certificate \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"center\" style=\"cursor:pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-check-square-o ');\"><i class=\"menu-icon fa fa-check-square-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-square-o ');\"><i class=\"menu-icon fa fa-square-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-circle ');\"><i class=\"menu-icon fa fa-circle \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-circle-o ');\"><i class=\"menu-icon fa fa-circle-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cloud ');\"><i class=\"menu-icon fa fa-cloud \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cloud-download ');\"><i class=\"menu-icon fa fa-cloud-download \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cloud-upload ');\"><i class=\"menu-icon fa fa-cloud-upload \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa  fa-coffee ');\"><i class=\"menu-icon fa  fa-coffee \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cog ');\"><i class=\"menu-icon fa fa-cog \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cogs ');\"><i class=\"menu-icon fa fa-cogs \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-comment ');\"><i class=\"menu-icon fa fa-comment \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-comment-o ');\"><i class=\"menu-icon fa fa-comment-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-comments ');\"><i class=\"menu-icon fa fa-comments \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-comments-o ');\"><i class=\"menu-icon fa fa-comments-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-credit-card ');\"><i class=\"menu-icon fa fa-credit-card \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-tachometer ');\"><i class=\"menu-icon fa fa-tachometer \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-desktop ');\"><i class=\"menu-icon fa fa-desktop \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-arrow-circle-o-down ');\"><i class=\"menu-icon fa fa-arrow-circle-o-down \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-download ');\"><i class=\"menu-icon fa fa-download \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"center\" style=\"cursor:pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-pencil-square-o ');\"><i class=\"menu-icon fa fa-pencil-square-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-envelope ');\"><i class=\"menu-icon fa fa-envelope \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-envelope-o ');\"><i class=\"menu-icon fa fa-envelope-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-exchange ');\"><i class=\"menu-icon fa fa-exchange \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-exclamation-circle ');\"><i class=\"menu-icon fa fa-exclamation-circle \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-external-link ');\"><i class=\"menu-icon fa fa-external-link \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-eye-slash ');\"><i class=\"menu-icon fa fa-eye-slash \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-eye ');\"><i class=\"menu-icon fa fa-eye\"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-video-camera ');\"><i class=\"menu-icon fa fa-video-camera \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-fighter-jet ');\"><i class=\"menu-icon fa fa-fighter-jet \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-film ');\"><i class=\"menu-icon fa fa-film \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-filter ');\"><i class=\"menu-icon fa fa-filter \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-fire ');\"><i class=\"menu-icon fa fa-fire \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-flag ');\"><i class=\"menu-icon fa fa-flag \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-folder ');\"><i class=\"menu-icon fa fa-folder \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-folder-open ');\"><i class=\"menu-icon fa fa-folder-open \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-folder-o ');\"><i class=\"menu-icon fa fa-folder-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-folder-open-o ');\"><i class=\"menu-icon fa fa-folder-open-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-cutlery ');\"><i class=\"menu-icon fa fa-cutlery \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"center\" style=\"cursor:pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-gift ');\"><i class=\"menu-icon fa fa-gift \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-glass ');\"><i class=\"menu-icon fa fa-glass \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-globe ');\"><i class=\"menu-icon fa fa-globe \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-users ');\"><i class=\"menu-icon fa \tfa-users \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-hdd-o ');\"><i class=\"menu-icon fa fa-hdd-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-headphones ');\"><i class=\"menu-icon fa fa-headphones \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-heart ');\"><i class=\"menu-icon fa fa-heart \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-heart-o ');\"><i class=\"menu-icon fa fa-heart-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-home ');\"><i class=\"menu-icon fa fa-home \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-inbox ');\"><i class=\"menu-icon fa  fa-inbox \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-info-circle ');\"><i class=\"menu-icon fa fa-info-circle \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-key ');\"><i class=\"menu-icon fa fa-key \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-leaf ');\"><i class=\"menu-icon fa fa-leaf \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-laptop ');\"><i class=\"menu-icon fa fa-laptop \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-gavel ');\"><i class=\"menu-icon fa fa-gavel \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-lemon-o ');\"><i class=\"menu-icon fa fa-lemon-o \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-lightbulb-o ');\"><i class=\"menu-icon fa fa-lightbulb-o \"></i>&nbsp;&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-lock ');\"><i class=\"menu-icon fa fa-lock \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><label onclick=\"seticon('menu-icon fa fa-unlock ');\"><i class=\"menu-icon fa fa-unlock \"></i>&nbsp;<input name=\"form-field-radio\" type=\"radio\" value=\"icon-edit\"><span class=\"lbl\"></span></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align: center;\" colspan=\"100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"btn btn-mini btn-primary\" onclick=\"save();\">保存</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"btn btn-mini btn-danger\" onclick=\"top.Dialog.close();\">取消</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div id=\"zhongxin2\" class=\"center\" style=\"display:none\"><img src=\"static/images/jzx.gif\" /></div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.page-content -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.main-content -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- /.main-container -->\r\n");
      out.write("\t<!-- basic scripts -->\r\n");
      out.write("\t<!-- 页面底部js¨ -->\r\n");
      out.write("\t");
      out.write('	');
      out.write('	');

			String pathf = request.getContextPath();
			String basePathf = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ pathf + "/";
		
      out.write("\r\n");
      out.write("\t\t<!--[if !IE]> -->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\twindow.jQuery || document.write(\"<script src='");
      out.print(basePathf);
      out.write("static/ace/js/jquery.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<!-- <![endif]-->\r\n");
      out.write("\t\t<!--[if IE]>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t window.jQuery || document.write(\"<script src='");
      out.print(basePathf);
      out.write("static/ace/js/jquery1x.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tif('ontouchstart' in document.documentElement) document.write(\"<script src='");
      out.print(basePathf);
      out.write("static/ace/js/jquery.mobile.custom.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script src=\"static/ace/js/bootstrap.js\"></script>");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(top.hangge());\r\n");
      out.write("\t\t//保存\r\n");
      out.write("\t\tfunction save(){\r\n");
      out.write("\t\t\tif($(\"#MENU_ICON\").val()==\"\"){\r\n");
      out.write("\t\t\t\talert('请选择图标');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#MENU_ICON\").val($(\"#MENU_ICON\").val()+$(\"#MENU_ICONColor\").val());\r\n");
      out.write("\t\t\t$(\"#menuForm\").submit();\r\n");
      out.write("\t\t\t$(\"#zhongxin\").hide();\r\n");
      out.write("\t\t\t$(\"#zhongxin2\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction seticon(icon){\r\n");
      out.write("\t\t\t$(\"#MENU_ICON\").val(icon);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction setcolor(iconColor){\r\n");
      out.write("\t\t\t$(\"#MENU_ICONColor\").val(iconColor);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
