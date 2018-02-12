/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bo
 */
@WebServlet(name = "Opg4", urlPatterns = {"/Opg4"})
public class Opg4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Opg4</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Opg4 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

            response.setContentType("text/html;charset=UTF-8");

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Opg4</title>");
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("name");
            String host = request.getHeader(headerName);
            if (name != null) {
                out.println("<p> Welcome " + name + " !</p>");
            } else {
                out.println("<h2>Please enter your name, and submit</h2>");
                out.println("<form action='Opg4'>");
                out.println("<input type='input' name='name'>");
                out.println("<input type='submit'></form>");
                out.println("<p>Host: " + host );
            }
            out.println("</body>");
            out.println("</html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("HTTP headers sent by your client:<br>");

        Enumeration head = request.getHeaderNames();
        while (head.hasMoreElements()) {
            String headerName = (String) head.nextElement();
            String headerValue = request.getHeader(headerName);
            out.print("<b>" + headerName + "</b>: ");
            out.println(headerValue + "<br>");
        }

//         Set response content type
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//        String title = "HTTP Header Request Example";
//        String docType
//                = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
//
//        out.println(docType
//                + "<html>\n"
//                + "<head><title>" + title + "</title></head>\n"
//                + "<body bgcolor = \"#f0f0f0\">\n"
//                + "<h1 align = \"center\">" + title + "</h1>\n"
//                + "<table width = \"100%\" border = \"1\" align = \"center\">\n"
//                + "<tr bgcolor = \"#949494\">\n"
//                + "<th>Header Name</th><th>Header Value(s)</th>\n"
//                + "</tr>\n"
//        );
//
//        Enumeration headerNames = request.getHeaderNames();
//
//        while (headerNames.hasMoreElements()) {
//            String paramName = (String) headerNames.nextElement();
//            out.print("<tr><td>" + paramName + "</td>\n");
//            String paramValue = request.getHeader(paramName);
//            out.println("<td> " + paramValue + "</td></tr>\n");
//        }
//        out.println("</table>\n</body></html>");
//    } 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Headers<hr/>");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            out.print("Header Name: <em>" + headerName);
//            String headerValue = request.getHeader(headerName);
//            out.print("</em>, Header Value: <em>" + headerValue);
//            out.println("</em><br/>");
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
