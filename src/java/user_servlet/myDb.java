package user_servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Al Ahad, Al-Farabi and Mushfika
 * An instance is created of the database 'Netbeans'
 * This helps the other classes to connect to the database using the object of this class.
 */
public class myDb {

    
    
        /**
         *@throws  ClassNotFoundException if connection class is not found
         * @throws  SQLException if error found is sql query
         */
    Connection conn;
    public Connection getCon(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(myDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

}
