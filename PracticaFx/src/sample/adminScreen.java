package sample;

import com.jfoenix.controls.*;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adminScreen implements Initializable {



    @FXML
    private MenuItem insert_trip;

    @FXML
    private MenuItem insert_train;

    @FXML
    private MenuItem insert_promotion;

    @FXML
    private MenuItem change_trip12;

    @FXML
    private MenuItem change_train12;

    @FXML
    private MenuItem change_promotion12;


    @FXML
    private Button back;

    @FXML
    private Label info;

    @FXML
    private JFXButton test;

    @FXML
    private JFXButton home_btn;

    @FXML
    private Pane client_info;

    @FXML
    private TableView<Train> table_train;

    @FXML
    private TableColumn<Train,Integer> train_id_col;

    @FXML
    private TableColumn<Train,String> train_type_col;

    @FXML
    private TableColumn<Train,Integer> max_c1_col;

    @FXML
    private TableColumn<Train,Integer> max_c2_col;

    @FXML
    private TableColumn<Train,String> train_status_col;

    @FXML
    private JFXComboBox<String> to_combo;

    @FXML
    private JFXToggleButton toggle;

    @FXML
    private JFXComboBox<String> from_combo;

    @FXML
    private JFXButton changePassword;

    @FXML
    private JFXTextField first_name_info;

    @FXML
    private JFXTextField last_name_info;

    @FXML
    private JFXButton update_info_btn;

    @FXML
    private Pane search_pane;

    @FXML
    private  MenuButton insert;

    @FXML
    private JFXButton search;

    @FXML
    private  JFXTextField from;

    @FXML
    private  JFXTextField to;

    @FXML
    private  DatePicker date ;

    @FXML
    private Label  succes;

    @FXML
    private TableView<Program> progview;

    @FXML
    private JFXTextField email_info;

    @FXML
    private TableView<Promo> promotion;

    @FXML
    private TableColumn<Promo,String> promo_type_col;

    @FXML
    private TableColumn<Promo,Float> amount_col;

    @FXML
    private TableView<Promo> mod_promotion;

    @FXML
    private TableColumn<Promo,String> promo_type_col1;

    @FXML
    private TableColumn<Promo,Float> amount_col1;


    @FXML
    private TableColumn<Program,String> etd_col;

    @FXML
    private TableColumn<Program,String> eta_col;

    @FXML
    private TableColumn<Program,String> price_col;

    @FXML
    private TableColumn<Program,String> train_col;

    @FXML
    private JFXButton logoutexit;

    @FXML
    private JFXButton add_promo;

    @FXML
    private JFXTextField promo_type;

    @FXML
    private JFXTextField promo_amount;

    @FXML
    private JFXTextField promo_type1;

    @FXML
    private JFXTextField promo_amount1;

    @FXML
    private AnchorPane promo;

    @FXML
    private AnchorPane trip;

    @FXML
    private TextField trip_etd_field;

    @FXML
    private TextField trip_eta_field;

    @FXML
    private TextField trip_std_field;

    @FXML
    private TextField trip_sta_field;

    @FXML
    private TextField trip_id_train_field;

    @FXML
    private DatePicker trip_date_field;

    @FXML
    private AnchorPane train;

    @FXML
    private TableView<Trip> trip_table;

    @FXML
    private TableColumn<Trip,String > table_eta_col;
    @FXML
    private TableColumn<Trip,String > table_etd_col;
    @FXML
    private TableColumn<Trip,String > table_sta_col;
    @FXML
    private TableColumn<Trip,String > table_std_col;
    @FXML
    private TableColumn<Trip,Integer > table_train_id_col;
    @FXML
    private TableColumn<Trip,String > table_date_col;
    @FXML
    private JFXTextField add_type_field;
    @FXML
    private JFXTextField add_train_id_field;
    @FXML
    private JFXTextField add_cls1_field;
    @FXML
    private JFXTextField add_cls2_field;
    @FXML
    private JFXToggleButton status_toggle;

    @FXML
    private AnchorPane change_promo;

    @FXML
    private AnchorPane change_train;

    @FXML
    private AnchorPane change_trip;

    @FXML
    private MenuButton change;

    @FXML
    private TableView<Trip> trip_table1;

    @FXML
    private TableColumn<Trip, Integer> table_train_id_col1;

    @FXML
    private TableColumn<Trip, String> table_std_col1;

    @FXML
    private TableColumn<Trip, String> table_sta_col1;

    @FXML
    private TableColumn<Trip, String> table_etd_col1;

    @FXML
    private TableColumn<Trip, String> table_eta_col1;

    @FXML
    private TableColumn<Trip, String> table_date_col1;

    @FXML
    private JFXTextField trip_etd_field1;

    @FXML
    private JFXTextField trip_id_train_field1;

    @FXML
    private JFXTextField trip_eta_field1;

    @FXML
    private JFXTextField trip_std_field1;

    @FXML
    private JFXTextField trip_sta_field1;

    @FXML
    private DatePicker trip_date_field1;

    @FXML
    private JFXTextField add_type_field1;

    @FXML
    private JFXTextField add_cls1_field1;

    @FXML
    private JFXTextField add_cls2_field1;

    @FXML
    private JFXTextField add_train_id_field1;

    @FXML
    private JFXToggleButton status_toggle1;

    @FXML
    private TableView<Train> table_train1;

    @FXML
    private TableColumn<Train, Integer> train_id_col1;

    @FXML
    private TableColumn<Train, String> train_type_col1;

    @FXML
    private TableColumn<Train, Integer> max_c1_col1;

    @FXML
    private TableColumn<Train, Integer> max_c2_col1;

    @FXML
    private TableColumn<Train, String> train_status_col1;

    @FXML
    private JFXTextField search_box_mod_train;

    @FXML
    private JFXTextField search_box_mod_promo;

    @FXML
    private JFXTextField search_box_mod_trip;

    @FXML
    private JFXButton reserve;

    private ObservableList<Train> trainlist =FXCollections.observableArrayList();
    private ObservableList<Trip> triplist = FXCollections.observableArrayList();
    private ObservableList<Promo> promolist =FXCollections.observableArrayList();
    private ObservableList<Train> trainlist1 =FXCollections.observableArrayList();
    private ObservableList<Trip> triplist1= FXCollections.observableArrayList();
    private ObservableList<Promo> promolist1 =FXCollections.observableArrayList();

    private ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<Program> proglist ;
    private UserPriv user_con;
    private int id_user;
    private double xOffset = 0;
    private double yOffset = 0;
    private int id_cursa_cod = getIdCursaFromDB();
    private int id_train_mod;
    private int id_cursa_passed;
    public void reserveIsPushed(ActionEvent event)throws IOException{
        Program selectedprog = progview.getSelectionModel().getSelectedItem();
        id_cursa_passed = selectedprog.getId_cursa();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ticketScreen.fxml"));
        Parent clientSceneParent = loader.load();
        Scene clientScene = new Scene(clientSceneParent);
        TicketScreen controller  = loader.getController();
        //    String text = user_cl.getText();
        //   System.exit(0);
        controller.initUserTick(user_con);
        controller.setId_client(user_con.getId_user());
        controller.pasid(id_cursa_passed);

       // controller.setId_cursa(id_cursa_passed);

        Stage reg = new Stage();
        clientScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        clientScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                reg.setX(event.getScreenX() - xOffset);
                reg.setY(event.getScreenY() - yOffset);
            }
        });
        reg.setScene(clientScene);
        reg.initStyle(StageStyle.UNDECORATED);
        reg.initModality(Modality.APPLICATION_MODAL);
        reg.showAndWait();


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

    public void modify_trainIsPushed(ActionEvent event)throws  IOException{
        String sql =    "Insert into tren  (id_tr ,tip ,nr_cls1, nr_cls2, status) values(99999,'temp',0,0,0) ";
        String sql2 =   "Update cursa set tren_id_tr = 99999 where tren_id_tr = ? ";
        String sql4 =   "Update cursa set tren_id_tr = ? where tren_id_tr = 99999 ";
        String upd =    "Update tren set id_tr= ?, tip = ? , nr_cls1 = ? ,nr_cls2 = ? ,status = ? where id_tr = ?";
        String sql3 =   "Delete from tren where id_tr = ?";
        Connection con = null;

        try{
            con = MySQLJDBCUtil.getConnection();
           Statement stm = con.createStatement();
              PreparedStatement stm4 = con.prepareStatement(sql4);
              PreparedStatement upds = con.prepareStatement(upd);
            PreparedStatement stm2 = con.prepareStatement(sql2);
            PreparedStatement stm3 = con.prepareStatement(sql3);
            Train selectedTrain = (Train) table_train1.getSelectionModel().getSelectedItem();
            int id = selectedTrain.getId_tr();
            if(id  == id_train_mod)
                System.out.println("true");
            //stm.setInt(6,id_train_mod);
            stm3.setInt(1,99999);

            upds.setInt(1,Integer.parseInt(add_train_id_field1.getText()));
            upds.setString(2,add_type_field1.getText());
            upds.setInt(3,Integer.parseInt(add_cls1_field1.getText()));
            upds.setInt(4,Integer.parseInt(add_cls2_field1.getText()));
            upds.setInt(5,status_toggle1.isSelected()?1:0);
            upds.setInt(6,selectedTrain.getId_tr());

            stm4.setInt(1,selectedTrain.getId_tr());


            stm2.setInt(1,id_train_mod);
            stm.executeUpdate(sql);
            stm2.executeUpdate();
            upds.executeUpdate();
            stm4.execute();
            stm3.executeUpdate();




        }catch (Exception e){
            e.printStackTrace();
        }



        updateModTrain();
        dynamicTrainSearch();
    }
    public void modify_promoIsPushed(ActionEvent event)throws IOException{
        Promo selectedPromo = (Promo) mod_promotion.getSelectionModel().getSelectedItem();
        String sql ="Update tarife set tip= ? ,reducere =? where id_tarif = ?";
        String sql1 = "Insert into tarife (id_tarif, tip, reducere) values(99999,'temp',000)";
        String temp = "Delete from tarife where id_tarif = 99999";
        String sql2 = "Update bilet set id_tarif = 99999 where id_tarif = ?";
        String sql3 = "Update bilet set id_tarif = ? where id_tarif = 99999";
        Connection con = null;


        try{
            con  = MySQLJDBCUtil.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            Statement stm1 = con.createStatement();
            stm1.execute(sql1);

            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm.setInt(3,selectedPromo.getPromo_id());
            stm.setFloat(2,Float.parseFloat(promo_amount1.getText()));
            stm.setString(1,promo_type1.getText());
            stm.execute();

            stm2.setInt(1,selectedPromo.getPromo_id());
            stm2.execute();

            PreparedStatement stm3 = con.prepareStatement(sql3);
            stm3.setInt(1,selectedPromo.getPromo_id());
            stm3.execute();
            Statement temp1= con.createStatement();
            temp1.execute(temp);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        updateModPromo();
        dynamicPromoSearch();
    }

    public void modify_tripIsPushed(ActionEvent event) throws IOException{
        String sql = "UPDATE cursa set ora_plecare = ? ,ora_sosire =? ,id_statie_plecare = ?,id_statie_sosire = ?,data =?,tren_id_tr = ? where id_cursa = ? ";
        Trip selectedTrip = (Trip) trip_table1.getSelectionModel().getSelectedItem();
        Connection con = null;
        try{
            con = MySQLJDBCUtil.getConnection();
            PreparedStatement  stm = con.prepareStatement(sql);
            stm.setString(1,trip_etd_field1.getText());
            stm.setString(2,trip_eta_field1.getText());
            stm.setString(3,trip_std_field1.getText());
            stm.setString(4,trip_sta_field1.getText());
            stm.setString(5,trip_date_field1.getValue().toString());
            stm.setInt(6,Integer.parseInt(trip_id_train_field1.getText()));
            stm.setInt(7,selectedTrip.getTrip_id_cursa());
            stm.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        updateModTrip();
        dynamicTripSearch();
    }

    public void dynamicTripSearch(){
        FilteredList<Trip> filteredData = new FilteredList<>(triplist1 ,b-> true);
        search_box_mod_trip.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(mod_trip -> {
                // If filter text is empty, display all
                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (mod_trip.getTrip_sta().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(mod_trip.getTrip_id_train()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if (mod_trip.getTrip_std().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if (mod_trip.getTrip_eta().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if (mod_trip.getTrip_etd().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Trip> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(trip_table1.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        trip_table1.setItems(sortedData);
    }

    public void change_tripIsPushed(ActionEvent event)throws IOException{
        change_trip.setVisible(true);
        change_trip.toFront();
        updateModTrip();
        dynamicTripSearch();

    }

    public void dynamicPromoSearch(){
        FilteredList<Promo> filteredData = new FilteredList<>(promolist1 ,b-> true);
        search_box_mod_promo.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(mod_promo -> {
                // If filter text is empty, display all
                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (mod_promo.getPromo_type().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(mod_promo.getPromo_amount()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Promo> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(mod_promotion.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        mod_promotion.setItems(sortedData);
    }

    public void change_promoIsPushed(ActionEvent event)throws IOException{
        change_promo.setVisible(true);
        change_promo.toFront();
        updateModPromo();
        dynamicPromoSearch();

    }
    public void dynamicTrainSearch(){
        FilteredList<Train> filteredData = new FilteredList<>(trainlist1 ,b-> true);
        search_box_mod_train.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(mod_train -> {
                // If filter text is empty, display all
                if (newValue == null || newValue.isEmpty()) {
                    System.out.println("aici");
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(mod_train.getId_tr()).contains(lowerCaseFilter)) {
                    return true;
                } else if (mod_train.getTip().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Train> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table_train1.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table_train1.setItems(sortedData);
    }
    public void change_trainIsPushed(ActionEvent event)throws IOException{
        change_train.setVisible(true);
        change_train.toFront();
        updateModTrain();
       dynamicTrainSearch();

    }

    public void import_trainIsPushed(ActionEvent event)throws IOException{
        FileChooser fileChooser = new FileChooser();
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(theStage);
        System.out.println(selectedFile);
        //add more
    }

    public void add_trainIsPushed(ActionEvent event)throws IOException{
        String sql = "Insert into tren (id_tr,tip,nr_cls1,nr_cls2,status) values(?,?,?,?,?);";
        Connection con = null;
        try{
            int status = 1;
            status = status_toggle.isSelected()? 1:0;
            con = MySQLJDBCUtil.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,Integer.parseInt(add_train_id_field.getText()));
            stm.setString(2,add_type_field.getText());
            stm.setInt(3,Integer.parseInt(add_cls1_field.getText()));
            stm.setInt(4,Integer.parseInt(add_cls2_field.getText()));
            stm.setInt(5, status);
            stm.execute();


        }catch (NumberFormatException e) {
            Alert alert= new Alert(Alert.AlertType.ERROR,"Max. cls1 ,max.cls2 and id train must be numbers!");
            alert.showAndWait();
        }
        catch (SQLIntegrityConstraintViolationException e){
            Alert alert= new Alert(Alert.AlertType.ERROR,"Train id must be unique!");
            alert.showAndWait();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            trainlist.removeAll(trainlist);
            trainsFromDataBase(con,trainlist);

            train_id_col.setCellValueFactory(new PropertyValueFactory<>("id_tr"));
            train_type_col.setCellValueFactory(new PropertyValueFactory<>("tip"));
            train_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
            max_c1_col.setCellValueFactory(new PropertyValueFactory<>("nr_cls1"));
            max_c2_col.setCellValueFactory(new PropertyValueFactory<>("nr_cls2"));

            table_train.setItems(trainlist);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void trainsFromDataBase(Connection conn,ObservableList list){

        String  sql = "Select id_tr,tip,nr_cls1,nr_cls2,status from tren;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                String train_stat = "available";
                 if(rs.getInt("status") == 0)
                     train_stat = "not available";
                list.add(new Train(rs.getInt("id_tr"),rs.getString("tip"),rs.getInt("nr_cls1"),rs.getInt("nr_cls2"),train_stat));
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getIdCursaFromDB(){
        int id_cursa = 99999;
        String sql="Select max(id_cursa) as id_cursa from cursa;";
        Connection con = null;
        try {
            con = MySQLJDBCUtil.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            id_cursa = rs.getInt("id_cursa");
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id_cursa ;
    }

    public void import_tripIsPushed(ActionEvent event)throws IOException{
        FileChooser fileChooser = new FileChooser();
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(theStage);
        System.out.println(selectedFile);
        //add more
    }

    public  void add_tripIsPushed(ActionEvent event) throws IOException{
        Connection con = null;
        id_cursa_cod ++;
        boolean ok = false;
        String sql = "Insert into cursa (id_cursa,ora_plecare,ora_sosire,id_statie_plecare,id_statie_sosire,data,tren_id_tr) values(?,?,?,?,?,?,?);  ";
        String query="SELECT EXISTS(SELECT 1 FROM statie WHERE nume_statie = ? LIMIT 1);";
        Pattern hour = Pattern.compile("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]");
        Matcher m1 = hour.matcher(trip_eta_field.getText());
        Matcher m2 = hour.matcher(trip_etd_field.getText());
        if(trip_eta_field.getText().isBlank() ||
            trip_etd_field.getText().isBlank() ||
            trip_id_train_field.getText().isBlank() ||
            trip_sta_field.getText().isBlank() ||
            trip_std_field.getText().isBlank())
        {
            Alert alert= new Alert(Alert.AlertType.ERROR,"Fields can't be empty!");
            alert.showAndWait();

        }else  if(!m1.matches() && !m2.matches()  ){
            Alert alert= new Alert(Alert.AlertType.ERROR,"ETD and ETA must be \" hh:mm:ss \" ");
            alert.showAndWait();
        }
        else {
            try {
                con = MySQLJDBCUtil.getConnection();
                // System.out.println(trip_date_field.getValue().toString());
                // java.sql.Date sDate = convertUtilToSql(localDate);
                PreparedStatement check = con.prepareStatement(query);
                check.setString(1,trip_sta_field.getText());
                ResultSet rs1= check.executeQuery();
                rs1.next();
                int r1= rs1.getInt(1);
                check.setString(1,trip_std_field.getText());
                ResultSet rs2 = check.executeQuery();
                rs2.next();
                int r2= rs2.getInt(1);

                if(r1 == 1  && r2 == 1) {
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setInt(1, id_cursa_cod);
                    stm.setString(2, trip_etd_field.getText());
                    stm.setString(3, trip_eta_field.getText());
                    stm.setString(4, trip_std_field.getText());
                    stm.setString(5, trip_sta_field.getText());
                    stm.setString(6, trip_date_field.getValue().toString());
                    stm.setInt(7, Integer.parseInt(trip_id_train_field.getText()));
                    stm.execute();
                    ok = true;
                }
                else {
                    Alert alert= new Alert(Alert.AlertType.ERROR,"One of the stations does't exist!");
                    alert.showAndWait();

                }
            }catch (NullPointerException exn){
                Alert alert= new Alert(Alert.AlertType.ERROR,"Fields can't be empty!");
                alert.showAndWait();
            }
            catch (NumberFormatException ex){
                Alert alert= new Alert(Alert.AlertType.ERROR,"Train id is a number!");
                alert.showAndWait();
            }
            catch (SQLIntegrityConstraintViolationException exi){
                System.out.println(exi.getErrorCode()) ;
                Alert alert= new Alert(Alert.AlertType.ERROR,"Train Id must exist in train table!");
                alert.showAndWait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ok){
            trip_std_field.setText("");
            trip_sta_field.setText("");
            trip_etd_field.setText("");
            trip_eta_field.setText("");
            trip_id_train_field.setText("");

            try{

               triplist.removeAll(triplist);
                tripsFromDataBase(con,triplist);

                table_eta_col.setCellValueFactory(new PropertyValueFactory<>("trip_eta"));
                table_etd_col.setCellValueFactory(new PropertyValueFactory<>("trip_etd"));
                table_std_col.setCellValueFactory(new PropertyValueFactory<>("trip_std"));
                table_sta_col.setCellValueFactory(new PropertyValueFactory<>("trip_sta"));
                table_date_col.setCellValueFactory(new PropertyValueFactory<>("trip_date"));
                table_train_id_col.setCellValueFactory(new PropertyValueFactory<>("trip_id_train"));
                trip_table.setItems(triplist);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void add_promoIsPushed(ActionEvent event) throws IOException{
        boolean ok = true;
        if(promo_type.getText().isBlank() || promo_amount.getText().isBlank()){
           Alert alert = new Alert(Alert.AlertType.ERROR,"Fields can't be empty!");
            alert.showAndWait();
        }else {
            Connection con = null;
            PreparedStatement stm = null;
            String querry = "Insert into tarife (tip , reducere) values( ? , ? ) ; ";
            try {
                con = MySQLJDBCUtil.getConnection();
                stm = con.prepareStatement(querry);
                stm.setString(1, promo_type.getText());
                stm.setFloat(2, Float.parseFloat(promo_amount.getText()));
                stm.execute();

            } catch (NumberFormatException nr) {
                Alert conf = new Alert(Alert.AlertType.ERROR, "Amount must be a number!");
                ok = false;
                conf.showAndWait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (ok) {
                Alert conf = new Alert(Alert.AlertType.CONFIRMATION, "Success!");
                conf.showAndWait();


                promo_type.setText("");
                promo_amount.setText("");
                try {

                    promolist.removeAll(promolist);
                    tarifeFromDataBase(con, promolist);
                    promo_type_col.setCellValueFactory(new PropertyValueFactory<>("promo_type"));
                    amount_col.setCellValueFactory(new PropertyValueFactory<>("promo_amount"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                promotion.setItems(promolist);
            }
        }
    }


    public  void insert_promoIsPushed(ActionEvent event)throws  IOException{
            promo.setVisible(true);
            promo.toFront();
    }

    public void logoutexitIsPushed(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if( alert.getResult()==ButtonType.YES)
            System.exit(0);
    }

    public static void tripsFromDataBase(Connection conn,ObservableList<Trip> list){
        String sql = "Select id_cursa, ora_plecare,ora_sosire,id_statie_plecare,id_statie_sosire,data,tren_id_tr from cursa;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                list.add(new Trip(rs.getString("ora_plecare" ),rs.getString("ora_sosire"),rs.getString("id_statie_plecare"),rs.getString("id_statie_sosire"),rs.getString("data"),rs.getInt("tren_id_tr"),rs.getInt("id_cursa")));
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillListFromDataBase (Connection conn, ObservableList<String> list) {
        String sql = "SELECT nume_statie FROM statie order by nume_statie";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                list.add(rs.getString("nume_statie"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void tarifeFromDataBase(Connection conn, ObservableList<Promo> list){
        String sql = "Select id_tarif, tip ,reducere From tarife;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new Promo(rs.getInt("id_tarif"),rs.getString("tip"),rs.getFloat("reducere")));

            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void date_IsSelected(ActionEvent event)throws  IOException{
        System.out.println(date.getValue().toString());
    }

    public void to_comboIsSelected(ActionEvent event) throws IOException{

    }
    public void from_comboIsSelected(ActionEvent event)throws IOException{
        System.out.println(from_combo.getValue());
    }

    public void changePasswordIsPushed(ActionEvent event )throws IOException{
           // funct f = new funct();
           // f.newScene("changePass.fxml");
            try{
                FXMLLoader loader = new FXMLLoader((getClass().getResource("changePass.fxml")));
                Parent root = (Parent) loader.load();

                ChangePass controller = loader.getController();
                controller.passUser(user_con);
                Stage stage = new Stage();
                Scene window = new Scene(root);
                stage.setScene(window);
                stage.initStyle(StageStyle.UNDECORATED);
                root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }
                });
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    }
                });
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
             //   stage.show();

            }catch ( Exception e){
                e.printStackTrace();
            }
    }

    public void update_info_btnIsPushed(ActionEvent event )throws IOException{
        funct f =new funct();
        String temp = user_con.getEmail_user();
            if(f.validationPriv(user_con,"update","client")){
                Connection con = null;
                String querry ="UPDATE client Set email = ?, nume =  ? ,prenume = ? where email = ? ";
                try{
                    con = MySQLJDBCUtil.getConnection();
                    PreparedStatement stm2 = con.prepareStatement(querry);
                    if(!email_info.getText().isEmpty()) {
                        stm2.setString(1, email_info.getText());
                        user_con.setEmail_user(email_info.getText());
                    }
                        else stm2.setString(1,user_con.getEmail_user());
                    if(!last_name_info.getText().isEmpty()) {
                        stm2.setString(2, last_name_info.getText());
                        user_con.setLast_name_user(last_name_info.getText());
                    }
                        else stm2.setString(2,user_con.getLast_name_user());
                    if(!first_name_info.getText().isEmpty()) {
                        stm2.setString(3, first_name_info.getText());
                        user_con.setFirst_name_user(first_name_info.getText());
                    }
                        else stm2.setString(3,user_con.getFirst_name_user());

                    stm2.setString(4, temp);

                    stm2.execute();
                    stm2.close();
                    succes.setVisible(true);
                    PauseTransition visiblePause = new PauseTransition(
                            Duration.seconds(2)
                    );
                    email_info.setPromptText(user_con.getEmail_user());
                    last_name_info.setPromptText(user_con.getLast_name_user());
                    first_name_info.setPromptText(user_con.getFirst_name_user());
                    email_info.setText("");
                    first_name_info.setText("");
                    last_name_info.setText("");
                    visiblePause.setOnFinished(
                            eventlabel -> succes.setVisible(false)
                    );
                    visiblePause.play();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        //new Alert(Alert.AlertType.ERROR, "This is an error!").showAndWait();
    }

    public void home_btnIsPushed(ActionEvent event) throws  IOException{
        client_info.setVisible(true);
        search_pane.setVisible(false);
        client_info.toFront();
    }

    public  void testIsPushed(ActionEvent event) throws IOException{
        client_info.setVisible(false);
        search_pane.setVisible(true);
        search_pane.toFront();
    }

    public void insert_tripIsPushed(ActionEvent event) throws IOException {
        trip.setVisible(true);
        trip.toFront();
    }

    public void insert_trainIsPushed(ActionEvent event) throws IOException{
        train.setVisible(true);
        train.toFront();
    }


    public void toggleAction(ActionEvent event)throws  IOException{

    }

    public void search_mod_tripIsPushed(ActionEvent event) throws IOException{
        trip_table1.getItems().stream()
                .filter(item -> item.getTrip_std().equals(trip_std_field1.getText()))
                .findAny()
                .ifPresent(item -> {
                    trip_table1.getSelectionModel().select(item);
                    trip_table1.scrollTo(item);
                });
    }

    public void search_mod_promoIsPushed(ActionEvent event) throws IOException{
        mod_promotion.getItems().stream()
                .filter(item -> item.getPromo_type().equals(promo_type1.getText()))
                .findAny()
                .ifPresent(item -> {
                    mod_promotion.getSelectionModel().select(item);
                    mod_promotion.scrollTo(item);
                });
    }

    public void search1_mod_trainIsPushed(ActionEvent event)throws IOException{
       table_train1.getItems().stream()
                .filter(item ->item.getId_tr() == Integer.parseInt(train_id_col1.getText()))
                .findAny()
                .ifPresent(item -> {
                    table_train1.getSelectionModel().select(item);
                    table_train1.scrollTo(item);
                });
    }

    public void onMouseClicked(MouseEvent event) throws IOException{
        if (event.getClickCount() > 1) {
            onEdit(progview, "Program");

        }
    }
    public void mod_clicked(MouseEvent event) throws IOException{
        if (event.getClickCount() > 1) {

            onEdit(table_train1, "Train");


        }
    }
    public void mod_clicked_trip(MouseEvent event) throws IOException{
        if (event.getClickCount() > 1) {

            onEdit(trip_table1, "Trip");

        }
    }
    public void mod_clicked_promo(MouseEvent event) throws IOException{
        if (event.getClickCount() > 1) {

            onEdit(mod_promotion, "Promo");

        }
    }

    public void onEdit(TableView table,String obj){
        if (progview.getSelectionModel().getSelectedItem() != null || table_train1.getSelectionModel().getSelectedItem() != null || trip_table1.getSelectionModel().getSelectedItem() != null|| mod_promotion.getSelectionModel().getSelectedItem() != null) {
            System.out.println(obj);

            switch (obj) {
                case "Program":
                    Program selectedPerson = (Program) table.getSelectionModel().getSelectedItem();
                    System.out.println(selectedPerson.getEta());
                    System.out.println(selectedPerson.getId_cursa());
                    break;
                case "Train":
                    System.out.println("aoci");
                    Train selectedTrain = (Train) table.getSelectionModel().getSelectedItem();
                     id_train_mod = selectedTrain.getId_tr();
                    add_train_id_field1.setText(String.valueOf(selectedTrain.getId_tr()));
                    add_cls1_field1.setText(String.valueOf(selectedTrain.getNr_cls1()));
                    add_cls2_field1.setText(String.valueOf(selectedTrain.getNr_cls2()));
                    add_type_field1.setText(selectedTrain.getTip());
                    status_toggle1.setSelected(selectedTrain.getStatus().equals("available"));


                    break;
                case  "Trip":
                    Trip selectedTrip = (Trip) table.getSelectionModel().getSelectedItem();
                    trip_std_field1.setText(selectedTrip.getTrip_std());
                    trip_sta_field1.setText(selectedTrip.getTrip_sta());
                    trip_eta_field1.setText(selectedTrip.getTrip_eta());
                    trip_etd_field1.setText(selectedTrip.getTrip_etd());
                    trip_date_field1.setValue(LocalDate.parse(selectedTrip.getTrip_date()));
                    trip_id_train_field1.setText(String.valueOf(selectedTrip.getTrip_id_train()));
                    break;
                case "Promo":
                    Promo selectedPromo = (Promo) table.getSelectionModel().getSelectedItem();
                    promo_amount1.setText(String.valueOf(selectedPromo.getPromo_amount()));
                    promo_type1.setText(selectedPromo.getPromo_type());

                    break;
                default:
                    break;
            }
        }
        return;
    }

    public void searchIsPushed(ActionEvent event)throws IOException{
        funct f = new funct();
        proglist = FXCollections.observableArrayList();
       //     System.out.println("From " + from.getText() + "  to  " + to.getText() + " date: " + date.getValue().toString());

            try{
                String querry="Select ora_plecare,ora_sosire ,tren_id_tr,id_cursa from cursa where id_statie_plecare = ? and id_statie_sosire = ? and data = ?;";
                String querry1="Select ora_plecare,ora_sosire ,tren_id_tr,id_cursa from cursa where id_statie_plecare = 'Alexandria' and id_statie_sosire = 'Roșiori Nord';";
                Connection con = MySQLJDBCUtil.getConnection();
                if (con!=null){
                    PreparedStatement stm =null;
                    if(toggle.isSelected()) {
                        System.out.println("true");
                        stm = con.prepareStatement(querry);
                        stm.setString(1, from_combo.getValue());
                        stm.setString(2, to_combo.getValue());

                        if(date.getValue() == null){
                         Alert alert    =    new Alert(Alert.AlertType.ERROR,"Select a date!");
                            alert.showAndWait();
                            return;
                        }else {
                            stm.setString(3, date.getValue().toString());
                        }

                    }
                    else{
                        stm = con.prepareStatement(querry1);



                    }
                    ResultSet sr = stm.executeQuery();
                    while (sr.next()){
                        proglist.add(new Program(sr.getString(1),sr.getString(2),String.valueOf(getPrice(sr.getString(1),sr.getString(2))),Integer.toString(sr.getInt("tren_id_tr")),sr.getInt("id_cursa")));
                    //    id_cursa_passed = sr.getInt("id_cursa");
                    }

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }



        try{
           // from_col.setCellValueFactory(new PropertyValueFactory<>("from"));
          //  to_col.setCellValueFactory(new PropertyValueFactory<>("to"));
            etd_col.setCellValueFactory(new PropertyValueFactory<>("etd"));
            eta_col.setCellValueFactory(new PropertyValueFactory<>("eta"));
            price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
            train_col.setCellValueFactory(new PropertyValueFactory<>("tren"));

        }catch (Exception e){
            e.printStackTrace();
        }

        progview.setItems(proglist);
    }
    Trip trippassed;


    public void initUser(String email){
        Connection con = null;
        int id_user = -1;
        String query = "Select cl_id From client Where email = ? ; ";
        String query1 = "Select Distinct denumire_priv,tabela from privilegii as p, rol as r , client as c  where p.id_rol =r.id_rol and r.id_rol = c.id_rol and cl_id = ? ;";
        String query2 = "Select nume,prenume,parola from client where email  = ? ;";
        try {
            con = MySQLJDBCUtil.getConnection();
            user_con.setEmail_user(email);
            System.out.println("email : " +user_con.getEmail_user());
            PreparedStatement stat_info = null;
            stat_info = con.prepareStatement(query2);
            stat_info.setString(1,email);
            ResultSet res2 = stat_info.executeQuery();
            res2.next();
            user_con.setFirst_name_user(res2.getString("prenume"));
            user_con.setLast_name_user(res2.getString("nume"));
            user_con.setPassword(res2.getString("parola"));

            stat_info.close();

            PreparedStatement stat = null;
            stat = con.prepareStatement(query);
            stat.setString(1,email);
            ResultSet rs = stat.executeQuery();
            rs.next();
            id_user= rs.getInt(1);

            stat.close();
            this.id_user = id_user;
            user_con.setId_user(id_user);


            PreparedStatement stm = con.prepareStatement(query1);
            stm.setInt(1,user_con.getId_user());
            ResultSet rss = stm.executeQuery();
            String[] listaIN = new String[10] ;
            String[] listaS = new String[10] ;
            String[] listaD = new String[10] ;
            String[] listaU = new String[10] ;
            int s = 0;
            int i = 0;
            int u = 0;
            int d = 0;
            while (rss.next()) {

                switch (rss.getString(1)) {
                    case "select" -> {

                        listaS[s] = rss.getString(2);
                         s++;
                    }
                    case "insert" -> {

                        listaIN[i] = rss.getString(2);
                        i++;
                        if (!user_con.isInsert()) user_con.setInsert(true);
                    }
                    case "update" -> {

                        listaU[u] = rss.getString(2);
                        u++;
                        if (!user_con.isUpdate()) user_con.setUpdate(true);
                    }
                    case "delete" -> {

                        listaD[d] = rss.getString(2);
                        d++;
                        if (!user_con.isDelete()) user_con.setDelete(true);
                    }
                }
            }
            user_con.setDelete_table(listaD);
            user_con.setSelect_table(listaS);
            user_con.setInsert_table(listaIN);
            user_con.setUpdate_table(listaU);

            stm.close();

            email_info.setPromptText(user_con.getEmail_user());
            last_name_info.setPromptText(user_con.getLast_name_user());
            first_name_info.setPromptText(user_con.getFirst_name_user());
            System.out.println(user_con.getEmail_user());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        if (id_user == -1) {
            System.out.println("eroare!");
        }
        funct f = new funct();

        insert_trip.setVisible(f.validationPriv(user_con,"insert","cursa"));
        insert_promotion.setVisible(f.validationPriv(user_con,"insert","tarife"));
        insert_train.setVisible(f.validationPriv(user_con,"insert","tren"));

        change_promotion12.setVisible(f.validationPriv(user_con,"update","tarife"));
        change_train12.setVisible(f.validationPriv(user_con,"update","tren"));
        change_trip12.setVisible(f.validationPriv(user_con,"update","cursa"));
        if(f.validationPriv(user_con,"update","cursa") || f.validationPriv(user_con,"update","tren") || f.validationPriv(user_con,"update","tarife") )
        change.setVisible(true);
        else
            change.setVisible(false);

        if(f.validationPriv(user_con,"insert","cursa") || f.validationPriv(user_con,"insert","tarife") || f.validationPriv(user_con,"insert","tren"))
        insert.setVisible(true);
        else
            insert.setVisible(false);
        System.out.println(f.validationPriv(user_con,"insert","cursa") || f.validationPriv(user_con,"insert","tarife") || f.validationPriv(user_con,"insert","tren"));
    }

    public void backIsPushed(ActionEvent event) throws IOException{
        funct  f = new funct();
       f.changeScreen("login_form.fxml",event);
    }

    public void updateModTrain(){
        try{
            Connection con = MySQLJDBCUtil.getConnection();
            trainlist1.removeAll(trainlist1);
            trainsFromDataBase(con,trainlist1);


            train_id_col1.setCellValueFactory(new PropertyValueFactory<>("id_tr"));
            train_type_col1.setCellValueFactory(new PropertyValueFactory<>("tip"));
            train_status_col1.setCellValueFactory(new PropertyValueFactory<>("status"));
            max_c1_col1.setCellValueFactory(new PropertyValueFactory<>("nr_cls1"));
            max_c2_col1.setCellValueFactory(new PropertyValueFactory<>("nr_cls2"));


        }catch (Exception ex){
            ex.printStackTrace();
        }

        table_train1.setItems(trainlist1);
    }
    public void updateModPromo(){
        try{
            Connection con = MySQLJDBCUtil.getConnection();
            promolist1.removeAll(promolist1);
            tarifeFromDataBase(con,promolist1);
            promo_type_col1.setCellValueFactory(new PropertyValueFactory<>("promo_type"));
            amount_col1.setCellValueFactory(new PropertyValueFactory<>("promo_amount"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        mod_promotion.setItems(promolist1);
    }

    public  void updateModTrip(){
        try{
            Connection con = MySQLJDBCUtil.getConnection();

            triplist1.removeAll(triplist1);
            tripsFromDataBase(con,triplist1);

            table_eta_col1.setCellValueFactory(new PropertyValueFactory<>("trip_eta"));
            table_etd_col1.setCellValueFactory(new PropertyValueFactory<>("trip_etd"));
            table_std_col1.setCellValueFactory(new PropertyValueFactory<>("trip_std"));
            table_sta_col1.setCellValueFactory(new PropertyValueFactory<>("trip_sta"));
            table_date_col1.setCellValueFactory(new PropertyValueFactory<>("trip_date"));
            table_train_id_col1.setCellValueFactory(new PropertyValueFactory<>("trip_id_train"));



        }catch (Exception ex){
            ex.printStackTrace();
        }
        trip_table1.setItems(triplist1);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] table=new String[10];
        funct f=new funct();
        user_con = new UserPriv(id_user);
        succes.setVisible(false);
        try{
            Connection con = MySQLJDBCUtil.getConnection();
            tarifeFromDataBase(con,promolist);
            tripsFromDataBase(con,triplist);
            trainsFromDataBase(con,trainlist);
            fillListFromDataBase(con,list);

            promo_type_col.setCellValueFactory(new PropertyValueFactory<>("promo_type"));
            amount_col.setCellValueFactory(new PropertyValueFactory<>("promo_amount"));

            table_eta_col.setCellValueFactory(new PropertyValueFactory<>("trip_eta"));
            table_etd_col.setCellValueFactory(new PropertyValueFactory<>("trip_etd"));
            table_std_col.setCellValueFactory(new PropertyValueFactory<>("trip_std"));
            table_sta_col.setCellValueFactory(new PropertyValueFactory<>("trip_sta"));
            table_date_col.setCellValueFactory(new PropertyValueFactory<>("trip_date"));
            table_train_id_col.setCellValueFactory(new PropertyValueFactory<>("trip_id_train"));

            train_id_col.setCellValueFactory(new PropertyValueFactory<>("id_tr"));
            train_type_col.setCellValueFactory(new PropertyValueFactory<>("tip"));
            train_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
            max_c1_col.setCellValueFactory(new PropertyValueFactory<>("nr_cls1"));
            max_c2_col.setCellValueFactory(new PropertyValueFactory<>("nr_cls2"));



        }catch (Exception ex){
            ex.printStackTrace();
        }
        to_combo.setItems(list);
        from_combo.setItems(list);
        promotion.setItems(promolist);
        promotion.refresh();
        trip_table.setItems(triplist);
        table_train.setItems(trainlist);


        //
        updateModTrain();
        updateModTrip();
        updateModPromo();
        //


        //  insert.setDisable(!f.validationPriv(user_con,"update","tren"));
       // initUser();


    }
}
