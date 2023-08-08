<%@page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet,mypkg.Utility" %>
<%@ page contentType = "text/html" errorPage="myerrorpage.jsp" %>

<%!
    public double deathPercentage(int death,int total){
    double res = (double)death*100/total;
    return res;
    }
 %>
 
<% 
    String sql = "select * from covidinfo";
    Connection con = Utility.connect();
    PreparedStatement pt = con.prepareStatement(sql);
    ResultSet rs= pt.executeQuery();
%>
<html>
    <body>
        <h2>Covid-Data</h2>
        <hr> 
        <table border="2">
            <tr>
              <th>Sno</th><th>Date</th><th>State</th><th>Total</th><th>Active</th><th>Deaths</th><th>Death%</th>
            </tr>
            <% 
                while(rs.next()){
                    String s1= rs.getString(1);
                    String s2= rs.getString(2);
                    String s3 = rs.getString(3);
                    int s4 = rs.getInt(4);//total
                    String s5 =rs.getString(5);
                   int s6 = rs.getInt(6);//deaths
                   double percentage = deathPercentage(s6,s4);
            %>
            <tr>
                <td> <%= s1 %></td>
                <td> <%= s2 %></td>
                <td> <%= s3 %></td>
                <td> <%= s4 %></td>
                <td> <%= s5 %></td>
                <td> <%= s6 %></td>
                <td> <%= percentage %></td>
            </tr>
            
            <%
                }
            %>
            
        </table>
        <hr>
        <a href="userdashboard.jsp">Home</a>
    </body>
</html>
<% con.close(); %>