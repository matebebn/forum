<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 12.12.2019
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Zarejestruj się</title>
</head>
<body>
<div align="center" >
    <form action="logowanie.jsp" method="post">
        <input  style=" background-image: linear-gradient(to bottom right, red, yellow); width: 20%;margin-right: 100%" type="submit" value="Zaloguj się">

    </form>
    <form action="index.jsp" method="post">
        <input  style=" background-image: linear-gradient(to bottom right, red, yellow); width: 20%;margin-right: 100%" type="submit" value="Powrót do strony głównej">
    </form>
    <img src="img/logo1.png">
    <div style="height: 100%;overflow: auto;">

        <form action="Rejestracja.do" method="post">
        <label for="nazwa">Twoja nazwa</label>
            <input type="text" pattern="[a-zA-Z0-9]+" id_uzyt="nazwa" name="nazwa" required placeholder="Wpisz nazwe, będzie ona widoczna przy zakładaniu postów...">

            <label for="haslo">Hasło</label>
            <input type="text" pattern="[a-zA-Z0-9]+" id_uzyt="haslo" name="haslo" required placeholder="Wprowadz swoje hasło...">
            <input style=" background-image: linear-gradient(to bottom right, red, yellow);" type="submit" value="Zarejestruj się">
        </form>
    </div>


</form>
</div>
</body>
</html>
