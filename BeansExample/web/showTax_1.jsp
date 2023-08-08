<% 
    int income = Integer.parseInt(request.getParameter("t1"));
    int age = Integer.parseInt(request.getParameter("t2"));
     int tax;
     //we dont need to write business logic in here (if it already exist with bean)
     //for tax we need to set income/age
     mypkg.TaxBean bean =new mypkg.TaxBean();
     bean.setAge(age);
     bean.setIncome(income);
   
%>
<html>
    <body>
        <h3>Tax Details</h3>
        <hr>
        <pre>
            Income : <%= bean.getIncome() %> 
            Age    : <%= bean.getAge() %> 
            Tax    : <%= bean.getTax() %>
        </pre>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
