package lk.ijse.cw.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.view.tdm.ProgramTM;
import lk.ijse.cw.view.tdm.StudentTM;

import java.util.List;
import java.util.Optional;

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
    private TableView<ProgramTM> tblCourse;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtname;


    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Course);


    public void initialize() {
        clear();
        loadAllProgram();
        setCellVslues();
        ShowSelectedVal();
    }


    private void clear(){
        txtID.clear();
        txtname.clear();
        txtFee.clear();
        txtDuration.clear();
    }



    private void setCellVslues(){
        colID.setCellValueFactory(new PropertyValueFactory<>("cId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("cName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }


    private void ShowSelectedVal(){
        ProgramTM selectedVal = tblCourse.getSelectionModel().getSelectedItem();
        tblCourse.setOnMouseClicked(event -> ShowSelectedVal());

        if (selectedVal != null) {
            txtID.setText(selectedVal.getCId());
            txtname.setText(selectedVal.getCName());
            txtDuration.setText(selectedVal.getDuration());
            txtFee.setText(String.valueOf(selectedVal.getFee()));
        }
    }



    private void loadAllProgram(){

        ObservableList<ProgramTM> list = FXCollections.observableArrayList();

        try {
            List<ProgramDTO> programDTOList = programBO.getProgram();
            for (ProgramDTO programDTO : programDTOList) {



                ProgramTM programTM = new ProgramTM(
                        programDTO.getCId(),
                        programDTO.getCName(),
                        programDTO.getDuration(),
                        programDTO.getFee()

                );
                list.add(programTM);
            }


            tblCourse.setItems(list);


        }catch (Exception e) {

        }
    }

    @FXML
    void btnClr(ActionEvent event) {
             clear();
    }

    @FXML
    void btnDlt(ActionEvent event) {
        String cID = txtID.getText();

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this Program?");
        confirmationAlert.setHeaderText("Confirmation");
        confirmationAlert.setContentText("Are you sure you want to delete the student with cID: " + cID + "?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                if (programBO.deleteProgram(cID)) {
                    new Alert(Alert.AlertType.INFORMATION, "Program deleted successfully!").show();
                    clear();
                    loadAllProgram();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
            }
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Deletion canceled.").show();
        }

    }



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
            loadAllProgram();
            clear();
        }

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }
}
