
package mypkg;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mypkg.Utility;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class TotalCaseHandler extends SimpleTagSupport {

   
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            String sql = "select * from covidinfo";
            Connection con= Utility.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            int totalCases = 0;
            while(rs.next()){
                totalCases   =totalCases +rs.getInt("total");
                
            }
            out.print("<h4>Total Covid Cases : </h4>"+  totalCases);
            
        } catch (Exception ex) {
            throw new JspException("Error in TotalCaseHandler tag", ex);
        }
    }
    
}
