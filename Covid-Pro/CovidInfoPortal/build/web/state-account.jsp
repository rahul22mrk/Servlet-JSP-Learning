<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>State-Account</title>
    </head>
     <body>
        <h1>State-Account-Creation-Form</h1>
        <hr>
        <form action="StateAccountCreationServlet" method="post">
            <table>
                <tr>
                    <td>Userid</td>  
                    <td><input type="text" name="uid"/></td>
                </tr>
                
                <tr>
                    <td> Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                  <tr>
                    <td>State</td>
                    <td><select name="state" >
                            <option>AP</option>
                            <option>JH</option>
                            <option>MP</option>
                            <option>RJ</option>
                            <option>UP</option>
                        </select></td>
                </tr>
                 
                <tr>
                    <td><input type="submit"value="Create-Account"/></td>
                    <td><input type="submit"value="Reset"/></td>
                </tr>
                           
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
