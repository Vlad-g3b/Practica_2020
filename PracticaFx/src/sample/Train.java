package sample;

import javafx.beans.property.*;

public class Train {
    private IntegerProperty id_tr;
    private StringProperty tip;
    private IntegerProperty nr_cls1;
    private IntegerProperty nr_cls2;
    private StringProperty status;

    public int getId_tr() {
        return id_tr.get();
    }

    public IntegerProperty id_trProperty() {
        return id_tr;
    }

    public void setId_tr(int id_tr) {
        this.id_tr.set(id_tr);
    }

    public String getTip() {
        return tip.get();
    }

    public StringProperty tipProperty() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip.set(tip);
    }

    public int getNr_cls1() {
        return nr_cls1.get();
    }

    public IntegerProperty nr_cls1Property() {
        return nr_cls1;
    }

    public void setNr_cls1(int nr_cls1) {
        this.nr_cls1.set(nr_cls1);
    }

    public int getNr_cls2() {
        return nr_cls2.get();
    }

    public IntegerProperty nr_cls2Property() {
        return nr_cls2;
    }

    public void setNr_cls2(int nr_cls2) {
        this.nr_cls2.set(nr_cls2);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    Train(int id, String type, int cls1, int cls2, String stat){
        this.id_tr =new SimpleIntegerProperty(id);
        this.tip = new SimpleStringProperty(type);
        this.nr_cls1 = new SimpleIntegerProperty(cls1);
        this.nr_cls2 = new SimpleIntegerProperty(cls2);
        this.status = new SimpleStringProperty(stat);


    }
}
