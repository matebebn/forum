<%@ page import="java.io.BufferedReader" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<%@ page import="java.io.FileReader" %><%--
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

        div {
            border-radius: 5px;
            background-color: #999999;
            padding: 20px;
        }
        h1{
            background-color :green;
            color:white;
            font-size: 40px;
        }

        .byline{
            font-size: 24px;
        }
    </style>
    <title>Moje odpowiedzi:</title>
</head>
<body>
<div id_uzyt="srodek" align="center" style="height: 100%;overflow: auto;" >
    <% String nazwa= (String) session.getAttribute("zalogowany");  %>
    <sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost/konta" user="root" type="" />
    <sql:query dataSource="${con}" var="odpowiedzi">
        select *from odpowiedzi where uzytkownik='<%out.print(nazwa);%>';
    </sql:query>
    <center><h1>Odpowiedzi :</h1></center>
    <c:forEach var="row" items="${odpowiedzi.rows}">

        <div class="byline" style = " float: left;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));margin-top:10px;width: 99%;height: 30%;padding: 10px 0;border-radius: 25px; " ><p style="margin-left:50px">Odpowiedz : ${row.odpowiedz}</p >
            <p style="margin-left:50px">Data : ${row.data}, uzytkownik : ${row.uzytkownik}</p></div>

        <center><h2><a href="index.jsp">Wróć na stronę główną</a></h2></center>
    </c:forEach>


</div>
</body>
</html>
