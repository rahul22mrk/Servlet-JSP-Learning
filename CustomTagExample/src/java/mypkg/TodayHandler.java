
package mypkg;

import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TodayHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Date dt =new Date();
            String date= dt.toString();
            out.print("<h3>"+date+"</h3>");
            
        } catch (Exception ex) {
            throw new JspException("Error in TodayHandler tag", ex);
        }
    }
    
}
