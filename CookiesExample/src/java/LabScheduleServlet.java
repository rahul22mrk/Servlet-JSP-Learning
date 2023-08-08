import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LabScheduleServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       String cls="";
       
       //We will read the cookie name "info" to get the information about the class
       
       //step-1 fetch all the cookies coming with request
      Cookie ck[]=request.getCookies();
       
       //step-2 search for the desired one
      for(Cookie c:ck)
      {
          String name=c.getName();
          if(name.equals("info"))
          {
              cls=c.getValue();
              break;
          }
      }
       
        out.println("<html><body>");
        switch (cls) {
            case "CS-I":
                out.println("Lab-Schedule-For-CS-I");
                break;
            case "CS-II":
                out.println("Lab-Schedule-For-CS-II");
                break;
            case "CS-III":
                out.println("Lab-Schedule-For-CS-III");
                break;
            case "CS-IV":
                out.println("Lab-Schedule-For-CS-IV");
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
