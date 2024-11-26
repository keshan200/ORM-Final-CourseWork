package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.util.Regex;
import lk.ijse.cw.util.TxtField;
import lk.ijse.cw.view.tdm.StudentTM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    private TableView<StudentTM> tblStu;

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
        ClearFields();
        loadAllStudents();
        setCellVslues();
        ShowSelectedSTUDetails();
    }



    private void setCellVslues(){
        colNIc.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAdrs.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));

    }


    private void ShowSelectedSTUDetails(){
        StudentTM selectedVal = tblStu.getSelectionModel().getSelectedItem();
        tblStu.setOnMouseClicked(event -> ShowSelectedSTUDetails());

        if (selectedVal != null) {
          txtNIC.setText(selectedVal.getNIC());
          txtName.setText(selectedVal.getName());
          txtAdrs.setText(selectedVal.getAddress());
          txtCid.setText(String.valueOf(selectedVal.getUser().getUID()));
          txtTel.setText(String.valueOf(selectedVal.getTel()));
          txtMail.setText(selectedVal.getEmail());
          drpGender.setValue(selectedVal.getGender());
          DpBDay.setValue(selectedVal.getBday());

        }
    }


    public void loadAllStudents() {

        ObservableList<StudentTM> list = FXCollections.observableArrayList();

        try {
            List<StudentDTO> studentDTOList = studentBO.getStudents();
            for (StudentDTO studentDTO : studentDTOList) {

                StudentTM studentTM = new StudentTM(
                        studentDTO.getNIC(),
                        studentDTO.getUser(),
                        studentDTO.getName(),
                        studentDTO.getEmail(),
                        studentDTO.getAddress(),
                        studentDTO.getBday(),
                        studentDTO.getTel(),
                        studentDTO.getGender()
                );
                list.add(studentTM);

            }
            tblStu.setItems(list);

            System.out.println("list"+list);
        }catch (Exception e) {

        }
    }



    @FXML
    void btnClr(ActionEvent event) {
          ClearFields();
    }

    @FXML
    void btnDlt(ActionEvent event) {

        String NIC = txtNIC.getText();

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this student?");
        confirmationAlert.setHeaderText("Confirmation");
        confirmationAlert.setContentText("Are you sure you want to delete the student with NIC: " + NIC + "?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                if (studentBO.deleteStu(NIC)) {
                    new Alert(Alert.AlertType.INFORMATION, "Student deleted successfully!").show();
                    ClearFields();
                    loadAllStudents();
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
        if (isValid()){
            new Alert(Alert.AlertType.INFORMATION, "Incorrect.!Check Fields").show();
        }else {
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION,"User has been registered successfully").show();
            loadAllStudents();
            ClearFields();
        }}
    }

    @FXML
    void btnUpdate(ActionEvent event) {
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

        System.out.println("sty"+student);

        boolean isUpdated = studentBO.updateStu(student);

        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION,"Student has been updated successfully").show();
            ClearFields();
            loadAllStudents();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }

    }


    private void ClearFields() {

        txtNIC.setText("");
        txtCid.setText("");
        txtName.setText("");
        txtMail.setText("");
        txtAdrs.setText("");
        txtTel.setText("");
        DpBDay.setValue(null);
        drpGender.setValue(null);

    }



    public void setCmbGender(){
        ObservableList<String> list = FXCollections.observableArrayList("Male","Female");
        drpGender.setItems(list);
    }


    @FXML
    void telOnKeyRelaase(javafx.scene.input.KeyEvent event) {
        Regex.setTextColor(TxtField.TEL,txtTel);
    }


    public boolean isValid(){
        boolean telValid =  Regex.setTextColor(TxtField.TEL,txtTel);

        return telValid;
    }
}
