package databasegui;
import java.sql.*;


public class publicMethods
{
    
    public static void startingDatabase() {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch (Exception e)
        {
            System.out.println(" driver failed to load.");
            System.exit(-1);
        }
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test1", "app", "app");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BPMRECORDS");    
            ResultSetMetaData rsmd = rs.getMetaData();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("FIRSTNAME  LASTNAME  MINBPM  MAXBPM");
    }
    
    public static void gettingEnterDataInfo(String frst, String lst, double mn, double mx) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test1", "app", "app");
            publicMethods.enterData(con, frst, lst, mn, mx);
            con.close();
        } catch (Exception enteringFailed) {
            System.out.println(enteringFailed);
        }
    }
    
    public static void enterData(Connection cnnctn, String frst, String lst, double mn, double mx) {
        try {
            String statement = ("INSERT INTO BPMRECORDS (FirstName, LastName, MinRange, MaxRange)"
                    + "VALUES(?, ?, ?, ?)");
            PreparedStatement prepStatement = cnnctn.prepareStatement(statement);
            prepStatement.setString(1, frst);
            prepStatement.setString(2, lst);
            prepStatement.setString(3, Double.toString(mn));
            prepStatement.setString(4, Double.toString(mx));
            prepStatement.executeUpdate();
            
        } catch (Exception errorEnter) {
            System.out.println(errorEnter);
        }
    }
    
    public static Boolean gettingGetDataInfo(String searchTerm) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test1", "app", "app");
            if (publicMethods.getData(con, searchTerm)) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (Exception gettingFailed) {
            System.out.println(gettingFailed);
        }
        return false;
    }
    
    public static boolean getData(Connection cnnctn, String term) {
        boolean success = false;
        try {
            String statement = ("SELECT * FROM BPMRECORDS WHERE FirstName = ? OR LastName = ?");
            PreparedStatement prepStatement = cnnctn.prepareStatement(statement);
            prepStatement.setString(1, term);
            prepStatement.setString(2, term);
            ResultSet results = prepStatement.executeQuery();
            ResultSetMetaData resultsMeta = results.getMetaData();
            
            int colomns = resultsMeta.getColumnCount();
            int rows = 1;
            while (results.next()) {
                
                for (int i = 1; i <= colomns; i++) {
                    
                    System.out.print(results.getString(i) + "     ");
                    if (!results.getString(i).equals("")) {
                        success = true;
                    }
                }
                System.out.println("");
                rows++;
            }
            System.out.println("_____________________________________________");
            
        } catch (Exception errorGet) {
            System.out.println(errorGet);
        }
        return success;
    }
}