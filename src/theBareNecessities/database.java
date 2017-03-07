package theBareNecessities;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class database {
    private static String mysqlAddr = "jdbc:mysql://mysql.stud.ntnu.no:3306/theaks_testingDB?allowMultiQueries=true";
    private static String mysqlUser = "theaks_test";
    private static String mysqlPass = "TKStestDB";



    public static String test(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Ovelse");

            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                return rs.getString(1);
            conn.close();
            return null;

        }
        catch(SQLException e){
            return e.toString();
        }
    }
   
}
