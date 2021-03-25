import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "Szczegoly",urlPatterns = {"/Szczegoly"})
public class Szczegoly extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        String ktory = request.getParameter("numerP");
        System.out.println(ktory);


        String id=null;
        String id11=null;
        String nazwa=null;
        String nazwaMain=null;
        String ktoto=null;
        String dataa=null;
        String odpwiedzz=null;
        String ktooo=null;
        String dattt=null;


        try {
            String url = "jdbc:mysql://localhost/Konta";
            Connection conn = DriverManager.getConnection(url,"root","");
            Statement stmt = conn.createStatement();
            ResultSet rs;


            rs = stmt.executeQuery("SELECT * FROM posty WHERE  id_post='"+ktory+"' ");
            while ( rs.next() ) { id11 = rs.getString("id_post");
            nazwaMain=rs.getString("Nazwa");
            ktoto=rs.getString("uzytkownik");
            dataa=rs.getString("data");

            }


                    out.println("<html>\n" +
                            "  <head>\n" +
                            "      <style>body {\n" +
                            "\n" +
                            "          font: 13px 'Lucida sans', Arial, Helvetica;\n" +
                            "          color: #eee;\n" +
                            "\n" +
                            "      }\n" +
                            "\n" +
                            "      a {\n" +
                            "          color: #ccc;\n" +
                            "      }\n" +
                            "\n" +
                            "\n" +
                            "      .cf:before, .cf:after{\n" +
                            "          content:\"\";\n" +
                            "          display:table;\n" +
                            "      }\n" +
                            "\n" +
                            "      .cf:after{\n" +
                            "          clear:both;\n" +
                            "      }\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "      .form-wrapper {\n" +
                            "          margin-top: 5%;\n" +
                            "          width: 100%;\n" +
                            "          background: #444;\n" +
                            "          background: rgba(0,0,0,.2);\n" +
                            "          -moz-border-radius: 10px;\n" +
                            "          -webkit-border-radius: 10px;\n" +
                            "          border-radius: 10px;\n" +
                            "          -moz-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);\n" +
                            "          -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);\n" +
                            "          box-shadow: 0 1px 1px rgba(0,0,0,.4) inset, 0 1px 0 rgba(255,255,255,.2);\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper input {\n" +
                            "\n" +
                            "          width: 80%;\n" +
                            "          padding: 10px 5px;\n" +
                            "          float: left;\n" +
                            "          font: bold 15px 'lucida sans', 'trebuchet MS', 'Tahoma';\n" +
                            "          border: 0;\n" +
                            "          background: #eee;\n" +
                            "          -moz-border-radius: 3px 0 0 3px;\n" +
                            "          -webkit-border-radius: 3px 0 0 3px;\n" +
                            "          border-radius: 3px 0 0 3px;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper input:focus {\n" +
                            "          outline: 0;\n" +
                            "          background: #fff;\n" +
                            "          -moz-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;\n" +
                            "          -webkit-box-shadow: 0 0 2px rgba(0,0,0,.8) inset;\n" +
                            "          box-shadow: 0 0 2px rgba(0,0,0,.8) inset;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper input::-webkit-input-placeholder {\n" +
                            "          color: #999;\n" +
                            "          font-weight: normal;\n" +
                            "          font-style: italic;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper input:-moz-placeholder {\n" +
                            "          color: #999;\n" +
                            "          font-weight: normal;\n" +
                            "          font-style: italic;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper input:-ms-input-placeholder {\n" +
                            "          color: #999;\n" +
                            "          font-weight: normal;\n" +
                            "          font-style: italic;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button {\n" +
                            "          overflow: visible;\n" +
                            "          position: relative;\n" +
                            "          float: left;\n" +
                            "          border: 0;\n" +
                            "          padding: 0;\n" +
                            "          cursor: pointer;\n" +
                            "          height: 40px;\n" +
                            "          width: 20%;\n" +
                            "          font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';\n" +
                            "          color: #fff;\n" +
                            "          text-transform: uppercase;\n" +
                            "          background: #d83c3c;\n" +
                            "          -moz-border-radius: 0 3px 3px 0;\n" +
                            "          -webkit-border-radius: 0 3px 3px 0;\n" +
                            "          border-radius: 0 3px 3px 0;\n" +
                            "          text-shadow: 0 -1px 0 rgba(0, 0 ,0, .3);\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button:hover{\n" +
                            "          background: #e54040;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button:active,\n" +
                            "      .form-wrapper button:focus{\n" +
                            "          background: #c42f2f;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button:before {\n" +
                            "          content: '';\n" +
                            "          position: absolute;\n" +
                            "          border-width: 8px 8px 8px 0;\n" +
                            "          border-style: solid solid solid none;\n" +
                            "          border-color: transparent #d83c3c transparent;\n" +
                            "          top: 12px;\n" +
                            "          left: -6px;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button:hover:before{\n" +
                            "          border-right-color: #e54040;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button:focus:before{\n" +
                            "          border-right-color: #c42f2f;\n" +
                            "      }\n" +
                            "\n" +
                            "      .form-wrapper button::-moz-focus-inner {\n" +
                            "          border: 0;\n" +
                            "          padding: 0;\n" +
                            "      }\n" +
                            "      .byline p{\n" +
                            "          color:white;\n" +
                            "          font: bold 18px Arial, Helvetica, Sans-serif;\n" +
                            "          text-shadow: 0 2px 3px rgba(0,0,0,0.1);\n" +
                            "      }\n" +
                            "\n" +
                            "      .byline p a{\n" +
                            "          color:#d83c3c;\n" +
                            "          text-decoration:none;\n" +
                            "      }\n" +
                            "\n" +
                            "      </style>\n" +
                            "    <title>Zadanie5</title>\n" +
                            "  </head>\n" +
                            "  <body style=\"background: linear-gradient(to right, rgb(93, 65, 87), rgb(168, 202, 186));\">\n" +
                            "\n" +
                            "  <div  style=\"height: 100%; background: linear-gradient(to right, rgb(93, 65, 87), rgb(168, 202, 186));overflow: auto;\" >\n" +
                            "<div   style=\"float: left;width: 20%;height: 100%; border-radius: 25px; position: absolute\">\n" +
                            "\n" +
                            "\n");


                    rs = stmt.executeQuery(" select *from posty order by id_post desc limit 3");
                   while ( rs.next() ) {
                       nazwa = rs.getString("Nazwa");
                       id = rs.getString("id_post");
                        out.println("   <div class=\"byline\"  style=\"width: 100%;height: 15%; text-align: center;margin-top: 60%;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));border-radius: 25px\"><p>"+nazwa+"</p> <form action=\"Szczegoly.do\"method=\"post\"> <input type=\"hidden\" value="+id+" id=\"numerP\" name=\"numerP\">  <input style=\"width: 70%;height: 40%;border-radius: 15px;background: white; font: bold 18px Arial, Helvetica, Sans-serif\" type=\"submit\" value=\"Zobacz więcej\"></form></div>");
                   }


                          out.println(" <div class=\"byline\" style=\"width: 100%;height: 15%; border-radius: 25px;text-align: center;margin-top: 25%;\"><form action=\"index.jsp\"> <input style=\"width: 70%;height: 40%;border-radius: 15px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\"   type=\"submit\" value=\"Strona główna\"></form></div>" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "    <div style=\"float: right;width: 79%\">\n" +
                            "      <div  style=\"height: 25%;border-radius: 25px;\">\n" +
                            "        <img style=\"float: left\" src=\"img/logo1.png\">\n" +
                            "\n" +
                            "        <div style=\"float:left;border-radius: 25px;height: 100%;width: 25%;background: darkgray;\"><p  style=\"width: 50%;text-align: center; margin:auto;padding: 70px 0; \"><font size=\"4\">W naszym serwisie znajdziesz :");




                    out.println(": problemow </font></p></div>");
                    out.println("\n" +
                            "        <div style=\"float:left;border-radius: 25px;height: 100%;width: 25%;;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));\"><p  style=\"width: 50%;text-align: center; margin: auto;padding: 70px 0; \"><font size=\"4\">Nasz spolecznosc udzielila : ");




                    out.println(" odpowiedzi</font> </p></div>\n" +
                            "        <div style=\"float:right;border-radius:25px;margin-right:6%;margin-top:2%;width: 20%\">\n");

                    out.println("<ul style=\" list-style-type: none;\">");

                    String uzytkownik = (String)  session.getAttribute("zalogowany");
                    if(uzytkownik==null) {
                        out.print("            <li><form action=\"rejestracja.jsp\">   <div style=\"width: 100%; border-radius: 25px;text-align: center;margin-top: 2%;\"><input style=\"width: 100%;height: 20%; font: bold 18px Arial, Helvetica, Sans-serif;border-radius: 25px;background: white;\"  type=\"submit\" value=\"REJESTRUJ\"></div></form></li>\n" +
                                "            <li><form action=\"logowanie.jsp\">     <div style=\" width: 100%; border-radius: 25px;text-align: center;margin-top: 30%;\"> <input  style=\"width: 100%;height: 20%;border-radius: 25px; font: bold 18px Arial, Helvetica, Sans-serif;background: white;\" type=\"submit\" value=\"ZALOGUJ\"></div></form></li>"); }
                    else { out.print("            <li> <div style=\"width: 100%;text-align: center;margin-top: 2%;\"><p><strong>Witaj : "+uzytkownik+" </strong></p></div></li>\n" +
                                "            <li><form action=\"DodajPost.jsp\"method=\"post\">     <div style=\" width: 100%;border-radius: 25px;text-align: center;margin-top: 10%;\"> <input  style=\"width: 100%;height: 20%; border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"DODAJ POST\"></div></form></li>"
                            + "            <li><form action=\"Wyloguj.do\"method=\"post\">     <div style=\" width: 100%; border: border-radius: 25px;text-align: center;margin-top: 30%;\"> <input  style=\"width: 100%;height: 20%;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"WYLOGUJ SIĘ\"></div></form></li>"); }




                  out.println("  </ul>\n" + "        </div>\n" + "      </div>\n" + "\n" + "\n" + "    " +
                          "  <div> <form class=\"form-wrapper cf\" action=\"wyszukiwarka.jsp\" >\n" + "          <input type=\"text\" placeholder=\"Wyszukaj tutaj...\" required>\n" +
                          "          <button type=\"submit\">Szukaj</button>\n" + "      </form>\n" + "\n" + "       </div>");
                    out.println("  <div class=\"byline\" style = \" float: left;background: linear-gradient(to right, rgb(194, 21, 0), rgb(255, 197, 0));margin-top:10px;width: 99%;height: 20%;padding: 10px 0;border-radius: 25px; \" ><p style=\"margin-left:50\">Nazwa postu : " + nazwaMain + "</p >" + "<p style=\"margin-left:50%;\">Data dodania :"+dataa+" </p><p style=\"margin-left:50%;\">Utworzony przez :"+ktoto+" </p> ");


                    String logged = (String) session.getAttribute("zalogowany");

                    if(logged==null) { }
                    else {out.println("<form action=\"DodajODP.jsp\"method=\"post\"> <input type=\"hidden\" value="+id11+" id=\"numerP\" name=\"numerP\">  <input  style=\"width: 40%;height: 30%;margin-left:5%;margin-bottom:10%;border-radius: 25px;background: white; font: bold 18px Arial, Helvetica, Sans-serif;\" type=\"submit\" value=\"DODAJ ODPOWIEDZ\"></form>"); }

                            out.println("</div>\"");




            rs = stmt.executeQuery("SELECT * FROM odpowiedzi WHERE  id_postu='"+id11+"' ");
            while ( rs.next() ) {
                odpwiedzz=rs.getString("odpowiedz");
                ktooo=rs.getString("uzytkownik");
                dattt=rs.getString("data");
                out.println("  <div class=\"byline\" style = \" float: left;background: darkgray;margin-top:10px;width: 99%;height: 20%;padding: 10px 0;border-radius: 25px; \" ><p style=\"margin-left:50\">Napisal :" + ktooo + " , Data dodania :  "+dattt+" </p ><p style=\"margin-left:10%;\">Odpowiedz :"+odpwiedzz+" </p></div> ");


            }
            conn.close();

        } catch (Exception e) { System.err.println("Got an exception! "); System.err.println(e.getMessage()); }





                    out.println("  </div>\n" +
                            "  </body>\n" +
                            "</html>");


                }




    }



