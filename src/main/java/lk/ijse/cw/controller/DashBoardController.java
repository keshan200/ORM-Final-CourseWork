package lk.ijse.cw.controller;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cw.entity.UserSession;

import java.io.IOException;

public class DashBoardController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane ancMain;

    @FXML
    private Label lblName;

    @FXML
    private Label lblRole;


    @FXML
    private Button btnPro;

    @FXML
    private Button btnUser;


    String uid = String.valueOf(UserSession.getInstance().getUserId());
    String role =UserSession.getInstance().getRole();



    public void initialize() {

        PauseTransition delay = new PauseTransition(Duration.seconds(0.0001));
        delay.setOnFinished(event -> loadMainDashboard());
        delay.play();


        checkLoggedUser();
    }

    private void checkLoggedUser() {
            if(role.equals("Admin Cordinator")) {
                btnUser.setVisible(false);
                btnPro.setVisible(false);
            }
    }



    private void loadMainDashboard(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/dashboard_middleAnc.fxml"));
            AnchorPane mainDashboard = fxmlLoader.load();

            ancMain.getChildren().setAll(mainDashboard);
            Stage stage = (Stage) ancMain.getScene().getWindow();
            stage.setTitle("Dashboard");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/dashboard_middleAnc.fxml"));
        Parent load1 = fxmlLoader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load1);

    }



    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/login_form.fxml"));
        Parent load1 = fxmlLoader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load1);
    }

    @FXML
    void btnPrgrm(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/programme_form.fxml"));
        Parent load1 = fxmlLoader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load1);

    }

    @FXML
    void btnReg(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/view_forms/register_form.fxml"));
        Parent load = fxmlLoader2.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

    }

    @FXML
    void btnSetting(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/user_reg_form.fxml"));
        Parent load = fxmlLoader.load();


        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }



    @FXML
    void btnStu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/student_form.fxml"));
        Parent load = fxmlLoader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }



}
