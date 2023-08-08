<% 
 java.util.Enumeration<String> e= session.getAttributeNames();
 while(e.hasMoreElements()){
        String name= e.nextElement();
        //String value =(String) session.getAttribute(name);
        out.println(name+"<=> "+session.getAttribute(name)+"<br>");
    }
%>