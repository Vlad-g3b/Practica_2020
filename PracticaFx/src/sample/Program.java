package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Program {
    private StringProperty from;
    private StringProperty to;
    private StringProperty etd;
    private StringProperty eta;
    private StringProperty price; //de schimbat tipul
    private StringProperty tren; //de schimbat tipul
    private IntegerProperty id_cursa;

    public int getId_cursa() {
        return id_cursa.get();
    }

    public IntegerProperty id_cursaProperty() {
        return id_cursa;
    }

    public void setId_cursa(int id_cursa) {
        this.id_cursa.set(id_cursa);
    }

    public String getFrom() {
        return from.get();
    }

    public StringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public StringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getEtd() {
        return etd.get();
    }

    public StringProperty etdProperty() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd.set(etd);
    }

    public String getEta() {
        return eta.get();
    }

    public StringProperty etaProperty() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta.set(eta);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getTren() {
        return tren.get();
    }

    public StringProperty trenProperty() {
        return tren;
    }

    public void setTren(String tren) {
        this.tren.set(tren);
    }

    public Program(String etd, String eta, String price, String tren) {
    //    this.from =new SimpleStringProperty(from);
   //     this.to =new SimpleStringProperty(to);
        this.etd =new SimpleStringProperty(etd);
        this.eta = new SimpleStringProperty(eta);
        this.price = new SimpleStringProperty(price);
        this.tren = new SimpleStringProperty(tren);
    }

    public Program(String etd, String eta, String price, String tren,int id_cursa) {
        //    this.from =new SimpleStringProperty(from);
        //     this.to =new SimpleStringProperty(to);
        this.etd =new SimpleStringProperty(etd);
        this.eta = new SimpleStringProperty(eta);
        this.price = new SimpleStringProperty(price);
        this.tren = new SimpleStringProperty(tren);
        this.id_cursa = new SimpleIntegerProperty(id_cursa);
    }

}
