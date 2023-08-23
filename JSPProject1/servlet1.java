/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author markb
 */
public class servlet1 extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab 1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>First Servlet Lab</h1>");
            out.println("<form action=\"servlet1.java\" method=\"get\">");
            out.println("<label for=\"name\">Name: </label><br />");
            out.println("<input type=\"text\" id=\"name\" name=\"name\" /><br />");
            out.println("<label for=\"salary\">Yearly Salary: </label><br>");
            out.println("<input type=\"text\" id=\"salary\" name=\"salary\" /><br /><br />");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            
            if (!request.getParameter("name").equals("") && !request.getParameter("salary").equals("")) {
                String name = request.getParameter("name");
                int yearlySalary = 0;
                if (!request.getParameter("salary").equals("")) {
                    yearlySalary = Integer.parseInt(request.getParameter("salary"));
                }
                int monthlySalary = monthlySalaryCalculator.calcMonth(yearlySalary);
                out.println("<h1>Hello " + name + ", your calculated monthly salary" +
                         " was $" + monthlySalary + ".</h1>");
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
