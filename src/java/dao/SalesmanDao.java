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

public class SalesmanDao extends SuperDao implements InterfaceDao<Salesman> {

    private static final String FINDALL = "select * from salesman";
    private static final String FINDSALESMANBYID = "SELECT * FROM salesman WHERE scode = ?";
    private static final String INSERTSALESMAN = "INSERT INTO salesman (sname, scity, scomm) VALUES (?,?,?)";
    private static final String DELETESALESMAN = "DELETE FROM salesman WHERE scode = ?";
    private static final String UPDATESALESMAN = "UPDATE salesman SET sname = ?, scity = ?, scomm = ? WHERE scode = ?";
    private static final String FINDFAMILYBYSALESMAN = "SELECT * FROM family WHERE salesman = ?";
    
    @Override
    public boolean create(Salesman s) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTSALESMAN);
            pst.setString(1, s.getName());
            pst.setString(2, s.getCity());
            pst.setDouble(3, s.getCommission());
            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Salesman> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Salesman> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int code = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                double comm = rs.getDouble(4);
                Salesman s = new Salesman(code, name, city, comm);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salesman.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Salesman findById(int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Salesman s = null;
        try {
            pstm = getConnection().prepareStatement(FINDSALESMANBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String name = rs.getString(2);
            String city = rs.getString(3);
            double comm = rs.getDouble(4);
            s = new Salesman(code, name, city, comm);
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return s;
    }

    @Override
    public boolean update(Salesman s) {
        PreparedStatement pst = null;
        boolean updated = false;
        try {
            pst = getConnection().prepareStatement(UPDATESALESMAN);
            pst.setString(1, s.getName());
            pst.setString(2, s.getCity());
            pst.setDouble(3, s.getCommission());
            pst.setInt(4, s.getScode());
            int result = pst.executeUpdate();
            if (result > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return updated;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean deleted = false;
        try {
            pst = getConnection().prepareStatement(DELETESALESMAN);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return deleted;
    }

    public List<Family> getFamilyBySalesman(int id){
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Family> list = new ArrayList();
        try {
            pst = getConnection().prepareStatement(FINDFAMILYBYSALESMAN);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                int fid = rs.getInt(1);
                String fname = rs.getString(2);
                String frelation = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                Family f = new Family(fid, fname, frelation, dob);
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, pst);
        }
        return list;
    }
}

















