package service;

import dao.SalesmanDao;
import entities.Salesman;
import java.util.List;

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
    
}





