package salesmanagement;

import database.DbConnection;
import view.Registration;
import view.popUp;
import database.DbModel;
import database.SQL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 @author Islam, Khondokar Hashibul aka PK
 */
public class SalesManageMent extends Application {
    AnchorPane apMother, apChild, apDesign;
    HBox hBox;
    VBox vBox;
    Label titleLabel, SignIn, mail;
    GridPane gridPane;
    TextField userName ;
    PasswordField passwordField;
    Button clearUserButton, clearPassWordButton, logInButton;
    Hyperlink createAccout;
    Text nameDev;
    Stage primaStage;
    private static int loginCounter = 0;
    
    public SalesManageMent(){
        
    } 
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        this.primaStage = primaryStage;
        if(loginCounter == 0){
            
            DbConnection connect = new DbConnection();
            connect.DbloginWindow(primaryStage);

            DbModel model = new DbModel();
            model.createDataBase();
            ++loginCounter;
        }
        
        //ApMother
        apMother = new AnchorPane();
        apMother.setPrefHeight(620);
        apMother.setPrefWidth(989);
        
        //HBox
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(535);
        hBox.setPrefWidth(760);
        AnchorPane.setBottomAnchor(hBox, 0.0);
        AnchorPane.setTopAnchor(hBox, 0.0);
        AnchorPane.setRightAnchor(hBox, 0.0);
        AnchorPane.setLeftAnchor(hBox, 0.0);
        
        
        //VBox
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(620);
        vBox.setPrefWidth(726);
        
        
        //Apchild
        apChild = new AnchorPane();
        apChild.setPrefHeight(384);
        apChild.setPrefWidth(668);
        
        
        //Label Title
        titleLabel = new Label("Sales Management");
        titleLabel.setLayoutX(14);
        titleLabel.setLayoutY(18);
        titleLabel.setTextFill(Color.web("#0076a3"));
        titleLabel.setFont(new Font("System Bold",31));
        Reflection reflection = new Reflection();
        reflection.setBottomOpacity(0.04);
        reflection.setFraction(0.6);
        reflection.setTopOpacity(0.32);
        titleLabel.setEffect(reflection);
        
        
        //AnchorPane Main
        apDesign = new AnchorPane();
        apDesign.prefHeight(280);
        apDesign.prefWidth(290);
        apDesign.setLayoutX(381);
        apDesign.setLayoutY(52);
        //apDesign.setStyle("-fx-background-color: BROWN;");
        
        
        //Sign in, Gridpane for Login and HyperLink for new account goes in apDesign
        //Sign in
        SignIn = new Label("SIGN IN");
        SignIn.setLayoutX(90);
        SignIn.setLayoutY(14);
        SignIn.setFont(new Font("Dejavu Sans Bold", 29));
        
        //GridPane for login details
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 5, 0, 0));
        gridPane.setVgap(10);
        gridPane.setLayoutX(5);
        gridPane.setLayoutY(83);
        gridPane.setPrefHeight(97);
        gridPane.setPrefWidth(281);
        
        //Sign IN elements
        userName = new TextField();
        userName.setPromptText("User Name");
        userName.setFocusTraversable(false);
        userName.setOnAction(e -> login(primaryStage));
        
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setFocusTraversable(false);
        passwordField.setOnAction(e -> login(primaryStage));
        
        clearUserButton = new Button("X");
        clearUserButton.setMnemonicParsing(false);
        clearUserButton.setPrefSize(29, 31);
        clearUserButton.setFocusTraversable(false);
        clearUserButton.setOnAction(e -> clearUserName());
        
        clearPassWordButton = new Button("X");
        clearPassWordButton.setMnemonicParsing(false);
        clearPassWordButton.setPrefSize(29, 31);
        clearPassWordButton.setFocusTraversable(false);
        clearPassWordButton.setOnAction(e -> clearPassword());
        
        GridPane.setConstraints(userName, 0, 0, 2, 1);
        GridPane.setConstraints(passwordField, 0, 1, 2, 1);
        GridPane.setConstraints(clearUserButton, 0, 0, 2, 1);
        GridPane.setHalignment(clearUserButton, HPos.RIGHT);
        GridPane.setConstraints(clearPassWordButton, 0, 1, 2, 1);
        GridPane.setHalignment(clearPassWordButton, HPos.RIGHT);
        
        ColumnConstraints column1 = (new ColumnConstraints(100, 250, 250));
        column1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints column2 = (new ColumnConstraints(100, 250, 250));
        column2.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().addAll(column1, column2);
        
        RowConstraints row1 = new RowConstraints(10, 30, 30);
        row1.setVgrow(Priority.SOMETIMES);
        RowConstraints row2 = new RowConstraints(10, 30, 30);
        row2.setVgrow(Priority.SOMETIMES);
        gridPane.getRowConstraints().addAll(row1, row2);
        
        gridPane.getChildren().addAll(userName, passwordField, clearPassWordButton, clearUserButton);
        ///End of GridPane
        
        logInButton = new Button("Log in");
        logInButton.setLayoutX(112);
        logInButton.setLayoutY(203);
        logInButton.setMnemonicParsing(false);
        logInButton.setOnAction(e -> login(primaryStage));
        
        //Create an accout
        createAccout = new Hyperlink("Create an account");
        createAccout.setLayoutX(90);
        createAccout.setLayoutY(256);
        createAccout.setFont(new Font(" ",11));
        createAccout.setFocusTraversable(false);
        createAccout.setOnAction(e -> createNewAccout());
        //All goes into ApDesign && End of ApDesign
        
        //Text For Descripe of Us @Islam, Khondokar Hashibul aka PK
        nameDev = new Text("CREATED BY:\n\tSheshir & \n\t\tPK(Hashibul)");
        nameDev.setFill(Color.BLACK);
        nameDev.setFont(new Font(20));
        nameDev.setLayoutX(14);
        nameDev.setLayoutY(122);
        nameDev.setStrokeType(StrokeType.OUTSIDE);
        nameDev.setStrokeWidth(0);
        nameDev.setWrappingWidth(319.99999513477087);
        
        
        mail = new Label("email me :\n     peeyalk@gmail.com");
        mail.setLayoutX(14);
        mail.setLayoutY(260);
        mail.setTextFill(Color.BLACK);
        mail.setFont(new Font("System Italic", 16));
        
        
        
        apDesign.getChildren().addAll(SignIn, gridPane, createAccout, logInButton);
        apChild.getChildren().addAll(titleLabel, apDesign, nameDev, mail);
        vBox.getChildren().add(apChild);
        hBox.getChildren().add(vBox);
        apMother.getChildren().add(hBox);
        
        
        Scene scene = new Scene(apMother,989,620);
        primaryStage.setTitle("Sales Management System - Login!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //Set on action methods
    private void createNewAccout(){
        Registration registration;
        registration = new Registration();
        registration.regWindow();
    }
    
    private void login(Stage primaryStage){
        if(userName.getText().trim() == null || userName.getText().trim().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your User name");
        }
        if(passwordField.getText().trim() == null || passwordField.getText().trim().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your password");
        }
        try {
              SQL login = new SQL();
              login.login(userName, passwordField , primaryStage);
        } catch (Exception e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void clearUserName(){
        userName.setText("");
        passwordField.setText(null);
    }
    
    private void clearPassword(){
        passwordField.setText(null);
    }
    
}
