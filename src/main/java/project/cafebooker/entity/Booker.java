package project.cafebooker.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "booker")
public class Booker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customer;
    private Date date;

    private String cafe;

    Booker(){}
    public Booker(String customer, Date date, String cafe) {
        this.customer = customer;
        this.date = date;
        this.cafe = cafe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }
}
