import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Logowanie",urlPatterns = {"/Logowanie"})
public class Logowanie extends HttpServlet {
    private FilterChain filterChain;


    @SuppressWarnings("Duplicates")


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList al = new ArrayList();

        String nazwaUzyt = request.getParameter("nazwa");
        String hasloUzyt = request.getParameter("haslo");


        String pattern = "[a-zA-Z0-9]+";
        if (nazwaUzyt == null || !nazwaUzyt.matches(pattern)) { al.add("Niepoprawne imie !"); }
        if (hasloUzyt == null || !hasloUzyt.matches(pattern)) { al.add("Niepoprawne nazwisko !"); }


        if (al.isEmpty() == true) {
            String id=null;
            String zmien=null;

            Boolean zmien_haslo=null;
            try {

                String url = "jdbc:mysql://localhost/Konta";
                Connection conn = DriverManager.getConnection(url,"root","");
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM dane WHERE Nazwa = '"+nazwaUzyt+"' and Haslo='"+hasloUzyt+"' ");
                while ( rs.next() ) { id = rs.getString("id_uzyt");
                    HttpSession session = request.getSession(true);
                    session.setAttribute("id",id);
                zmien=rs.getString("aktywne"); zmien_haslo=rs.getBoolean("zmien"); }
                conn.close();

            } catch (Exception e) { System.err.println("Got an exception! "); System.err.println(e.getMessage()); }

            if(!(id ==null) && (zmien.contains("Zablokuj")) && zmien_haslo==false)
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("zalogowany",nazwaUzyt);
                forwardRequest(request, response, "index.jsp");
            }
            if(zmien.contains("Odblokuj"))
            {
                forwardRequest(request, response, "blokada.jsp");
            }
            if(zmien_haslo==true &&  (zmien.contains("Zablokuj")))
            {   HttpSession session = request.getSession(true);
                session.setAttribute("zalogowany",nazwaUzyt);
                forwardRequest(request, response, "zmianahasla.jsp");
            }



          out.println(
                  "<html>\n" +
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
                  "    <title>Zaloguj się</title>\n" +
                  "</head>\n" +
                  "<body>\n" +
                  "<div align=\"center\" >\n" +
                  "    <img src=\"img/logo1.png\">\n" +
                  "    <div>\n<h2><strong>Nieudana próba zalogowania ! </strong></h2>" +
                  "        <form action=\"Logowanie.do\" method=\"post\">\n" +
                  "            <label for=\"nazwa\">Twoja nazwa</label>\n" +
                  "            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"nazwa\" name=\"nazwa\" required placeholder=\"Wpisz nazwe, będzie ona widoczna przy zakładaniu postów...\">\n" +
                  "\n" +
                  "            <label for=\"haslo\">Hasło</label>\n" +
                  "            <input type=\"text\" pattern=\"[a-zA-Z0-9]+\" id=\"haslo\" name=\"haslo\" required placeholder=\"Wprowadz swoje hasło...\">\n" +
                  "            <input style=\" background-image: linear-gradient(to bottom right, red, yellow);\" type=\"submit\" value=\"Zaloguj się\">\n" +
                  "        </form>\n" +
                  "    </div>\n" +
                  "\n" +
                  "\n" +
                  "    </form>\n" +
                  "</div>\n" +
                  "</body>\n" +
                  "</html>\n");
doFilter(request,response,filterChain);

        }

    }


    protected void forwardRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        HttpServletRequest req= (HttpServletRequest) request;
        String ip = req.getRemoteAddr();
        System.out.println("ip "+ ip+", czas "+ new Date().toString());
        try {
            File file = new File("C:\\Users\\Mateusz\\Desktop\\Java ZPJ\\Lista4 ZPJ\\Zad5\\web/log.txt");
            FileWriter fstream = new FileWriter(file, true);
            BufferedWriter out1 = new BufferedWriter(fstream);
            out1.newLine();
            out1.write("-------------------------");
            out1.newLine();
            out1.write("ip "+ ip+", czas "+ new Date().toString());
            out1.newLine();
            out1.write("-------------------------");
            out1.newLine();
            out1.close();
            fstream.close();
        } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
    }




}
