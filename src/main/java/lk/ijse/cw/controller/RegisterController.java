package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.bo.custom.RegisterBO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.view.tdm.ProgramTM;
import lk.ijse.cw.view.tdm.RegisterTM;
import lk.ijse.cw.view.tdm.StudentTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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
    private TableColumn<?, ?> txtBal;

    @FXML
    private DatePicker dtDate;

    @FXML
    private Label duration;

    @FXML
    private JFXComboBox<String> sltProgram;

    @FXML
    private JFXComboBox<String> sltStatus;

    @FXML
    private TableView<RegisterTM> tblCart;

    @FXML
    private TextField txtBalance;

    @FXML
    private Label txtCordinator;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtNIC;

    @FXML
    private Label  txtProgrmID;

    @FXML
    private TextField txtRegFee;

    @FXML
    private TextField txtRegID;

    @FXML
    private Label txtfee;

    @FXML
    private Label txtstuName;



     StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);
     ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Course);
     RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Register);



    public void initialize(){
        getCourseNames();
        setSltStatus();
        generateNewID();
        loadAllProgram();
        setCellVslues();
        balanceCalculate();
        StatusChange();
        ShowSelectedSTUDetails();

/*        setupRowSelectionListener();*/

    }





    private void clearField(){
        txtBalance.setText("");
        txtCordinator.setText("");
        txtNIC.setText("");
        txtProgrmID.setText("");
        txtfee.setText("");
        txtRegFee.setText("");
        txtstuName.setText("");
        sltProgram.setValue("");
        sltStatus.setValue("");
        dtDate.setValue(null);
        duration.setText("");
        txtRegID.setText("");
    }


    private void StatusChange() {
        sltStatus.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Complete".equals(newValue)) {
                txtBalance.setText("0.00");
            }
        });
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





    private void ShowSelectedSTUDetails(){
        RegisterTM selectedVal = tblCart.getSelectionModel().getSelectedItem();
        tblCart.setOnMouseClicked(event -> ShowSelectedSTUDetails());

        if (selectedVal != null) {
            txtNIC.setText(selectedVal.getStudent().getNIC());
            txtRegID.setText(selectedVal.getRid());
            txtProgrmID.setText(selectedVal.getProgram().getCId());
            sltProgram.setValue(selectedVal.getProgram().getCName());
            duration.setText(selectedVal.getProgram().getDuration());
            txtfee.setText(String.valueOf(selectedVal.getProgram().getFee()));
            txtstuName.setText(selectedVal.getStudent().getName());
            txtCordinator.setText(String.valueOf(selectedVal.getStudent().getUser()));
            txtRegFee.setText(String.valueOf(selectedVal.getRegisterFee()));
            txtBalance.setText(String.valueOf(selectedVal.getBalance()));
            dtDate.setValue(selectedVal.getDate());
            sltStatus.setValue(selectedVal.getPaymentStatus());

        }

    }






    private void balanceCalculate(){
        try {

            double programFee = txtfee.getText().isEmpty() ? 0.0 : Double.parseDouble(txtfee.getText());
            double regFee = txtRegFee.getText().isEmpty() ? 0.0 : Double.parseDouble(txtRegFee.getText());
            double balance = programFee - regFee;
            txtBalance.setText(String.format("%.2f", balance));

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numbers for the fees.");
            alert.showAndWait();
        }
    }


    @FXML
    void onBalance(ActionEvent event) {
           balanceCalculate();
    }


    private void loadAllProgram() {
        ObservableList<RegisterTM> list = FXCollections.observableArrayList();

        try {
            List<RegisterDTO> regDTOList = registerBO.getAll();
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

            tblCart.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private void getCourseNames() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<String> nameList = programBO.getProgramrNames();

        for (String name : nameList) {
            obList.add(name);
        }
        sltProgram.setItems(obList);

    }

    private void generateNewID() {
        try {
            String nextRegId = registerBO.generateNewID();

            txtRegID.setText(String.valueOf(nextRegId));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBuy(ActionEvent event){

        String rId = txtRegID.getText();
        String NIC = txtNIC.getText();
        String pId = txtProgrmID.getText();
        LocalDate date = dtDate.getValue();
        Double registerFee = Double.parseDouble(txtRegFee.getText());
        Double balance = Double.parseDouble(txtBalance.getText());
        String status =  sltStatus.getValue();

        StudentDTO studentDTO = new StudentDTO(NIC);
        ProgramDTO programDTO = new ProgramDTO(pId);

        RegisterDTO registerDTO = new RegisterDTO(rId,studentDTO,programDTO,date,registerFee,balance,status);

        boolean idRegisterd = registerBO.Register(registerDTO);

        if (idRegisterd) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Registration is done");
            alert.showAndWait();
            clearField();
            generateNewID();
            loadAllProgram();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Registration is not done");
            alert.showAndWait();
        }

    }
    @FXML
    void programNameOnAction(ActionEvent event) {

        String cname = sltProgram.getValue();
        List<ProgramDTO> cList = programBO.SearchByProgramName(cname);
        if (!cList.isEmpty()) {

            ProgramDTO courseModle =cList.get(0);
            txtProgrmID.setText(courseModle.getCId());
            duration.setText(courseModle.getDuration());
            txtfee.setText(String.valueOf(courseModle.getFee()));
        }
    }

    void setSltStatus() {
        ObservableList<String> list = FXCollections.observableArrayList("Complete", "Pending", "Incomplete");
        sltStatus.setItems(list);
    }


    @FXML
    void NicOnAction(ActionEvent event) {
        String nic = txtNIC.getText().trim();


        List<StudentDTO> cList = studentBO.SearchByNICstName(nic);
        if (!cList.isEmpty()) {

            StudentDTO stmodel =cList.get(0);
              txtstuName.setText(stmodel.getName());
              txtCordinator.setText(String.valueOf(stmodel.getUser().getUID()));
        }

        if (!nic.isEmpty()) {
            try {
                List<RegisterDTO> regList = registerBO.getRegisterationByNIC(nic);
                if (!regList.isEmpty()) {
                    tblCart.getItems().clear();
                    loadRegister(regList);
                    System.out.println(regList);
                } else {
                    tblCart.getItems().clear();
                    new Alert(Alert.AlertType.INFORMATION, "No payments found for the provided NIC.").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Error occurred while fetching payments: " + e.getMessage()).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please enter a NIC.").show();
        }

    }


    private void loadRegister(List<RegisterDTO> regList) {
        tblCart.getItems().clear();
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
            tblCart.getItems().add(registerTM);
        }
    }

    void clear(){
        txtRegID.setText("");
        txtNIC.setText("");
        txtProgrmID.setText("");
        dtDate.setValue(null);
        txtRegFee.setText("");
        txtBalance.setText("");
        sltStatus.setValue("");
    }


    @FXML
    void update(ActionEvent event) {
        String rid = txtRegID.getText();
        String nic = txtNIC.getText();
        String pid = txtProgrmID.getText();
        LocalDate date = dtDate.getValue();
        Double regfee = Double.valueOf(txtRegFee.getText());
        Double balance = Double.valueOf(txtBalance.getText());
        String status = sltStatus.getValue();

        StudentDTO student = new StudentDTO(nic);
        ProgramDTO program = new ProgramDTO(pid);
        RegisterDTO register = new RegisterDTO(rid,student,program,date,regfee,balance,status);



        System.out.println(register);

        boolean isUpdate = registerBO.update(register);

        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION,"Registered Student has been updated successfully").show();
            loadAllProgram();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        clearField();
    }
}


