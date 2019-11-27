package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuperDao{
    private final String URL = "jdbc:mysql://localhost:3306/sales?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "1234";
    private Connection conn;

    protected Connection getConnection(){
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    protected void closeConnections(ResultSet rs, Statement stmt){
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    
    protected void closeConnections(Statement st){
        try {
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}
