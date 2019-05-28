<%-- 
    Document   : register
    Created on : Apr 7, 2019, 3:09:53 AM
    Author     : Mushfika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Here</title>
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
    <center> <h1>Register Here!</h1></center>
    <center>  <p> ${message}</p></center>
    <center>
        <div>
            <form action="register" method="post">
                <table>
                    <tr>
                        <td> User Name: </td>
                        <td> <input type="text"class='form-control' name = "username" placeholder="User name"> </td>
                    </tr>
                    <tr>
                        <td> Email: </td>
                        <td> <input type="text" class='form-control' name = "email" placeholder="Email"> </td>
                    </tr>
                    <tr>
                        <td> Password: </td>
                        <td> <input type="password"class='form-control' name = "password" placeholder="Password"> </td>
                    </tr>
                    <tr>
                        <td> Re-Enter Password: </td>
                        <td> <input type="password" class="form-control" name = "repassword" placeholder="Re Enter Password"> </td>
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
