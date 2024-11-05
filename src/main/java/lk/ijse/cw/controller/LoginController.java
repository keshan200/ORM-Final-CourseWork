package lk.ijse.cw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtuID;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.User);

    @FXML
    void btnLogin(ActionEvent event) {


    }


    }

