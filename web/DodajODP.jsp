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
        input[type=text], select,textarea {
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
    <title>Dodaj odpowiedz</title>
</head>
<body>
<div align="center" >
    <img src="img/logo1.png">
    <div style="height: 100%;overflow: auto;">
        <form action="DodajODP.do" method="post">
            <input type="hidden" value="<%=request.getParameter("numerP")%>" id_uzyt="numerposta" name="numerposta"/>
            <label for="text">Odpowiedz :</label>
            <textarea   id_uzyt="text" name="text" required placeholder="Wprowadz informacje dot. postu..."></textarea>
            <input style=" background-image: linear-gradient(to bottom right, red, yellow);" type="submit" value="Dodaj odpowiedz">
        </form>
    </div>



</div>
</body>
</html>
