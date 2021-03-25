<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 12.12.2019
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<html>
<head>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <title>Rejestracja</title>
</head>
<body>
<div align="center" >
    <img src="img/logo1.png">
    <div>
            <h2>Rejestracja przebiegla pomyslnie</h2>
        <form action="logowanie.jsp" method="post">
            <input style=" background-image: linear-gradient(to bottom right, red, yellow);" type="submit" value="Zaloguj się">

        </form>
        <form action="index.jsp" method="post">

            <input style=" background-image: linear-gradient(to bottom right, red, yellow);" type="submit" value="Wróc do strony głównej">
        </form>
    </div>


    </form>
</div>
</body>
</html>
