package sample;

import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable{

    @FXML
    private Label error_1;

    @FXML
    private JFXTextField user;
    @FXML
    private JFXButton login_b;
    @FXML
    private JFXButton login_bc;
    @FXML
    private JFXButton close_btn;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField password_cl;
    @FXML
    private JFXTextField user_cl;
    @FXML
    private JFXButton reg_now;

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    private int id_usr;

    private UserPriv user_con;
    private double xOffset= 0;
    private double yOffset= 0;
    public void close_btnIsPushed(ActionEvent event) throws IOException{
        System.exit(0);
    }

    public void reg_nowIsPushed(ActionEvent event) throws IOException{
       funct f = new funct();

       f.newScene("regForm.fxml");
    }


    public void login_bcIsPushed(ActionEvent event) throws IOException {
        System.out.println(user_cl.getText());
        System.out.println((password_cl.getText()));
       Boolean connected ;
       connected = false;
       String query ="Select parola FROM client where email = ?;";
       PreparedStatement stm = null;
        try{
            Connection con =MySQLJDBCUtil.getConnection();
            if (con !=null){
                System.out.println("Connection to database successful!");
                stm = con.prepareStatement(query);
                stm.setString(1,user_cl.getText());
                ResultSet rs =stm.executeQuery();

                if(rs.next()){
                    if(rs.getString(1).equals(MD5.getMd5(password_cl.getText()))){
                    connected = true;}

                }
                else {
                    System.out.println("This email doesn't exeist!");
                }
            }


        }catch (SQLException f) {
            System.out.println("eroare la conectare!");
            System.out.println(f);
            System.out.println(f.getErrorCode());
        }
        if (connected){

            adminScreen user = new adminScreen();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("adminScreen.fxml"));
            Parent clientSceneParent = loader.load();
            Scene clientScene = new Scene(clientSceneParent);
            adminScreen controller  = loader.getController();
            //    String text = user_cl.getText();
             //   System.exit(0);
                controller.initUser(user_cl.getText());

            Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(clientScene);
            clientSceneParent.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            clientSceneParent.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window.setX(event.getScreenX() - xOffset);
                    window.setY(event.getScreenY() - yOffset);
                }
            });
          //  funct f = new funct();
          //  f.newScene("loadingScreen.fxml");
            window.show();

            //funct f = new funct();
           // f.changeScreen("adminScreen.fxml",event);

        }
        else{
            error_1.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(5)
            );
            visiblePause.setOnFinished(
                    eventlabel -> error_1.setVisible(false)
            );
            visiblePause.play();

        }
    }
/*
    public void login_bIsPushed(ActionEvent event) throws IOException {

        try{
            Connection con =MySqlConnection.getConnection(user.getText(), new String(password.getText()));
            if (con !=null){
                System.out.println("Connection successful!");

            }
        }catch (SQLException f){
            System.out.println("eroare la conectare!");
            System.out.println(f);
            System.out.println(f.getErrorCode());
            //error code 1045 = informatii gresite
            if (f.getErrorCode()==1045){
               System.out.println("Incorrect User or Password!");

            }else {
               System.out.println("Error!");
            }

        }


    }
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(user_cl.getText());
      RequiredFieldValidator validator = new RequiredFieldValidator();
       validator.setMessage("Input Required");
        user_cl.getValidators().add(validator);
        user_cl .focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) user_cl.validate();
        });
        RequiredFieldValidator validator1= new RequiredFieldValidator();
        validator1.setMessage("Input Required");
        password_cl.getValidators().add(validator1);
        password_cl .focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) password_cl.validate();
        });
    }
}
