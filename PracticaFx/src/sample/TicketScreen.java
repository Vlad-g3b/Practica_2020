package sample;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class TicketScreen implements Initializable {

    @FXML
    private JFXButton confirm;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXTextField to;

    @FXML
    private JFXTextField eta;

    @FXML
    private JFXComboBox<String> clasa;

    @FXML
    private JFXTextField client_id;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField from;

    @FXML
    private JFXTextField etd;

    @FXML
    private JFXTextField train;

    @FXML
    private JFXComboBox<Integer> seat_nr;

    @FXML
    private JFXTextField date;

    @FXML
    private JFXComboBox<String> price_combo;

    Trip trippassed;
    private int id_cursa;

    private UserPriv user_con;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    private int id_client;

    public int getId_cursa() {
        return id_cursa;
    }

    public void setId_cursa(int id_cursa) {
        this.id_cursa = id_cursa;
    }


    public void confirmIsPushed(ActionEvent event)throws IOException{
            String sql="Insert into locuri (nr_loc,clasa,tren_id_tr) values(?,?,?); ";
            String sql1= "Insert into bilet (data_emiterii ,cl_id, id_tarif, id_cursa, pret) values (now(),?,?,?,?);";
            String sql2 ="Select id_tarif from tarife where tip = ?";
            Connection con = null;


            try{
                con = MySQLJDBCUtil.getConnection();
                PreparedStatement stm = con.prepareStatement(sql);
                PreparedStatement stm1 = con.prepareStatement(sql1);
                PreparedStatement stm2 = con.prepareStatement(sql2);
                stm2.setString(1,price_combo.getValue());

                ResultSet rs2 = stm2.executeQuery();
                rs2.next();
                int id_tarif= rs2.getInt("id_tarif");

                stm.setInt(1,seat_nr.getValue());
                stm.setInt(2,clasa.getValue().equals("class I")?1:2);
                stm.setInt(3,Integer.parseInt(train.getText()));
                stm.execute();

                stm1.setInt(1,this.id_client);
                stm1.setInt(2,id_tarif);
                stm1.setInt(3,this.id_cursa);
                stm1.setFloat(4,Float.parseFloat(price.getText()));
                stm1.execute();



                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Done!");
                alert.showAndWait();
                Stage stage = (Stage) confirm.getScene().getWindow();
                stage.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage() + " Fill all the fields!");
                alert.showAndWait();
            }


    }


    public void pasid(int id_trip){
        id_cursa = id_trip;
        initTrip(id_cursa);
    }

    public void cancel_btnIsPushed(ActionEvent event){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public float getPrice(String sfrom, String sto){
        float price =0;
            int hf = Integer.parseInt(sfrom.substring(0,2));
            int mf = Integer.parseInt(sfrom.substring(3,5));
            int ht = Integer.parseInt(sto.substring(0,2));
            int mt = Integer.parseInt(sto.substring(3,5));
        price =(float) ((ht - hf)*10 + (mf-mt)*0.1);


        if (price >0 )
        return  price;
        else
            return -price;
    }

    public void initUserTick(UserPriv user){
        user_con = new UserPriv(user);
    }


    ObservableList<String> promo = FXCollections.observableArrayList();

    public void initTrip(int id_trip){
        Connection con = null;
        String sql = "Select ora_plecare,ora_sosire ,tren_id_tr,id_cursa,id_statie_plecare,id_statie_sosire,data from cursa where id_cursa = ?";
        String sql1 = "Select tip from tarife ;";
        String sql2= "Select reducere from tarife where tip =?";
        String sql3 ="Select nr_loc,clasa from locuri where tren_id_tr = ?";
        String sql4 ="Select nr_cls1,nr_cls2 from tren where id_tr= ?";
        try{
            con = MySQLJDBCUtil.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            Statement stm1= con.createStatement();
            PreparedStatement stm2= con.prepareStatement(sql2);
            PreparedStatement stm3=con.prepareStatement(sql3);
            PreparedStatement stm4=con.prepareStatement(sql4);



            stm.setInt(1,id_trip);
            ResultSet rs = stm.executeQuery();
            rs.next();
            String temp_from = rs.getString("id_statie_plecare");
            String temp_to =rs.getString("id_statie_sosire");
            String temp_eta= rs.getString("ora_sosire");
            String temp_etd =rs.getString("ora_plecare");
            String temp_date= String.valueOf(rs.getDate("data"));
            int temp_id_train= rs.getInt("tren_id_tr");
            int temp_id_cursa = rs.getInt("id_cursa");
            trippassed = new Trip(temp_etd,temp_eta,temp_from,temp_to,temp_date,temp_id_train,temp_id_cursa);

            stm4.setInt(1,temp_id_train);
            ResultSet rs4 = stm4.executeQuery();
            rs4.next();
            int cls1= rs4.getInt("nr_cls1");
            int cls2= rs4.getInt("nr_cls2");

            stm3.setInt(1,temp_id_train);
            ResultSet rs3 = stm3.executeQuery();
            ObservableList<Integer> seats = FXCollections.observableArrayList();
            seats.removeAll(seats);
            ObservableList<Integer> seats2 = FXCollections.observableArrayList();
            seats2.removeAll(seats2);
            while (rs3.next()){
                if(rs3.getString("clasa").equals("1"))
                    seats.add(rs3.getInt("nr_loc"));
                else
                    seats2.add(rs3.getInt("nr_loc"));
            }

            ObservableList<Integer> real_seats = FXCollections.observableArrayList();
            ObservableList<Integer> real_seats2 = FXCollections.observableArrayList();
            real_seats.removeAll(real_seats);
            real_seats2.removeAll(real_seats2);
            for (int i = 0; i < cls1; i++) {
                real_seats.add(i);
            }

            for (int i = 0; i < cls2; i++) {
                real_seats2.add(i);
            }

            real_seats.removeAll(seats);
            real_seats2.removeAll(seats2);
            clasa.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                System.out.println(newValue);
                try {
                    if(newValue.equals("class I")) {
                        System.out.println("clasa I"+ real_seats);
                        seat_nr.setItems(real_seats);
                    }else {
                        System.out.println("clasa II"+ real_seats2);
                        seat_nr.setItems(real_seats2);
                    }



                }catch (Exception e){
                    e.printStackTrace();
                }

            });





            from.setText(temp_from);
            to.setText(temp_to);
            eta.setText(temp_eta);
            etd.setText(temp_etd);
            date.setText(temp_date);
            train.setText(Integer.toString(temp_id_train));
            price.setText(String.valueOf(getPrice(temp_etd,temp_eta)));
            client_id.setText(String.valueOf(this.id_client));
            ResultSet rs1 = stm1.executeQuery(sql1);
            while (rs1.next()){
                promo.add(rs1.getString("tip"));
            }
        price_combo.setItems(promo);

            price_combo.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                        System.out.println(newValue);
                        try {
                            stm2.setString(1, newValue);


                            ResultSet rs2 = stm2.executeQuery();
                            rs2.next();
                            price.setText(String.valueOf(getPrice(temp_etd,temp_eta) - getPrice(temp_etd,temp_eta)*rs2.getFloat("reducere")/100));

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    });
           // stm2.setString();


        }catch (Exception ex){
            ex.printStackTrace();

        }





    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trippassed = new Trip(id_cursa);
            try{
                System.out.println(trippassed.getTrip_id_cursa());
            }catch (Exception e){
                e.printStackTrace();
            }

            ObservableList<String> list = FXCollections.observableArrayList();
        list.add("class I");
        list.add("class II");
            clasa.setItems(list);

    }
}
