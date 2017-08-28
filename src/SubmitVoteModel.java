
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp Pavilion g6
 */
public class SubmitVoteModel {
    Connection connection=MysqlConnection.connector();
    
    public String submit(String voterId,String president,String vP,String treasurer) throws SQLException{
        Statement statement=null;
        ResultSet rs=null;
        
        int forT=0;
        int agT=0;
        try {
            if(president==null){
                president="no_presd";
            }
            if(vP==null){
                vP="no_vP";
            }
            if(treasurer=="forTreas"){
                forT=1;
                agT=0;
            }
            if(treasurer=="againstTreas"){
                forT=0;
                agT=1;
            }
            if(treasurer==null){
                forT=0;
                agT=0;
            }
            
            //connection.setAutoCommit(false);
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            String query=String.format("INSERT INTO president(voterId,candidate)VALUES('%s','%s')",voterId,president);
            statement.executeUpdate(query);
            
            query=String.format("INSERT INTO vice_president(voterId,candidate)VALUES('%s','%s')",voterId,vP);
            statement.executeUpdate(query);
            
            query=String.format("INSERT INTO treasurer(voterId,forT,against)VALUES('%s','%d','%d')",voterId,forT,agT);
            statement.executeUpdate(query);
            
            query=String.format("UPDATE voters SET castedVote='1' WHERE voterId='%s'",voterId);
            statement.executeUpdate(query);
            //rs=statement.executeQuery(query1);
            
            //connection.commit();
            
            return "";
//            return resultSet1.next();
        } catch (Exception e) {
            return e.toString();
        }
        finally{
            //rs.close();
            //statement.close();
            connection.close();
        }
        //return false;
    }
    
}
