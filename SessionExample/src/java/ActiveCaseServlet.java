
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActiveCaseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //for reading the data from session
        //step-1 fetch the session object
        HttpSession session = request.getSession();
        //step-2 read the data 
        String uid =(String) session.getAttribute("userid");
        
        //for reading the context object 
        //get the context object
        ServletContext context= getServletContext();
        //read the data from context 
        String appName= (String) context.getAttribute("appname");
        
        if(uid==null)
        {
            response.sendRedirect("index.jsp");
        }else{
               try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
             out.println("<h3>Welcome "+uid+"</h3>");
             out.println("<h3>App Name is"+appName+" </h3>");
            out.println("<h3>Total Active Cases :50000 </h3>");
            out.println("<h4><a href=dashboard.jsp> Dashboard</a> </h4>");
            out.println("</body>");
            out.println("</html>");
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
