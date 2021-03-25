import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Wyloguj",urlPatterns = {"/Wyloguj"})
public class Wyloguj extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out=response.getWriter();



        HttpSession session=request.getSession();
        session.invalidate();

        out.print("<html><head>\n" +
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
                "    <title>Rejestracja</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div align=\"center\" >\n" +
                "    <img src=\"img/logo1.png\">\n" +
                "    <div>\n" +
                "            <h2>Wylogowales sie pomyslnie</h2>\n" +
                "        <form action=\"logowanie.jsp\" method=\"post\">\n" +
                "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Zaloguj sie\">\n" +
                "\n" +
                "        </form>\n" +
                "        <form action=\"index.jsp\" method=\"post\">\n" +
                "\n" +
                "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Wróc do strony glównej\">\n" +
                "        </form>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }


}
