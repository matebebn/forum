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
    <title>Znalezione posty:</title>
</head>
<body>
<% String wyszukiwanyTytul = request.getParameter("szukane"); %>
<sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/konta" user="root" type="" />
<sql:query dataSource="${con}" var="posty">
    select *from posty where Nazwa='<%out.print(wyszukiwanyTytul);%>';
</sql:query>
<center> <h1> Wynik :</h1><br/></center>
<c:forEach var="row" items="${posty.rows}">

<div id_uzyt="srodek" align="center" style="height: 100%;overflow: auto;" >
    <div class="byline" style = " float: left;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));margin-top:10px;width: 99%;height: 30%;padding: 10px 0;border-radius: 25px; " ><p style="margin-left:50px">${row.Nazwa} </p >
        <p style="margin-left:50px">${row.data}</p>
        <form action="Szczegoly.do"method="post"> <input  id_uzyt="numerP" name="numerP" type="hidden" value=${row.id_post}>  <input  style="width: 40%;margin-left:50%;height: 20%;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;" type="submit" value="Zobacz więcej"></form></div>

</c:forEach>
<c:choose>
    <c:when test="${posty.rowCount == 0}">
        <center> <h1>Nic nie znaleziono!</h1><br/><h2><a href="index.jsp">Wróć na stronę główną</a></h2></center>
    </c:when>
</c:choose>







</div>
</body>
</html>
