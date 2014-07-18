/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.1.v20140609
 * Generated at: 2014-07-17 15:57:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <title>Web Frameworks Comparison</title>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/wro/all.css\"/>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"/wro/all.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body ng-app=\"claimer\" role=\"document\">\r\n");
      out.write("<div id=\"loginModal\" class=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\" ng-controller=\"login\">\r\n");
      out.write("  <div class=\"modal-dialog container-fluid\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h2 class=\"modal-title text-center\">Please choose GitHub repository with optional password.</h2>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        <form class=\"form-horizontal container-fluid\" name=\"loginForm\">\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <label class=\"control-label sr-only\" ng-class=\"{'has-error': loginForm.username.$invalid}\">Username</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\"\r\n");
      out.write("                   name=\"username\" ng-model=\"username\" required=\"true\"/>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <label class=\"control-label sr-only\">Password (optional)</label>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\"\r\n");
      out.write("                   name=\"password\" ng-model=\"password\" required=\"false\"/>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <div class=\"btn-group btn-group-justified\">\r\n");
      out.write("              <a class=\"btn btn-primary\" role=\"button\" data-dismiss=\"modal\" ng-click=\"login()\"\r\n");
      out.write("                 ng-disabled=\"loginForm.url.$invalid\">Select</a>\r\n");
      out.write("              <a class=\"btn btn-danger \" role=\"button\" data-dismiss=\"modal\">Cancel</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"claimer-container\">\r\n");
      out.write("      <div class=\"claimer-left\">\r\n");
      out.write("        <selectenvbranchcommit name=\"From\"></selectenvbranchcommit>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"claimer-center\">\r\n");
      out.write("        <div class=\"btn-group\">\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-default navbar-btn\" data-toggle=\"modal\" data-target=\"#loginModal\">\r\n");
      out.write("            {{username || 'Login'}}\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      </button>\r\n");
      out.write("      <div class=\"claimer-right\">\r\n");
      out.write("        <selectenvbranchcommit name=\"To\"></selectenvbranchcommit>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!--div class=\"container-fluid\" role=\"main\">\r\n");
      out.write("  <div class=\"fifty\">\r\n");
      out.write("    <form><textarea id=\"FromText\">Placeholder\r\n");
      out.write("    </textarea></form>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"fifty\">\r\n");
      out.write("    <form><textarea id=\"ToText\">Placeholder\r\n");
      out.write("    </textarea></form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div-->\r\n");
      out.write("<div id=view></div>\r\n");
      out.write("</div>\r\n");
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
