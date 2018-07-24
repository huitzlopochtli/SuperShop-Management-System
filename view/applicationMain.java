package view;

import database.SQL;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author PK
 */
public class applicationMain {
    public void StartMain(String userName, Stage primaryStage) throws SQLException{
        AnchorPane apMain = new AnchorPane();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight()-100;
        apMain.setPrefSize(width, height);
        apMain.setMinSize(width, height);
        apMain.setMaxSize(width, height);
        
        BorderPane bpMain = new BorderPane();
        apMain.getChildren().add(bpMain);
        bpMain.setPrefSize(width, height);
        
        
        //Vbox @borderpane
        VBox vBox = new VBox(10);
        bpMain.setLeft(vBox);
        BorderPane.setAlignment(vBox, Pos.TOP_LEFT);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPrefSize(106,500);
        vBox.setPadding(new Insets(0, 10, 0, 10));
        
        //vBox elliments
        //Home Button
        ToggleButton home = new ToggleButton("Home");
        home.setSelected(true);
        home.setAlignment(Pos.TOP_CENTER);
        home.setMnemonicParsing(false);
        home.setPrefSize(127, 72);
        home.setContentDisplay(ContentDisplay.TOP);
        ImageView homeImg = new ImageView(new Image("view/icon/home.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        home.setGraphic(homeImg);
        vBox.getChildren().add(home);
        VBox.setVgrow(home, Priority.SOMETIMES);
        
        ImageView lineBreak1 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak1.setFitHeight(5);
        lineBreak1.setFitWidth(114);
        lineBreak1.setPickOnBounds(true);
        lineBreak1.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak1);
        
        //Store Button
        Button store = new Button("Store");
        store.setAlignment(Pos.TOP_CENTER);
        store.setMnemonicParsing(false);
        store.setPrefSize(127, 72);
        store.setContentDisplay(ContentDisplay.TOP);
        ImageView storeImg = new ImageView(new Image("view/icon/stock.png"));
        store.setGraphic(storeImg);
        storeImg.setFitHeight(40);
        storeImg.setFitWidth(40);
        vBox.getChildren().add(store);
        VBox.setVgrow(store, Priority.SOMETIMES);
        
        //lineBreak2
        ImageView lineBreak2 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak2.setFitHeight(5);
        lineBreak2.setFitWidth(144);
        lineBreak2.setPickOnBounds(true);
        lineBreak2.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak2);
        
        //sell Button
        Button sell = new Button("Sell");
        sell.setAlignment(Pos.TOP_CENTER);
        sell.setMnemonicParsing(false);
        sell.setPrefSize(127, 72);
        sell.setContentDisplay(ContentDisplay.TOP);
        ImageView sellImg = new ImageView(new Image("view/icon/sell2.png"));
        sell.setGraphic(sellImg);
        sellImg.setFitHeight(40);
        sellImg.setFitWidth(40);
        vBox.getChildren().add(sell);
        VBox.setVgrow(sell, Priority.SOMETIMES);
        
        ImageView lineBreak3 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak3.setFitHeight(5);
        lineBreak3.setFitWidth(144);
        lineBreak3.setPickOnBounds(true);
        lineBreak3.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak3);
        
        //Employee
        Button emp = new Button("Employee");
        emp.setAlignment(Pos.TOP_CENTER);
        emp.setMnemonicParsing(false);
        emp.setPrefSize(127, 72);
        emp.setContentDisplay(ContentDisplay.TOP);
        ImageView empImg = new ImageView(new Image("view/icon/employe.png"));
        emp.setGraphic(empImg);
        empImg.setFitHeight(40);
        empImg.setFitWidth(40);
        vBox.getChildren().add(emp);
        VBox.setVgrow(emp, Priority.SOMETIMES);
        
