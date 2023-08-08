<% 
    session.setMaxInactiveInterval(150);
 
    String sid = session.getId();
    out.println("Your Session id : "+sid+"<br>");
    int interval = session.getMaxInactiveInterval();
    out.println("Your Session will expire if you remain idle for "+interval +" seconds <br>");
    long val = session.getCreationTime();
    java.util.Date dt= new java.util.Date(val);
    out.println("Your Session was created: "+dt);
        //read session object 
        String uid= (String) session.getAttribute("userid");
       if(uid==null){
       response.sendRedirect("index.jsp");
    }
%>
<html>
    <body>
        <h1>User-Dashboard</h1>
        <pre>
        <a href="ActiveCaseServlet">active-cases</a>
        <a href="RecoveredCaseServlet">recovered-cases</a>
        <a href="TotalDeathCaseServlet">total-death-cases</a>
        <a href="DestroySession">Logout</a>
        </pre>
    </body>
</html>
