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

    @ManyToMany
    @JoinTable(
            name = "cafe",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")
            )
    private Cafe cafes;

    Booker(){}
    public Booker(String customer, Date date, Cafe cafes) {
        this.customer = customer;
        this.date = date;
        this.cafes = cafes;
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

    public Cafe getCafes() {
        return cafes;
    }

    public void setCafes(Cafe cafes) {
        this.cafes = cafes;
    }
}
