package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TableColumn<?, ?> colBalFee;

    @FXML
    private TableColumn<?, ?> colCid;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPid;

    @FXML
    private TableColumn<?, ?> colRegID;

    @FXML
    private TableColumn<?, ?> colStuts;

    @FXML
    private DatePicker dtDate;

    @FXML
    private TextField duration;

    @FXML
    private JFXComboBox<?> sltProgram;

    @FXML
    private JFXComboBox<?> sltStatus;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtCordinator;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtProgrmID;

    @FXML
    private TextField txtRegFee;

    @FXML
    private TextField txtRegID;

    @FXML
    private TextField txtname3;

    @FXML
    private TextField txtstuName;




    @FXML
    void btnAddCart(ActionEvent event) {

    }

    @FXML
    void btnBuy(ActionEvent event) {

    }
}
