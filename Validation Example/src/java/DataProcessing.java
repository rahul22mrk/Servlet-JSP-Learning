
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DataProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String username = request.getParameter("t1");
           String t2 = request.getParameter("t2");
           int age=0;
           boolean isWrong = false;
           if(username.length()<1){
               isWrong = true;
               request.setAttribute("nameErr", "Name can't be Blank");
           }
           try{
                age = Integer.parseInt(t2);
           }catch(NumberFormatException e){
               isWrong = true;
                 request.setAttribute("ageErr", "Age should be numeric");
           }
           
           if(isWrong==false){
                out.println("<html>");
            out.println("<body>");
            out.println("<h3>Display-User-Details</h3>");
            out.println("<hr><h3>Username  :   "+username+"</h3>"); 
            out.println("<h3>Age  :   "+age+"</h3><hr>"); 
             
            out.println("</body>");
            out.println("</html>");
           }else{
                //response.sendRedirect("index.jsp");
               RequestDispatcher rd = request.getRequestDispatcher("input.jsp");
                rd.forward(request, response);
           }
           
           
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
