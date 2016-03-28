package dariabeliaeva.diploma.com.finefin.data_models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Spendings extends RealmObject{

    @PrimaryKey
    private long id;
    private String name;
    private double price;
    private Date date;
    //private Categories category;


    public Spendings() {

    }

    public Spendings(long id, String name, double price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        //this.category = category;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public Categories getCategory() {
        return category;
    }

    public void setCategory_id(Categories category) {
        this.category = category;
    }*/

}
