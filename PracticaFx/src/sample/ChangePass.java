package sample;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.animation.PauseTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.management.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.ResourceBundle;

import static sample.Controller.*;
public class ChangePass implements Initializable {



    @FXML
    private JFXPasswordField old_password;

    @FXML
    private JFXPasswordField new_password;

    @FXML
    private JFXPasswordField conf_new_password;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXButton cancel;

    private UserPriv user_con;

    @FXML
    void cancelIsPushed(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void submitIsPushed(ActionEvent event) {
            System.out.println(user_con.getEmail_user() + "  " + user_con.getFirst_name_user());

            if (user_con.getPassword().equals(MD5.getMd5(old_password.getText()))){
                if(new_password.getText().equals(conf_new_password.getText())){
                    user_con.setPassword(MD5.getMd5(new_password.getText()));

                    String query="Update client set parola = ? where email = ? ;";

                    try {
                        Connection con = MySQLJDBCUtil.getConnection();
                        PreparedStatement stm = con.prepareStatement(query);
                        stm.setString(1,user_con.getPassword());
                        stm.setString(2,user_con.getEmail_user());
                        stm.execute();
                        stm.close();
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Password changed successful!");
                    alert.showAndWait();
                    if(!alert.isShowing()) {
                        Stage stage = (Stage) submit.getScene().getWindow();
                        stage.close();
                    }
                }
                else{
                    new Alert(Alert.AlertType.ERROR, "Password doesn't match!").showAndWait();

                }
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Not your password!").showAndWait();

            }



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void passUser(UserPriv user){
        this.user_con = user;
    }

}
