package view.stock;

import database.SQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import model.product;
import view.popUp;

/**
 *
 * @author PK
 */
public class addProduct {
    TextField productTextField, productNameField, productQuantityField, productPriceField;

    TextArea productDescription;

    DatePicker dateAdded;

    ComboBox<String> supplerComboBox, brandComboBox, catagoryComboBox;
    
    public void addProductWindow(TableView<?> tableView, String userName){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(650, 570);
        
        //Label @AddProduct
        Label addProductText = new Label("Add Product");
        anchorPane.getChildren().add(addProductText);
        addProductText.setAlignment(Pos.CENTER);
        addProductText.setLayoutX(4);
        addProductText.setLayoutY(4);
        addProductText.setPrefSize(650, 30);
        addProductText.setFont(new Font("System Bold", 25));
        
        //Grid @product details
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        anchorPane.getChildren().add(gridPane);
        gridPane.setHgap(1.0);
        gridPane.setLayoutX(80.0);
        gridPane.setLayoutY(60.0);
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(10);
        column1.setPrefWidth(100);
        column1.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setMinWidth(10);
        column2.setPrefWidth(100);
        column2.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setMinWidth(10);
        column3.setPrefWidth(100);
        column3.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setMinWidth(10);
        column4.setPrefWidth(100);
        column4.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column5 = new ColumnConstraints();
        column5.setMinWidth(10);
        column5.setPrefWidth(100);
        column5.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column6 = new ColumnConstraints();
        column6.setMinWidth(10);
        column6.setPrefWidth(100);
        column6.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column7 = new ColumnConstraints();
        column7.setMinWidth(10);
        column7.setPrefWidth(100);
        column7.setHgrow(Priority.SOMETIMES);
        
        /*        gridPane.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7);*/        
        RowConstraints row1 =  new RowConstraints();
        row1.setMinHeight(10);
        row1.setPrefHeight(30);
        row1.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row1);
        
        
        RowConstraints row2 =  new RowConstraints();
        row2.setMinHeight(10);
        row2.setPrefHeight(30);
        row2.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row2);
        
        RowConstraints row3 =  new RowConstraints();
        row3.setMinHeight(10);
        row3.setPrefHeight(30);
        row3.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row3);
        
        RowConstraints row4 =  new RowConstraints();
        row4.setMinHeight(10);
        row4.setPrefHeight(30);
        row4.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row4);
        
        RowConstraints row5 =  new RowConstraints();
        row5.setMinHeight(10);
        row5.setPrefHeight(30);
        row5.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row5);
        
        RowConstraints row6 =  new RowConstraints();
        row6.setMinHeight(10);
        row6.setPrefHeight(30);
        row6.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row6);
        
        RowConstraints row7 =  new RowConstraints();
        row7.setMinHeight(10);
        row7.setPrefHeight(30);
        row7.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row7);
        
        RowConstraints row8 =  new RowConstraints();
        row8.setMinHeight(10);
        row8.setPrefHeight(30);
        row8.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row8);
        
        RowConstraints row9 =  new RowConstraints();
        row9.setMinHeight(10);
        row9.setPrefHeight(30);
        row9.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row9);
        
        RowConstraints row10 =  new RowConstraints();
        row10.setMinHeight(10);
        row10.setPrefHeight(30);
        row10.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row10);
        
        RowConstraints row11 =  new RowConstraints();
        row11.setMinHeight(10);
        row11.setPrefHeight(30);
        row11.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row11);
        
        RowConstraints row12 =  new RowConstraints();
        row12.setMinHeight(10);
        row12.setPrefHeight(30);
        row12.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row12);
        
        RowConstraints row13 =  new RowConstraints();
        row13.setMinHeight(10);
        row13.setPrefHeight(30);
        row13.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row13);
        
        RowConstraints row14 =  new RowConstraints();
        row14.setMinHeight(10);
        row14.setPrefHeight(30);
        row14.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row14);
        
        RowConstraints row16 =  new RowConstraints();
        row16.setMinHeight(10);
        row16.setPrefHeight(30);
        row16.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row16);
        
        RowConstraints row15 =  new RowConstraints();
        row15.setMinHeight(10);
        row15.setPrefHeight(30);
        row14.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().add(row15);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //children @gridPane
        Label productLabel = new Label("Product Id : ");
        
        Label productNameLabel = new Label("Product Name : ");
        GridPane.setColumnSpan(productNameLabel, 2);
        GridPane.setRowIndex(productNameLabel, 2);
        
        Label quantity = new Label("Quantity");
        GridPane.setRowIndex(quantity, 4);
        
        Label price = new Label("Price : ");
        GridPane.setRowIndex(price, 6);
        
        Label Description = new Label("Description : ");
        GridPane.setRowIndex(Description, 10);
        
        Label suppliedBy = new Label("Supplied By : ");
        GridPane.setColumnIndex(suppliedBy, 4);
        
        Label brand = new Label("Brand : ");
        GridPane.setColumnIndex(brand, 4);
        GridPane.setRowIndex(brand, 2);
        
        Label catagory = new Label("Catagory : ");
        GridPane.setColumnIndex(catagory, 4);
        GridPane.setRowIndex(catagory, 4);
        
        Label dateLabel = new Label("Date : ");
        GridPane.setColumnIndex(dateLabel, 4);
        GridPane.setRowIndex(dateLabel, 8);
        
        gridPane.getChildren().addAll(productLabel, productNameLabel, quantity, price, Description, suppliedBy, brand, catagory, dateLabel);
        
        
        productTextField = new TextField();
        GridPane.setColumnSpan(productLabel, 3);
        GridPane.setRowIndex(productTextField, 1);
        productTextField.setMinWidth(200);
        gridPane.getChildren().add(productTextField);
        
        productNameField = new TextField();
        GridPane.setColumnSpan(productNameField, 3);
        GridPane.setRowIndex(productNameField, 3);
        gridPane.getChildren().add(productNameField);
        
        productQuantityField = new TextField();
        GridPane.setColumnSpan(productQuantityField, 3);
        GridPane.setRowIndex(productQuantityField, 5);
        gridPane.getChildren().add(productQuantityField);
        
        productPriceField = new TextField();
        GridPane.setColumnSpan(productPriceField, 3);
        GridPane.setRowIndex(productPriceField, 7);
        gridPane.getChildren().add(productPriceField);
        
        productDescription = new TextArea();
        GridPane.setColumnSpan(productDescription, 3);
        GridPane.setRowIndex(productDescription, 11);
        GridPane.setRowSpan(productDescription, 3);
        productDescription.setPrefSize(200, 200);
        gridPane.getChildren().add(productDescription);
        
        dateAdded = new DatePicker();
        GridPane.setColumnIndex(dateAdded, 4);
        GridPane.setColumnSpan(dateAdded, 2);
        GridPane.setRowIndex(dateAdded, 9);
        gridPane.getChildren().add(dateAdded);
        
        
        Button addSupplier = new Button("+");
        GridPane.setColumnIndex(addSupplier, 6);
        GridPane.setHalignment(addSupplier, HPos.LEFT);
        GridPane.setRowIndex(addSupplier, 1);
        gridPane.getChildren().add(addSupplier);
        
        Button addBrand = new Button("+");
        GridPane.setColumnIndex(addBrand, 6);
        GridPane.setHalignment(addBrand, HPos.LEFT);
        GridPane.setRowIndex(addBrand, 3);
        gridPane.getChildren().add(addBrand);
        
        Button addCatagory = new Button("+");
        GridPane.setColumnIndex(addCatagory, 6);
        GridPane.setHalignment(addCatagory, HPos.LEFT);
        GridPane.setRowIndex(addCatagory, 5);
        gridPane.getChildren().add(addCatagory);
        
        supplerComboBox = new ComboBox<>();
        GridPane.setColumnIndex(supplerComboBox, 4);
        supplerComboBox.setPrefSize(212, 31);
        GridPane.setColumnSpan(supplerComboBox, 2);
        GridPane.setRowIndex(supplerComboBox, 1);
        gridPane.getChildren().add(supplerComboBox);
        GridPane.setHalignment(supplerComboBox, HPos.CENTER);
        try{
            returnSupplierName(supplerComboBox);
        } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        brandComboBox = new ComboBox<>();
        GridPane.setColumnIndex(brandComboBox, 4);
        brandComboBox.setPrefSize(212, 31);
        GridPane.setColumnSpan(brandComboBox, 2);
        GridPane.setRowIndex(brandComboBox, 3);
        gridPane.getChildren().add(brandComboBox);
        GridPane.setHalignment(brandComboBox, HPos.CENTER);
        try{
            returnBrandName(brandComboBox);
        } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catagoryComboBox = new ComboBox<>();
        GridPane.setColumnIndex(catagoryComboBox, 4);
        catagoryComboBox.setPrefSize(212, 31);
        GridPane.setColumnSpan(catagoryComboBox, 2);
        GridPane.setRowIndex(catagoryComboBox, 5);
        gridPane.getChildren().add(catagoryComboBox);
        GridPane.setHalignment(catagoryComboBox, HPos.CENTER);
        try{
            returnCatagoryName(catagoryComboBox);
        } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        Button Update = new Button("Update");
        GridPane.setColumnIndex(Update, 3);
        GridPane.setRowIndex(Update, 15);
        GridPane.setHalignment(Update, HPos.CENTER);
        gridPane.getChildren().add(Update);
        Update.setOnAction(e -> {
            try {
                addProduct((TableView<product>) tableView,userName);
            } catch (Exception ex) {
                Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        Stage popUpStage = new Stage();
        popUpStage.setScene(new Scene(anchorPane));
        
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("Add Product");
        popUpStage.setResizable(false);
        popUpStage.setAlwaysOnTop(true);
        popUpStage.showAndWait();
        popUpStage.setAlwaysOnTop(true);
    }
    private void returnSupplierName(ComboBox<String> combo) throws SQLException{
        SQL supplier = new SQL();
        supplier.returnSupplierName(combo);
    }
    private void returnBrandName(ComboBox<String> combo) throws SQLException{
        SQL supplier = new SQL();
        supplier.returnBrandName(combo);
    }private void returnCatagoryName(ComboBox<String> combo) throws SQLException{
        SQL supplier = new SQL();
        supplier.returnCatagoryName(combo);
    }
    
    //Update button
    private void addProduct(TableView<product> tableView,String userName) throws Exception{
        java.sql.Date date = java.sql.Date.valueOf(dateAdded.getValue());
        try{
            SQL addProduct = new SQL();
            addProduct.addProduct(productNameField.getText(), Integer.parseInt(productQuantityField.getText()), userName, supplerComboBox.getValue(), brandComboBox.getValue(), catagoryComboBox.getValue(), Double.parseDouble(productPriceField.getText()),  productTextField.getText(), productDescription.getText(), date);
            
        }catch(SQLException e){
            popUp errorAdd = new popUp();
            errorAdd.popUpWindow("Adding Error" ,"The product will not be added to the data base! Please REFRESH!");
        }
        product p = new product(Integer.parseInt(productQuantityField.getText()),Double.parseDouble(productPriceField.getText()), productTextField.getText(),productNameField.getText(), productDescription.getText(),userName,supplerComboBox.getValue(),brandComboBox.getValue(),catagoryComboBox.getValue(),date);
        tableView.getItems().add(p);
        productDescription.clear();
        productNameField.clear();
        productPriceField.clear();
        productQuantityField.clear();
        productTextField.clear();
    }
}
