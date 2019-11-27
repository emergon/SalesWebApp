package entities;

import java.util.Objects;

public class Salesman {
    private int scode;
    private String name;
    private String city;
    private double commission;

    public Salesman() {
    }

    public Salesman(String name, String city, double commission) {
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public Salesman(int scode, String name, String city, double commission) {
        this.scode = scode;
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.scode;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.city);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.commission) ^ (Double.doubleToLongBits(this.commission) >>> 32));
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
        final Salesman other = (Salesman) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (Double.doubleToLongBits(this.commission) != Double.doubleToLongBits(other.commission)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salesman{" + "scode=" + scode + ", name=" + name + ", city=" + city + ", commission=" + commission + '}';
    }
    
    
}
