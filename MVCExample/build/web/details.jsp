<jsp:useBean id="info" class="mypkg.Medicine" scope="session"/>
<html>
    <body>
        <h3>Medicine Details</h3>
        <hr> 
        <pre>
            Code    <jsp:getProperty name="info" property="code"/>
            Name    <jsp:getProperty name="info" property="name"/>   
            Type    <jsp:getProperty name="info" property="type"/>
            Price   <jsp:getProperty name="info" property="price"/>
        </pre>
        <hr>
        <a href="search.jsp">Search-More</a>
        <a href="index.jsp">Home</a>
    </body>
</html>
