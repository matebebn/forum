<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>

<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 12.12.2019
  Time: 17:49
  To change this template us
  e File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
  <head>

      <style>
          @import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

          fieldset, label { margin: 0; padding: 0; }
          /****** Style Star Rating Widget *****/

          .rating {
              border: none;
              float: left;
          }

          .rating > input { display: none; }
          .rating > label:before {
              margin: 5px;
              font-size: 1.25em;
              font-family: FontAwesome;
              display: inline-block;
              content: "\f005";
          }

          .rating > .half:before {
              content: "\f089";
              position: absolute;
          }

          .rating > label {
              color: #ddd;
              float: right;
          }

          /***** CSS Magic to Highlight Stars on Hover *****/

          .rating > input:checked ~ label, /* show gold star when clicked */
          .rating:not(:checked) > label:hover, /* hover current star */
          .rating:not(:checked) > label:hover ~ label { color: #FFD700;  } /* hover previous stars in list */

          .rating > input:checked + label:hover, /* hover current star when changing rating */
          .rating > input:checked ~ label:hover,
          .rating > label:hover ~ input:checked ~ label, /* lighten current selection */
          .rating > input:checked ~ label:hover ~ label { color: #FFED85;  }

          body {

          font: 13px 'Lucida sans', Arial, Helvetica;
          color: #eee;

      }

      a {
          color: #ccc;
      }


      .cf:before, .cf:after{
          content:"";
          display:table;
      }

      .cf:after{
          clear:both;
      }



      .form-wrapper {
          margin-top: 5%;
          width: 100%;
          background: #444;
          background: rgba(0,0,0,.2);
          -moz-border-radius: 10px;
          -webkit-border-radius: 10px;
          border-radius: 10px;
          -moz-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
          -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
          box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);
      }

      .form-wrapper input {

          width: 80%;
          padding: 10px 5px;
          float: left;
          font: bold 15px 'lucida sans', 'trebuchet MS', 'Tahoma';
          border: 0;
          background: #eee;
          -moz-border-radius: 3px 0 0 3px;
          -webkit-border-radius: 3px 0 0 3px;
          border-radius: 3px 0 0 3px;
      }

      .form-wrapper input:focus {
          outline: 0;
          background: #fff;
          -moz-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
          -webkit-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
          box-shadow: 0 0 2px rgba(0,0,0,.8) inset;
      }

      .form-wrapper input::-webkit-input-placeholder {
          color: #999;
          font-weight: normal;
          font-style: italic;
      }

      .form-wrapper input:-moz-placeholder {
          color: #999;
          font-weight: normal;
          font-style: italic;
      }

      .form-wrapper input:-ms-input-placeholder {
          color: #999;
          font-weight: normal;
          font-style: italic;
      }

      .form-wrapper button {
          overflow: visible;
          position: relative;
          float: left;
          border: 0;
          padding: 0;
          cursor: pointer;
          height: 40px;
          width: 20%;
          font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';
          color: #fff;
          text-transform: uppercase;
          background: #d83c3c;
          -moz-border-radius: 0 3px 3px 0;
          -webkit-border-radius: 0 3px 3px 0;
          border-radius: 0 3px 3px 0;
          text-shadow: 0 -1px 0 rgba(0, 0 ,0, .3);
      }

      .form-wrapper button:hover{
          background: #e54040;
      }

      .form-wrapper button:active,
      .form-wrapper button:focus{
          background: #c42f2f;
      }

      .form-wrapper button:before {
          content: '';
          position: absolute;
          border-width: 8px 8px 8px 0;
          border-style: solid solid solid none;
          border-color: transparent #d83c3c transparent;
          top: 12px;
          left: -6px;
      }

      .form-wrapper button:hover:before{
          border-right-color: #e54040;
      }

      .form-wrapper button:focus:before{
          border-right-color: #c42f2f;
      }

      .form-wrapper button::-moz-focus-inner {
          border: 0;
          padding: 0;
      }
      .byline p{
          color:white;
          font: bold 18px Arial, Helvetica, Sans-serif;
          text-shadow: 0 2px 3px rgba(0,0,0,0.1);
      }

      .byline p a{
          color:#d83c3c;
          text-decoration:none;
      }

      </style>
    <title>Zadanie5</title>
  </head>
  <body style="background: linear-gradient(to right, rgb(93, 65, 87), rgb(168, 202, 186));">


  <div  style="height: 100%; background: linear-gradient(to right, rgb(93, 65, 87), rgb(168, 202, 186));" >
<div   style="float: left;width: 20%;height: 100%; border-radius: 25px; position: absolute">
    <sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost/konta" user="root"  />
    <sql:query dataSource="${con}" var="posty">
        select *from posty order by id_post desc limit 3;
    </sql:query>

        <c:forEach var="row" items="${posty.rows}">

            <div class="byline"  style="width: 100%;height: 15%; text-align: center;margin-top: 60%;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));border-radius: 25px"><p> ${row.Nazwa}</p> <form action="Szczegoly.do"method="post"> <input type="hidden" value=${row.id_post} id_uzyt="numerP" name="numerP">  <input style="width: 70%;height: 40%;border-radius: 15px;background: white; font: bold 18px Arial, Helvetica, Sans-serif" type="submit" value="Zobacz więcej"></form></div>


        </c:forEach>






    <div class="byline" style="width: 100%;height: 15%; border-radius: 25px;text-align: center;margin-top: 25%;"><form action="index.jsp"> <input style="width: 70%;height: 40%;border-radius: 15px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;"   type="submit" value="Strona główna"></form></div>

</div>


    <div style="float: right;width: 79%">
      <div  style="height: 25%;border-radius: 25px;">
        <img style="float: left" src="img/logo1.png">

        <div style="float:left;border-radius: 25px;height: 100%;width: 25%;background: darkgray;"><p  style="width: 50%;text-align: center; margin:auto;padding: 70px 0; "><font size="4">W naszym serwisie znajdziesz :
            <%
                int liczba=0;
                int liczodp=0;
                //WYKRYWANIE PRZEGLADARKI

                HttpServletRequest req= (HttpServletRequest) request;
                String userAgent=req.getHeader("user-agent");
                System.out.println("Wykryta przegladarka: " + userAgent);
                //String browserName = "";
                //String  browserVer = "";
                if(userAgent.contains("Chrome")){
                    out.println("<body style='background-color:blue;'>");
                }
                else if(userAgent.contains("Firefox")){
                    out.println("<body style='background-color:orange;'>");
                }

            %>



            <sql:query dataSource="${con}" var="posty">
                select *from posty;
            </sql:query>

            <c:forEach var="row" items="${posty.rows}">
                <%

                    liczba++;
                %>

            </c:forEach>
            <%  out.println(String.valueOf(liczba));   %>  problemow </font></p></div>

          <sql:query dataSource="${con}" var="posty">
              select *from odpowiedzi;
          </sql:query>

          <c:forEach var="row" items="${posty.rows}">
              <%

                  liczodp++;
              %>

          </c:forEach>

        <div style="float:left;border-radius: 25px;height: 100%;width: 25%;;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));"><p  style="width: 50%;text-align: center; margin: auto;padding: 70px 0; "><font size="4">Nasz spolecznosc udzielila :    <%out.println(String.valueOf(liczodp));
        %>odpowiedzi</font> </p></div>


        <div style="float:right;border-radius:25px;margin-right:6%;margin-top:2%;width: 20%">


        <ul style=" list-style-type: none;">
            <% String uzytkownik = (String) session.getAttribute("zalogowany");

                if(uzytkownik==null) {
                    out.print("            <li><form action=\"rejestracja.jsp\">   <div style=\"width: 100%; border-radius: 25px;text-align: center;margin-top: 2%;\"><input style=\"width: 100%;height: 20%; font: bold 18px Arial, Helvetica, Sans-serif;border-radius: 25px;background: white;\"  type=\"submit\" value=\"REJESTRUJ\"></div></form></li>\n" +
                            "            <li><form action=\"logowanie.jsp\">     <div style=\" width: 100%; border-radius: 25px;text-align: center;margin-top: 30%;\"> <input  style=\"width: 100%;height: 20%;border-radius: 25px; font: bold 18px Arial, Helvetica, Sans-serif;background: white;\" type=\"submit\" value=\"ZALOGUJ\"></div></form></li>");
                }
                else
                {
                    out.print("            <li> <div style=\"width: 100%;text-align: center;margin-top: 2%;\"><p><strong>Witaj : "+uzytkownik+" </strong></p></div></li>\n" +
                                    "            <li><form action=\"DodajPost.jsp\"method=\"post\">     <div style=\" width: 100%;border-radius: 25px;text-align: center;margin-top: 10%;\"> <input  style=\"width: 100%;height: 20%; border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"DODAJ POST\"></div></form></li>"
                            +
                            "            <li><form action=\"Wyloguj.do\"method=\"post\">     <div style=\" width: 100%; border: border-radius: 25px;text-align: center;margin-top: 30%;\"> <input  style=\"width: 100%;height: 20%;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"WYLOGUJ SIĘ\"></div></form></li>");
                }

                int stanodpo=0;
            %>



        </ul>
        </div>
      </div>


      <div> <form class="form-wrapper cf" action="wyszukiwarka.jsp" >
          <input type="text" id_uzyt="szukane" name="szukane" placeholder="Wyszukaj tutaj..." required>
          <button type="submit">Szukaj</button>
      </form>


          <% String uzytkownik1 = (String) session.getAttribute("zalogowany");
              ResultSet resultSet = null;
              PreparedStatement preparedStatement = null;
              String query="";
              try {
                  query = "Select * from dane where Nazwa='"+uzytkownik1+"'";
                  String url = "jdbc:mysql://localhost/konta";
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conn = DriverManager.getConnection(url,"root","");
                  preparedStatement = conn.prepareStatement(query);
                  resultSet = preparedStatement.executeQuery();

                  while (resultSet.next()){
                      if(resultSet.getString("komunikat")!=null){ %>
          <b><%out.println("<center><h2>Komunikat : <br>"+resultSet.getString("komunikat")+"</h2></center>"); %></b><br><% }
          }
              Statement stmt = conn.createStatement();
              ((Statement) stmt).execute("UPDATE dane SET komunikat='' WHERE  Nazwa='"+uzytkownik1+"'");
              conn.close();
          } catch (Exception e) {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
          } %>


       </div>
        <sql:query dataSource="${con}" var="posty">
            select *from posty;
        </sql:query>

        <c:forEach var="row" items="${posty.rows}">




            <div class="byline" style =" float: left;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));margin-top:10px;width: 99%;height: 30%;padding: 10px 0;border-radius: 25px; " ><p style="margin-left:50px">Nazwa postu :${row.Nazwa} </p >
                <form action="Szczegoly.do"method="post"> <input type="hidden"  id_uzyt="numerP" name="numerP" value=${row.id_post} >
                <sql:query dataSource="${con}" var="odpowiedzi">
                    select *from odpowiedzi where id_postu="${row.id_post}";
                </sql:query>

                <c:forEach var="row" items="${odpowiedzi.rows}">
                    <%
                        stanodpo++;
                    %>
                </c:forEach>

                <p style="margin-left:50px">${row.data} </p><p style="margin-left:50px">Liczba udzielonych odpowiedzi : <%out.println(String.valueOf(stanodpo));%> </p>
                 <input  style="width: 40%;margin-left:50%;height: 20%;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;" type="submit" value="Zobacz więcej"></form></div>


            <% stanodpo=0; %>
        </c:forEach>





        <%
            if(uzytkownik!=null) {out.println("<div class=\"byline\" style =\" float: left;background: darkgray;margin-top:10px;width: 99%;height: 100px;padding: 50px 0;border-radius: 25px;\" >\n" +
                    "            <form action=\"konto.jsp\"method=\"post\"> <input  style=\"float:left;width: 30%;margin-top:13px;height: 50px;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"Moje konto\"/></form>\n" +
                    "            <form action=\"mojepytania.jsp\"method=\"post\">  <input  style=\"float:left;width: 30%;margin-left:5%;height: 50px;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"Moje pytania \"/></form>\n" +
                    "            <form action=\"mojeodpowiedzi.jsp\"method=\"post\"> <input  style=\"float:left;width: 30%;margin-left:5%;height: 50px;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"Moje odpowiedzi\"/></form>");

            if(uzytkownik.equals("admin")){out.print("  <center><form action=\"panelAdmin.jsp\"method=\"post\"> <input  style=\"float:left;width: 100%;margin-top:15px;height: 50px;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"Panel ADMIN\"/></form>\"</center>");}}

            out.print("</div>");
        %>



    </div>


  </div>
  </body>


</html>
