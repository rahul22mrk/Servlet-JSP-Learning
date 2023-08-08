
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllDataServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //this servelt show the data of that state whose admin is current logged-in
       //from where the name of the state come? (read from session)
      PrintWriter out= response.getWriter();
//       HttpSession session =request.getSession();
//       String state=(String)session.getAttribute("state");
       //fetching the data from database
       String query="select * from covidinfo";
       try{
            ServletContext context = getServletContext();
           Connection con = (Connection) context.getAttribute("dbcon");
           PreparedStatement ps= con.prepareStatement(query);
           ResultSet rs= ps.executeQuery();
             out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h3>Data for AllState :</h3>");
             out.println("<table border=2>");
             out.println("<tr>");
              out.println("<th>S.No</th><th>IDate</th><th>State</th><th>Total</th><th>Active</th><th>Deaths</th>");
             out.println("</tr>");
             int sumTotalCases=0;
             int sumActiveCases=0;
             int sumDeaths=0;
             while(rs.next()){
                 String sno = rs.getString("sno");
                 String date= rs.getString("idate");
                 String state= rs.getString("state");
                 int total=rs.getInt("total");
                 int active = rs.getInt("active");
                 int deaths= rs.getInt("deaths");
                 sumTotalCases+=total;
                 sumActiveCases+=active;
                 sumDeaths+=deaths;
                  out.println("<tr>");
                   out.println("<td>"+sno+"</td>");
                    out.println("<td>"+ date+"</td>");
                      out.println("<td>"+ state+"</td>"); 
                    out.println("<td>"+total+"</td>");
                    out.println("<td>"+active+"</td>");
                    out.println("<td>"+deaths+"</td>");
                   out.println("</tr>");
             }
             out.println("<tr>");
             out.println("<td></td><td></td><td></td>");
             out.println("<td>"+ sumTotalCases+"</td>");
              out.println("<td>"+sumActiveCases+"</td>");
               out.println("<td>"+  sumDeaths+"</td>");
             out.println("</tr>");
             out.println("</table>");
             
            out.println("<hr>");
              out.println("<a href=stateadmindashboard.jsp>Dashboard</a>");
            out.println("</body>");
            out.println("</html>");
       }catch(Exception e){
           out.println(e);
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
