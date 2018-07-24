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

import model.brand;
import view.popUp;

public class addBrand {
    ComboBox<String> supplierComboBox;
    TextField brandNameTextField;
    TextArea brandDescriptionTextArea;
    
    public void addBrandWindow(TableView<?> tableView, String userName){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(469, 409);
        
        Label addSupplier = new Label("Add Brand");
        anchorPane.getChildren().add(addSupplier);
        addSupplier.setAlignment(Pos.CENTER);
        addSupplier.setLayoutX(4.0);
        addSupplier.setLayoutY(7.0);
        addSupplier.setPrefSize(469, 36);
        addSupplier.setFont(new Font("System Bold", 25));
        
        GridPane gridPane = new GridPane();
        anchorPane.getChildren().add(gridPane);
        gridPane.setLayoutX(33);
        gridPane.setLayoutY(55);
        
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
        
        
        //Children @gridpane
        
        Label supplierName = new Label("Select Supplier : ");
        gridPane.getChildren().add(supplierName);
        
        supplierComboBox = new ComboBox<>();
        GridPane.setColumnSpan(supplierComboBox, 3);
        GridPane.setRowIndex(supplierComboBox, 1);
        supplierComboBox.setPrefSize(402, 31);
        gridPane.getChildren().add(supplierComboBox);
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
        
        Label brandName = new Label("Brand Name : ");
        GridPane.setRowIndex(brandName, 2);
        gridPane.getChildren().add(brandName);
        
        brandNameTextField = new TextField();
        GridPane.setColumnSpan(brandNameTextField, 4);
        GridPane.setRowIndex(brandNameTextField, 3);
        gridPane.getChildren().add(brandNameTextField);
        
        Label desc = new Label("Description : ");
        GridPane.setRowIndex(desc, 4);
        gridPane.getChildren().add(desc);
        
        brandDescriptionTextArea = new TextArea();
        GridPane.setRowIndex(brandDescriptionTextArea, 5);
        GridPane.setColumnSpan(brandDescriptionTextArea, 4);
        GridPane.setRowSpan(brandDescriptionTextArea, 3);
        gridPane.getChildren().add(brandDescriptionTextArea);
        
        Button update = new Button("Update");
        GridPane.setColumnIndex(update, 1);
        GridPane.setColumnSpan(update, 2);
        GridPane.setRowIndex(update, 9);
        GridPane.setHalignment(desc, HPos.CENTER);
        gridPane.getChildren().add(update);
        update.setOnAction(e -> {
            try {
                addBrand((TableView<brand>) tableView, userName);
            } catch (Exception ex) {
                Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
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
        supplier.returnSupplierName(supplierComboBox);
    }
    
    private void addBrand(TableView<brand> tableView,String userName) throws Exception{
        try {
            SQL addBrand = new SQL();
            addBrand.addBrand(brandNameTextField.getText(), supplierComboBox.getValue(),userName ,brandDescriptionTextArea.getText());
        } catch (Exception e) {
            popUp errorAdd = new popUp();
            errorAdd.popUpWindow("Error Addind!", "Unexpected Error Occured! please refresh!");
        }
        brand s = new brand();
        s.setDateAddedOn(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        s.setName(brandNameTextField.getText());
        s.setSupplier(supplierComboBox.getValue());
        s.setDescription(brandDescriptionTextArea.getText());
        
        tableView.getItems().add(s);
        
        brandDescriptionTextArea.clear();
        brandNameTextField.clear();
    }
}
