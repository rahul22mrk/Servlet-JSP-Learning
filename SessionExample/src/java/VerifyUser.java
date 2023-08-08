
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/VerifyUser"})
public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //read the request 
        String id = request.getParameter("t1");
        
        //process the request
        if(id.equalsIgnoreCase("abc")|| id.equalsIgnoreCase("xyz")|| id.equalsIgnoreCase("pqr")){
           //storing the userid to the session so that it will available for other servlets also
           
           //step-1 obtain the session object created for this user
           
           HttpSession session =  request.getSession();
           
           //step-2 write the data to session using setAttribute method of HttpSession
           session.setAttribute("userid", id);
           session.setAttribute("loginTime", new java.util.Date());
           
           
           //Writing something to context object
           //get the context object
           ServletContext context= getServletContext();
           //write the data to context object
           context.setAttribute("appname", "Session-Example-app-v.1.1");
            response.sendRedirect("dashboard.jsp");
        }else{
            PrintWriter out= response.getWriter();
            out.println("Invalid Account");
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
