/* 
CMPSCI 221 CDC Demographics Final Project
index.html
Purpose: Using SQL, Java, and HTML to display the CDC's numbers to the user who 
inputs their desired parameters. 

@author Mark Garas, Alvin Chen, Gabriel Fleming, Kaiqi Yang
@version 1.0 4/20/2021
*/

package CDCJava;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author markb
 */
@WebServlet(name = "CDCServlet", urlPatterns = {"/CDCServlet"})
public class CDCServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {}
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet handles JSP inputs.";
    }// </editor-fold>
    
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
        //processRequest(request, response);
        
        // Setting Strings to the desired search filter
        String firstSearchDemo = request.getParameter("group1");
        System.out.print(firstSearchDemo);
        String dropDown1 = request.getParameter("demo1");
        System.out.print(dropDown1);
        String question1 = request.getParameter("question1");
        System.out.print(question1);
        
        String secondSearchDemo = request.getParameter("group2");
        System.out.print(secondSearchDemo);
        String dropDown2 = request.getParameter("demo2");
        System.out.print(dropDown2);
        String question2 = request.getParameter("question2");
        System.out.print(question2);
        
        // If either search bar is not empty, use that input to make a SearchQuery object
        if (firstSearchDemo != null) {
            SearchQuery search1 = new SearchQuery(firstSearchDemo, dropDown1, question1);
            String output1 = search1.executeSearch();
            output1 = insertSpacing(output1);
            request.setAttribute("results1", output1);
        }
        
        if (secondSearchDemo != null) {
            SearchQuery search2 = new SearchQuery(secondSearchDemo, dropDown2, question2);
            String output2 = search2.executeSearch();
            output2 = insertSpacing(output2);
            request.setAttribute("results2", output2);
        }
        
        // Resetting the form with the output
        getServletContext().getRequestDispatcher("/CDCJSP.jsp").forward(request, response);
    }
    
    // This takes the string output from the SearchQuery and adds HTML spaces for better visual design.
    public String insertSpacing(String unSpaced) {
        int insertSpace1 = unSpaced.indexOf("Search D");
        int insertSpace2 = unSpaced.indexOf("Search R");
        return unSpaced.substring(0,insertSpace1 - 1) + "&nbsp&nbsp&nbsp&nbsp" + 
                unSpaced.substring(insertSpace1, insertSpace2 - 1) + "&nbsp&nbsp&nbsp&nbsp" +
                unSpaced.substring(insertSpace2);
    }

}