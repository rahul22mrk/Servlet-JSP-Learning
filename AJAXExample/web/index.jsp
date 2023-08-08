<html>
    <script>
        var request;
        function one(){
            request = new XMLHttpRequest();
            request.onreadystatechange = two;
            request.open("get","Timer",true);
            request.send(null);
        }
        
        function two(){
            if(request.status == 200 && request.readyState ==4){
                document.getElementById("data").innerHTML =request.responseText ;
            }
        }
    </script>
    <body>
        <h3>Ajax-Example</h3>
        <hr>
        <a href="Timer">Current-Time</a>
        <hr>
         <input type="button" value="getTime" onClick="one()"/><hr>
         <div id="data">Place-To-Show-Time</div><hr>
    </body>
</html>