        ImageView lineBreak4 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak4.setFitHeight(5);
        lineBreak4.setFitWidth(144);
        lineBreak4.setPickOnBounds(true);
        lineBreak4.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak4);
        
        //settings
        Button settings = new Button("Settings");
        settings.setAlignment(Pos.TOP_CENTER);
        settings.setMnemonicParsing(false);
        settings.setPrefSize(127, 72);
        settings.setContentDisplay(ContentDisplay.TOP);
        ImageView settingsImg = new ImageView(new Image("view/icon/settings.png"));
        settings.setGraphic(settingsImg);
        settingsImg.setFitHeight(40);
        settingsImg.setFitWidth(40);
        vBox.getChildren().add(settings);
        VBox.setVgrow(emp, Priority.SOMETIMES);
        
        ImageView lineBreak5 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak5.setFitHeight(5);
        lineBreak5.setFitWidth(144);
        lineBreak5.setPickOnBounds(true);
        lineBreak5.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak5);
        
        //About
        Button about = new Button("About");
        about.setAlignment(Pos.TOP_CENTER);
        about.setMnemonicParsing(false);
        about.setPrefSize(127, 72);
        about.setContentDisplay(ContentDisplay.TOP);
        ImageView aboutImg = new ImageView(new Image("view/icon/about.png"));
        about.setGraphic(aboutImg);
        aboutImg.setFitHeight(40);
        aboutImg.setFitWidth(40);
        vBox.getChildren().add(about);
        VBox.setVgrow(emp, Priority.SOMETIMES);
        
        ImageView lineBreak6 = new ImageView(new Image("view/icon/btnBreak.png"));
        lineBreak6.setFitHeight(5);
        lineBreak6.setFitWidth(144);
        lineBreak6.setPickOnBounds(true);
        lineBreak6.setPreserveRatio(true);
        vBox.getChildren().add(lineBreak6);
        
 
        
         //hBox @borderpane
        HBox hBox = new HBox();
        BorderPane.setAlignment(hBox, Pos.CENTER);
        bpMain.setTop(hBox);
        hBox.setPrefSize(width, 39);
        
        //Hbox Eliments
        //GridBox
        GridPane gridPane = new GridPane();
        gridPane.setMinWidth(width);
        gridPane.setPadding(new Insets(0, 30, 10, 10));
        hBox.getChildren().add(gridPane);
        
        ColumnConstraints column1 = new ColumnConstraints(width/3);
        column1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints column2 = new ColumnConstraints(width/3);
        column2.setHgrow(Priority.SOMETIMES);
        ColumnConstraints column3 = new ColumnConstraints(width/3 - 20);
        column3.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);
        
        RowConstraints row = new RowConstraints(35);
        gridPane.getRowConstraints().add(row);
        
        //GridPane Eliments
        Text dashBoard = new Text("DashBoard");
        dashBoard.setStrokeWidth(0.0);
        dashBoard.setStrokeType(StrokeType.OUTSIDE);
        dashBoard.setFont(new Font("System Bold Italic", 23.0));
        GridPane.setConstraints(dashBoard, 0, 0);
        gridPane.getChildren().add(dashBoard);
        
        Label companyName = new Label("Company Name");
        companyName.setFont(new Font("System Italic", 25));
        GridPane.setHalignment(companyName, HPos.CENTER);
        GridPane.setConstraints(companyName, 1, 0);
        gridPane.getChildren().add(companyName);
        
        //MenuButton
        MenuButton menuButton = new MenuButton();
        menuButton.setPrefHeight(38);
        GridPane.setColumnIndex(menuButton, 2);
        GridPane.setHalignment(menuButton, HPos.RIGHT);
        gridPane.getChildren().add(menuButton);
        
        //MenuButton Eliments
        MenuItem userNameMenuItem = new MenuItem();
        userNameMenuItem.setMnemonicParsing(false);
        menuButton.getItems().add(userNameMenuItem);
        //Menu Anchor
        AnchorPane userNameMenuItemAnchorPane = new AnchorPane();
        userNameMenuItemAnchorPane.setPrefSize(200, 200);
        userNameMenuItem.setGraphic(userNameMenuItemAnchorPane);
        
        //Menu - anchor - VBox
        VBox vboxMenu = new VBox(10);
        userNameMenuItemAnchorPane.getChildren().add(vboxMenu);
        vboxMenu.setPrefSize(200, 200);
        vboxMenu.setAlignment(Pos.CENTER);
        
        ImageView menuItemImageView = new ImageView(new Image("view/icon/d.png"));
        menuItemImageView.setFitHeight(40);
        menuItemImageView.setFitWidth(40);
        menuItemImageView.setPickOnBounds(true);
        menuItemImageView.setPreserveRatio(true);
        vboxMenu.getChildren().add(menuItemImageView);
        
        Label userNameLabel = new Label("UserName : " +userName);
        userNameLabel.setFont(new Font("System Bolo Italic", 15.0));
        vboxMenu.getChildren().add(userNameLabel);
        
        SQL fullNameRetSql = new SQL();
        Label fullNameLabel = new Label("FullName : " + fullNameRetSql.fullnameReturn(userName));
        fullNameLabel.setFont(new Font("System Bolo Italic", 15.0));
        vboxMenu.getChildren().add(fullNameLabel);
        
        //HyperLink to Edit Profile
        Hyperlink editHyperlink = new Hyperlink("edit/update profile");
        vboxMenu.getChildren().add(editHyperlink);
        
        //Button signOut
        Button signOut = new Button("Sign Out");
        vboxMenu.getChildren().add(signOut);
        
        
        
        //MenuButton Graphic
        AnchorPane menuButtonAnchorPane = new AnchorPane();
        menuButton.setGraphic(menuButtonAnchorPane);
        
        HBox menuButtonAnchorHbox = new HBox(10);
        menuButtonAnchorHbox.setLayoutY(9.0);
        menuButtonAnchorHbox.setPrefSize(110, 27);
        menuButtonAnchorHbox.setPadding(new Insets(0, 0, 10, 2));
        menuButtonAnchorPane.getChildren().add(menuButtonAnchorHbox);
        
        ImageView userLogo = new ImageView(new Image("view/icon/d.png"));
        userLogo.setFitHeight(30);
        userLogo.setFitWidth(30);
        userLogo.setPickOnBounds(true);
        userLogo.setPreserveRatio(true);
        menuButtonAnchorHbox.getChildren().add(userLogo);
        Label userNamelogo = new Label(userName);
        userNamelogo.setPrefSize(51, 29);
        userNamelogo.setFont(new Font(15));
        menuButtonAnchorHbox.getChildren().add(userNamelogo);
        
        
        
        //Anchorpane @borderPaer
        //BorderPane Center Part
        AnchorPane bpChild = new AnchorPane();
        BorderPane.setAlignment(bpChild, Pos.CENTER);
        bpMain.setCenter(bpChild);
        bpChild.setPadding(new Insets(0, 50, 20, 0));
        bpChild.setPrefSize((width - 285) , (height - 39));
        
        
        ////ClickOnAction ProperPy
        if(home.isSelected())
            homeApp(bpChild, home, store, sell, emp, settings, about);
        home.setOnAction(e -> homeApp(bpChild, home, store, sell, emp, settings, about));
        store.setOnAction(e -> {
            try {
                stockApp(bpChild, home, store, sell, emp, settings, about, userName);
            } catch (SQLException ex) {
                Logger.getLogger(applicationMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        sell.setOnAction(e -> sellApp(bpChild, home, store, sell, emp, settings, about));
        emp.setOnAction(e -> employeeApp(bpChild, home, store, sell, emp, settings, about));
        settings.setOnAction(e -> settingsApp(bpChild, home, store, sell, emp, settings, about));
        about.setOnAction(e -> aboutApp(bpChild, home, store, sell, emp, settings, about));
        
   
        Scene scene = new Scene(apMain, width, height);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    
    
    private void homeApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about){
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/homeRed.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        home.setGraphic(homeImg);
        
        stockButtonChangeBlack(stock);
        sellButtonChangeBlack(sell);
        empButtonChangeBlack(emp);
        aboutButtonChangeBlack(about);
        settingsButtonChangeBlack(settings);
    }
    
    private void stockApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about, String userName) throws SQLException{
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/stockRed.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        stock.setGraphic(homeImg);
        
        homeButtonChangeBlack(home);
        sellButtonChangeBlack(sell);
        empButtonChangeBlack(emp);
        aboutButtonChangeBlack(about);
        settingsButtonChangeBlack(settings);
        
        
        stockAnchorPane stAnchorPane = new stockAnchorPane();
        stAnchorPane.changeAP(anchorPane, userName);
        
    }
    
    private void sellApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about){
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/sell2Red.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        sell.setGraphic(homeImg);
        
        stockButtonChangeBlack(stock);
        homeButtonChangeBlack(home);
        empButtonChangeBlack(emp);
        aboutButtonChangeBlack(about);
        settingsButtonChangeBlack(settings);
    }
    
    private void employeeApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about){
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/employeRed.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        emp.setGraphic(homeImg);
        
        stockButtonChangeBlack(stock);
        homeButtonChangeBlack(home);
        sellButtonChangeBlack(sell);
        settingsButtonChangeBlack(settings);
        aboutButtonChangeBlack(about);
        
    }
    
    private void settingsApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about){
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/settingsRed.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        settings.setGraphic(homeImg);
        
        stockButtonChangeBlack(stock);
        homeButtonChangeBlack(home);
        sellButtonChangeBlack(sell);
        empButtonChangeBlack(emp);
        aboutButtonChangeBlack(about);
        
    }
    
    private void aboutApp(AnchorPane anchorPane, ToggleButton home, Button stock, Button sell, Button emp, Button settings, Button about){
        anchorPane.getChildren().clear();
        ImageView homeImg = new ImageView(new Image("view/icon/aboutRed.png"));
        homeImg.setFitHeight(40);
        homeImg.setFitWidth(40);
        about.setGraphic(homeImg);
        
        stockButtonChangeBlack(stock);
        homeButtonChangeBlack(home);
        sellButtonChangeBlack(sell);
        empButtonChangeBlack(emp);
        settingsButtonChangeBlack(settings);
        
    }
    
    
    
    
    
    private void homeButtonChangeBlack(ToggleButton button){
        ImageView Img = new ImageView(new Image("view/icon/home.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    private void stockButtonChangeBlack(Button button){
        ImageView Img = new ImageView(new Image("view/icon/stock.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    private void sellButtonChangeBlack(Button button){
        ImageView Img = new ImageView(new Image("view/icon/sell2.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    private void empButtonChangeBlack(Button button){
        ImageView Img = new ImageView(new Image("view/icon/employe.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    private void settingsButtonChangeBlack(Button button){
        ImageView Img = new ImageView(new Image("view/icon/settings.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    private void aboutButtonChangeBlack(Button button){
        ImageView Img = new ImageView(new Image("view/icon/about.png"));
        Img.setFitHeight(40);
        Img.setFitWidth(40);
        button.setGraphic(Img);
    }
    
    
    
    
}
