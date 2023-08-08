<% 
   // public int x=10;
    String state = request.getParameter("t1");
    String contacts = "";
    
    switch(state){
       case "mp" :
            contacts="234334";
            break;
       case "mh" :
           contacts ="342321";
           break;
       case "rj":
           contacts = "435643";
           break;
       default:
           contacts = "123456"; 
           break;
    }
%>
<html>
    <body>
        <h3>Helpline Number For Your State : <% out.println(state); %> </h3>
        <hr>
        Number :  <% out.println(contacts); %>
         <hr>
         <a href="index.jsp">Home</a>
    </body>
</html>
