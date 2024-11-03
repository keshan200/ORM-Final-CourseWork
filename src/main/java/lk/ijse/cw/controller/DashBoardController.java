package lk.ijse.cw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardController {


    @FXML
    private AnchorPane ancMain;

    @FXML
    private Label lblName;

    @FXML
    private Label lblRole;



    @FXML
    void btnHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_forms/dahsboard.fxml"));
        Parent load1 = fxmlLoader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load1);

    }

    @FXML
    void btnLogout(ActionEvent event) {

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
