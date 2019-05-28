<%-- 
    Document   : welcome
    Created on : Apr 6, 2019, 1:16:13 PM
    Author     : Mushfika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="engine1/style.css" />
        <script type="text/javascript" src="engine1/jquery.js"></script>
        <title>Admin Page</title>
        <style>
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
    <body >
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

        welcome ${username}
        welcome ${message}



        <form action ="welcome" method ="get">
            <button name="action" value="login"></button>
            <!-- <input type="button" name="action" value = "register"> -->
            <input class="btn btn-success" type="submit" name ="action"value = "register"> 


        </form>
    </body>
</html>
