import java.sql.*;
public class MysqlConnection {
    //private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public static Connection connector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFX_eVote","damilare","damilare");
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
    
}
