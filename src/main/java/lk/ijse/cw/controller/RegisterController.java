package lk.ijse.cw.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.bo.BOFactory;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.bo.custom.RegisterBO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;

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
    private DatePicker dtDate;

    @FXML
    private TextField duration;

    @FXML
    private JFXComboBox<String> sltProgram;

    @FXML
    private JFXComboBox<String> sltStatus;

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
    private TextField txtfee;

    @FXML
    private TextField txtstuName;



     StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);
     ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Course);
     RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Register);



    public void initialize() {
        getCourseNames();
        setSltStatus();
    }



    private void getCourseNames() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<String> nameList = programBO.getProgramrNames();

        for (String name : nameList) {
            obList.add(name);
        }
        sltProgram.setItems(obList);

    }


    @FXML
    void btnBuy(ActionEvent event) {

        String rId = txtRegID.getText();
        String NIC = txtNIC.getText();
        String pId = txtProgrmID.getText();
        LocalDate date = dtDate.getValue();
        Double registerFee = Double.parseDouble(txtRegFee.getText());
        String status =  sltStatus.getValue();

        Student studentDTO = new Student(NIC);
        Program programDTO = new Program(pId);

        RegisterDTO registerDTO = new RegisterDTO(rId,studentDTO,programDTO,date,registerFee,status);

        boolean idRegisterd = registerBO.Register(registerDTO);

        if (idRegisterd) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Registration is done");
            alert.showAndWait();
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
        String nic = txtNIC.getText();

        List<StudentDTO> cList = studentBO.SearchByNICstName(nic);
        if (!cList.isEmpty()) {

            StudentDTO stmodel =cList.get(0);
              txtstuName.setText(stmodel.getName());
              txtstuName.setEditable(false);
              txtCordinator.setText(String.valueOf(stmodel.getUser().getUID()));
        }

    }
}
