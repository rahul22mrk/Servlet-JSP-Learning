import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StateAccountCreationServlet extends HttpServlet {
    private Connection con;
    private PreparedStatement pt;
    //called while loading
    public void init()
    {
        try{
           ServletContext context = getServletContext();
           con = (Connection) context.getAttribute("dbcon");
            String sql= "insert into stateadmins values(?,?,?,null,null,null,null,'disabled')";
            pt=con.prepareStatement(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //called just before unloading
    public void destroy()
    {
        try
        {
          //  con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //request read
        String userid=request.getParameter("uid");
        String password=request.getParameter("password");
        String state=request.getParameter("state");
        
        //request process (Store the values to Database)
        //now we will store the values into db using JDBC.
        try{
            
            pt.setString(1, userid);
            pt.setString(2, password);
            pt.setString(3, state);
            pt.executeUpdate();
            
            
            //response
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Account-Successfully-Created</h3>");
            out.println("<h4><a href=sadmindashboard.jsp>Dashboard</a></h4>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e)
        {
            out.println(e);
        }
        
        //request response
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
