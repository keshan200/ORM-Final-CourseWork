package lk.ijse.cw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.bo.custom.StudentBO;

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



    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Course);

    @FXML
    void btnSave(ActionEvent event) {

        String id = txtID.getText();
        String name = txtname.getText();
        String duration = txtDuration.getText();
        Double fee = Double.valueOf(txtFee.getText());

        ProgramDTO programDTO = new ProgramDTO(id,name,duration,fee);
        boolean isSaved = programBO.saveProgram(programDTO);

        System.out.println("pDTO"+programDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION,"Course has been registered successfully").show();
        }

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }
}
