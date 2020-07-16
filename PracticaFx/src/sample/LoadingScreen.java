package sample;

import animatefx.animation.Bounce;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreen implements Initializable {

    @FXML
     Circle circle1;

    @FXML
     Circle circle2;

    @FXML
     Circle circle3;
    @FXML
    AnchorPane glass;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        new Bounce(circle1).setCycleCount(100).setDelay(Duration.valueOf("100ms")).play();
        new Bounce(circle2).setCycleCount(100).setDelay(Duration.valueOf("1000ms")).play();
        new Bounce(circle3).setCycleCount(100).setDelay(Duration.valueOf("500ms")).play();



    }
}

