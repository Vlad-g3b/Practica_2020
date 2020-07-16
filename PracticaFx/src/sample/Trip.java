package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Trip {
    private StringProperty trip_etd;
    private StringProperty trip_eta;
    private StringProperty trip_std;
    private StringProperty trip_sta;
    private StringProperty trip_date;
    private IntegerProperty trip_id_train;
    private IntegerProperty trip_id_cursa;

    public String getTrip_etd() {
        return trip_etd.get();
    }

    public StringProperty trip_etdProperty() {
        return trip_etd;
    }

    public void setTrip_etd(String trip_etd) {
        this.trip_etd.set(trip_etd);
    }

    public String getTrip_eta() {
        return trip_eta.get();
    }

    public StringProperty trip_etaProperty() {
        return trip_eta;
    }

    public int getTrip_id_cursa() {
        return trip_id_cursa.get();
    }

    public IntegerProperty trip_id_cursaProperty() {
        return trip_id_cursa;
    }

    public void setTrip_id_cursa(int trip_id_cursa) {
        this.trip_id_cursa.set(trip_id_cursa);
    }

    public void setTrip_eta(String trip_eta) {
        this.trip_eta.set(trip_eta);
    }

    public String getTrip_std() {
        return trip_std.get();
    }

    public StringProperty trip_stdProperty() {
        return trip_std;
    }

    public void setTrip_std(String trip_std) {
        this.trip_std.set(trip_std);
    }

    public String getTrip_sta() {
        return trip_sta.get();
    }

    public StringProperty trip_staProperty() {
        return trip_sta;
    }

    public void setTrip_sta(String trip_sta) {
        this.trip_sta.set(trip_sta);
    }

    public String getTrip_date() {
        return trip_date.get();
    }

    public StringProperty trip_dateProperty() {
        return trip_date;
    }

    public void setTrip_date(String trip_date) {
        this.trip_date.set(trip_date);
    }

    public int getTrip_id_train() {
        return trip_id_train.get();
    }

    public IntegerProperty trip_id_trainProperty() {
        return trip_id_train;
    }

    public void setTrip_id_train(int trip_id_train) {
        this.trip_id_train.set(trip_id_train);
    }
    Trip(String etd, String eta, String std, String sta, String date, int id_train,int id_cursa) {
        this.trip_etd = new SimpleStringProperty(etd);
        this.trip_eta = new SimpleStringProperty(eta);
        this.trip_std = new SimpleStringProperty(std);
        this.trip_sta = new SimpleStringProperty(sta);
        this.trip_date = new SimpleStringProperty(date);
        this.trip_id_train = new SimpleIntegerProperty(id_train);
        this.trip_id_cursa = new SimpleIntegerProperty(id_cursa);
    }
    Trip(int trip_ip){
        this.trip_id_cursa =new SimpleIntegerProperty(trip_ip);
    }

}
