package lk.ijse.cw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProgrammeController {



    @FXML
    private AnchorPane ancCourse;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> tblCourse;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtname;

    @FXML
    void btnClr(ActionEvent event) {

    }

    @FXML
    void btnDlt(ActionEvent event) {

    }

    @FXML
    void btnSave(ActionEvent event) {

        String id = txtID.getText();
        String name = txtname.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }
}
