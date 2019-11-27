package dao;

import entities.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDao extends SuperDao implements InterfaceDao<Customer>{
    
    private static final String FINDALL = "select ccode, cname from customer";
    private static final String FINDCUSTOMERBYID = "SELECT * FROM customer WHERE ccode = ?";
    private static final String INSERTCUSTOMER = "INSERT INTO customer (cname) VALUES (?)";
    private static final String DELETECUSTOMER = "DELETE FROM customer WHERE ccode = ?";
    private static final String UPDATECUSTOMER = "UPDATE customer SET cname = ? WHERE ccode = ?";
        
    @Override
    public List<Customer> findAll(){
        Statement stmt = null;
        ResultSet rs = null;
        List<Customer> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int code = rs.getInt(1);
                String name = rs.getString(2);
                Customer c = new Customer(code, name);
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }
    
    @Override
    public Customer findById(int id){
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Customer c = null;
        try {
            pstm = getConnection().prepareStatement(FINDCUSTOMERBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String name = rs.getString(2);
            c = new Customer(code, name);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(rs, pstm);
        }
        return c;
    }
    
    @Override
    public boolean create(Customer c){
        PreparedStatement pst = null;
        boolean created = false;
        try {
             pst = getConnection().prepareStatement(INSERTCUSTOMER);
             pst.setString(1, c.getCname());
             int result = pst.executeUpdate();
             if(result>0){
                 created = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return created;
    }
    
    @Override
    public boolean delete(int id){
        
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
             pst = getConnection().prepareStatement(DELETECUSTOMER);
             pst.setInt(1, id);
             int result = pst.executeUpdate();
             if(result>0){
                 deleted = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return deleted;
    }
    
    @Override
    public boolean update(Customer c){
        
        PreparedStatement pst = null;
        boolean updated = false;
        try {
             pst = getConnection().prepareStatement(UPDATECUSTOMER);
             pst.setString(1, c.getCname());
             pst.setInt(2, c.getCcode());
             int result = pst.executeUpdate();
             if(result>0){
                 updated = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return updated;
    }

}



