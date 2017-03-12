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

    // HJELPEFUNKSJON FOR Å KOBLE OSS TIL DB SÅ VI IKKE MÅ DET MASSE
    public static Connection connectToDb(){
    	try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
    	catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	Connection conn = null;
		try {
			conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return conn;
    };
    
    public static String createOppvarming(String name, String description, int duration){
    	// LEGG INN EN OPPVARMING ELLER AVLUTNINGSØVELSE (alle uten resultat mao)
    	
    	Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ovelse (ovelsesnavn,beskrivelse) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setString(2, description);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO OppvarmingAvslutning (ovelsesnavn,varighet) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setInt(2, duration);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
    	
    	return "OK";
    };
    
    public static String createAnnet(String name, String description, String notat){
    	// LEGG INN EN annen type øvelse (alle uten resultat mao)
    	
    	Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ovelse (ovelsesnavn,beskrivelse) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setString(2, description);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO Annet (ovelsesnavn,notat) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setString(2, notat);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
    	
    	return "OK";
    };
    
    public static String createKondisjonStyrke(String name, String description, int belastning, int Antallrepitisoner, int Antallsett  ){
    	// LEGG INN EN annen type øvelse (alle uten resultat mao)
    	
    	Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ovelse (ovelsesnavn,beskrivelse) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setString(2, description);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO KondisjonStyrke (ovelsesnavn,Belastning,Antallrepitisoner,Antallsett) VALUES (?,?,?,?)");
    		stmt.setString(1, name);
    		stmt.setInt(2, belastning);
    		stmt.setInt(3, Antallrepitisoner);
    		stmt.setInt(4, Antallsett);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
    	
    	return "OK";
    };
    
    public static String createUtholdenhet(String name, String description, float lengde){
    	// LEGG INN EN annen type øvelse (alle uten resultat mao)
    	
    	Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ovelse (ovelsesnavn,beskrivelse) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setString(2, description);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO Utholdenhet (ovelsesnavn,Lengde) VALUES (?,?)");
    		stmt.setString(1, name);
    		stmt.setFloat(2, lengde);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
    	
    	return "OK";
    };
    

    public static String getAllOvelse(){
        // Heinjte ut aillj øvelsainj sjø.
    	
    	String str = "";
        
        try{
            Connection conn = connectToDb();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Ovelse");

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	str += rs.getString(1) + ": " + rs.getString(2) + "\n"; 	         	
            }
            conn.close();
            return str;

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
