package service;

import dao.ProductDao;
import entities.Product;
import java.util.List;

public class ProductService {
    ProductDao pdao;

    public ProductService() {
        this.pdao = new ProductDao();
    }
    
    public List<Product> fereMyProducts(){
        return pdao.findAll();
    }
    
    public boolean createProduct(String descr, String p){
        double price = Double.parseDouble(p);
        Product product = new Product(descr, price);
        boolean result = pdao.create(product);
        return result;
    }
    
    public boolean deleteProduct(String id){
        int pcode = Integer.parseInt(id);
        boolean result = pdao.delete(pcode);
        return result;
    }
}


















