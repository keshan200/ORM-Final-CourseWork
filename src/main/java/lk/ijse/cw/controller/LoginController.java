/*
package lk.ijse.cw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.LoginBO;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.entity.UserSession;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtuID;





    String temporaryUserName = "admin";
    String temporaryPassword = "admin";


    LoginBO loginBO  = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Login);


    public void initialize() {
        clickEnterButtonMoveCursor();
    }

    @FXML
    void btnLogin(ActionEvent event) {
        Session session = FactoryConfiguration.getInstance().getSession();

        String userName= txtuID.getText();
        String password = txtPass.getText();

        try {
            if (userName.equals(temporaryUserName)  && password.equals(temporaryPassword)) {
                session = FactoryConfiguration.getInstance().getSession();
                UserSession.getInstance().setUser(123, "admin");
                navigateToTheDashboard((Stage) btnLogin().getScene().getWindow());


            } else {
                LoginDTO loginDTO = new LoginDTO(userName, password);

                boolean loginResult = loginBO.login(loginDTO);
                if (loginResult) {
                    navigateToTheDashboard((Stage).getScene().getWindow());

                } else {

                    new Alert(Alert.AlertType.ERROR, "Invalid credentials! Please try again.").show();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    void clickEnterButtonMoveCursor() {
        txtuID.setOnAction(event -> txtPass.requestFocus());
        txtPass.setOnAction(event -> {
            btnLogin(new ActionEvent());
        });
    }

    private void navigateToTheDashboard(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_forms/dahsboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
        stage.show();
    }

}
*/
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
import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.LoginBO;
import lk.ijse.cw.entity.UserSession;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtuID;

    private final String temporaryUserName = "1";
    private final String temporaryPassword = "1";

    private final LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Login);

    public void initialize() {
        clickEnterButtonMoveCursor();
    }

    @FXML
    void btnLogin(ActionEvent event) {
        String userName = txtuID.getText();
        String password = txtPass.getText();

        try {

            if (userName.equals(temporaryUserName) && password.equals(temporaryPassword)) {
                UserSession.getInstance().setUser(123, "admin");
                navigateToTheDashboard((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
            } else {
                LoginDTO loginDTO = new LoginDTO(userName, password);

                boolean loginResult = loginBO.login(loginDTO);
                if (loginResult) {
                    navigateToTheDashboard((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid credentials! Please try again.").show();
                }
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred while loading the dashboard.").show();
            e.printStackTrace();
        }
    }

    private void clickEnterButtonMoveCursor() {
        txtuID.setOnAction(event -> txtPass.requestFocus());
        txtPass.setOnAction(event -> btnLogin(new ActionEvent()));
    }


    private void navigateToTheDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_forms/dahsboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
        stage.show();
    }
}
