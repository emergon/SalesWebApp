package dao;

import entities.Family;
import entities.Salesman;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FamilyDao extends SuperDao implements InterfaceDao<Family> {

    private static final String FINDALL = "SELECT * FROM family";
    private static final String FINDBYID = "SELECT * FROM family WHERE fid = ?";
    private static final String INSERTFAMILY = "INSERT INTO family (fname, frelationship, dob, salesman) VALUES (?,?,?,?)";
    
    @Override
    public boolean create(Family f) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTFAMILY);
            pst.setString(1, f.getFname());
            pst.setString(2, f.getFrelationship());
            pst.setObject(3, f.getDob());
            pst.setInt(4, f.getSalesman().getScode());
            int result = pst.executeUpdate();
            if(result>0){
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FamilyDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Family> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Family> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String relation = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int scode = rs.getInt(5);
                Salesman salesman = getSalesmanById(scode);
                Family f = new Family(id, name, relation, dob, salesman);
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Family.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Family findById(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Family f = null;
        try {
            stmt = getConnection().prepareStatement(FINDBYID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            int fid = rs.getInt(1);
            String name = rs.getString(2);
            String relation = rs.getString(3);
            LocalDate dob = rs.getDate(4).toLocalDate();
            int scode = rs.getInt(5);
            Salesman salesman = getSalesmanById(scode);
            f = new Family(fid, name, relation, dob, salesman);
        } catch (SQLException ex) {
            Logger.getLogger(Family.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return f;
    }

    @Override
    public boolean update(Family e) {
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
}
