/**
 * CMPSCI 221 Exercise 3.16 (Heart Rate Class)
 * HeartRate.java  
 * Purpose: Target-Heart-Rate Calculator (Heart Rate Class)
 *  
 * @author Mark Garas  
 * @version 1.0 1/30/2021
 */ 
package databasegui;

/**
 * @author markb
 */
public class HeartRates {
    private static String first, last;
    private static int year, month, day, presentYear, presentMonth, presentDay;
    private static double age, ageInDays, bdInDaysAD, presentInDaysAD, 
                maxRate, targetMin, targetMax;
    private static final double AVG_DAYS_IN_YEAR = 365.24,
        AVG_DAY_IN_MONTH = 30.436875, LOWER_BOUND = .5, HIGHER_BOUND = .85;
    private static final int maxRateConst = 220;
    
    public HeartRates(String name1, String name2, int yr, int mth, int dy, 
            int pyr, int pmth, int pdy) {
        // @param name1 is the first name, @param name2 is the last name, 
        // @param yr is the given year of birth, @param mth is birth month, 
        // @param dy is the birth day of the month (1-31), @param pyr is the 
        // present year, @param pmth is the present month, @param pdy is the 
        // present day
        first = name1;
        last = name2;
        year = yr;
        month = mth;
        day = dy;
        presentYear = pyr;
        presentMonth = pmth;
        presentDay = pdy;
    }
    
    // This finds the difference between the present day in days since 0 AD and
    // the birth date of the user in days after 0 AD, and converts it to years
    // through simple Dimensional Analysis (
    public double calcAge() {
        bdInDaysAD = (Double.valueOf(year) * AVG_DAYS_IN_YEAR) + 
                (Double.valueOf(month) * AVG_DAY_IN_MONTH) + Double.valueOf(day);
        presentInDaysAD = (Double.valueOf(presentYear) * AVG_DAYS_IN_YEAR) + 
                (Double.valueOf(presentMonth) * AVG_DAY_IN_MONTH) + 
                Double.valueOf(presentDay);
        ageInDays = presentInDaysAD - bdInDaysAD;
        age = ageInDays / AVG_DAYS_IN_YEAR;
        return age;
    }
    
    
    
    // @param age is the given age
    // This will return the maximum heart rate using the AHA equation
    public int maxHeartRate(double age) {
        maxRate = maxRateConst - age;
        return (int)maxRate;
    }
    
    // @param maxRate is the calculated maximum heart rate
    // This will return the minimum target heart rate
    public double targetMinHeartRate(int maxRate) {
        targetMin = maxRate * LOWER_BOUND;
        return targetMin;
    }
    
    // @param maxRate is the calculated maximum heart rate
    // This will return the maximum target heart rate
    public double targetMaxHeartRate(int maxRate) {
        targetMax = maxRate * HIGHER_BOUND;
        return targetMax;
    }
    
    // @param name1 is the new first name
    public void setFirst(String name1){
        first = name1;
    }
    
    // @param name2 is the new last name
    public void setLast(String name2){
        last = name2;
    }
    
    // @param yr is the new birth year
    public void setYear(int yr){
        year = yr;
    }
    
    // @param mth is the new birth month
    public void setMonth(int mth){
        month = mth;
    }
    
    // @param dy is the new birth day (1-31)
    public void setDay(int dy){
        day = dy;
    }
    
    // @param pyr is the new birth year
    public void setPresentYear(int pyr){
        presentYear = pyr;
    }
    
    // @param pmth is the new birth month
    public void setPresentMonth(int pmth){
        presentMonth = pmth;
    }
    
    // @param pdy is the new birth day (1-31)
    public void setPresentDay(int pdy){
        presentDay = pdy;
    }
    
    // ABOVE is set methods, BELOW is get methods
    
    // @return first will return the first name
    public String getFirst(){
        return first;
    }
    // @return last will return the last name
    public String getLast(){
        return last;
    }
    // @return year will return the birth year
    public int getYear(){
        return year;
    }
    // @return month will return the birth month
    public int getMonth(){
        return month;
    }
    // @return day will return the birth day
    public int getDay(){
        return day;
    }
    // @return presentYear will return the current year
    public int getPresentYear(){
        return presentYear;
    }
    // @return presentMonth will return the current month
    public int getPresentMonth(){
        return presentMonth;
    }
    // @return presentDay will return the current day
    public int getPresentDay(){
        return presentDay;
    }
}