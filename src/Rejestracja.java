import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Rejestracja",urlPatterns = {"/Rejestracja"})
public class Rejestracja extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList al = new ArrayList();

        String nazwaUzytkownika = request.getParameter("nazwa");
        String hasloUzytkownika = request.getParameter("haslo");


        String pattern = "[a-zA-Z0-9]+";
        if (nazwaUzytkownika == null || !nazwaUzytkownika.matches(pattern)) {
            al.add("Niepoprawne imie !");
        }

        if (hasloUzytkownika == null || !hasloUzytkownika.matches(pattern)) {
            al.add("Niepoprawne nazwisko !");
        }


        if (al.isEmpty() == true) {
            try {
                String dataa=new Date().toString();

                String url = "jdbc:mysql://localhost/Konta";
                Connection conn = DriverManager.getConnection(url,"root","");

                Statement stmt = conn.createStatement();
                String insert = "INSERT INTO dane (Nazwa, Haslo) VALUES (?,?)";

                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setString(1, nazwaUzytkownika);
                pst.setString(2, hasloUzytkownika);

                pst.execute();




                forwardRequest(request, response, "index.jsp");

            } catch (Exception e) { System.err.println("Got an exception! "); System.err.println(e.getMessage()); }
        }
        else
            {
                out.println("Nie udalo sie zarejestrowac ! Wypełnij formularz poprawnie !");
                out.println("<html>\n" +
                        "<head>\n" +
                        "    <style>\n" +
                        "        input[type=text], select {\n" +
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
                        "    <title>Zarejestruj się</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div align=\"center\" >\n" +
                        "    <img src=\"img/logo1.png\">\n" +
                        "    <div>\n" +
                        "        <form action=\"Rejestracja.do\" method=\"post\">\n" +
                        "        <label for=\"nazwa\">Twoja nazwa</label>\n" +
                        "            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"nazwa\" name=\"nazwa\" placeholder=\"Wpisz nazwe, będzie ona widoczna przy zakładaniu postów...\">\n" +
                        "\n" +
                        "            <label for=\"haslo\">Hasło</label>\n" +
                        "            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"haslo\" name=\"haslo\" placeholder=\"Wprowadz swoje hasło...\">\n" +
                        "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Zarejestruj się\">\n" +
                        "        </form>\n" +
                        "    </div>\n" +
                        "\n" +
                        "\n" +
                        "</form>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
            }








    }


    protected void forwardRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }

}
