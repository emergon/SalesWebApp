package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Family {
    private int fid;
    private String fname;
    private String frelationship;
    private LocalDate dob;
    private Salesman salesman;

    public Family() {
    }

    public Family(String fname, String frelationship, LocalDate dob, Salesman salesman) {
        this.fname = fname;
        this.frelationship = frelationship;
        this.dob = dob;
        this.salesman = salesman;
    }

    public Family(int fid, String fname, String frelationship, LocalDate dob, Salesman salesman) {
        this.fid = fid;
        this.fname = fname;
        this.frelationship = frelationship;
        this.dob = dob;
        this.salesman = salesman;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(String frelationship) {
        this.frelationship = frelationship;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.fid;
        hash = 37 * hash + Objects.hashCode(this.fname);
        hash = 37 * hash + Objects.hashCode(this.frelationship);
        hash = 37 * hash + Objects.hashCode(this.dob);
        hash = 37 * hash + Objects.hashCode(this.salesman);
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
        final Family other = (Family) obj;
        if (this.fid != other.fid) {
            return false;
        }
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.frelationship, other.frelationship)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        if (!Objects.equals(this.salesman, other.salesman)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Family{" + "fid=" + fid + ", fname=" + fname + ", frelationship=" + frelationship + ", dob=" + dob + '}';
    }
    
}
