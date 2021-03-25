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
    <title>Usun/Zmien:</title>
</head>
<body>
<%
    String usunODP=null;
        usunODP=request.getParameter("numerPpp");
    String usuwany=null;
    usuwany=request.getParameter("numerP");
    String zmien=null;
    zmien=request.getParameter("numerPp");
    String zmieniony=null;
    String opiss=null;
    opiss=request.getParameter("text");
    zmieniony=request.getParameter("numerposta");


%>
<sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/konta" user="root" type="" />

<sql:query dataSource="${con}" var="posty">
    select *from posty where id_post='<%out.print(usuwany);%>';
</sql:query>
<c:forEach var="row" items="${posty.rows}">
    <sql:update dataSource="${con}" var="odpowiedzi">
        DELETE FROM odpowiedzi
        WHERE id_postu=${row.id_post};
    </sql:update>
</c:forEach>

<sql:update dataSource="${con}" var="posty">
    DELETE FROM posty
    WHERE id_post='<%out.print(usuwany);%>';
</sql:update>

<sql:update dataSource="${con}" var="odpowiedzi">
    DELETE FROM odpowiedzi
    WHERE id_postu='<%out.print(usunODP);%>';
</sql:update>
<div id_uzyt="srodek" align="center" style="height: 100%;overflow: auto;" >

    <c:set var = "empId" scope="session"  value="${param.text}"/>


    <c:if test = "${empId !=null}">

        <sql:update dataSource="${con}" var="odpowiedzi">
            UPDATE odpowiedzi SET odpowiedz = ?
            WHERE id_odpo='<%out.print(zmieniony);%>';

            <sql:param value="${empId}"/>
        </sql:update>
    </c:if>




    <sql:query dataSource="${con}" var="odpowiedzi">
        select *from odpowiedzi where id_postu='<%out.print(zmien);%>';
    </sql:query>
    <c:forEach var="row" items="${odpowiedzi.rows}">

    </c:forEach>




    <%

        if(!(zmien ==null))
        {
            out.print("<div align=\"center\" >\n" +
                    "    <img src=\"img/logo1.png\">\n" +
                    "    <div style=\"height: 100%;overflow: auto;\">\n" +
                    "        <form action=\"Usun.jsp\" method=\"post\">\n" +
                    "            <input type=\"hidden\" value="+zmien+" id_uzyt=\"numerposta\" name=\"numerposta\"/>\n" +
    " <label for=\"text\">Odpowiedz :</label>\n" +
    " <textarea id_uzyt=\"text\" name=\"text\"  required placeholder=\"Podaj nowa odpowiedz...\"></textarea>\n" +
    " <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Zmien\">\n" +
    "        </form>\n" +
    " </div>\n" +
"\n" +
"\n" +
" \n" +
"</div>");
        }

        if(zmieniony==null)
        {
            out.print("  <center> <h1>Usuwanie zakonczone pomyslnie!</h1><br/><h2><a href=\"index.jsp\">Wróć na stronę główną</a></h2></center>");
        }
        if(!(zmieniony ==null))
        {
            out.print("  <center> <h1>Zaaktualizowano  pomyslnie!</h1><br/><h2><a href=\"index.jsp\">Wróć na stronę główną</a></h2></center>");
        }
    %>


</div>
</body>
</html>
