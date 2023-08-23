/**  
* CMPSC 221 Final Project 
* DBWorker.java  
* Purpose: This program will connect to the COVID_19 Database and retrieves 
* data from the table.
*  
* @author Alvin Chen
* @version 1.0 5/4/21
*/ 

package CDCJava;

//import statements 
import java.util.*;
import java.io.*;
import java.sql.*;

public class DBWorker {
        
    //declare and initizales variables needed for connection 
    private String driver, url, username, password;
    private Connection connection;
    private Statement statement;
    
    //constructor to connect to the database
    public DBWorker(){
        loadProperties(); //loads information from db.properties
        loadDriver(); //loads the driver 
    }
    
    /**
     *Creates a connection from the class to the database and statement
     */
    private void establishConnection(){
        try {
            //try to create connection
            connection = DriverManager.getConnection(url, username, password);
            //create statement 
            statement = connection.createStatement();
        }
        catch(Exception e){
            //if connection could not be established output to user
            System.out.println("Connection could not be established.");
        }
    }
    
    /**
     *Disconnects the connection and the statement 
     */
    private void disconnectConnection(){
        //close connection
        if(connection != null){ //if connection is not null
            try{
                connection.close(); //close the connection 
            }
            catch (SQLException ex){
                //output to error is the connection could not diconnect
                System.out.println("There was an error disconnecting the "
                        + "connection.");
            }
        }
        
        //close statement
        if(statement != null){ //if statement is not null
            try{
                statement.close(); //close the statement 
            }
            catch (SQLException ex){
                //output to error is the statement could not be diconnected
                System.out.println("There was an error disconnecting the "
                        + "statement.");
            }
        }
    }
    
    /** 
     * loads the driver for the class
     */    
    private void loadDriver(){
        try{
            Class.forName(driver); //load driver
        }
        catch(Exception exception){
            //throw exception if there is an error loading driver 
            System.out.println("There was an error loading the Driver. "
                    + "Error:" + exception);     
        }
    }       
    
    /** 
     * loads the properties for the class
     */  
    private void loadProperties(){
        try{
            InputStream input = null;
            
            /*input = ClassLoader.getSystemResourceAsStream(
                "db.properties");   
            ResourceBundle properties;
            properties = new PropertyResourceBundle(input); 
            */
            
            driver = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/COVIDDB";
            username = "app";
            password = "app";
            
            /*
            jdbc.driver= org.apache.derby.jdbc.ClientDriver
            jdbc.url = jdbc:derby://localhost:1527/COVIDDB
            jdbc.user = app
            jdbc.password = app
            */
        }
        catch(Exception exception){
            System.out.println("There was an error loading in the properties");      
        }
    }
    
    /**
     * receives a piece of data associated to the selected demographic and 
     * dataType
     * 
     * @param demographic ex. "White"
     * @param dataType ex. "CASES"
     * 
     * @return the number desired by the users given the parameters set
     */   
    public int getEntry(String demographic, String dataType){
        establishConnection(); //connect to the data base
        //declare and initialize variables
        int resultNumber = 0; 
        String strResult = "";
        try{ //gets results from the database based on the parameters 
            ResultSet results = statement.executeQuery("SELECT " + dataType + " "
                    + "FROM APP.COVID_TABLE WHERE DEMOGRAPHIC = '" + 
                    demographic + "'");
            results.next();
            //save data into a string and then into the integer or result number
            strResult = results.getString(results.findColumn(dataType));
            resultNumber = Integer.parseInt(strResult);
        }
        catch(Exception exception){
            //output to user if there was an error retreiving the entry 
            System.out.println("There was an error retreiving the entry");      
        }
        finally{
            //mask sure connection is disconnected 
            disconnectConnection();
        }
        //return the data to user
        return resultNumber; 
    }
    
    /**
     * displays all the data according to the provided demographicType and 
     * dataType
     * 
     * @param demographicType ex. "Race"
     * @param dataType ex. "POPULATION"
     * 
     * @return an array of data that fits the users parameters 
     */      
    public String[] getAllData(String demographicType, String dataType){
        establishConnection(); //create connection
        //create string array variable
        String[] allData;
        try{
            //creates a ResultSet of the numbers of items that fit the parameters
            ResultSet numOfItems = statement.executeQuery("SELECT COUNT(" + 
                    dataType + ") FROM APP.COVID_TABLE WHERE TYPE = '" + 
                    demographicType + "'");
            numOfItems.next();
            int numOfData = numOfItems.getInt(1); 
            allData = new String[numOfData]; //save data to array, set length
            
            //creates ResultSet of data from the table
            ResultSet results = statement.executeQuery("SELECT " + dataType + 
                    " FROM APP.COVID_TABLE WHERE TYPE = '" + demographicType + 
                    "'");
            //loops through the data and add each one to the array
            for(int i = 0; i < numOfData; i++){
                results.next();
                allData[i] = results.getString(results.findColumn(dataType));
            }
        }
        catch(Exception exception){
            //set array to null if there is an error
            allData = null; 
        }
        finally{
            disconnectConnection(); //disconnect connection
        }
        return allData; //return the data set to the user 
    }
    
    /**
     *Sums all the data that fit the selected parameters 
     * 
     * @param demographicType ex. "Race"
     * @param dataType ex. "POPULATION"
     * 
     * @return the sum of all the data
     */      
    public int sumAllData(String demographicType, String dataType){
        establishConnection(); //establish connection
        //declare and initialize variables
        int sumOfData = 0;
        String strResult1 = "";
        try{
            //creates a ResultSet of the sum of items that fit the parameters
            ResultSet results = statement.executeQuery("SELECT SUM(" + dataType 
                    + ") FROM APP.COVID_TABLE WHERE TYPE = '" + 
                    demographicType + "'");
            results.next();
            //save to string
            strResult1 = results.getString(results.findColumn("1"));
            //save to int
            sumOfData = Integer.parseInt(strResult1); 
        }
        catch(Exception exception){
            //output to user if there was an error retreiving the sum
            System.out.println("There was an error retreiving the sum");      
        }
        finally{
            disconnectConnection(); //disconnect connection
        }        
        return sumOfData; //return the sum of the data to the user 
    }
        
} // end of class

