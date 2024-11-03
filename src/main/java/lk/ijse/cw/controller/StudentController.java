package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.entity.User;

import java.time.LocalDate;

public class StudentController {
    @FXML
    private DatePicker DpBDay;

    @FXML
    private AnchorPane ancStu;

    @FXML
    private TableColumn<?, ?> colAdrs;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colMail;

    @FXML
    private TableColumn<?, ?> colNIc;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXComboBox<String> drpGender;

    @FXML
    private TableView<?> tblStu;

    @FXML
    private TextField txtAdrs;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtCid;


    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.User);


    public void initialize() {
        setCmbGender();
    }


    @FXML
    void btnClr(ActionEvent event) {

    }

    @FXML
    void btnDlt(ActionEvent event) {

    }

    @FXML
    void btnSave(ActionEvent event) {

        String nic = txtNIC.getText();
        String uid = txtCid.getText();
        String name = txtName.getText();
        String email = txtMail.getText();
        String adr = txtAdrs.getText();
        LocalDate bday = DpBDay.getValue();
        int tel = Integer.parseInt(txtTel.getText());
        String gender = drpGender.getValue().toString();

        System.out.println("uid"+uid);

        UserDTO user = new UserDTO(uid);
        StudentDTO student = new StudentDTO(nic, user, name, email, adr, bday, tel, gender);

        boolean isSaved = studentBO.saveStu(student);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION,"User has been registered successfully").show();
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }





    public void setCmbGender(){
        ObservableList<String> list = FXCollections.observableArrayList("Male","Female");
        drpGender.setItems(list);
    }
}
