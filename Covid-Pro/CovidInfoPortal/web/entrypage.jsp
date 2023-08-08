<%
    String uid =(String)session.getAttribute("userid");
    if(uid==null){
    response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry Page</title>
    </head>
    <body>
        <h3>Submit-Info-For-Today</h3>
        <form action="SaveInfo">
            <pre>
             TotalCases     <input type="text" name="total"/>
             ActiveCases    <input type="text" name="active"/>
             TotalDeaths    <input type="text" name="deaths"/>
                            <input type="submit" name="submit"/>
            </pre>
        </form>
        <hr> 
        <a href="stateadmindashboard.jsp">Dashboard</a>
    </body>
</html>
