
<html>
    <body>
        <h3>User-Entry-Form</h3>
        <hr>
        <form action="SaveUser" method="post" enctype="multipart/form-data">
             <pre>
                UserName    <input type="text" name="username"/>
                Email       <input type="text" name="email"/>
                Mobile      <input type="text" name="mobile"/>
                Address     <input type="text" name="address"/>
                Photo       <input type="file" name="photo"/>
                            <input type="submit" name="Save"/>
            </pre>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
