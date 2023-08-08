<html>
    <script language="JavaScript">
        function validation(){
           let v1= checkAge();
            let v2=checkName();
            return v1&&v2;
        }
        function checkAge(){
            let age = document.getElementById("t2").value;
            if(isNaN(age)==true){
                alert("age should be numeric");
                return false;
            }else{
                return true;
            }
        }
        function checkName(){
            let username = document.getElementById("t1").value;
           // alert(username);
            if( username.length<1){
                //document.getElementsByName("submit").
                alert("username can't be empty");
                return false;
            }else{
                return true;
            }
        }
        
    </script>
    <body>
        <h3>Entry-Form</h3>
        <hr> 
        <form action="ProcessData" onsubmit="return validation()">
            <pre>
                Username    :   <input type="text" id="t1" name="t1"/>
                Age         :   <input type="text" id="t2" name="t2"/>
                                <input type="submit" id="submitBtn" value="Submit"/>
                
            </pre>
        </form>
        <hr>
        <a href="input.jsp">Sever-Validation</a>
    </body>
</html>
