/**  
* CMPSC 221 Final Project
* DataTypeInfo.Java
* Purpose: Supporting class for SearchQuery, Takes the strings representing  
* data types selected on the user interfaces and maps them to more useful data
*  
* @author Gabriel Fleming
* @version 1.0 5/4/21
*/ 

package CDCJava;

import java.util.HashMap;


public class DataTypeInfo {
    
    
    //a list of options for dataTypes that appears on the user interface
    private final static String[] dataTypes = {
        "Population", 
        "Percent of total population", 
        "Number of cases", 
        "Percent of all cases",
        "Percent infected", 
        "Number of deaths", 
        "Percent of all deaths", 
        "Percent Dead",
        "Number with one dose of vaccine", 
        "Percent of all people with one dose",
        "Percent who have one dose", 
        "Number fully vaccinated",
        "Percent of all people fully vaccinated", 
        "Percent who are fully vaccinated"
    };
    //maps the dataTypes to the category of data found in the database
    //e.g. "percent with one dose" Maps to "ONEDOSE"
    private static HashMap<String, String> dataCategoryMap;
    
    //maps the datatTypes to the Type of statistic being represented
    //e.g. 
    private static HashMap<String, String> statisticMap;
    
    /**
     * the default constructors
     */
    public DataTypeInfo(){
        //configures the dataCategoryMap if it wasn't already
        if(dataCategoryMap == null){
            configureDataCategoryMap();
        }
        //configures the statisticMap if it wasn't already
        if(statisticMap == null){
            configureStatisticMap();
        }
    }
    
    /**
     * gets the dataCategory corresponding to the data type
     * @param dataType the type of data (e.g. "Percent infected"
     * @return the corresponding data category
     */
    public String getDataCategory(String dataType){
        return dataCategoryMap.get(dataType);
    }
    
    /**
     * gets the statisticType corresponding to the data type
     * @param dataType the type of data (e.g. "Percent infected"
     * @return the corresponding statisticType
     */
    public String getStatisticType(String dataType){
        return statisticMap.get(dataType);
    }

    /**
     * returns a list of all data types
     * 
     * @return a list of all valid values of dataType
     */
    public String[] getDataTypeList(){
        return dataTypes;
    }
    
    /**
     * configures dataCategoryMap, which maps each valid dataType value to a 
     * corresponding dataCategory
     */
    private void configureDataCategoryMap(){
        //dataCategoryMap maps strings to strngs
        dataCategoryMap = new HashMap<String, String>();
        //adds in all of the key-value pairs
        dataCategoryMap.put("Population", "POPULATION");
        dataCategoryMap.put("Percent of total population", "POPULATION");
        dataCategoryMap.put("Number of cases", "CASES");
        dataCategoryMap.put("Percent of all cases", "CASES");
        dataCategoryMap.put("Percent infected", "CASES");
        dataCategoryMap.put("Number of deaths", "DEATHS");
        dataCategoryMap.put("Percent of all deaths", "DEATHS");
        dataCategoryMap.put("Percent Dead", "DEATHS");
        dataCategoryMap.put("Number with one dose of vaccine", "ONEDOSE");
        dataCategoryMap.put("Percent of all people with one dose", "ONEDOSE");
        dataCategoryMap.put("Percent who have one dose", "ONEDOSE");
        dataCategoryMap.put("Number fully vaccinated", "FULLYVACCINATED");
        dataCategoryMap.put("Percent of all people fully vaccinated", "FULLYVACCINATED");
        dataCategoryMap.put("Percent who are fully vaccinated", "FULLYVACCINATED");
    }
    
    /**
     * configures statisticMap, which maps each valid dataType value to a 
     * corresponding statisticType value
     */
    private void configureStatisticMap(){
        //statisticMap maps strings to strings
        statisticMap = new HashMap<String, String>();
        //adds in all of the key-value pairs
        statisticMap.put("Population", "NumberOf");
        statisticMap.put("Percent of total population", "PercentOfAll");
        statisticMap.put("Number of cases", "NumberOf");
        statisticMap.put("Percent of all cases", "PercentOfAll");
        statisticMap.put("Percent infected", "PercentWith");
        statisticMap.put("Number of deaths", "NumberOf");
        statisticMap.put("Percent of all deaths", "PercentOfAll");
        statisticMap.put("Percent Dead", "PercentWith");
        statisticMap.put("Number with one dose of vaccine", "NumberOf");
        statisticMap.put("Percent of all people with one dose", "PercentOfAll");
        statisticMap.put("Percent who have one dose", "PercentWith");
        statisticMap.put("Number fully vaccinated", "NumberOf");
        statisticMap.put("Percent of all people fully vaccinated", "PercentOfAll");
        statisticMap.put("Percent who are fully vaccinated", "PercentWith");
    }
}
