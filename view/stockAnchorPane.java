package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import view.stock.currentBrand;
import view.stock.currentCatagory;
import view.stock.currentSuppliers;
import view.stock.stockCurrent;

/**
 *
 * @author PK
 */
public class stockAnchorPane {
    public void changeAP(AnchorPane anchorPane, String userName) throws SQLException{
        
        anchorPane.setPrefSize(965, 599);
        
        
        
        BorderPane structure = new BorderPane();
        anchorPane.getChildren().add(structure);
        AnchorPane.setBottomAnchor(structure, 0.0);
        AnchorPane.setTopAnchor(structure, 0.0);
        AnchorPane.setRightAnchor(structure, 0.0);
        AnchorPane.setLeftAnchor(structure, 0.0);
        structure.setPrefSize(600, 400);
        
        AnchorPane topBorder = new AnchorPane();
        structure.setTop(topBorder);
        BorderPane.setAlignment(topBorder, Pos.CENTER);
        topBorder.setPrefSize(965, 81);
        
        
        GridPane gridPane = new GridPane();
        topBorder.getChildren().add(gridPane);
        AnchorPane.setTopAnchor(gridPane, 0.0);
        AnchorPane.setRightAnchor(gridPane, 0.0);
        AnchorPane.setLeftAnchor(gridPane, 0.0);
        AnchorPane.setBottomAnchor(gridPane, 0.0);
        gridPane.setPrefSize(965, 92);
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(100);
        column1.setMinWidth(10);
        column1.setHgrow(Priority.SOMETIMES);
        
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(488);
        column2.setHgrow(Priority.SOMETIMES);
        
        gridPane.getColumnConstraints().addAll(column1,column2);
        
        RowConstraints row = new RowConstraints();
        row.setPrefHeight(30);
        row.setVgrow(Priority.SOMETIMES);
        
        gridPane.getRowConstraints().add(row);
        
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        GridPane.setColumnIndex(hBox, 1);
        gridPane.getChildren().add(hBox);
        hBox.setPadding(new Insets(20, 10, 0, 0));
        
        
        //stock
        ToggleButton stockButton = new ToggleButton("Stock");
        hBox.getChildren().add(stockButton);
        stockButton.setMnemonicParsing(false);
        
        //supplier
        ToggleButton supplierButton = new ToggleButton("Supplier");
        hBox.getChildren().add(supplierButton);
        supplierButton.setMnemonicParsing(false);
        
        //brand
        ToggleButton brandButton = new ToggleButton("Brands");
        hBox.getChildren().add(brandButton);
        brandButton.setMnemonicParsing(false);
        
        //catagory
        ToggleButton catagoryButton = new ToggleButton("Catagory");
        hBox.getChildren().add(catagoryButton);
        catagoryButton.setMnemonicParsing(false);
        
        //ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        stockButton.setToggleGroup(toggleGroup);
        supplierButton.setToggleGroup(toggleGroup);
        brandButton.setToggleGroup(toggleGroup);
        catagoryButton.setToggleGroup(toggleGroup);
        stockButton.setSelected(true);
        
        
        
        
        
        AnchorPane storeLabelAnchorPane = new AnchorPane();
        gridPane.getChildren().add(storeLabelAnchorPane);
        GridPane.setColumnIndex(storeLabelAnchorPane, 0);
        storeLabelAnchorPane.setPrefSize(200, 200);
        
        Label store = new Label("Store");
        storeLabelAnchorPane.getChildren().add(store);
        store.setLayoutX(14);
        store.setLayoutY(21);
        store.setFont(new Font(34));
        
        
        
        
        
        
        
        StackPane cernterBorder = new StackPane();
        structure.setCenter(cernterBorder);
        BorderPane.setAlignment(cernterBorder, Pos.CENTER);
        cernterBorder.setPrefSize(200, 150);
        
        
        
        
        //setOnACtion 
        stockButton.setOnAction(e -> {
            try {
                stockDisplay(cernterBorder, userName);
            } catch (SQLException ex) {
                Logger.getLogger(stockAnchorPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        if(stockButton.isSelected())
            stockDisplay(cernterBorder, userName);
        
        
        brandButton.setOnAction(e -> {
            try {
                brandDisplay(cernterBorder,userName);
            } catch (SQLException ex) {
                Logger.getLogger(stockAnchorPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        catagoryButton.setOnAction(e -> {
            try {
                catagoryDisplay(cernterBorder, userName);
            } catch (SQLException ex) {
                Logger.getLogger(stockAnchorPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        supplierButton.setOnAction(e -> {
            try {
                supplierDisplay(cernterBorder, userName);
            } catch (SQLException ex) {
                Logger.getLogger(stockAnchorPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    
    //Toggle Btton setON action methods
    private void stockDisplay(StackPane center, String userName) throws SQLException{
        center.getChildren().clear();
        stockCurrent stock = new stockCurrent();
        stock.stockDisplay(center, userName);
    }
    
    private void brandDisplay(StackPane center, String userName) throws SQLException{
        center.getChildren().clear();
        currentBrand brand = new currentBrand();
        brand.brandDisplay(center, userName);
    }
    
    private void catagoryDisplay(StackPane center, String userName) throws SQLException{
        center.getChildren().clear();
        currentCatagory catagory = new currentCatagory();
        catagory.catagoryDisplay(center, userName);
    }
    
    private void supplierDisplay(StackPane center, String userName) throws SQLException{
        center.getChildren().clear();
        currentSuppliers supplier = new currentSuppliers();
        supplier.supplierDisplay(center, userName);
    }
    
}
