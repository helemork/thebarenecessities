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
    
    
    
    
     //	Div eksempelkode fra PU prosjektet mitt for å endre ting i databasen.. kan kanskje brukes ??
     
    
    
      
     /* 
	public static boolean runQuery(String query, String... args){
        try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement(query);
            int i = 0;
            for(String arg : args)
                stmt.setString(++i, arg);
            return stmt.executeUpdate() != 0;
        }
        catch(SQLException e){
            return false;
        }
    }
    
    // Add lecture
    public static void createLecture(Lecture lecture){
    	try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lecture (courseID, number, name) VALUES (?,?,?)");
            stmt.setInt(1, Integer.parseInt(lecture.getCourseID()));
            stmt.setInt(2, Integer.parseInt(lecture.getlectureNumber()));
            stmt.setString(3, lecture.getlectureName());
            
            stmt.executeUpdate();
    	}
        catch(SQLException e){
        	System.out.println(e);
        }
    }
    
    // Delete lecture
    public static void deleteLecture(Lecture lecture){
    	try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM lecture WHERE lectureID = ?");
            //DELETE FROM 'prodoteam_db'.'lecture'WHERE 'lecture'.'lectureID' = 15
            stmt.setInt(1, Integer.parseInt(lecture.getLectureID()));
            //
            stmt.executeUpdate();
    	}
        catch(SQLException e){
        	System.out.println(e);
        }
    }
    
    *
    */
    
   
}
