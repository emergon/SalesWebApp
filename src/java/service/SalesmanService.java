package service;

import dao.SalesmanDao;
import entities.Salesman;
import java.util.List;
import java.util.Map;

public class SalesmanService {
    private SalesmanDao sdao;
    
    public SalesmanService(){
        sdao = new SalesmanDao();
    }
    
    public List<Salesman> getSalesmen(){
        return sdao.findAll();
    }

    public boolean createSalesman(String name, String city, String commission) {
        double comm = Double.parseDouble(commission);
        Salesman s = new Salesman(name, city, comm);
        boolean result = sdao.create(s);
        return result;
    }

    public boolean deleteSalesman(String scode) {
        int code = Integer.parseInt(scode);
        boolean result = sdao.delete(code);
        return result;
    }

    public Salesman getSalesman(String id) {
        int scode = Integer.parseInt(id);
        Salesman s = sdao.findById(scode);
        return s;
    }

    public boolean updateSalesman(Map<String, String[]> map) {
        //Take the parameters from the map
        String id = map.get("scode")[0];//Contains the value of parameter scode
        String name = map.get("name")[0];//Contains the value of parameter name
        String city = map.get("city")[0];//Contains the value of parameter city
        String commission = map.get("commission")[0];//Contains the value of parameter commission
        //Parse id and commission
        int scode = Integer.parseInt(id);
        double comm = Double.parseDouble(commission);
        //Create salesman object
        Salesman s = new Salesman(scode, name, city, comm);
        //Pass object to DB
        boolean result = sdao.update(s);
        return result;
    }
    
}





