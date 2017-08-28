import java.sql.*;
public class LoginModel {
    Connection connection;
    public LoginModel(){
        connection=MysqlConnection.connector();
        if(connection==null){
            System.out.println("Not connected");
            System.exit(1);
        }
    }
    
    public boolean isDBConnected(){
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean hasVoted(String id) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query="SELECT * FROM voters WHERE voterId=? AND castedVote=?";
        try {
            
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, "1");
            
            resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    public boolean userExists(String id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query="select * from voters where voterId=?";
        try {
            
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            
            resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
    }
}
