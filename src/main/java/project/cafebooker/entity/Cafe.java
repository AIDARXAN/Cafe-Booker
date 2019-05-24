package project.cafebooker.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cafe")
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int places;
    private int price;
    @ManyToMany(mappedBy = "cafes")
    private Collection<Booker> bookers;



    Cafe(){

    }

    public Collection<Booker> getBookers() {
        return bookers;
    }

    public void setBookers(Collection<Booker> bookers) {
        this.bookers = bookers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cafe(String name, int places, int price, Collection<Booker> bookers) {
        this.name = name;
        this.bookers = bookers;
        this.places = places;
        this.price = price;

    }
}
