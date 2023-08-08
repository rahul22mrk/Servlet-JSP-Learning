<%@page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet,mypkg.Utility" %>
<% 
    String uname= request.getParameter("username");
    String sql = "select username,email,mobile,address from user_info where username = ?";
    Connection con = Utility.connect();
    PreparedStatement pt = con.prepareStatement(sql);
    pt.setString(1, uname);
    ResultSet rs= pt.executeQuery();
    
%>
<html>
    <body>
        <h3>User-Details</h3>
        <hr>
         <% 
                while(rs.next()){
                    String username= rs.getString(1);
                    String email = rs.getString(2);
                    String mobile = rs.getString(3);
                    String address = rs.getString(4);
            %>
        <pre>
            Username :  <%= username %>
            Email    :  <%= email %>
            Mobile   :  <%= mobile %>
            Address  :  <%= address %>

            <image src="ImageLoader?name=<%=uname%>"/>
        </pre>
        <% 
            } 
        %>
        <hr>
        <a href="index.jsp">Home</a>
        <a href="search.jsp">Search-User</a>
        <a href="entry.jsp">Add-More-User</a>
    </body>
</html>
