package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import view.Registration;
import view.applicationMain;
import view.popUp;


public class SQL {
    
    DbConnection dbcon = new DbConnection();
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    static int userId = 0, productId = 0 , supplierId = 0, brandId = 0, catagoryId = 0, sellId = 0;
    
    
    public void registration(String userName, String fullName, String password , Stage Regwindow) throws SQLException {
        con = dbcon.mkDatabase();
        try {
            setUserId();
            
            userId++;
            pst = con.prepareStatement("insert into SALESMANAGEMENT.USERS(id,user_name,full_name,password) values(?,?,?,?)");
            pst.setInt(1, userId);
            pst.setString(2, userName);
            pst.setString(3, fullName);
            pst.setString(4, password);
            pst.execute();
            popUp Congo = new popUp() ;
            Congo.popUpWindow("Congratulation", "Your account has been created. Press OK to Continue to login page");
            Regwindow.close();
            con.close();
        } catch (Exception e) {
            popUp regError = new popUp();
            regError.popUpWindow("Error Signing In", "Try with different credentials.");
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            userId--;
        }
    }
    
    
    //set ids
    private void setUserId() throws SQLException{
        try {
            pst = con.prepareStatement("select max(id) \"id\" from salesmanagement.users");
            rs = pst.executeQuery();
            while(rs.next()){
                userId = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setProductId() throws SQLException{
        try {
            pst = con.prepareStatement("select max(id) \"id\" from salesmanagement.product");
            rs = pst.executeQuery();
            while(rs.next()){
                productId = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setSupplierId() throws SQLException{
        try {
            pst = con.prepareStatement("select max(id) \"id\" from salesmanagement.supplier");
            rs = pst.executeQuery();
            while(rs.next()){
                supplierId = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setBrandId() throws SQLException{
        try {
            pst = con.prepareStatement("select max(id) \"id\" from salesmanagement.brand");
            rs = pst.executeQuery();
            while(rs.next()){
                brandId = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setCatagoryId() throws SQLException{
        try {
            pst = con.prepareStatement("select max(id) \"id\" from salesmanagement.catagory");
            rs = pst.executeQuery();
            while(rs.next()){
                catagoryId = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    
    
    
    public void login(TextField user, PasswordField password, Stage primatyStage) throws SQLException{
        con = dbcon.mkDatabase();
        String userName = user.getText();
        try {
            pst = con.prepareStatement("select password from salesmanagement.users where user_name = ?");
            pst.setString(1, userName);
            String confirmPass = null;
            rs = pst.executeQuery();
            while(rs.next()){
                confirmPass = rs.getString("password");
            }
            
            if(password.getText().equals(confirmPass)){
                popUp popup = new popUp();
                popup.popUpWindow("Login Success!", "Logged in as : " + userName);
                rs.close();
                pst.close();
                con.close();
                applicationMain main = new applicationMain();
                main.StartMain(userName, primatyStage);
            }
            else{
                popUp popUp = new popUp();
                popUp.popUpWindow("Erro -Login", "Username or Password didn't match. Try again");
                password.setText(null);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String fullnameReturn(String userName) throws SQLException{
        String fullName = null;
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select full_name from salesmanagement.users where user_name = ?");
            pst.setString(1, userName);
            rs = pst.executeQuery();
            while(rs.next()){
                fullName = rs.getString("full_name");
            }
        } catch (Exception e) {
        }
        rs.close();
        pst.close();
        con.close();
        return fullName;
    }
    
    public void returnSupplierName(ComboBox<String> combo) throws SQLException{
        String supplierName = null;
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select name from salesmanagement.supplier");
            rs = pst.executeQuery();
            while(rs.next()){
                supplierName = rs.getString("name");
                combo.getItems().add(supplierName);
            }
            System.out.println("combo");
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
        }
        
    }
    
    public void returnBrandName(ComboBox<String> combo) throws SQLException{
        String supplierName = null;
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select name from salesmanagement.brand");
            rs = pst.executeQuery();
            while(rs.next()){
                supplierName = rs.getString("name");
                combo.getItems().add(supplierName);
            }
            System.out.println("combo");
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
        }
        
    }
    public void returnCatagoryName(ComboBox<String> combo) throws SQLException{
        String supplierName = null;
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select name from salesmanagement.catagory");
            rs = pst.executeQuery();
            while(rs.next()){
                supplierName = rs.getString("name");
                combo.getItems().add(supplierName);
            }
            System.out.println("combo");
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
        }
        
    }
    
    //Store
    public ObservableList<product> getProduct() throws SQLException{
        ObservableList<product> productList = FXCollections.observableArrayList();
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select p.product_id \"product_id\",p.name \"product_name\",p.quantity \"Quantity\",p.price \"price\", s.name \"supplier_name\",b.name \"brana_name\",c.name\"catagory_name\",u.user_name \"AddedBy\",p.date_added_on \"date_added_on\" from salesmanagement.product p ,salesmanagement.supplier s ,salesmanagement.brand b,salesmanagement.catagory c,salesmanagement.users u where p.supplier_id = s.id and p.brand_id = b.id  and p.catagory_id = c.id and b.supplier_id = s.id and u.id = p.creator_id");
            rs = pst.executeQuery();
            while(rs.next()){
                product p = new product();
                p.setProductID(rs.getString(1));
                p.setName(rs.getString(2));
                p.setQuantity(rs.getInt(3));
                p.setPrice(rs.getDouble(4));
                p.setSupplier(rs.getString(5));
                p.setCatagory(rs.getString(7));
                p.setBrand(rs.getString(6));
                p.setDateAddedOn(rs.getDate(9));
                p.setAddedBy(rs.getString(8));
                productList.add(p);
            }
        } catch (Exception e) {
        }
        con.close();
        return productList;
    }
    
    
    
    public ObservableList<supplier> getSupplier() throws SQLException{
        ObservableList<supplier> supplierList = FXCollections.observableArrayList();
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select * from SALESMANAGEMENT.supplier");
            rs = pst.executeQuery();
            while(rs.next()){
                supplier s = new supplier();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setCreatorID(rs.getInt(3));
                s.setPhone(rs.getInt(4));
                s.setAddress(rs.getString(5));
                s.setDescription(rs.getString(6));
                s.setDateAddedOn(rs.getDate(7));
                supplierList.add(s);
            }
        } catch (Exception e) {
        }
        con.close();
        return supplierList;
    }
    
    public ObservableList<brand> getBrand() throws SQLException{
        ObservableList<brand> brandList = FXCollections.observableArrayList();
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select b.*,s.name from salesmanagement.brand b, salesmanagement.supplier s where b.supplier_id = s.id");
            rs = pst.executeQuery();
            while(rs.next()){
                brand b = new brand();
                b.setName(rs.getString(2));
                b.setSupplier(rs.getString(7));
                b.setDescription(rs.getString(5));
                b.setDateAddedOn(rs.getDate(6));
                
                brandList.add(b);
            }
        } catch (Exception e) {
        }
        con.close();
        return brandList;
    }
    
    
    public ObservableList<catagory> getCatagory() throws SQLException{
        
        ObservableList<catagory> supplierList = FXCollections.observableArrayList();
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("select c.name,b.name, s.name, u.user_name, b.date_added_on,c.description from salesmanagement.brand b, salesmanagement.supplier s, salesmanagement.users u, salesmanagement.catagory c where c.brand_id = b.id and c.supplier_id = s.id and c.creator_id = u.id");
            rs = pst.executeQuery();
            while(rs.next()){
                catagory s = new catagory();
                s.setName(rs.getString(1));
                s.setBrand(rs.getString(2));
                s.setSupplier(rs.getString(3));
                s.setCreator(rs.getString(4));
                s.setDateAddedOn(rs.getDate(5));
                s.setDiscription(rs.getString(6));
                
                supplierList.add(s);
            }
        } catch (Exception e) {
        }
        con.close();
        return supplierList;
    
    }
    
    
    
    //Adding
    public void addProduct(String name, int quantity, String userName, String supplier, String brand, String catagory, double price, String productIdName, String desc, Date dateAddedOn) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            setProductId();
            productId++;
            
            pst = con.prepareStatement("insert into SALESMANAGEMENT.PRODUCT values(?,?,?,(select id from SALESMANAGEMENT.USERS where user_name = ?),(select id from SALESMANAGEMENT.SUPPLIER where name = ?),(select id from SALESMANAGEMENT.BRAND where name = ?),(select id from SALESMANAGEMENT.CATAGORY where name = ?),?,?,?,?)");
            pst.setInt(1, productId);
            pst.setString(2, name);
            pst.setInt(3, quantity);
            pst.setString(4,userName);
            pst.setString(5, supplier);
            pst.setString(6, brand);
            pst.setString(7, catagory);
            pst.setDouble(8, price);
            pst.setString(9, productIdName);
            pst.setString(10, desc);
            pst.setDate(11, (java.sql.Date) dateAddedOn);
            
            pst.executeUpdate();
            popUp Congo = new popUp() ;
            Congo.popUpWindow("Added!", "Successfully Added a new Product");
            con.close();
        } catch (Exception e) {
            popUp productAddError = new popUp();
            productAddError.popUpWindow("Error Adding Product", "Try with different fields");
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            productId--;
        }
    } 
    
    public void addSupplier(String name, String userName, int phone, String address, String desc) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            setSupplierId();
            supplierId++;
            
            pst = con.prepareStatement("insert into SALESMANAGEMENT.supplier values(?,?, (select id from SALESMANAGEMENT.USERS WHERE USER_NAME = ?), ?, ?, ?, SYSDATE)");
            pst.setInt(1, supplierId);
            pst.setString(2, name);
            pst.setString(3, userName);
            pst.setInt(4, phone);
            pst.setString(5, address);
            pst.setString(6, desc);
            
            pst.executeQuery();
            popUp Congo = new popUp() ;
            Congo.popUpWindow("Added!", "Successfully Added a new Supplier");
            con.close();
            
        } catch (Exception e) {
            popUp productAddError = new popUp();
            productAddError.popUpWindow("Error Adding Supplier", "Try with different fields");
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            supplierId--;
        }
    }
    
    public void addBrand(String name , String supplier, String userName, String desc) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            setBrandId();
            brandId++;
            
            pst = con.prepareStatement("insert into salesmanagement.brand values(?,?,(select id from salesmanagement.supplier where name = ?),(select id from salesmanagement.users where user_name = ?),?,SYSDATE)");
            pst.setInt(1, brandId);
            pst.setString(2, name);
            pst.setString(3, supplier);
            pst.setString(4, userName);
            pst.setString(5, desc);
            
            pst.executeQuery();
            
            popUp Congo = new popUp() ;
            Congo.popUpWindow("Added!", "Successfully Added a new Brand");
            con.close();
        } catch (Exception e) {
            popUp productAddError = new popUp();
            productAddError.popUpWindow("Error Adding Brand", "Try with different fields");
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            brandId--;
        }
        con.close();
    }
    
    
    public void addCatagory(String name, String brand, String supplier, String userName, String desc) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            setCatagoryId();
            catagoryId++;
            
            pst = con.prepareStatement("insert into salesmanagement.catagory values(?, ?, (select id from salesmanagement.brand where name = ?), (select id from salesmanagement.supplier where name = ?), (select id from salesmanagement.users where user_name = ?), SYSDATE,?)");
            pst.setInt(1, catagoryId);
            pst.setString(2, name);
            pst.setString(3, brand);
            pst.setString(4, supplier);
            pst.setString(5, userName);
            pst.setString(6, desc);
            
            pst.executeQuery();
            
            popUp Congo = new popUp() ;
            Congo.popUpWindow("Added!", "Successfully Added a new Catagory");
            con.close();
        } catch (Exception e) {
            popUp productAddError = new popUp();
            productAddError.popUpWindow("Error Adding Catagory", "Try with different fields");
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            catagoryId--;
        }
        con.close();
    }
    
    
    
    
    
    //delete
    public void deleteProduct(String productId) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("delete from SALESMANAGEMENT.PRODUCT where product_id = ?");
            pst.setString(1, productId);
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
        }
    }
    
    public void deleteSupplier(int supplierId) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("delete from SALESMANAGEMENT.supplier where id = ?");
            pst.setInt(1, supplierId);
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
        }
    }
    
    public void deleteBrand(String name) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("delete from SALESMANAGEMENT.brand where name = ?");
            pst.setString(1, name);
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
        }
    }
    
    public void deleteCatagory(String name) throws SQLException{
        con = dbcon.mkDatabase();
        try {
            pst = con.prepareStatement("delete from SALESMANAGEMENT.catagory where name = ?");
            pst.setString(1, name);
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
        }
    }
}
