
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class SaveUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
      String username = "", mobile = "" ,email = "", address = "";
      //for stroing image 
      byte image[]=null;
      
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      try{
         List<FileItem> items= upload.parseRequest(new ServletRequestContext(request));
         for(int i = 0 ;i<items.size();i++){
             FileItem item = items.get(i);
             String name = item.getFieldName();
             switch (name) {
                 case "username":
                     username = item.getString();
                     break;
                 case "mobile":
                     mobile = item.getString();
                     break;
                 case "email":
                     email = item.getString();
                     break;
                 case "address":
                     address = item.getString();
                     break;
                 case "photo":
                     image = item.get();
                     break;
                 default:
                     break;
             }
         }
            try (Connection con = mypkg.Utility.connect()) {
                String sql = "insert into user_info values (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, mobile);
                ps.setString(4, address);
                ps.setBytes(5, image);
                ps.executeUpdate();
                
                 out.println("<html>");
                out.println("<body>");
                  out.println("<hr>");
                   out.println("<h3>Data Saved Successfully!</h3>");
                    out.println("<hr>"); 
                    out.println("<a href=index.jsp>Home</a>");
                    out.println("<a href=entry.jsp>Add-More-User</a>");
                    out.println("</body>");
                     out.println("</html>");
                    
                    
              
            }
      }catch(UncheckedIOException | SQLException | FileUploadException e){
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
