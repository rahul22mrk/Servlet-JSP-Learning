import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveInfo extends HttpServlet {
    private Connection con;
    private PreparedStatement pt;
    //called while loading
    @Override
    public void init()
    {
        try{
           // con=mypkg.Utility.connect();//this will create a new connection
           //we want to access that connection which was established during startup
           
           //we will get the connection from context object
           ServletContext context = getServletContext();
           con = (Connection) context.getAttribute("dbcon");
            String sql= "insert into covidinfo (idate,state,total,active,deaths,userid) values(now(),?,?,?,?,?)";
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
            //con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //request read
        //state=mp&userid=mpuser&total=239&active=100&deaths=21&submit=Submit
      //  String userid=request.getParameter("userid");
       // String state=request.getParameter("state");
        
        //read the userid and state from session
        //fetch the session
        HttpSession session = request.getSession();
        //read userid and state 
        String userid =(String)session.getAttribute("userid");
        String state=(String)session.getAttribute("state");
        
        int total=Integer.parseInt(request.getParameter("total"));
        int active=Integer.parseInt(request.getParameter("active"));
        int deaths=Integer.parseInt(request.getParameter("deaths"));
//        java.util.Date dt=new java.util.Date();
//        long val=dt.getTime();
//        Date idate=new Date(val);
        //request process (Store the values to Database)
        //now we will store the values into db using JDBC.
        try{
            
//            pt.setDate(1,idate );
            pt.setString(1, state);
            pt.setInt(2, total);
            pt.setInt(3,active);
            pt.setInt(4, deaths);
            pt.setString(5,userid);
            pt.executeUpdate();
            
            
            //response
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Information-Submitted-Successfully</h3>");
            out.println("<h4><a href=stateadmindashboard.jsp>Dashboard</a></h4>");
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
