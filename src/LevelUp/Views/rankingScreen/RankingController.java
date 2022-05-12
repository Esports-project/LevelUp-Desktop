package Esprit.Views.rankingScreen;

import Esprit.Services.ServiceClassement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RankingController implements Initializable {

    @FXML
    private VBox rankingList;

    @FXML
    private Pane rankingPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ServiceClassement sr = new ServiceClassement();
        sr.readClassements().forEach(classement -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ranking-item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                RankingItemController itemController = fxmlLoader.getController();
                itemController.setData(classement);
                rankingList.getChildren().add(anchorPane);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }



}