package database;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Registration;

/**
 *
 * @author PK
 */
public class DbModel{
 
    public PreparedStatement pst = null;
        
        public void createDataBase(){
            DbConnection con = new DbConnection();
            try {
                 
                String CreateUsers = " DECLARE cnt NUMBER;\n" +
                                "BEGIN\n" +
                                "  SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'USERS';\n" +
                                "  IF cnt = 0 THEN \n" +
                                "    EXECUTE IMMEDIATE 'CREATE table SALESMANAGEMENT.USERS (\n" +
                                "    USER_NAME  VARCHAR2(20) NOT NULL UNIQUE,\n" +
                                "    ID         NUMBER(3) NOT NULL,\n" +
                                "    PASSWORD   VARCHAR2(50) NOT NULL,\n" +
                                "    ADDRESS    VARCHAR2(50),\n" +
                                "    PHONE      NUMBER(11) UNIQUE,\n" +
                                "    FULL_NAME  VARCHAR2(30) NOT NULL,\n" +
                                "    constraint  \"SALESMANAGEMENT.USER_PK\" primary key (\"ID\")\n" +
                                ")'; \n" +
                                "  END IF;\n" +
                                "END;";
                
                
                pst = con.mkDatabase().prepareStatement(CreateUsers);
                pst.execute();
                con.close();
                
                String CreateProduct = " DECLARE cnt NUMBER;\n" +
                                "BEGIN\n" +
                                "SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'PRODUCT';\n" +
                                "IF cnt = 0 THEN\n" +
                                "EXECUTE IMMEDIATE 'CREATE table SALESMANAGEMENT.PRODUCT (\n" +
                                "    ID            NUMBER(3) NOT NULL,\n" +
                                "    NAME          VARCHAR2(50) NOT NULL UNIQUE,\n" +
                                "    QUANTITY      NUMBER(4) NOT NULL,\n" +
                                "    CREATOR_ID    NUMBER(3) NOT NULL,\n" +
                                "    SUPPLIER_ID   NUMBER(2) NOT NULL,\n" +
                                "    BRAND_ID      NUMBER(3) NOT NULL,\n" +
                                "    CATAGORY_ID   NUMBER(3) NOT NULL,\n" +
                                "    PRICE         FLOAT(3) NOT NULL,\n" +
                                "    PRODUCT_ID    VARCHAR2(50) NOT NULL UNIQUE,\n" +
                                "    DESCRIPTION   VARCHAR2(50),\n" +
                                "    DATE_ADDED_ON DATE NOT NULL,\n" +
                                "    constraint  \"Salesmanagement.PRODUCT_PK\" primary key (\"ID\")\n" +
                                ")';\n" +
                                " END IF;\n" +
                                "END;";
                pst = con.mkDatabase().prepareStatement(CreateProduct);
                pst.execute();
                con.close();
                
                String CreateSupplier = "DECLARE cnt NUMBER;\n" +
                                "BEGIN\n" +
                                "SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'SUPPLIER';\n" +
                                "IF cnt = 0 THEN\n" +
                                "EXECUTE IMMEDIATE 'CREATE table SALESMANAGEMENT.SUPPLIER (\n" +
                                "    ID            NUMBER(3) NOT NULL UNIQUE,\n" +
                                "    NAME          VARCHAR2(50) NOT NULL UNIQUE,\n" +
                                "    CREATOR_ID    NUMBER(3) NOT NULL,\n" +
                                "    PHONE         NUMBER(11) NOT NULL UNIQUE,\n" +
                                "    ADDRESS       VARCHAR2(30) NOT NULL,\n" +
                                "    DESCRIPTION   VARCHAR2(50),\n" +
                                "    DATE_ADDED_ON DATE NOT NULL\n" +
                                ")';\n" +
                                " END IF;\n" +
                                "END;";
                pst = con.mkDatabase().prepareStatement(CreateSupplier);
                pst.execute();
                con.close();
                
                String CreateBrand = " DECLARE cnt NUMBER;\n" +
                                "BEGIN\n" +
                                "SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'BRAND';\n" +
                                "IF cnt = 0 THEN\n" +
                                "EXECUTE IMMEDIATE 'CREATE table SALESMANAGEMENT.BRAND (\n" +
                                "    ID            NUMBER(3) NOT NULL,\n" +
                                "    NAME          VARCHAR2(30) NOT NULL UNIQUE,\n" +
                                "    SUPPLIER_ID   NUMBER(3) NOT NULL,\n" +
                                "    CREATOR_ID    NUMBER(3) NOT NULL,\n" +
                                "    DESCRIPTION   VARCHAR2(50),\n" +
                                "    DATE_ADDED_ON DATE NOT NULL\n" +
                                ")';\n" +
                                " END IF;\n" +
                                "END;";
                pst = con.mkDatabase().prepareStatement(CreateBrand);
                pst.execute();
                con.close();
                
                String CreateCatagory = "DECLARE cnt NUMBER;\n" +
                                "BEGIN\n" +
                                "SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'CATAGORY';\n" +
                                "IF cnt = 0 THEN\n" +
                                "EXECUTE IMMEDIATE 'CREATE table SALESMANAGEMENT.CATAGORY (\n" +
                                "    ID            NUMBER(3) NOT NULL,\n" +
                                "    NAME          VARCHAR2(50) NOT NULL UNIQUE,\n" +
                                "    BRAND_ID      NUMBER(3) NOT NULL,\n" +
                                "    SUPPLIER_ID   NUMBER(3) NOT NULL,\n" +
                                "    CREATOR_ID    NUMBER(3) NOT NULL,\n" +
                                "    DATE_ADDED_ON DATE NOT NULL,\n" +
                                "    DESCRIPTION   VARCHAR2(50)\n" +
                                ")';\n" +
                                " END IF;\n" +
                                "END;";
                pst = con.mkDatabase().prepareStatement(CreateCatagory);
                pst.execute();
                con.close();
               
                
                
                
                
            } catch (Exception e) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
            }
    }
}


/*
                                DECLARE cnt NUMBER;
                               `BEGIN
                                  SELECT count(*) INTO cnt FROM all_tables WHERE table_name = 'USERS';
                                  IF cnt = 0 THEN
                                    EXECUTE IMMEDIATE '';
                                  END IF;
                                END;
*/

