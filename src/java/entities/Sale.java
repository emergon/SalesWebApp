package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Sale {
    private int scode;
    private Salesman salesman;
    private Customer customer;
    private Product product;
    private int quant;
    private double cost;
    private LocalDate sdate;

    public Sale() {
    }

    public Sale(Salesman salesman, Customer customer, Product product, int quant, double cost, LocalDate sdate) {
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.quant = quant;
        this.cost = cost;
        this.sdate = sdate;
    }

    public Sale(int scode, Salesman salesman, Customer customer, Product product, int quant, double cost, LocalDate sdate) {
        this.scode = scode;
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.quant = quant;
        this.cost = cost;
        this.sdate = sdate;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getSdate() {
        return sdate;
    }

    public void setSdate(LocalDate sdate) {
        this.sdate = sdate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.scode;
        hash = 97 * hash + Objects.hashCode(this.salesman);
        hash = 97 * hash + Objects.hashCode(this.customer);
        hash = 97 * hash + Objects.hashCode(this.product);
        hash = 97 * hash + this.quant;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.sdate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sale other = (Sale) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (this.quant != other.quant) {
            return false;
        }
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.salesman, other.salesman)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.sdate, other.sdate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale{" + "scode=" + scode + ", salesman=" + salesman.getName() + ", customer=" + customer.getCname() + ", product=" + product.getDescription() + ", quant=" + quant + ", cost=" + cost + ", sdate=" + sdate + '}';
    }
    
    
    
}
