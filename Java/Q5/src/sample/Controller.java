package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button btgr;
    @FXML

    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Label lb5;
    @FXML
    private  Label lb6;
    @FXML
    public TextField tffn;
    @FXML
    public TextField tfsn;
    @FXML
    public TextField tfage;
    @FXML
    public TextField tfcy;
    @FXML
    public TextField tfnic;
    @FXML
    public RadioButton rbaz, rbsp, rbpr;

    public void GenerateReceipt(){
        String txt = tffn.getText();// getters
        lb1.setText("First Name : " +txt); //setters
        String txt1 = tfsn.getText();// getters
        lb2.setText("Surname : "+txt1); //setters
        String txt2 = tfage.getText();
        lb3.setText("Age: "+txt2); //setters
        String txt3 = tfcy.getText();// getters
        lb4.setText("City : "+txt3); //setters
        String txt4 = tfnic.getText();// getters
        lb5.setText("NIC : "+txt4); //setters
        if(rbaz.isSelected()){
            lb6.setText("Go to the Booth 0&1 for getting"+rbaz.getText());
        }
        else if(rbsp.isSelected()){
            lb6.setText("Go to the Booth 2&3 for getting"+rbsp.getText());
        }
        else if(rbpr.isSelected()){
            lb6.setText("Go to the Booth 4&5 for getting"+rbpr.getText());
        }

    }
    @FXML
    public void clear() {
        // clearing for the next use
        tffn.clear();
        tfsn.clear();
        tfage.clear();
        tfcy.clear();
        tfnic.clear();
        rbaz.fire();
        rbsp.fire();
        rbsp.fire();

        String txt = tffn.getText();// getters
        lb1.setText("First Name : " +txt); //setters
        String txt1 = tfsn.getText();// getters
        lb2.setText("Surname : " +txt1); //setters
        String txt2 = tfage.getText();// getters
        lb3.setText("Age : " +txt2); //setters
        String txt3 = tfcy.getText();// getters
        lb4.setText("City : " +txt3); //setters
        String txt4 = tfnic.getText();// getters
        lb5.setText("Nic : " +txt4); //setters
        lb6.setText("Booth : ");
    }

}
