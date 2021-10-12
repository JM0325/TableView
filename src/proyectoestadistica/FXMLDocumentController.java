/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestadistica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private TextField txtC1;
    @FXML
    private TextField txtC2;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnMedia;
    @FXML
    private TextField txtMedia;
    @FXML
    private TableView<TablasG> TablaP;
    @FXML
    private TableColumn Cc1;
    @FXML
    private TableColumn Cc2;
    
    private ObservableList<TablasG> columnas;
    
    ////
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnEditar;
    
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnas = FXCollections.observableArrayList();
        this.Cc1.setCellValueFactory(new PropertyValueFactory("Columna1"));
        this.Cc2.setCellValueFactory(new PropertyValueFactory("Columna2"));
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        double clm1 = Double.valueOf(this.txtC1.getText());
        double clm2 = Double.valueOf(this.txtC2.getText());
        
        TablasG excel = new TablasG(clm1,clm2);
        this.columnas.add(excel);
        this.TablaP.setItems(columnas);
    }

    @FXML
    private void CalcularMedia(ActionEvent event) {
        double total = 0;
        for(int i = 0 ; i < TablaP.getItems().size(); i++)
        {
           double sum = new Double(TablaP.getItems().get(i).getColumna2());
           total += sum;
        }
        double mediaRs = total/TablaP.getItems().size();
        txtMedia.setText(String.valueOf(mediaRs));
    }

    @FXML
    private void Seleccionar(MouseEvent event) {
        TablasG exc = this.TablaP.getSelectionModel().getSelectedItem();
        if(exc != null){
            this.txtC1.setText(String.valueOf(exc.getColumna1()));
            this.txtC2.setText(String.valueOf(exc.getColumna2()));
        }
            
    }
    @FXML
    private void Eliminar(ActionEvent event) {
        TablasG exc = this.TablaP.getSelectionModel().getSelectedItem();
        if(exc == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("error");
            alert.setContentText("debeser selccionar algo");
            alert.showAndWait();
        }
        else{
            this.columnas.remove(exc);
            this.TablaP.refresh();
            
        }
    }

    @FXML
    private void Editar(ActionEvent event) {
        TablasG exc = this.TablaP.getSelectionModel().getSelectedItem();
        if(exc == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("error");
            alert.setContentText("debeser selccionar algo");
            alert.showAndWait();
        }
        else{
            double n1 = Double.valueOf(this.txtC1.getText());
            double n2 = Double.valueOf(this.txtC2.getText());
            TablasG aux = new TablasG(n1, n2);
            exc.setColumna1(aux.getColumna1());
            exc.setColumna2(aux.getColumna2());
            this.TablaP.refresh();
            
        }
    }


    
}
