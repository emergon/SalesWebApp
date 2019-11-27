package dao;

import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.Salesman;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleDao extends SuperDao implements InterfaceDao<Sale>{
    
    private static final String FINDALL = "SELECT * FROM sales";
    
    @Override
    public boolean create(Sale e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sale> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Sale> list = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("scode");
                Salesman salesman = getSalesmanById(rs.getInt("smcode"));
                Customer customer = getCustomerById(rs.getInt("ccode"));
                Product product = getProductById(rs.getInt("pcode"));
                int quant = rs.getInt("quant");
                double cost = rs.getDouble("cost");
//                LocalDate sdate;
//                if(rs.getDate("sdate")!=null){
//                    sdate = rs.getDate("sdate").toLocalDate();
//                }else{
//                    sdate = null;
//                }
                LocalDate sdate = (rs.getDate("sdate")!=null)           //if
                                    ?(rs.getDate("sdate").toLocalDate())//then
                                    :(null);                            //else
                
                Sale s = new Sale(id, salesman, customer, product, quant, cost, sdate);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return list;
    }

    @Override
    public Sale findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Sale e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Salesman getSalesmanById(int id) {
        SalesmanDao sdao = new SalesmanDao();
        Salesman s = sdao.findById(id);
        return s;
    }
    private Customer getCustomerById(int id) {
        CustomerDao cdao = new CustomerDao();
        Customer c = cdao.findById(id);
        return c;
    }
    private Product getProductById(int id) {
        ProductDao pdao = new ProductDao();
        Product p = pdao.findById(id);
        return p;
    }
    
}
