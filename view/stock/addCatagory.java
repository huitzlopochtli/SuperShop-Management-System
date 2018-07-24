package view.stock;

import database.SQL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import model.catagory;
import view.popUp;

/**
 *
 * @author PK
 */
public class addCatagory {
    ComboBox<String> supplierCombox, brandCombox;
    TextField catagoryNameTextField;
    TextArea catagoryDescriptionTextArea;
    
    public void addCatarotyWindow(TableView<?> tableView, String userName){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(470, 450);
        
        Label addSupplier = new Label("Add Catagory");
        anchorPane.getChildren().add(addSupplier);
        addSupplier.setAlignment(Pos.CENTER);
        addSupplier.setLayoutX(4.0);
        addSupplier.setLayoutY(7.0);
        addSupplier.setPrefSize(450, 37);
        addSupplier.setFont(new Font("System Bold", 25));
        
        GridPane gridPane = new GridPane();
        anchorPane.getChildren().add(gridPane);
        gridPane.setLayoutX(41);
        gridPane.setLayoutY(64);
        
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
        
        //
        Label supplierName = new Label("Select Supplier : ");
        gridPane.getChildren().add(supplierName);
        
        supplierCombox = new ComboBox<>();
        GridPane.setColumnSpan(supplierCombox, 3);
        GridPane.setRowIndex(supplierCombox, 1);
        supplierCombox.setPrefSize(300, 50);
        gridPane.getChildren().add(supplierCombox);
        try{
            returnSupplierName();
        } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Button addSupplierButton = new Button("+");
        GridPane.setColumnIndex(addSupplierButton, 3);
        GridPane.setRowIndex(addSupplierButton, 1);
        GridPane.setHalignment(addSupplierButton, HPos.LEFT);
        gridPane.getChildren().add(addSupplierButton);
        
        Label brandName = new Label("Select Brand : ");
        GridPane.setColumnSpan(brandName, 2);
        GridPane.setRowIndex(brandName, 2);
        gridPane.getChildren().add(brandName);
        
        brandCombox = new ComboBox<>();
        GridPane.setColumnSpan(brandCombox, 3);
        GridPane.setRowIndex(brandCombox, 3);
        brandCombox.setPrefSize(300, 50);
        gridPane.getChildren().add(brandCombox);
        try{
            returnBrandName();
        } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Button addBrandButton = new Button("+");
        GridPane.setColumnIndex(addBrandButton, 3);
        GridPane.setRowIndex(addBrandButton, 3);
        GridPane.setHalignment(addBrandButton, HPos.LEFT);
        gridPane.getChildren().add(addBrandButton);
        
        Label catagoryName = new Label("Catagory Name : ");
        GridPane.setColumnSpan(catagoryName, 2);
        GridPane.setRowIndex(catagoryName, 4);
        gridPane.getChildren().add(catagoryName);
        
        catagoryNameTextField = new TextField();
        GridPane.setColumnSpan(catagoryNameTextField, 4);
        GridPane.setRowIndex(catagoryNameTextField, 5);
        gridPane.getChildren().add(catagoryNameTextField);
        
        Label catagoryDescriptio = new Label("Description : ");
        GridPane.setColumnSpan(catagoryDescriptio, 2);
        GridPane.setRowIndex(catagoryDescriptio, 6);
        gridPane.getChildren().add(catagoryDescriptio);
        
        catagoryDescriptionTextArea = new TextArea();
        GridPane.setColumnSpan(catagoryDescriptionTextArea, 4);
        GridPane.setRowSpan(catagoryDescriptionTextArea, 3);
        GridPane.setRowIndex(catagoryDescriptionTextArea, 7);
        catagoryDescriptionTextArea.setPrefSize(200,200);
        gridPane.getChildren().add(catagoryDescriptionTextArea);
        
        Button update = new Button("Update");
        GridPane.setColumnIndex(update, 1);
        GridPane.setColumnSpan(update, 2);
        GridPane.setHalignment(update, HPos.CENTER);
        GridPane.setRowIndex(update, 11);
        gridPane.getChildren().add(update);
        update.setOnAction(e -> {
            try {
                addNew((TableView<catagory>) tableView, userName);
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
    
    private void returnSupplierName() throws SQLException{
        SQL supplier = new SQL();
        supplier.returnSupplierName(supplierCombox);
    }
    
    private void returnBrandName() throws SQLException{
        SQL supplier = new SQL();
        supplier.returnBrandName(brandCombox);
    }
    
    private void addNew(TableView<catagory> tableView , String userName){
        try {
            SQL add = new SQL();
            add.addCatagory(catagoryNameTextField.getText(), brandCombox.getValue(), supplierCombox.getValue(), userName, catagoryDescriptionTextArea.getText());
            
        } catch (Exception e) {
            popUp errorAdd = new popUp();
            errorAdd.popUpWindow("Error Addind!", "Unexpected Error Occured! please refresh!");
        }
        catagory c = new catagory();
        c.setBrand(brandCombox.getValue());
        c.setCreator(userName);
        c.setDateAddedOn(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        c.setName(catagoryNameTextField.getText());
        c.setSupplier(supplierCombox.getValue());
        c.setDiscription(catagoryDescriptionTextArea.getText());
        
        tableView.getItems().add(c);
        catagoryDescriptionTextArea.clear();
        catagoryNameTextField.clear();
    }
}
