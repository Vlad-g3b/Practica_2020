package sample;

import javafx.beans.property.*;

public class Promo {
    private StringProperty promo_type;
    private FloatProperty promo_amount;
    private IntegerProperty promo_id;

    public String getPromo_type() {
        return promo_type.get();
    }

    public StringProperty promo_typeProperty() {
        return promo_type;
    }

    public void setPromo_type(String promo_type) {
        this.promo_type.set(promo_type);
    }

    public float getPromo_amount() {
        return promo_amount.get();
    }

    public int getPromo_id() {
        return promo_id.get();
    }

    public IntegerProperty promo_idProperty() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id.set(promo_id);
    }

    public FloatProperty promo_amountProperty() {
        return promo_amount;
    }

    public void setPromo_amount(float promo_amount) {
        this.promo_amount.set(promo_amount);
    }

    public Promo(int id ,String promo, Float amount){
        this.promo_amount = new SimpleFloatProperty(amount);
        this.promo_type = new SimpleStringProperty(promo);
        this.promo_id = new SimpleIntegerProperty(id);
    }
}
