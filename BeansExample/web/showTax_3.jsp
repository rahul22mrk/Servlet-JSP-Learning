<%-- we will map our request parameters to bean properties directly (no need to read them) --%>
<%-- Instantiating the bean --%>
<jsp:useBean id="bean" class="mypkg.TaxBean" />

<%-- Set the income,age --%>
<jsp:setProperty name="bean" property="age" param="t2"/>
<jsp:setProperty name="bean" property="income" param="t1"/>

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
