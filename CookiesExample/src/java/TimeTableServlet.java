import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimeTableServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       String cls=request.getParameter("class");
       
       //TimeTableServlet will write the info about the class to client's disk
       //so that other servlet can get this info through the cookies coming with request
       
       //step-1 Create the Cookie Object
       Cookie ck=new Cookie("info",cls);
       
       //step-2 set the max age
       ck.setMaxAge(60*60*24*7);
       
       //step-3 add the cookie to response object
       response.addCookie(ck);
       
        out.println("<html><body>");
        switch (cls) {
            case "CS-I":
                out.println("Time-Table-For-CS-I");
                break;
            case "CS-II":
                out.println("Time-Table-For-CS-II");
                break;
            case "CS-III":
                out.println("Time-Table-For-CS-III");
                break;
            case "CS-IV":
                out.println("Time-Table-For-CS-IV");
                break;
            default:
                break;
        }
       
       out.println("<a href=index.jsp>Home</a>");
       out.println("</html></body>");
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
