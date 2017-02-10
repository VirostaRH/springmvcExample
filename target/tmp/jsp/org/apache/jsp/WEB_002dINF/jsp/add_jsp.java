package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-2.2.4.js\" integrity=\"sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"/resources/events2.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<h1>Crear contacto:</h1>\n");
      out.write("\t\n");
      out.write("\t<form method=\"POST\" id=\"formu1\" action=\"/addNew/\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\">Name</td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\">Address</td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\">Email</td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\">Phone</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\"><input name=\"name\">\n");
      out.write("\t\t\t\t</input></td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\"><input name=\"address\">\n");
      out.write("\t\t\t\t</input></td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\"><input name=\"email\">\n");
      out.write("\t\t\t\t</input></td>\n");
      out.write("\t\t\t\t<td style=\"border: solid 1px\"><input name=\"telephone\">\n");
      out.write("\t\t\t\t</input></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"submit\" id=\"send\" value=\"Aceptar\">\n");
      out.write("\t\t<input type=\"submit\" id=\"cancel\" value=\"Cancelar\">\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
