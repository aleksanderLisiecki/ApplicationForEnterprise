/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alili
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        request.setCharacterEncoding("windows-1250");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        
        out.println("<html>");
        out.println("<head><title>Hello World Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        
        out.println("<p>Witaj, " + name + ", masz " + age + " lat</p>");
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        this.doGet(request, response);
    }



    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
