<%@ page import="java.sql.*" %><%--
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
    <title>Zmiana hasła</title>
</head>
<body>

<%  String uzytkownik1 = (String) session.getAttribute("id");
    String hasloUzyt = request.getParameter("noweH");

  if(hasloUzyt==null){
  out.println("<div align=\"center\" style=\"height: 100%;overflow: auto;\" >\n" +
"    <form action=\"index.jsp\" method=\"post\">\n" +
"        <input  style=\" background-image: linear-gradient(to bottom right, red, yellow); width: 20%;margin-right: 100%\" type=\"submit\" value=\"Powrót do strony głównej\">\n" +
"    </form>\n" +
"    <img src=\"img/logo1.png\">\n" +
"    <div>\n" +
"        <b style=\"color: darkred\"><font size=\"15\">ZMIEN HASLO,ABY SIE ZALOGOWAC</font></b>\n" +
"        <form action=\"zmianahasla.jsp\" method=\"post\">\n" +
"            <label for=\"noweH\">Nowe hasło</label>\n" +
"            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"noweH\" name=\"noweH\" required placeholder=\"Wprowadz swoje hasło...\">\n" +
"\n" +
"            <label for=\"haslo\">Powtórz hasło</label>\n" +
"            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"haslo\" name=\"haslo\" required placeholder=\"Powtorz swoje hasło...\">\n" +
"            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Potwierdz\">\n" +
"        </form>\n" +
"    </div>\n" +
"\n" +
"\n" +
"    </form>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
  }
   if(hasloUzyt!=null) {
       ResultSet resultSet = null;
       PreparedStatement preparedStatement = null;

       try {
           String url = "jdbc:mysql://localhost/konta";
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, "root", "");
           Statement stmt = conn.createStatement();
           stmt.executeUpdate("UPDATE dane SET `Haslo`='" + hasloUzyt + "' WHERE `id_uzyt`='" + uzytkownik1 + "'");
           stmt.executeUpdate("UPDATE dane SET `zmien`=0 WHERE `id_uzyt`='" + uzytkownik1 + "'");
           conn.close();
       } catch (Exception e) {
           System.err.println("Got an exception! ");
           System.err.println(e.getMessage());



       }
                  out.println("<center><h2><a>Hasło zmienione</a></h2></center>");

              out.println("<div align=\"center\" style=\"height: 100%;overflow: auto;\" >\n" +
"    <form action=\"index.jsp\" method=\"post\">\n" +
"        <input  style=\" background-image: linear-gradient(to bottom right, red, yellow); width: 20%;margin-right: 100%\" type=\"submit\" value=\"Powrót do strony głównej\">\n" +
"    </form>\n" +
"    <img src=\"img/logo1.png\">\n" +
"    <div>\n" +

"    </div>\n" +
"\n" +
"\n" +
"    </form>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
   }

%>




