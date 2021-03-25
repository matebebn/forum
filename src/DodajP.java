import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DodajP",urlPatterns = {"/DodajP"})
public class DodajP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList al = new ArrayList();

        String nazwaPostu = request.getParameter("nazwa");
        String opisPostu = request.getParameter("text");
        String nazwaUzyt ="";
        HttpSession session=request.getSession();
        if(session!=null)
        {
          nazwaUzyt=(String) session.getAttribute("zalogowany");
        }


        if (nazwaPostu == null ) {
            al.add("Niepoprawne imie !");
        }

        if (opisPostu == null ) {
            al.add("Niepoprawne nazwisko !");
        }


        if (al.isEmpty() == true) {
            try {

                String dataa=new Date().toString();
                String url = "jdbc:mysql://localhost/Konta";
                Connection conn = DriverManager.getConnection(url,"root","");
                Statement stmt = conn.createStatement();
                String insert = "INSERT INTO posty  (Nazwa, data, uzytkownik) VALUES (?,?,?)";

                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setString(1, nazwaPostu);
                pst.setString(2, dataa);
                pst.setString(3, nazwaUzyt);

                pst.execute();

                out.println("<html>\n" +
                        "<head>\n" +
                        "    <style>\n" +
                        "        input[type=text], select,textarea {\n" +
                        "            width: 100%;\n" +
                        "            padding: 12px 20px;\n" +
                        "            margin: 8px 0;\n" +
                        "            display: inline-block;\n" +
                        "            border: 1px solid #ccc;\n" +
                        "            border-radius: 4px;\n" +
                        "            box-sizing: border-box;\n" +
                        "        }\n" +
                        "\n" +
                        "        input[type=submit] {\n" +
                        "            width: 100%;\n" +
                        "            background-color: #4CAF50;\n" +
                        "            color: white;\n" +
                        "            padding: 14px 20px;\n" +
                        "            margin: 8px 0;\n" +
                        "            border: none;\n" +
                        "            border-radius: 4px;\n" +
                        "            cursor: pointer;\n" +
                        "        }\n" +
                        "\n" +
                        "        input[type=submit]:hover {\n" +
                        "            background-color: #45a049;\n" +
                        "        }\n" +
                        "\n" +
                        "        div {\n" +
                        "            border-radius: 5px;\n" +
                        "            background-color: #f2f2f2;\n" +
                        "            padding: 20px;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "    <title>Dodaj post</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div align=\"center\" >\n" +
                        "    <img src=\"img/logo1.png\">\n" +
                        "    <div>\n<strong>Dodawanie postu zakonczone powodzeniem</strong>" +
                        "        <form action=\"DodajPost.jsp\" method=\"post\">\n" +
                        "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Dodaj kolejny post \">\n" +
                        "        </form>\n" +
                        "        <form action=\"index.jsp\" method=\"post\">\n" +
                        "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Powrót do strony głównej \">\n" +
                        "        </form>\n" +
                        "    </div>\n" +
                        "\n" +
                        "\n" +
                        "    </form>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");

            } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        }
        else
        {
            out.println("Nie udalo sie zamiesic postu ! Spróbuj jeszcze raz !");
            out.println("<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "        input[type=text], select,textarea {\n" +
                    "            width: 100%;\n" +
                    "            padding: 12px 20px;\n" +
                    "            margin: 8px 0;\n" +
                    "            display: inline-block;\n" +
                    "            border: 1px solid #ccc;\n" +
                    "            border-radius: 4px;\n" +
                    "            box-sizing: border-box;\n" +
                    "        }\n" +
                    "\n" +
                    "        input[type=submit] {\n" +
                    "            width: 100%;\n" +
                    "            background-color: #4CAF50;\n" +
                    "            color: white;\n" +
                    "            padding: 14px 20px;\n" +
                    "            margin: 8px 0;\n" +
                    "            border: none;\n" +
                    "            border-radius: 4px;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "\n" +
                    "        input[type=submit]:hover {\n" +
                    "            background-color: #45a049;\n" +
                    "        }\n" +
                    "\n" +
                    "        div {\n" +
                    "            border-radius: 5px;\n" +
                    "            background-color: #f2f2f2;\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "    <title>Dodaj post</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div align=\"center\" >\n" +
                    "    <img src=\"img/logo1.png\">\n" +
                    "    <div>\n" +
                    "        <form action=\"DodajP.do\" method=\"post\">\n" +
                    "            <label for=\"nazwa\">Nazwa postu :</label>\n" +
                    "            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"nazwa\" name=\"nazwa\" required placeholder=\"Wpisz nazwe, będzie ona widoczna przy zakładaniu postów...\">\n" +
                    "\n" +
                    "            <label for=\"text\">Opisz swoj post :</label>\n" +
                    "            <textarea   id=\"text\" name=\"text\" required placeholder=\"Wprowadz informacje dot. postu...\"></textarea>\n" +
                    "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Dodaj post\">\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "\n" +
                    "\n" +
                    "    </form>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");
        }


    }

    protected void forwardRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
