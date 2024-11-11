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
import lk.ijse.cw.config.FactoryConfiguration;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtuID;

    private LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Login);

    // Temporary login credentials for testing purposes
    private final String temporaryUserName = "admin";
    private final String temporaryPassword = "admin";

    @FXML
    public void initialize() {
        clickEnterButtonMoveCursor();
    }

    @FXML
    private void btnLogin(ActionEvent event) {
        String userName = txtuID.getText();
        String password = txtPass.getText();

        try {
            if (userName.equals(temporaryUserName) && password.equals(temporaryPassword)) {
                // Temporary login setup
                UserSession.getInstance().setUser(123, "admin");
                navigateToTheDashboard((Stage) txtuID.getScene().getWindow());
            } else {
                // Check credentials using the LoginBO
                LoginDTO loginDTO = new LoginDTO(userName, password);
                boolean loginResult = loginBO.checkCredential(loginDTO);

                if (loginResult) {
                    navigateToTheDashboard((Stage) txtuID.getScene().getWindow());
                } else {
                    // Show alert if credentials are incorrect
                    new Alert(Alert.AlertType.ERROR, "Invalid credentials! Please try again.").show();
                }
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An error occurred while processing your request.").show();
        }
    }

    // Setup enter button action to move cursor between fields
    private void clickEnterButtonMoveCursor() {
        txtuID.setOnAction(event -> txtPass.requestFocus());
        txtPass.setOnAction(this::btnLogin);
    }

    // Method to navigate to the dashboard
    private void navigateToTheDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_forms/dahsboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
