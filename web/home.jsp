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
            .slider-holder
            {
                width: 800px;
                height: 400px;
                background-color: yellow;
                margin-left: auto;
                margin-right: auto;
                margin-top: 0px;
                text-align: center;
                overflow: hidden;
            }

            .image-holder
            {
                width: 2400px;
                background-color: red;
                height: 400px;
                clear: both;
                position: relative;

                -webkit-transition: left 2s;
                -moz-transition: left 2s;
                -o-transition: left 2s;
                transition: left 2s;
            }

            .slider-image
            {
                float: left;
                margin: 0px;
                padding: 0px;
                position: relative;
            }

            #slider-image-1:target ~ .image-holder
            {
                left: 0px;
            }

            #slider-image-2:target ~ .image-holder
            {
                left: -800px;
            }

            #slider-image-3:target ~ .image-holder
            {
                left: -1600px;
            }

            .button-holder
            {
                position: relative;
                top: -20px;
            }

            .slider-change
            {
                display: inline-block;
                height: 10px;
                width: 10px;
                border-radius: 5px;
                background-color: brown;
            }
        </style>
    </head>
    <body action="home">
        <%
            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <div class="topnav">
            <form action="home" method="get">
                <a  href="#"><input class="btn btn-success" type="submit" name ="action"value = "Home"></a>
                <a href=""> <input class="btn btn-success" type="submit" name ="action"value = "Take Test"></a>
                <a href="#"> <input class="btn btn-success" type="submit" value = "Your Result"></a>
            </form>
            <div class="search-container">
                <form action="home" method="post">

                    <a href="#">Hi ${username}</a>
                    <a href="#"><input class="btn btn-success" type="submit" name ="action"value = "Logout"></a>
                    <button type="submit" name="action" value="direct"></button> 
                </form>              
            </div>          
        </div>
        <div class="slider-holder">
            <span id="slider-image-1"></span>
            <span id="slider-image-2"></span>
            <span id="slider-image-3"></span>
            <div class="image-holder">
                <img src="images/slider1.jpg" alt="logo" width="800" height="400">      
                <img src="images/slider.jpg" class="slider-image" width="800" height="400"/>
                <img src="images/slider.jpg" class="slider-image" width="800" height="400" />
            </div>
            <div class="button-holder">
                <a href="#slider-image-1" class="slider-change"></a>
                <a href="#slider-image-2" class="slider-change"></a>
                <a href="#slider-image-3" class="slider-change"></a>
            </div>
        </div>
        <div>
            <center>
                <table> 
                    <tr>
                    <center> WELCOME </center></br>
                   
                    </tr>
                </table>
            </center>          
        </div>

        <div>
            <center>

                <table> 
                    <tr>
                        ${score_id}
                    </tr>

                </table>
            </center>
        </div>


    </body>
</html>