/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-10 07:18:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.system.school;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class yyqualified_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/system/school/../index/foot.jsp", Long.valueOf(1504314937630L));
    _jspx_dependants.put("/WEB-INF/jsp/system/school/../index/top.jsp", Long.valueOf(1504314937633L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("<!-- 下拉框 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/ace/css/chosen.css\" />\r\n");
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
      out.write("<!-- 日期框 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/ace/css/datepicker.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"no-skin\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- /section:basics/navbar.layout -->\r\n");
      out.write("\t<div class=\"main-container\" id=\"main-container\">\r\n");
      out.write("\t\t<!-- /section:basics/sidebar -->\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t<div class=\"main-content-inner\">\r\n");
      out.write("\t\t\t\t<div class=\"page-content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 检索  -->\r\n");
      out.write("\t\t\t\t\t\t<table id=\"simple-table\" class=\"table table-striped table-bordered table-hover\"  style=\"margin-top:5px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"center\" style=\"width:35px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"pos-rel\"><input type=\"checkbox\" class=\"ace\" id=\"zcheckbox\" /><span class=\"lbl\"></span></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"center\" style=\"width:60px;\">编号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"center\">资质名称</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"center\">资质图片</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th class=\"center\">更新时间</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 开始循环 -->\t\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.page-content -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.main-content -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 返回顶部 -->\r\n");
      out.write("\t\t<a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\r\n");
      out.write("\t\t\t<i class=\"ace-icon fa fa-angle-double-up icon-only bigger-110\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.main-container -->\r\n");
      out.write("\r\n");
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
      out.write("\t<!-- 删除时确认窗口 -->\r\n");
      out.write("\t<script src=\"static/ace/js/bootbox.js\"></script>\r\n");
      out.write("\t<!-- ace scripts -->\r\n");
      out.write("\t<script src=\"static/ace/js/ace/ace.js\"></script>\r\n");
      out.write("\t<!-- 日期框 -->\r\n");
      out.write("\t<script src=\"static/ace/js/date-time/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\t<!-- 下拉框 -->\r\n");
      out.write("\t<script src=\"static/ace/js/chosen.jquery.js\"></script>\r\n");
      out.write("\t<!--提示框-->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/js/jquery.tips.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(top.hangge());\r\n");
      out.write("$(function (){  \r\n");
      out.write("    $(\"div\").tooltip();  //初始化      \r\n");
      out.write("});  \r\n");
      out.write("\r\n");
      out.write("function toPhoto(photo){\r\n");
      out.write("\tlocalStorage.setItem(\"photo\",photo);\r\n");
      out.write("\t top.jzts();\r\n");
      out.write("\t var diag = new top.Dialog();\r\n");
      out.write("\t diag.Drag=true;\r\n");
      out.write("\t diag.Title =\"查看\";\r\n");
      out.write("\t diag.URL = '");
      out.print(basePath);
      out.write("page/system/school/photo';\r\n");
      out.write("\t diag.Width = 500;\r\n");
      out.write("\t diag.Height = 600;\r\n");
      out.write("\t diag.Modal = true;\t\t\t\t//有无遮罩窗口\r\n");
      out.write("\t diag. ShowMaxButton = true;\t//最大化按钮\r\n");
      out.write("    diag.ShowMinButton = true;\t\t//最小化按钮 \r\n");
      out.write("\t diag.CancelEvent = function(){ //关闭事件\r\n");
      out.write("   \t window.location.reload();\r\n");
      out.write("\t\tdiag.close();\r\n");
      out.write("\t };\r\n");
      out.write("\t diag.show();\r\n");
      out.write("\t }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsp/system/school/yyqualified_list.jsp(52,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty qList}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /WEB-INF/jsp/system/school/yyqualified_list.jsp(53,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/system/school/yyqualified_list.jsp(53,9) '${qList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${qList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/system/school/yyqualified_list.jsp(53,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("q");
    // /WEB-INF/jsp/system/school/yyqualified_list.jsp(53,9) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("vs");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td class='center' style=\"width: 30px;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label><input type='checkbox' name='ids' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${q.qualified_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${q.qualified_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"  class=\"ace\"/><span class=\"lbl\"></span></label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vs.index+1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${q.qualified_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center\" style=\"cursor:pointer;color:blue;\" onClick=\"toPhoto('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${q.img_url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("')\">查看</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${q.update_time }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /WEB-INF/jsp/system/school/yyqualified_list.jsp(65,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QX.cha == 0 }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"10\" class=\"center\">您无权查看</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<tr class=\"main_info\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"10\" class=\"center\">没有相关数据</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
