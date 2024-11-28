package lk.ijse.cw.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.bo.custom.RegisterBO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.view.tdm.RegisterTM;

import java.sql.SQLException;
import java.util.List;

public class PaymentController {

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDate1;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colFee1;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colNic1;

    @FXML
    private TableColumn<?, ?> colPid;

    @FXML
    private TableColumn<?, ?> colPid1;

    @FXML
    private TableColumn<?, ?> colRegID;

    @FXML
    private TableColumn<?, ?> colRegID1;

    @FXML
    private TableColumn<?, ?> colStuts;

    @FXML
    private TableColumn<?, ?> colStuts1;

    @FXML
    private TableView<RegisterTM> tblPay;

    @FXML
    private TableView<RegisterTM> tblPay1;

    @FXML
    private TableColumn<?, ?> txtBal;

    @FXML
    private TableColumn<?, ?> txtBal1;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtPayrmtn;




    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Course);
    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Register);



    public void initialize() {
        loadAllProgram();
        setCellVslues();
        setCellVslues2();
    }

    @FXML
    void btNIC(ActionEvent event) {
        String nic = txtNIC.getText().trim();


        List<StudentDTO> cList = studentBO.SearchByNICstName(nic);
        if (!cList.isEmpty()) {
        }

        if (!nic.isEmpty()) {
            try {
                List<RegisterDTO> regList = registerBO.getRegisterationByNIC(nic);
                if (!regList.isEmpty()) {
                    tblPay1.getItems().clear();
                    loadRegister(regList);
                    System.out.println(regList);
                } else {
                    tblPay1.getItems().clear();
                    new Alert(Alert.AlertType.INFORMATION, "No payments found for the provided NIC.").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Error occurred while fetching payments: " + e.getMessage()).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please enter a NIC.").show();
        }
    }

    private void loadAllProgram() {
        ObservableList<RegisterTM> list = FXCollections.observableArrayList();

        try {
            List<RegisterDTO> regDTOList = registerBO.getPendingPayments();
            for (RegisterDTO reg : regDTOList) {
                RegisterTM registerTM = new RegisterTM(
                        reg.getRid(),
                        reg.getStudent(),
                        reg.getProgram(),
                        reg.getDate(),
                        reg.getRegisterFee(),
                        reg.getBalance(),
                        reg.getPaymentStatus()
                );
                list.add(registerTM);
            }

            tblPay.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setCellVslues(){
        colRegID.setCellValueFactory(new PropertyValueFactory<>("Rid"));
        colPid.setCellValueFactory(new PropertyValueFactory<>("programCID"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("studentNIC"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("RegisterFee"));
        colStuts.setCellValueFactory(new PropertyValueFactory<>("PaymentStatus"));
        txtBal.setCellValueFactory(new PropertyValueFactory<>("Balance"));
    }


    @FXML
    void btnPay(ActionEvent event) {

    }


    private void loadRegister(List<RegisterDTO> regList) {
        tblPay1.getItems().clear();
        for (RegisterDTO reg : regList) {
            RegisterTM registerTM = new RegisterTM(
                    reg.getRid(),
                    reg.getStudent(),
                    reg.getProgram(),
                    reg.getDate(),
                    reg.getRegisterFee(),
                    reg.getBalance(),
                    reg.getPaymentStatus()
            );
            tblPay1.getItems().add(registerTM);
        }
    }

    private void setCellVslues2(){
        colRegID1.setCellValueFactory(new PropertyValueFactory<>("Rid"));
        colPid1.setCellValueFactory(new PropertyValueFactory<>("programCID"));
        colNic1.setCellValueFactory(new PropertyValueFactory<>("studentNIC"));
        colDate1.setCellValueFactory(new PropertyValueFactory<>("date"));
        colFee1.setCellValueFactory(new PropertyValueFactory<>("RegisterFee"));
        colStuts1.setCellValueFactory(new PropertyValueFactory<>("PaymentStatus"));
        txtBal1.setCellValueFactory(new PropertyValueFactory<>("Balance"));
    }
}
