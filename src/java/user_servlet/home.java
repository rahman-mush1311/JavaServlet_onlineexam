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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Al Ahad, Al-Farabi and Mushfika Home class is created so that users
 * or examinee can take part in the exam and see previous results. Here button
 * is used to fetch the parameters needed to go to the page requested. Here our
 * database 'Netbeans' is connected if take test button is selected. All the
 * data from math_questions are taken and saved to ResultSet's object and on the
 * score page. If logout button is selected, HttpSession sets user_name to null
 * and sent to login page. request.getRequestDispatcher method is used to go to
 * these pages.
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        //which button is selected
        String next_action = request.getParameter("action");
        Connection conn = null;

        //redirects to homepage along with object of math_questions.
        if ("Take Test".equals(next_action)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans", "root", "");
                Statement st = conn.createStatement();
                HttpSession session = request.getSession();
                //session.setAttribute("username", "");
                request.getSession().setAttribute("message", "Start Your Test");
                int m_id = 1;

                String sql = "select * from math_question where math_id = ' " + m_id + " ' ";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    int math_id = rs.getInt("math_id");
                    String filename = rs.getString("math_image");
                    String opA = rs.getString("math_optionsA");
                    String opB = rs.getString("math_optionsB");
                    String opC = rs.getString("math_optionsC");
                    String opD = rs.getString("math_optionsD");
                    String answ = rs.getString("math_ans");

                    request.getSession().setAttribute("filename", filename);
                    request.setAttribute("opA", opA);
                    request.setAttribute("opB", opB);
                    request.setAttribute("opC", opC);
                    request.setAttribute("opD", opD);

                }
                request.getSession().setAttribute("number", String.valueOf(m_id));
                request.getSession().setAttribute("score", "10");
                request.getRequestDispatcher("score.jsp").forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if ("Your Result".equals(next_action)) {
                request.getSession().setAttribute("score_id", "10");
                request.getRequestDispatcher("scoring.jsp").forward(request, response);
            }
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // processRequest(request, response);
            PrintWriter out = response.getWriter();

            String next_action = request.getParameter("action");

            if ("Logout".equals(next_action)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", "");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

        }
    }
