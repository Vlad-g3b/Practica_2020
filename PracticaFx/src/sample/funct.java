package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class funct {
    private double xOffset = 0;
    private double yOffset = 0;
    private UserPriv user;
    public boolean validationPriv(UserPriv user_con ,String priv,String tab ){
        switch (priv) {
            case "select" -> {
                if(user_con.isSelect() ){
                    for(String i : user_con.getSelect_table()){
                         if( tab.equals(i)){
                                return true;
                         }
                    }
                }
            return false;}
            case "insert" -> {
                if(user_con.isInsert() ){
                    for(String i : user_con.getInsert_table()){
                        if( tab.equals(i)){
                            return true;
                        }
                    }
                }
                return false;
            }
            case "update" -> {
                if(user_con.isUpdate() ){
                    for(String i : user_con.getUpdate_table()){
                        if( tab.equals(i)){
                            return true;
                        }
                    }
                }
                return false;
            }
            case "delete" -> {
                if(user_con.isDelete() ){
                    for(String i : user_con.getDelete_table()){
                        if( tab.equals(i)){
                            return true;
                        }
                    }
                }
                return false; }
        }
   return false; }



    public void validationTextField(JFXTextField field){

        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        field.getValidators().add(validator);
        field.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) field.validate();
        });


    }
    public  void validatioPasswordField(JFXPasswordField pass){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        pass.getValidators().add(validator);
        pass.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) pass.validate();
        });
    }




    public   void changeScreen(String file, ActionEvent event) throws IOException {
        Parent newScreen = FXMLLoader.load(getClass().getResource(file));
        Scene newScene = new Scene(newScreen);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();


        newScreen.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        newScreen.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });

        window.setScene(newScene);
        window.show();
    }
    public void newScene(String file)throws IOException{
        Parent root;
        try {
            Stage reg = new Stage();
            root = FXMLLoader.load(getClass().getResource(file));




            Scene scene = new Scene(root);
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
                    reg.setX(event.getScreenX() - xOffset);
                    reg.setY(event.getScreenY() - yOffset);
                }
            });
            reg.setScene(scene);
            reg.initStyle(StageStyle.UNDECORATED);
            reg.initModality(Modality.APPLICATION_MODAL);
            reg.showAndWait();

            //reg.show();
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
