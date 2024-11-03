package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.entity.User;

public class UserRegController {


    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPass;

    @FXML
    private JFXComboBox<String> txtRole;

    @FXML
    private TextField txtuID;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.User);


    public void initialize() {
        setCmbRole();
    }

    @FXML
    void btnLogin(ActionEvent event) {

    }

    @FXML
    void btnSignUp(ActionEvent event) {

        String userID = txtuID.getText();
        String userPass = txtPass.getText();
        String mail = txtMail.getText();
        String name = txtName.getText();
        String role = txtRole.getValue();//combo


        UserDTO user = new UserDTO(userID, userPass, mail, name, role);

        boolean isSaved = userBO.saveUser(user);

        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION,"User has been registered successfully").show();

        }

    }



    public void setCmbRole(){
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Admin Cordinator","Manager");
        txtRole.setItems(list);
    }

}
