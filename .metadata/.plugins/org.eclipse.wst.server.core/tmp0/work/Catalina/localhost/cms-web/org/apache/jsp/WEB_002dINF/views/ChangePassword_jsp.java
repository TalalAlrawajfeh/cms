/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-02-20 08:03:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/u624/Desktop/cms/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/cms-web/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098703890000L));
    _jspx_dependants.put("/WEB-INF/lib/standard-1.1.2.jar", Long.valueOf(1487082037674L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=windows-1256");
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
      out.write("<div class=\"row\">\r\n");
      out.write("\t<div class=\"col-sm-9 col-sm-offset-2\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"col-sm-9 col-sm-offset-2\">\r\n");
      out.write("\t<h1 class=\"page-header\">Edit user</h1>\r\n");
      out.write("\t<form class=\"form-horizontal\" id=\"passwordForm\" method=\"post\"\r\n");
      out.write("\t\taction=\"./change-password\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"action\" name=\"action\" value=\"\">\r\n");
      out.write("\t\t<div class=\"col-xs-12 col-sm-8\">\r\n");
      out.write("\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t<label class=\"col-xs-12 col-sm-2\">Password</label>\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"oldPassword\" name=\"oldPassword\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Name\" required autofocus>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t<label class=\"col-xs-12 col-sm-2\">New Password</label>\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"newPassword\" name=\"newPassword\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Name\" required autofocus>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t<label class=\"col-xs-12 col-sm-2\">Confirm Password</label>\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\"\r\n");
      out.write("\t\t\t\t\t\toninput=\"checkTwoPasswords();\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Name\" required autofocus>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<label class=\"col-xs-12 col-sm-2\" id=\"errorLabel\"></label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-10 col-sm-offset-2\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"confirmPasswords();\">Save</button>\r\n");
      out.write("\t\t\t\t\t&nbsp; <a class=\"btn btn-danger\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"document.getElementById('action').value='cancel';document.getElementById('passwordForm').submit();\">Cancel</a>&nbsp;\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction checkTwoPasswords() {\r\n");
      out.write("\t\tnewPassword = document.getElementById('newPassword');\r\n");
      out.write("\t\tconfirmPassword = document.getElementById('confirmPassword');\r\n");
      out.write("\t\terrorLabel = document.getElementById('errorLabel');\r\n");
      out.write("\t\tif (newPassword.value === confirmPassword.value) {\r\n");
      out.write("\t\t\terrorLabel.style.color = 'green';\r\n");
      out.write("\t\t\terrorLabel.innerHTML = \"the two match\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\terrorLabel.style.color = 'red';\r\n");
      out.write("\t\t\terrorLabel.innerHTML = \"the two don't match\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction confirmPasswords() {\r\n");
      out.write("\t\tnewPassword = document.getElementById('newPassword');\r\n");
      out.write("\t\tconfirmPassword = document.getElementById('confirmPassword');\r\n");
      out.write("\t\tif (newPassword.value === confirmPassword.value) {\r\n");
      out.write("\t\t\tdocument.getElementById('action').value = 'save';\r\n");
      out.write("\t\t\tdocument.getElementById('passwordForm').submit();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\twindow\r\n");
      out.write("\t\t\t\t\t.alert(\"Please first confirm that the two passwords you entered match\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/ChangePassword.jsp(7,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${showError == true}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t<div class=\"alert alert-danger\">\r\n");
          out.write("\t\t\t\t\t<strong>Error!</strong> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      if (!_jspx_th_c_005fif_005f0_reused) {
        _jspx_th_c_005fif_005f0.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005fif_005f0);
      }
    }
    return false;
  }
}