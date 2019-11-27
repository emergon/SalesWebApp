package service;

import dao.CustomerDao;
import entities.Customer;
import java.util.List;

public class CustomerService {
    CustomerDao cdao;

    public CustomerService() {
        cdao = new CustomerDao();
    }
    
    public List<Customer> getCustomers(){
        List<Customer> list = cdao.findAll();
        return list;
    }

    public boolean createCustomer(String cname) {
        Customer c = new Customer(cname);
        boolean result = cdao.create(c);
        return result;
    }
    
    public void deleteCustomer(int id){
        cdao.delete(id);
    }

    public Customer getCustomer(int ccode) {
        Customer c = cdao.findById(ccode);
        return c;
    }

    public void updateCustomer(int code, String cname) {
        Customer c = new Customer(code, cname);
        cdao.update(c);
    }
}
