/**  
* CMPSC 221 Final Project
* SearchQuery.java 
* Purpose: Utilizes the DBWorker class to find the answers to searches
* entered in the user interfaces
*  
* @author Gabriel Fleming
* @version 1.0 5/4/21
*/ 
package CDCJava;

/*
import CDCJava.DataTypeInfo;
import CDCJava.DBWorker;
*/

public class SearchQuery {
    //the type of demographic being searched for ("Race", "Sex", or "Age")
    private String demographicType;
    //a demographic, such as "Male"
    private String demographic;
    //the type of data being searched for (e.g. "Percent Infected")
    private String dataType;
    //The type of statistic that corresponds to the dataType (e.g. "percentOf")
    private String statisticType;
    //The Category of data that corresponds to the dataType (e.g. "CASES")
    private String dataCategory;
    
    //the DBWorker and DataTypeInfo are shared by all instances of the class
    private static DBWorker dbWorker;
    private static DataTypeInfo dataInfo;
    
    
    
    /**
     * the default constructor
     */
    public SearchQuery(){
        //creates an instance of DataTypeInfo if there isn't one already
        if(dataInfo == null){
            dataInfo = new DataTypeInfo();
            
        //creates an instance of DBWorker if there isn't one already
        if(dbWorker == null){
            dbWorker = new DBWorker();
        }
        }
    }
    
    /**
     * A constructor that sets initial values for each attribute
     * 
     * @param initDemographicType the initial value for demographicType
     * @param initDemographic the initial value for demographic
     * @param initDataType the initial value for dataType
     */
    public SearchQuery(String initDemographicType, 
            String initDemographic, String initDataType){
        
        
        //creates an instance of DataTypeInfo if there isn't one already
        if(dataInfo == null){
            dataInfo = new DataTypeInfo();
        }
            
         //creates an instance of DBWorker if there isn't one already
        if(dbWorker == null){
            dbWorker = new DBWorker();
        }
        
        demographicType = initDemographicType;
        demographic = initDemographic;
        //sets the value for dataType
        //and also sets corresponding values for dataCategory and statisticType
        setDataType(initDataType);
        
    }

    
    /**
     * returns a list of all demographics in a demographic Type
     * (e.g. all races)
     * @param demographicType the type of demographic (e.g. "Race")
     * @return an array containing all demographics of the type
     */
    public String[] getDemographicList(String demographicType){
        return dbWorker.getAllData(demographicType, "Demographic");
    }
    
    
    /**
     * returns a list of all valid values for dataType
     * 
     * @return the list of dataType values
     */
    public String[] getDataTypeList(){
        return dataInfo.getDataTypeList();
    }
    
    /**
     * Uses the database to perform a search based on the class attributes
     * 
     * @return A string representing the search and its results
     */
    public String executeSearch() {
        String searchResult; //the result of the search
        
        //determines what method is used to perform the search based on the
        //type of statistic being searched for
        switch(statisticType){
            case "NumberOf":
                searchResult = this.numberOfSearch();
                break;
            case "PercentWith":
                searchResult = this.percentWithSearch();
                break;
            case "PercentOfAll":
                searchResult = this.percentOfAllSearch();
                break;
            default: 
                searchResult = "";
                break;
        }
        
        String returnString = formatSearchResult(searchResult);
        return returnString;
    }
    
    /**
     * Formats the search result String in a way that will look nice on
     * the user interfaces
     * 
     * @param result a String representing the numerical result of the search
     * @return A String representing a search result
     */
    private String formatSearchResult(String searchResult){
        String returnString; //the string that is returned
        //the string contains information about what was searched for
        returnString = ("Search type: " + this.dataType 
                + "     Search Demographic: " + demographic.toLowerCase()
                );
        
        //depending on the demographicType, extra words are added to the end
        switch(demographicType){
            case "Sex":
                //for sex, an s is added (e.g. "males")
                returnString += "s"; 
                break;
            case "Race":
                //for race, " people" is added (e.g. "white people")
                returnString += " people";
                break;
            case "Age":
                //for age " year olds" is added (e.g. "0-17 year olds")
                returnString += " year olds";
                break;
        }
        
        //adds the search result to the string
        returnString += ("      Search Result: " + searchResult);
        return returnString;
    }
    
