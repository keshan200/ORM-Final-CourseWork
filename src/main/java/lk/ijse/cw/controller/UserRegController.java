package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.entity.User;
import lk.ijse.cw.view.tdm.ProgramTM;
import lk.ijse.cw.view.tdm.UserTM;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

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

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<?, ?> colAccRole;

    @FXML
    private TableColumn<?, ?> colMail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUid;

    @FXML
    private TableView<UserTM> tblUser;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.User);


    public void initialize() {

        setCmbRole();
        loadAllUser();
        setCellVslues();
        ShowSelectedVal();
    }


    @FXML
    void btnSignUp(ActionEvent event) {

        String userID = txtuID.getText();
        String userPass = txtPass.getText();
        String mail = txtMail.getText();
        String name = txtName.getText();
        String role = txtRole.getValue();

        String hashedPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
        UserDTO user = new UserDTO(userID, hashedPass, mail, name, role);

        boolean isSaved = userBO.saveUser(user);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION,"User has been registered successfully").show();
            loadAllUser();
            clear();
        }else {
            new Alert(Alert.AlertType.ERROR,"User has not been registered successfully").show();
        }

    }

    @FXML
    void btnClear(ActionEvent event) {
     clear();
    }

    @FXML
    void btnDlt(ActionEvent event) {

    }


    private void loadAllUser(){
        ObservableList<UserTM> user = FXCollections.observableArrayList();
        List<UserDTO>userDto = userBO.getUsers();
        for (UserDTO userDTO : userDto) {
            user.add(new UserTM(userDTO.getUID(),userDTO.getName(),userDTO.getPassword(),userDTO.getEmail(),userDTO.getPassword()));
        }
        tblUser.setItems(user);
    }


    public void setCmbRole(){
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Admin Cordinator","Manager");
        txtRole.setItems(list);
    }


    private void setCellVslues(){
        colUid.setCellValueFactory(new PropertyValueFactory<>("uID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAccRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    }

    private void clear(){
        txtuID.setText("");
        txtName.setText("");
        txtMail.setText("");
        txtRole.setValue("");
        txtPass.setText("");
    }

    private void ShowSelectedVal(){
        UserTM selectedVal = tblUser.getSelectionModel().getSelectedItem();
        tblUser.setOnMouseClicked(event -> ShowSelectedVal());

        if (selectedVal != null) {
            txtuID.setText(selectedVal.getUID());
            txtName.setText(selectedVal.getName());
            txtMail.setText(selectedVal.getEmail());
            txtRole.setValue(selectedVal.getRole());
        }
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {

    }
}
