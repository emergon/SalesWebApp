package dao;

import entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDao extends SuperDao implements InterfaceDao<Product> {

    private static final String FINDALL = "SELECT * FROM product ORDER BY pdescr";
    private static final String FINDBYID = "SELECT * FROM product WHERE pcode = ?";
    private static final String INSERTPRODUCT = "INSERT INTO product (pdescr, pprice) VALUES (?, ?)";
    private static final String UPDATEPRODUCT = "UPDATE product SET pdescr = ?, pprice = ? WHERE pcode = ?";
    private static final String DELETEPRODUCT = "DELETE FROM product WHERE pcode = ?";
    @Override
    public boolean create(Product p) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
             pst = getConnection().prepareStatement(INSERTPRODUCT);
             pst.setString(1, p.getDescription());
             pst.setDouble(2, p.getPrice());
             int result = pst.executeUpdate();
             if(result>0){
                 created = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(FINDALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();
            while (rs.next()) {
                int pcode = rs.getInt(1);
                String descr = rs.getString("pdescr");
//                if(descr.equals("desk")){  //Delete the row from the DB
//                    rs.deleteRow();
//                    continue;
//                }
                double price = rs.getDouble(3);
                Product p = new Product(pcode, descr, price);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, st);
        }
        return list;
    }

    @Override
    public Product findById(int id) {
        Product p = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(FINDBYID);
            st.setInt(1, id);
            rs = st.executeQuery();
            rs.next();
            int pcode = rs.getInt(1);
            String descr = rs.getString(2);
            double price = rs.getDouble(3);
            p = new Product(pcode, descr, price);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, st);
        }
        return p;
    }

    @Override
    public boolean update(Product p) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
             pst = getConnection().prepareStatement(UPDATEPRODUCT);
             pst.setString(1, p.getDescription());
             pst.setDouble(2, p.getPrice());
             pst.setInt(3, p.getPcode());
             int result = pst.executeUpdate();
             if(result>0){
                 updated = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return updated;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
             pst = getConnection().prepareStatement(DELETEPRODUCT);
             pst.setInt(1, id);
             int result = pst.executeUpdate();
             if(result>0){
                 deleted = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return deleted;
    }

}
