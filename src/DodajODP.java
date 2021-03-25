import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DodajODP",urlPatterns = {"/DodajODP"})
public class DodajODP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList al = new ArrayList();

        String numerP = request.getParameter("numerposta");
        String opisPostu = request.getParameter("text");
        String nazwaUzyt ="";
        HttpSession session=request.getSession();

        System.out.println(numerP);
        if(session!=null)
        {
            nazwaUzyt=(String) session.getAttribute("zalogowany");
        }

        if (numerP == null ) {
            al.add("Niepoprawne numer !");
        }

        if (opisPostu == null ) {
            al.add("Niepoprawna odpowiedz !");
        }


        if (al.isEmpty() == true) {

            try {
                String dataa=new Date().toString();
                int nr1=Integer.parseInt(numerP);
                String url = "jdbc:mysql://localhost/Konta";
                Connection conn = DriverManager.getConnection(url,"root","");



                Statement stmt = conn.createStatement();
                String insert = "INSERT INTO odpowiedzi (id_postu, odpowiedz, data, uzytkownik) VALUES (?,?,?,?)";

                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setInt(1, nr1);     //valid foreign key
                pst.setString(2, opisPostu);
                pst.setString(3, dataa);
                pst.setString(4, nazwaUzyt);

                pst.execute();




                forwardRequest(request, response, "index.jsp");

            } catch (Exception e) { System.err.println("Got an exception! "); System.err.println(e.getMessage()); }
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
                    "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Dodaj odpowiedz\">\n" +
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
