<%-- we will communicate with bean using tags --%>
<% 
    int income = Integer.parseInt(request.getParameter("t1"));
    int age = Integer.parseInt(request.getParameter("t2"));
     
%>
<%-- Instantiating the bean --%>
<jsp:useBean id="bean" class="mypkg.TaxBean" />

<%-- Set the income,age --%>
<jsp:setProperty name="bean" property="age" value="<%=age%>"/>
<jsp:setProperty name="bean" property="income" value="<%=income%>"/>

<html>
    <body>
        <h3>Tax Details Using Tags</h3>
        <hr>
        <pre>
            Income : <jsp:getProperty name="bean" property="income" /><%-- print the income --%>
            Age    : <jsp:getProperty name="bean" property="age"/><%-- print the age --%>
            Tax    : <jsp:getProperty name="bean" property="tax"/><%-- print the tax --%>
        </pre>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
