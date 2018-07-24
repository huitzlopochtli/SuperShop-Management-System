package view.stock;

import database.SQL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.supplier;
import view.popUp;

/**
 *
 * @author PK
 */
public class addSupplier {
    TextField supplierNameTextField;
    TextArea supplierPhoneTextField, supplierAddressTextField, supplierDesTextArea;
    
    public void addSupplierWindow(TableView<?> tableView, String userName){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(524, 565);
        
        Label addSupplier = new Label("Add Supplier");
        anchorPane.getChildren().add(addSupplier);
        addSupplier.setAlignment(Pos.CENTER);
        addSupplier.setLayoutX(4.0);
        addSupplier.setLayoutY(7.0);
        addSupplier.setPrefSize(524, 36);
        addSupplier.setFont(new Font("System Bold", 25));
        
        GridPane gridPane = new GridPane();
        anchorPane.getChildren().add(gridPane);
        gridPane.setLayoutX(46);
        gridPane.setLayoutY(43);
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(10);
        column1.setPrefWidth(100);
        column1.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(column1);
        
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setMinWidth(10);
        column2.setPrefWidth(100);
        column2.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(column2);
        
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setMinWidth(10);
        column3.setPrefWidth(100);
        column3.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(column3);
        
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setMinWidth(10);
        column4.setPrefWidth(100);
        column4.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(column4);
        
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(30);
        row1.setMinHeight(10);
        row1.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row1);
        
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(30);
        row2.setMinHeight(10);
        row2.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row2);
        
        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(30);
        row3.setMinHeight(10);
        row3.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row3);
        
        RowConstraints row4 = new RowConstraints();
        row4.setPrefHeight(30);
        row4.setMinHeight(10);
        row4.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row4);
        
        RowConstraints row5 = new RowConstraints();
        row5.setPrefHeight(30);
        row5.setMinHeight(10);
        row5.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row5);
        
        RowConstraints row6 = new RowConstraints();
        row6.setPrefHeight(30);
        row6.setMinHeight(10);
        row6.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row6);
        
        RowConstraints row7 = new RowConstraints();
        row7.setPrefHeight(30);
        row7.setMinHeight(10);
        row7.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row7);
        
        RowConstraints row8 = new RowConstraints();
        row8.setPrefHeight(30);
        row8.setMinHeight(10);
        row8.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row8);
        
        RowConstraints row9 = new RowConstraints();
        row9.setPrefHeight(30);
        row9.setMinHeight(10);
        row9.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row9);
        
        RowConstraints row10 = new RowConstraints();
        row10.setPrefHeight(30);
        row10.setMinHeight(10);
        row10.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row10);
        
        RowConstraints row11 = new RowConstraints();
        row11.setPrefHeight(30);
        row11.setMinHeight(10);
        row11.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row11);
        
        RowConstraints row12 = new RowConstraints();
        row12.setPrefHeight(30);
        row12.setMinHeight(10);
        row12.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row12);
        
        RowConstraints row13 = new RowConstraints();
        row13.setPrefHeight(30);
        row13.setMinHeight(10);
        row13.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row13);
        
        RowConstraints row14 = new RowConstraints();
        row14.setPrefHeight(30);
        row14.setMinHeight(10);
        row14.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row14);
        
        RowConstraints row15 = new RowConstraints();
        row15.setPrefHeight(30);
        row15.setMinHeight(10);
        row15.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row15);
        
        RowConstraints row16 = new RowConstraints();
        row16.setPrefHeight(30);
        row16.setMinHeight(10);
        row16.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row16);
        
        Label supplierName = new Label("Supplier Name : ");
        GridPane.setColumnSpan(supplierName, 2);
        gridPane.getChildren().add(supplierName);
        
        supplierNameTextField = new TextField();
        GridPane.setColumnSpan(supplierNameTextField, 4);
        GridPane.setRowIndex(supplierNameTextField, 1);
        supplierNameTextField.setMaxWidth(150);
        gridPane.getChildren().add(supplierNameTextField);
        
        Label supplierPhone = new Label("Supplier Contact Number : ");
        GridPane.setColumnSpan(supplierPhone, 2);
        GridPane.setRowIndex(supplierPhone, 2);
        gridPane.getChildren().add(supplierPhone);
        
        supplierPhoneTextField = new TextArea();
        GridPane.setColumnSpan(supplierPhoneTextField, 4);
        GridPane.setRowSpan(supplierPhoneTextField, 3);
        GridPane.setRowIndex(supplierPhoneTextField, 3);
        supplierPhoneTextField.setPrefSize(200, 200);
        gridPane.getChildren().add(supplierPhoneTextField);
        
        Label supplierAddress = new Label("Supplier Address : ");
        GridPane.setColumnSpan(supplierAddress, 2);
        GridPane.setRowIndex(supplierAddress, 6);
        gridPane.getChildren().add(supplierAddress);
        
        supplierAddressTextField = new TextArea();
        GridPane.setColumnSpan(supplierAddressTextField, 4);
        GridPane.setRowSpan(supplierAddressTextField, 3);
        GridPane.setRowIndex(supplierAddressTextField, 7);
        supplierAddressTextField.setPrefSize(200, 200);
        gridPane.getChildren().add(supplierAddressTextField);
        
        Label supplierDescription = new Label("Description");
        GridPane.setColumnSpan(supplierDescription, 2);
        GridPane.setRowIndex(supplierDescription, 10);
        gridPane.getChildren().add(supplierDescription);
        
        supplierDesTextArea = new TextArea();
        GridPane.setColumnSpan(supplierDesTextArea, 4);
        GridPane.setRowSpan(supplierDesTextArea, 3);
        GridPane.setRowIndex(supplierDesTextArea, 11);
        supplierDesTextArea.setPrefSize(200, 200);
        gridPane.getChildren().add(supplierDesTextArea);
        
        Button update = new Button("Update");
        GridPane.setColumnIndex(update, 1);
        GridPane.setColumnSpan(update, 2);
        GridPane.setHalignment(update, HPos.CENTER);
        GridPane.setRowIndex(update, 15);
        gridPane.getChildren().add(update);
        update.setOnAction(e -> {
            try {
                addSupplier((TableView<supplier>) tableView, userName);
            } catch (Exception ex) {
                Logger.getLogger(addSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        
        
        Stage popUpStage = new Stage();
        popUpStage.setScene(new Scene(anchorPane));
        
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("Add Supplier");
        popUpStage.setResizable(false);
        popUpStage.setAlwaysOnTop(true);
        popUpStage.showAndWait();
        popUpStage.setAlwaysOnTop(true);
    }
    
    private void addSupplier(TableView<supplier> tableView,String userName) throws Exception{
        try {
            SQL addSupplier = new SQL();
            addSupplier.addSupplier(supplierNameTextField.getText(), userName, Integer.parseInt(supplierPhoneTextField.getText()), supplierAddressTextField.getText(), supplierDesTextArea.getText());
            
        } catch (Exception e) {
            popUp errorAdd = new popUp();
            errorAdd.popUpWindow("Error Addind!", "Unexpected Error Occured! please refresh!");
        }
        supplier s = new supplier();
        s.setName(supplierNameTextField.getText());
        s.setAddress(supplierAddressTextField.getText());
        s.setPhone(Integer.parseInt(supplierPhoneTextField.getText()));
        s.setDateAddedOn(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        s.setDescription(supplierDesTextArea.getText());
        tableView.getItems().add(s);
        supplierAddressTextField.clear();
        supplierDesTextArea.clear();
        supplierNameTextField.clear();
        supplierPhoneTextField.clear();
    }
    
}
