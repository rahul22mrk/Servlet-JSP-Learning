<%
    String uid =(String)session.getAttribute("userid");
    if(uid==null){
    response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>state-admin-dashboard</title>
    </head>
    <body>
        <h1>State-Admin-Dashboard</h1>
        <hr> 
        <pre>
            <a href="entrypage.jsp">Add-Info-For-Today</a>
            <a href="">Update-Info</a>
            <a href="StateDataServlet">View-Info-For-Own-State</a>
            <a href="AllDataServlet">View-Info-For-All-State</a>
            <a href="EndSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>
