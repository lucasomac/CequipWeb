//package control;
//
//import java.io.*;
//import java.sql.*;
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
//public class Logar_Old extends HttpServlet {
//
//    private ServletConfig config;
//
//    @Override
//    public void init(ServletConfig config)
//            throws ServletException {
//        this.config = config;
//    }
//
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        PrintWriter out = response.getWriter();
//        String connectionURL = "jdbc:mysql://localhost:3306/patrimonio?user=root&password=1234";
//        Connection connection = null;
//        ResultSet rs;
//        String login = new String("");
//        String senha = new String("");
//        response.setContentType("text/html");
//        try {
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver");
//            // Get a Connection to the database
//            connection = DriverManager.getConnection(connectionURL, "root", "1234");
//            //Add the data into the database
//            String sql = "select login,senha from users";
//            Statement s = connection.createStatement();
//            s.executeQuery(sql);
//            rs = s.getResultSet();
//            while (rs.next()) {
//                login = rs.getString("login");
//                senha = rs.getString("senha");
//            }
//            rs.close();
//            s.close();
//        } catch (Exception e) {
//            System.out.println("Exception is ;" + e);
//        }
//        if (login.equals(request.getParameter("login"))
//                && senha.equals(request.getParameter("senha"))) {
////            out.println("Olá " + login);
//            response.sendRedirect("index.jsp");
//        } else {
//            out.println("Por favor entre com usuario ou senha correto.");
//            out.println("<button type=\"button\" name=\"Salvar\" id=\"novamente\" class=\"btn btn-success\"><a href='login.jsp'><br>TENTAR NOVAMENTE</a></button>");
//        }
//    }
//}
