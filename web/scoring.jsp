<%-- 
    Document   : home
    Created on : Apr 7, 2019, 12:57:17 AM
    Author     : Mushfika
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel='stylesheet'>
        <title>Home Page</title>
        <style>
            *{box-sizing: border-box;}

            /* Style the navbar */
            .topnav {
                overflow: hidden;
                background-color: #e9e9e9;
            }

            /* Navbar links */
            .topnav a {
                float: left;
                display: block;
                color: black;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            /* Navbar links on mouse-over */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Active/current link */
            .topnav a.active {
                background-color: #2196F3;
                color: white;
            }

            /* Style the input container */
            .topnav .search-container {
                float: right;
            }

            /* Style the input field inside the navbar */
            .topnav input[type=text] {
                padding: 6px;
                margin-top: 8px;
                font-size: 17px;
                border: none;
            }

            /* Style the button inside the input container */
            .topnav .search-container button {
                float: right;
                padding: 6px;
                margin-top: 8px;
                margin-right: 16px;
                background: #ddd;
                font-size: 17px;
                border: none;
                cursor: pointer;
            }

            .topnav .search-container button:hover {
                background: #ccc;
            }

            /* Add responsiveness - On small screens, display the navbar vertically instead of horizontally */
            @media screen and (max-width: 600px) {
                .topnav .search-container {
                    float: none;
                }
                .topnav a, .topnav input[type=text], .topnav .search-container button {
                    float: none;
                    display: block;
                    text-align: left;
                    width: 100%;
                    margin: 0;
                    padding: 14px;
                }
                .topnav input[type=text] {
                    border: 1px solid #ccc; 
                }
            }
        </style>
    </head>
    <body action="scoring">
         <%
       /*     if(session.getAttribute("username")==null)
            {
                response.sendRedirect("login.jsp");
            }*/
         %>
         
        <div class="topnav">
            <form action="scoring" method="get">
            <a  href="home.jsp"><input class="btn btn-success" type="submit" name ="action"value = "Home"></a>
            <a href="score.jsp"> <input class="btn btn-success" type="submit" name ="action"value = "Take Test"></a>
            <a href="#"> <input class="btn btn-success" type="submit" value = "Your Result"></a>
            </form>
            <div class="search-container">
                <form action="scoring" method="post">
                    
                     <a href="#">hi ${username}</a>
                     <a href="login"><input class="btn btn-success" type="submit" name ="action"value = "Logout"></a>
                  
                </form>              
            </div>          
        </div>
   
         <div>
        <center>
      <table> 
                    <tr>
                    <center> ${message} </center></br></br>
                    Your Scorer is: ${score_id}</br>
                    </tr>
       </table>
        </center>          
         </div>
            
      <div>
        <center>
      
            <table> 
                <tr>
                
                </tr>

            </table>
    </center>
      </div>
           
                     
    </body>
</html>