    /**
     * Searching for the  number of something
     * e.g. number of cases for males
     * 
     * @return A string representing an integer, containing commas
     */
    private String numberOfSearch(){
        //gets the total from the database
        int total = dbWorker.getEntry(demographic, dataCategory);
        String totalString = this.formatInteger(total);
        return totalString;
    }
    
    /**
     * Searching for the percent of people with a characteristic
     * e.g. Percent of males with at least one dose of the vaccine
     * 
     * @return A string representing the percentage
     */
    private String percentWithSearch(){
        
        
        //the number of people in the demographic with the characteristic
        //has the type of double to avoid integer division
        double numberWith = dbWorker.getEntry(demographic, dataCategory);
        //the total population of the demographic
        int demographicPopulation = 
                dbWorker.getEntry(demographic, "POPULATION");
        
        //the percent of people in a population with X characteristic 
        //is equal to the number with X divided by the total population
        double percentWith = (numberWith / demographicPopulation);
        
        String returnString = this.formatAsPercentage(percentWith);
        
        
        return returnString;
        
    }
    
    /**
     * Finds the percentage of something that belongs to X groups
     * e.g. the percentage of vaccines that were given to males
     * 
     * @return A string representing the percentage
     */
    private String percentOfAllSearch(){
        //the total number of people in the demographic with X characteristic
        double demographicWith = dbWorker.getEntry(demographic, dataCategory);
        //the total number of people in the country with X characteristic
        int totalWith = dbWorker.sumAllData(this.demographicType, dataCategory);
        
        //the percent of X characteristic belonging to a demographic is equal to
        //the number in the demographic with X divided by the total number
        //of people with X
        double percentOfAll = (demographicWith / totalWith);
        String returnString = this.formatAsPercentage(percentOfAll);
        
        return returnString;
    }
    
    
    
    /**
     * converts a double to a percentage with 2 decimal places
     * 
     * @param percentage a double representing a percentage (e.g. 0.72813)
     * @return the percentage formatted as a string (e.g. "72.81%")
     */
    public String formatAsPercentage(double percentage){
        String finalString = ""; //the String that is returned
        
        //multiplying a decimal representation by 100 turns it into a percentage
        int PERCENTAGE_CONSTANT = 100;
        
        finalString = String.format("%.2f", (percentage * PERCENTAGE_CONSTANT));
        finalString += "%";
        
        return finalString;
    }
    
    /**
     * Converts an integer to a string with commas every 3 digits
     * @param integer the integer being converted to a String
     * @return an String representation of the integer (e.g. "10,000,000")
     */
    private String formatInteger(int integer){
        final int COMMA_CONSTANT = 3; //commas appear every three digits
        String numberString = ("" + integer);
        
        //the number of digits in the number
        int numberLength = numberString.length();
        String finalString = ""; //the string that is returned
        
        //iterates backwards through each digit in numberString
        for(int i = 0; i <= numberLength - 1; i++){
            
            //adds a comma to the start of the string every 3 digits
            if(i % COMMA_CONSTANT == 0 && i != 0){
                finalString = ("," + finalString);
            }
            //adds the ith-to-last digit to the front of the string
            finalString = (numberString.charAt(numberLength - i - 1) 
                    + finalString);
        }
        
        return finalString;
    }
    
    /**
     * sets the value demographicType
     * @param newDemographicType  The new value for demographicType
     */
    public void setDemographicType(String newDemographicType){
        demographicType = newDemographicType;
    }
    
    /**
     * gets the value of demographicType
     * @return the value of demographicType
     */
    public String getDemographicType(){
        return demographicType;
    }
    
    /**
     * sets the value of demographic
     * @param newDemographic  the new value for demographic
     */
    public void setDemographic(String newDemographic){
        demographic = newDemographic;
    }
    
    /**
     * gets the value of demographic
     * @return the value of demographic
     */
    public String getDemographic(){
        return demographic;
    }
    
    /**
     * sets the dataType, and sets corresponding values for dataCategory and
     * statisticType
     * 
     * @param newDataType the new dataType
     */
    public void setDataType(String newDataType){
        dataType = newDataType;
        //dataCategory and statisticType are found with the DataTypeInfo class
        dataCategory = dataInfo.getDataCategory(newDataType);
        statisticType = dataInfo.getStatisticType(newDataType);
    }
    
}
