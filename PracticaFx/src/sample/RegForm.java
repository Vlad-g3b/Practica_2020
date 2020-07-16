package sample;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import  java.util.Random;
import  java.sql.*;

public class RegForm implements Initializable {

    @FXML
    private JFXButton reg_close_btn;
    @FXML
    private JFXPasswordField pass_r;
    @FXML
    private JFXPasswordField conf_pass;
    @FXML
    private JFXTextField email_r;
    @FXML
    private JFXTextField first_n;
    @FXML
    private JFXTextField last_n;
    @FXML
    private JFXButton reg_btn;
    @FXML
    private Label error;


    public void reg_close_btnIsPushed(ActionEvent event){
        Stage stage = (Stage) reg_close_btn.getScene().getWindow();
        stage.close();
    }

    public void reg_btnIsPushed(ActionEvent event) throws IOException, SQLException {
        String deffn = "Anonymous";
        String defln = "";
        if(!email_r.getText().isEmpty() && !pass_r.getText().isEmpty() && !conf_pass.getText().isEmpty()  ) {
            Connection conn = null;
            System.out.println(pass_r.getText() + "  " + conf_pass.getText());
            if (pass_r.getText().equals(conf_pass.getText())) {
                String query = "INSERT INTO client (email,parola,nume,prenume,data_creare,id_rol) Values(?,md5(?),?,?,?,2);";
                PreparedStatement stmt = null;
                PreparedStatement stm = null;

                try {
                    conn = MySQLJDBCUtil.getConnection();
                    conn.setAutoCommit(false);
                    String email = email_r.getText();
                    stmt = conn.prepareStatement(
                            "SELECT email FROM client where email = ?");
                    stm = conn.prepareStatement(query);
                    stmt.setString(1, email);


                    ResultSet rs = stmt.executeQuery();

                    Boolean recordAdded = false;
                    if (!rs.next()) {
                        recordAdded = true;
                    }
                    if (recordAdded) {

                        System.out.println("All good!");
                        Calendar calendar = Calendar.getInstance();
                        java.sql.Date timestamp = new java.sql.Date(calendar.getTime().getTime());
                        //   String query = "INSERT INTO client (email,parola,nume,prenume,data_creare,id_rol) Values(?,md5(?),?,?,?,2);";
                        //   PreparedStatement stm = conn.prepareStatement(query);
                        stm.setString(1, email_r.getText());
                        stm.setString(2, pass_r.getText());
                        stm.setString(3, last_n.getText());
                        stm.setString(4, first_n.getText());
                        stm.setDate(5, timestamp);

                        stm.execute();
                        conn.commit();
                        System.out.println("Inregistrat cu succes!" + " " + timestamp);
                        Stage stage = (Stage) reg_btn.getScene().getWindow();
                        stage.close();
                    } else {
                        error.setText("This email already exists!");
                        System.out.println("email already exists");
                    }
                } catch (Exception ex) {
                    System.out.println("Couldn't connect to the database!");
                    System.out.println(ex);
                } finally {
                    if (stm != null) {
                        stm.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                    conn.setAutoCommit(true);
                }
            } else {
                System.out.println("Password doesn't match!");
            }
        }else {
            error.setText("Please fill all the required fields.");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        funct f = new funct();

        f.validationTextField(email_r);
        f.validatioPasswordField(pass_r);
        f.validatioPasswordField(conf_pass);
    }
}
