/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Al Ahad, Al-Farabi and Mushfika
 * Register class is created, so that new users or examinee can be added to the database.
 * Here our database 'Netbeans' is connected.
 * New user data is created, data fields of user_name, email and password is passed and inserted to the database.
 * Before inserting it checks whether there is previous user with the same user_name and email. 
 * Form is also validated and message is sent using request.setAttribute.
 * They are fetched using request.getParameter method.
 * request.getRequestDispatcher method is used to go to the home page is register is successful. 
 */
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("servlet working for process");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // processRequest(request, response);
            //gets fields for checking 
            
            int u_id = 1;
            String uname = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            PrintWriter out = response.getWriter();
            
            //validation starts checks for empty fields.
            
            if (uname.equals("") || email.equals("") || password.equals("") || repassword.equals("")) {
                String message = " fields cannot be empty";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/register.jsp").forward(request, response);

            }
            // checks if the passwords matches
            if (!password.equals(repassword)) {
                String message = " passwords don't match";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
            //database connection is created.
            
            Connection conn = null;
            /* myDb db = new myDb();
             conn = db.getCon();*/
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans", "root", "");
            //preparing for excecuting query
            Statement st = conn.createStatement();
            String sql = "select user_name from user where user_name =?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, uname);
            ResultSet rs = psm.executeQuery();
            //if result set returns something it won't insert to datbase
           if(rs.next()){
            //  out.println("username already exsists");
              String message = "username already exsists";
              request.setAttribute("message", message);
              request.getRequestDispatcher("/register.jsp").forward(request, response);
           }
           //inserting to database.
           else{
            String query = "select * from user";
            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery(query);
            while(rSet.next()){
                u_id = rSet.getInt(1);
            }
            u_id++;
            String SQL = "insert into user (user_id,user_name,email,password) values(' "+u_id+" ' ,' "+uname+" ',' "+email+" ',' "+password+" ')";
            stmt.executeUpdate(SQL);
            //forwarding to the homepage.
             HttpSession session = request.getSession();
             session.setAttribute("username", uname);
             response.sendRedirect("home.jsp");
              
           }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
