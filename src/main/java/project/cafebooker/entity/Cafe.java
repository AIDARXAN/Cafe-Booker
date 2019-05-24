package project.cafebooker.entity;

import javax.persistence.*;
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




    Cafe(){

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

    public Cafe(String name, int places, int price) {
        this.name = name;

        this.places = places;
        this.price = price;

    }
}
