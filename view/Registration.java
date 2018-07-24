package view;

import database.DbModel;
import database.SQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Registration{
    
    Stage RegWindow;

    public void regWindow() {
        RegWindow = new Stage();
        AnchorPane apDesign = new AnchorPane();
        apDesign.setPrefSize(600, 400);
        apDesign.setMaxSize(600, 400);
        apDesign.setMinSize(600, 400);
        apDesign.setPadding(new Insets(100, 100, 100, 100));
        
        GridPane grid = new GridPane();
        grid.setPrefSize(371,162);
        grid.setLayoutX(115);
        grid.setLayoutY(94);
        
        Text RegisText = new Text("                           Registration");
        RegisText.setStrokeType(StrokeType.OUTSIDE);
        RegisText.setStrokeWidth(0.0);
        RegisText.setFont(new Font("System Bold", 17));
        RegisText.setWrappingWidth(346.65625);
        GridPane.setColumnSpan(RegisText, 2);
        
        TextField userName = new TextField();
        userName.setPromptText("Enter User Name");
        userName.setPrefSize(271, 25);
        GridPane.setColumnSpan(userName, 2);
        GridPane.setRowIndex(userName, 1);
        userName.setFocusTraversable(false);
        
        TextField fullName = new TextField();
        fullName.setPromptText("Enter Full Name");
        GridPane.setColumnSpan(fullName, 2);
        GridPane.setRowIndex(fullName, 2);
        fullName.setFocusTraversable(false);
        
        PasswordField password = new PasswordField();
        password.setPromptText("Type Password");
        GridPane.setColumnSpan(password, 2);
        GridPane.setRowIndex(password, 3);
        password.setFocusTraversable(false);
        
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Re-Type Password");
        GridPane.setColumnSpan(confirmPasswordField, 2);
        GridPane.setRowIndex(confirmPasswordField, 4);
        confirmPasswordField.setFocusTraversable(false);
        
        Button clearUN = new Button("X");
        GridPane.setRowIndex(clearUN, 1);
        buttonSet(clearUN);
        clearUN.setOnAction(e -> clear(userName));
        clearUN.setFocusTraversable(false);
        
        Button clearFN = new Button("X");
        GridPane.setRowIndex(clearFN, 2);
        buttonSet(clearFN);
        clearFN.setFocusTraversable(false);
        clearFN.setOnAction(e -> clear(fullName));
        
        
        Button clearPW = new Button("X");
        GridPane.setRowIndex(clearPW, 3);
        buttonSet(clearPW);
        clearPW.setFocusTraversable(false);
        clearPW.setOnAction(e -> clearpw(password));
        
        Button clearConfirm = new Button("X");
        GridPane.setRowIndex(clearConfirm, 4);
        buttonSet(clearConfirm);
        clearConfirm.setFocusTraversable(false);
        clearConfirm.setOnAction(e -> clearpw(confirmPasswordField));
        
        
        ColumnConstraints column1 = new ColumnConstraints(10, 305, 324);
        column1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints column2 = new ColumnConstraints(10, 54, 191);
        column2.setHgrow(Priority.SOMETIMES);
        grid.getColumnConstraints().addAll(column1, column2);
        
        RowConstraints row1 = new RowConstraints(10, 30, 30);
        row1.setVgrow(Priority.SOMETIMES);
        RowConstraints row2 = new RowConstraints(10, 30, 30);
        row2.setVgrow(Priority.SOMETIMES);
        RowConstraints row3 = new RowConstraints(10, 30, 30);
        row3.setVgrow(Priority.SOMETIMES);
        RowConstraints row4 = new RowConstraints(10, 30, 30);
        row4.setVgrow(Priority.SOMETIMES);
        RowConstraints row5 = new RowConstraints(10, 30, 30);
        row5.setVgrow(Priority.SOMETIMES);
        
        GridPane.setHalignment(clearUN, HPos.RIGHT);
        GridPane.setHalignment(clearFN, HPos.RIGHT);
        GridPane.setHalignment(clearPW, HPos.RIGHT);
        GridPane.setHalignment(clearConfirm, HPos.RIGHT);
        
        grid.getRowConstraints().addAll(row1, row2, row3, row4, row5);
        
        grid.getChildren().addAll(RegisText,userName,fullName,password,confirmPasswordField,clearConfirm,clearFN,clearPW,clearUN);
        
        Hyperlink already = new Hyperlink("ALready Have An Account? Login");
        already.setLayoutX(200);
        already.setLayoutY(316);
        already.setFocusTraversable(false);
        already.setOnAction(e -> RegWindow.close());
        
        Button signUp = new Button("Sign up");
        signUp.setLayoutX(265);
        signUp.setLayoutY(272);
        signUp.setMnemonicParsing(false);
        signUp.setOnAction(e -> {
            try {
                signUp(userName, fullName, password, confirmPasswordField);
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        apDesign.getChildren().addAll(grid,already,signUp);
        
        Scene scene  = new Scene(apDesign, 600, 400);
        RegWindow.setScene(scene);
        RegWindow.initModality(Modality.APPLICATION_MODAL);
        RegWindow.setTitle("Registration -SalesManagement");
        RegWindow.setResizable(false);
        RegWindow.setAlwaysOnTop(false);
        RegWindow.showAndWait();
    }
    
    /*void setClearButtonProperty(Button b){
        b.setLayoutX(279);
        b.setMnemonicParsing(false);
        b.setPrefSize(35, 25);
    }*/
    
    void buttonSet(Button b){
        b.setMnemonicParsing(false);
        GridPane.setColumnIndex(b, 1);
    }

    //handlers
    private void clear(TextField userName) {
        userName.setText(null);
    }
    private void clearpw(PasswordField userName) {
        userName.setText(null);
    }
    
    private void signUp(TextField userName, TextField fullName, PasswordField password, PasswordField confirmPassword) throws SQLException{
        
        if(userName.getText().trim() == null || userName.getText().trim().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your User name");
        }
        else if(fullName.getText().trim() == null || fullName.getText().trim().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your Full name");
        }
        else if(password.getText() == null || password.getText().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your password");
        }
        else if(confirmPassword.getText() == null || confirmPassword.getText().isEmpty()){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "You must enter your password again");
            clearpw(password);
            clear(confirmPassword);
        }
        
        else if(!password.getText().equals(confirmPassword.getText())){
            popUp popup = new popUp();
            popup.popUpWindow("Error!", "Passwords doesn't match. Try again!");
            clearpw(password);
            clear(confirmPassword);
        }
        else{
            SQL sql = new SQL();
            sql.registration(userName.getText(), fullName.getText(), password.getText(), RegWindow);
        }
    }
}
