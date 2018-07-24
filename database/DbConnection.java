package database;

import view.popUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.Registration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PK
 */
public class DbConnection {
    public Connection con;
    Stage popUpStage;
    Stage primaryStage;
    static int x=0;
    
    public static String userName,passWord;
    
    
        public void DbloginWindow(Stage main){
            
            popUpStage = new Stage();
            this.primaryStage = main;
            
            TextField loginField = new TextField();
            loginField.setPromptText("Username");
            loginField.setFocusTraversable(false);
            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");
            passwordField.setFocusTraversable(false);
            
            Button loginButton = new Button("Login");
            
            loginButton.setOnAction(e -> {
                try {
                    checkConnection(loginField.getText(), passwordField.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            loginButton.setFocusTraversable(false);

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(loginField, passwordField, loginButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);

            popUpStage.setScene(scene);

            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("Salesmanagement - Database login!");
            popUpStage.setResizable(false);
            popUpStage.setAlwaysOnTop(true);
            popUpStage.setMaxWidth(400);
            popUpStage.setMinWidth(300);
            popUpStage.showAndWait();
            popUpStage.setAlwaysOnTop(true);
        }
    
    public Connection mkDatabase() throws SQLException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,passWord);
            System.out.println("Connection " + ++x + " starts");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
        return con; 
    }
    
    private void checkConnection(String userName, String password) throws SQLException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,password);
            DbConnection.userName = userName;
            DbConnection.passWord = password;
            System.err.println("connection 0 start!");
            con.close();
            System.err.println("connection 0 ends");
            popUpStage.close();
            popUp DBok  = new popUp();
            DBok.popUpWindow("Successfull :D","Database conncetion Succenfull.\nClick OK to continue");
        } catch (ClassNotFoundException | SQLException e) {
            popUpStage.close();
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            popUp DBerror = new popUp();
            DBerror.popUpWindow("Error!", "Database login error! Please restart.");
            primaryStage.close();
        }
    }
    
    void close() throws SQLException{
        this.con.close();
        System.out.println("connection " + x + "ends");
    }
}
