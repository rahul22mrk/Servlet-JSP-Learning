<html>
    <body>
        <h3>Entry-Form</h3>
        <hr> 
        <form action="DataProcessing">
            <pre>
                Username    :   <input type="text" id="t1" name="t1"/><%= request.getAttribute("nameErr")%>
                Age         :   <input type="text" id="t2" name="t2"/><%= request.getAttribute("ageErr")%>
                                <input type="submit" id="submitBtn" value="Submit"/>
                
            </pre>
        </form>
        <hr>
         <a href="index.jsp">client-Validation</a>
    </body>
</html>
