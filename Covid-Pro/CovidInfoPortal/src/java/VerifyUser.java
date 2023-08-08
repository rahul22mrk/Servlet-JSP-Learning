import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyUser extends HttpServlet {

    private Connection con;
    private PreparedStatement ps1,ps2;
    public void init()
    {
        try{
           ServletContext context = getServletContext();
           con = (Connection) context.getAttribute("dbcon");
            ps1=con.prepareStatement("select * from users where email=? and password=?");
            ps2=con.prepareStatement("select * from stateadmins where userid=? and password=?");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void destroy()
    {
       
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       String id= request.getParameter("uid");
       String password=request.getParameter("password");
       String utype=request.getParameter("utype");
       
       if(utype.equals("super-admin"))
       {
           if(id.equals("sadmin") && password.equals("1234"))
           {
              //we want this request to be forwarded to sadmindashboard
                //response.sendRedirect("sadmindashboard.jsp");
              RequestDispatcher rd=request.getRequestDispatcher("sadmindashboard.jsp");
              rd.forward(request, response);
               
           }else{
              out.println("<html><body>");
               out.println("<h3>Invalid Super Admin</h3>");
               out.println("<h4><a href=index.jsp>Try-again</a></h4>");
                out.println("</body></html>");
           }
           
       }else if(utype.equals("state-admin"))
       {
          //we will check the credentials from db and match with inputs given by user
         try{
               ps2.setString(1, id);
               ps2.setString(2, password);
               ResultSet rs=ps2.executeQuery();
               boolean found=rs.next();
               if(found)
               {//credentials are true
                   String status=rs.getString("status");
                   String uid=rs.getString("userid");
                   //check the status
                   if(status.equals("disabled"))
                   {
                       //if-disabled-then-we-will-show-profile-completion-form
                       out.println("<html>");
                       out.println("<body>");
                       out.println("<h3>Profile-Completion-Form-Show</h3>");
                       out.println("<form action=UpdateStateAdminProfile>");
                       out.println("<pre>");
                       out.println("Userid        : <input type=text name=uid value="+uid+">"); 
                       out.println("Password     : <input type=password name=password>");
                       out.println("Username     : <input type=text name=uname>");
                       out.println("Email        : <input type=text name=email>");
                       out.println("Address      : <input type=text name=address>");
                       out.println("Mobile       : <input type=text name=mobile>");
                       out.println("<input type=submit value=Update");
                        out.println("</pre>");
                       out.println("</form>");
                       
                       out.println("</body>");
                       out.println("</html>");
                   }else{
                         //if-enabled-then-we-will-display-dashboard
                         //stroing the userid and state into session 
                         //fetch the session
                         HttpSession session = request.getSession();
                         //write the data into session
                         session.setAttribute("userid", id);
                         session.setAttribute("state", rs.getString("state"));
                         response.sendRedirect("stateadmindashboard.jsp");
                   }
               }else{
                   //credentials are wrong 
                   out.println("<html><body>");
               out.println("<h3>Invalid State-Admin Account</h3>");
               out.println("<h4><a href=index.jsp>Try-again</a></h4>");
                out.println("</body></html>");
               }
            
         }catch(SQLException e)
         {
            out.println(e);
         }
           
          
       }else if(utype.equals("enduser")){
          //we need authincate to db
          try{
          
          ps1.setString(1, id);
          ps1.setString(2,password);
          ResultSet rs=ps1.executeQuery();
          boolean found=rs.next();
          if(found)
          {
              //we want this request to be forwarded to sadmindashboard
              // response.sendRedirect("userdashboard.jsp");
              RequestDispatcher rd=request.getRequestDispatcher("userdashboard.jsp");
              rd.forward(request, response);
          }else{
               out.println("<html><body>");
               out.println("<h3>Invalid End User</h3>");
               out.println("<h4><a href=index.jsp>Try-again</a></h4>");
                out.println("</body></html>");
          }
          
          }catch(Exception e)
          {
              e.printStackTrace();
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
