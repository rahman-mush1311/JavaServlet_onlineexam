<%-- 
    Document   : login
    Created on : Apr 6, 2019, 7:43:22 AM
    Author     : Mushfika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Here</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel='stylesheet'>
        <style>
            td{
                padding: 15px;
            }
            div{
                width: 51%;
                border: 1px solid black;
                border-radius: 5px;
                background-color: lightcoral;
            }
        </style>
    </head>
    <body>
    <center> <h1>Login Here!</h1></center>
    <center>  <p> ${message}</p></center>
    <center>
        <div>
            <form action="login" method="post">
                <table>
                    <tr>
                        <td> User Name: </td>
                        <td> <input type="text"class='form-control' name = "username" placeholder="User name"> </td>
                    </tr>                   
                    <tr>
                        <td> Password: </td>
                        <td> <input type="password"class='form-control' name = "password" placeholder="Password"> </td>
                    </tr>
                    <tr>
                        <td colspan="2" style ='text-align: center'> <input class="btn btn-success" type="submit" value = "submit"> </td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>
