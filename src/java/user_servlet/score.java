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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Al Ahad, Al-Farabi and Mushfika
 * Here our database 'Netbeans' is connected.
 * All the data from math_questions are taken and saved to ResultSet's object and on the jsp page to set in table form.
 * request.getSession().setAttribute() method is used to send the ResultSet.
 * If none button is selected, the result is checked and score is updated.
 * request.getSession().setAttribute() is used to show the used updated result.
 * If logout button is selected, HttpSession sets user_name to null and sent to login page.
 * request.getRequestDispatcher method is used to go to these pages.  
 */


public class score extends HttpServlet {

    
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        try {
            String math_ans = "";
            String answ = "";
            String msg = request.getSession().getAttribute("number").toString();
            String score = request.getSession().getAttribute("score").toString();
            int m_id = Integer.parseInt(msg);
            int current_score = Integer.parseInt(score);
            String ans = request.getParameter("button");
            // String score = request.getSession().getAttribute("score").toString();
            
            //bbutton is clicked checks for correct answer.
            if ("none".equals(ans)) {
                //  request.getSession().setAttribute("message", "Your ans is correct");
                //connection is created
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans", "root", "");
                String sql = "select * from math_question where math_id = ' " + m_id + " ' ";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    answ = rs.getString("math_ans");
                }
                math_ans = request.getParameter("ans");
                String message = "";
                //sets score for correct ans
                if (math_ans.equals(answ)) {
                    message = "Your ans is correct";
                    current_score+=10;
                }
                else{
                     message = "Your ans isnot correct";
                }
                m_id++;
                request.getSession().setAttribute("number", String.valueOf(m_id));
                request.getSession().setAttribute("score", String.valueOf(current_score));
                request.getSession().setAttribute("message", message);
                //loads three questions and finishes test
                if (m_id >= 3) {
                    request.getSession().setAttribute("message", "test finished");
                    request.getSession().setAttribute("score_id", String.valueOf(current_score));
                    request.getRequestDispatcher("scoring.jsp").forward(request, response);
                }
                //sends object of question through resultset in jsp page.
                String SQL = "select * from math_question where math_id = ' " + m_id + " ' ";
                rs = st.executeQuery(SQL);

                while (rs.next()) {
                    int math_id = rs.getInt("math_id");
                    String filename = rs.getString("math_image");
                    String opA = rs.getString("math_optionsA");
                    String opB = rs.getString("math_optionsB");
                    String opC = rs.getString("math_optionsC");
                    String opD = rs.getString("math_optionsD");

                    request.getSession().setAttribute("filename", filename);
                    request.setAttribute("opA", opA);
                    request.setAttribute("opB", opB);
                    request.setAttribute("opC", opC);
                    request.setAttribute("opD", opD);

                }

                RequestDispatcher view = request.getRequestDispatcher("score.jsp");
                view.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(score.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(score.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
