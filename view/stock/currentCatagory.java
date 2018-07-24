package view.stock;

import database.SQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.catagory;
import view.popUp;

/**
 *
 * @author PK
 */
public class currentCatagory {
    TableView<catagory> tableView;
    ObservableList<catagory> producList;
    TextField searchField;
    
    public void catagoryDisplay(StackPane stack, String userName) throws SQLException{
        stack.setPrefSize(1004, 580);
        stack.setPadding(new Insets(0, 30, 30, 0));
        
        AnchorPane anchorPane1 = new AnchorPane();
        stack.getChildren().add(anchorPane1);
        anchorPane1.setPrefSize(834, 494);
        
        BorderPane borderPane1 = new BorderPane();
        AnchorPane.setBottomAnchor(borderPane1, 0.0);
        AnchorPane.setTopAnchor(borderPane1, 0.0);
        AnchorPane.setRightAnchor(borderPane1, 0.0);
        AnchorPane.setLeftAnchor(borderPane1, 0.0);
        anchorPane1.getChildren().add(borderPane1);
        borderPane1.setLayoutX(220);
        borderPane1.setLayoutY(140);
        borderPane1.setPrefSize(639, 479);
        
        
        //Top @borderPane1
        BorderPane borderPane2 = new BorderPane();
        borderPane1.setTop(borderPane2);
        borderPane2.setPrefSize(944, 85);
        BorderPane.setAlignment(borderPane2, Pos.CENTER);
        
        //top @borderPane2
        HBox hBox1 = new HBox(10);
        borderPane2.setTop(hBox1);
        BorderPane.setAlignment(hBox1, Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPrefSize(944, 44);
        
        //Children @hBox1
        searchField = new TextField();
        searchField.setPromptText("Search with any kew word!");
        searchField.setPrefSize(300, 40);
        hBox1.getChildren().add(searchField);
        
        
        
        
        
        //Center @borderpane2
        AnchorPane anchorPane2 = new AnchorPane();
        borderPane2.setCenter(anchorPane2);
        BorderPane.setAlignment(anchorPane2, Pos.CENTER);
        //children @anchorPane2
        HBox hBox2 = new HBox(10);
        anchorPane2.getChildren().add(hBox2);
        AnchorPane.setBottomAnchor(hBox2, 0.0);
        AnchorPane.setTopAnchor(hBox2, 0.0);
        AnchorPane.setRightAnchor(hBox2, 0.0);
        AnchorPane.setLeftAnchor(hBox2, 0.0);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPrefSize(944, 100);
        //children @hbox2
        
        
        
        //Bottom @borderPane1
        HBox hBox3 = new HBox(20);
        hBox3.setAlignment(Pos.CENTER_RIGHT);
        hBox3.setPrefSize(944,66);
        BorderPane.setAlignment(hBox3, Pos.CENTER);
        borderPane1.setBottom(hBox3);
        BorderPane.setMargin(hBox3, new Insets(0, 20, 0, 0));
        //Childer @hBox3
        Button addNew = new Button("Add New");
        hBox3.getChildren().add(addNew);
        addNew.setMnemonicParsing(false);
        addNew.setOnAction(e -> addNew(tableView,userName));
        
        
        Button update = new Button("Update");
        hBox3.getChildren().add(update);
        update.setDisable(true);
        update.setMnemonicParsing(false);
        
        
        Button delete = new Button("Delete");
        hBox3.getChildren().add(delete);
        delete.setMnemonicParsing(false);
        delete.setOnAction(e -> {
            try {
                delete(tableView);
            } catch (SQLException ex) {
                Logger.getLogger(stockCurrent.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        
        
        
        
        //Center @borderpane1
        tableView = new TableView<>();
        SQL productTableSql = new SQL();
        producList = productTableSql.getCatagory();
        tableView.setItems(producList);
        tableView.setEditable(true);
        tableView.setPrefSize(200, 200);
        tableView.setMaxWidth(1202);
        BorderPane.setAlignment(tableView, Pos.CENTER);
        borderPane1.setCenter(tableView);
        
        TableColumn<catagory, String> catagoryNameColumn = new TableColumn<>("Catagoty Name");
        catagoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        catagoryNameColumn.setMinWidth(200);
        tableView.getColumns().add(catagoryNameColumn);
        
        TableColumn<catagory, String> catagoryBrandColumn = new TableColumn<>("Brand Name");
        catagoryBrandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        catagoryBrandColumn.setMinWidth(200);
        tableView.getColumns().add(catagoryBrandColumn);
        
        TableColumn<catagory, String> catagorySupplierColumn = new TableColumn<>("Supplier Name");
        catagorySupplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        catagorySupplierColumn.setMinWidth(200);
        tableView.getColumns().add(catagorySupplierColumn);
        
        TableColumn<catagory, String> catagoryCreatorColumn = new TableColumn<>("Creator's Name");
        catagoryCreatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
        catagoryCreatorColumn.setMinWidth(200);
        tableView.getColumns().add(catagoryCreatorColumn);
        
        TableColumn<catagory, String> catagoryDateColumn = new TableColumn<>("Date Created");
        catagoryDateColumn.setCellValueFactory(new PropertyValueFactory<>("dateAddedOn"));
        catagoryDateColumn.setMinWidth(200);
        tableView.getColumns().add(catagoryDateColumn);
        
        TableColumn<catagory, String> catagoryDescColumn = new TableColumn<>("Description");
        catagoryDescColumn.setCellValueFactory(new PropertyValueFactory<>("discription"));
        catagoryDescColumn.setMinWidth(200);
        tableView.getColumns().add(catagoryDescColumn);
        
       
        
        
        
        
        ////setOnActions @searchField
        try {
            ObservableList data =  tableView.getItems();
            searchField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                tableView.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<catagory> subentries = FXCollections.observableArrayList();

            long count = tableView.getColumns().stream().count();
            for (int i = 0; i < tableView.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + tableView.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(tableView.getItems().get(i));
                        break;
                    }
                }
            }
            tableView.setItems(subentries);
        });
        }catch (Exception e) {
            System.out.println("no Error!");
        }
    }
    
    private void delete(TableView tableView) throws SQLException{
        ObservableList<catagory> productSelected, allProducts;
        allProducts = tableView.getItems();
        productSelected = tableView.getSelectionModel().getSelectedItems();
        
        
        catagory item = (catagory) tableView.getSelectionModel().getSelectedItem();
        
        
        SQL delete = new SQL();
        delete.deleteCatagory(item.getName());
        
        popUp deleteConfirmation = new popUp();
        deleteConfirmation.popUpWindow("Delete!", "Catagory deleted!");
        
        productSelected.forEach(allProducts :: remove);
        
    }
    
    private void addNew(TableView<catagory> tableView, String usernaName){
        addCatagory add = new addCatagory();
        add.addCatarotyWindow(tableView, usernaName);
    }    
}
