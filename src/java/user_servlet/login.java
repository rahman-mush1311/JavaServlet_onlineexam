package user_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Al Ahad, Al-Farabi and Mushfika Login class is created, so that users
 * or examinee can take part in the exam. Here our database 'Netbeans' is
 * connected. User data is checked, data fields of user_name and password is
 * passed and compared with the database. Form is also validated and message is
 * sent using request.setAttribute. They are fetched using request.getParameter
 * method. If all is validated user is taken to home page. For Admin user_name
 * and password match, user is taken to the welcome page.
 * request.getRequestDispatcher method is used to go to these pages.
 */
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("servet process");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            // processRequest(request, response);
            PrintWriter out = response.getWriter();
            //connectin is created.
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans", "root", "");
//admin login
            if ((uname.equals("root")) && (password.equals("14"))) {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
                view.forward(request, response);
            }
            //preparing for user login
            String sql = "select user_name and password from user where user_name =? and password=? ";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, uname);
            psm.setString(2, password);
            ResultSet rs = psm.executeQuery();
//if user exsists redirects to homepage.
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                session.setAttribute("message", "1");
                //response.sendRedirect("home.jsp");
                RequestDispatcher view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
//otherwise sends to login page
            } else {
                String message = "username and password doesn't match";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}