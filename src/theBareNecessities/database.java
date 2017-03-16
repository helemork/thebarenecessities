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
    
    public static String getAllPerioder(){
        // Henter ut alle periodene registrert i databsen
    	
    	String str = "";
        
        try{
            Connection conn = connectToDb();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Periode");

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	str += "Periode: " + rs.getString(1) + "  -  Fra: " + rs.getString(2) + " Til: " + rs.getString(3) +"  -  Mål for periode " + rs.getString(4) +"\n"; 	         	
            }
            conn.close();
            return str;

        }
        catch(SQLException e){
            return e.toString();
        }
    }
    
    public static String getAllTreningerIPeriode(int periode){
        // Henter ut alle treninger registrert i en gitt periode fra databasen
    	
    	String str = "";
        
        try{
            Connection conn = connectToDb();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Trening LEFT JOIN Utetrening ON Trening.treningstid=Utetrening.treningstid LEFT JOIN Innetrening ON Trening.treningstid=Innetrening.treningstid WHERE periodeid ="+periode);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	str += "Når: " + rs.getString(1) + "  -  Varighet: " + rs.getString(2) + "  -  Dagsform: " + rs.getString(3) +"  -  Prestasjon: " + rs.getString(4) +"  -  Værtype:"+ rs.getString(9) +  "  -  Temperatur:"+ rs.getString(8) + "  -  Luftkvalitet:"+rs.getString(11)+"  -  Antall tilskuere:"+rs.getString(12)+"  -  Notat: " + rs.getString(5)+"\n"; 	         	
            }
            conn.close();
            return str;

        }
        catch(SQLException e){
            return e.toString();
        }
    }

	public static String createInnetrening(String tid, int varighet, int dagsform, int prestasjon, String notat,
			int periode,int tilskuere, int luftkva) {

		Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Trening (treningstid, varighet, dagsform, prestasjon, notat, periodeid) VALUES (?,?,?,?,?,?)");
    		stmt.setString(1, tid);
    		stmt.setInt(2, varighet);
    		stmt.setInt(3, dagsform);
    		stmt.setInt(4, prestasjon);
    		stmt.setString(5, notat);
    		stmt.setInt(6, periode);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO Innetrening(treningstid, luftkvalitet, antalltilskuere) VALUES (?,?,?)");
    		stmt.setString(1, tid);
    		stmt.setInt(2, luftkva);
    		stmt.setInt(3, tilskuere);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
		
		return "Innereningen ble opprettet";
	}

	public static String createUtetrening(String tid, int varighet, int dagsform, int prestasjon, String notat,
			int periode,int ver, int temp) {

		Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Trening (treningstid, varighet, dagsform, prestasjon, notat, periodeid) VALUES (?,?,?,?,?,?)");
    		stmt.setString(1, tid);
    		stmt.setInt(2, varighet);
    		stmt.setInt(3, dagsform);
    		stmt.setInt(4, prestasjon);
    		stmt.setString(5, notat);
    		stmt.setInt(6, periode);
    		stmt.executeUpdate();
    		stmt = conn.prepareStatement("INSERT INTO Utetrening(treningstid, temperatur, weathertype) VALUES (?,?,?)");
    		stmt.setString(1, tid);
    		stmt.setInt(2, ver);
    		stmt.setInt(3, temp);
    		stmt.executeUpdate();
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
		
		return "Utetreningen ble opprettet";
	}

	public static String createPeriode(String fra, String til, String goal) {
		System.out.println(""+fra+til+goal);
		Connection conn = connectToDb();
    	try{
    		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Periode( startdato, sluttdato, goals) VALUES (?,?,?)");
    		stmt.setString(1, fra);
    		stmt.setString(2, til);
    		stmt.setString(3, goal);
    		stmt.executeUpdate();
    		
    	}
    	catch (SQLException e){
    		return e.toString();
    	};
		return "Du har opprettet en periode";
	}
	
	
    
    
     //	INSERT INTO `Trening` (`treningstid`, `varighet`, `dagsform`, `prestasjon`, `notat`, `periodeid`) VALUES ('2017-03-22 15:00:00', '3', '1', '2', 'Det va vondt', '2');
    
    
    
    //Div eksempelkode fra PU prosjektet mitt for å endre ting i databasen.. kan kanskje brukes ??
     
    
    
      
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
