/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hp Pavilion g6
 */
public class SubmitVoteController implements Initializable {
    SubmitVoteModel submitVoteModel=new SubmitVoteModel();
    
    @FXML
    ImageView pres_imgView;
    @FXML
    ImageView vP_imgView;
    @FXML
    ImageView treas_imgView;
    
    @FXML
    Label label_presd;
    @FXML
    Label label_vP;
    @FXML
    Label label_treas;
    
    @FXML
    Button editButton;
    
    Image presImg;
    Image vPImg;
    Image treasImg;
    
    public static String p;
    public static String vP;
    public static String t;
    public static String voterId;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void voter(String id){
        voterId=id;
        System.out.println(voterId);
    }
    public void dispayCandidates(String pName,String vPName, String tName, String pImg,String vPimg,String tImage){
        p=pName;
        vP=vPName;
        t=tName;
        // set image for president
        if(pImg!=null){
            presImg=new Image(getClass().getResourceAsStream(pImg));
            System.out.println("VoteController.presidentImg");
            pres_imgView.setImage(presImg);
            label_presd.setText(pName);
        }
        else{
            label_presd.setText("You chose not to vote for any candidate");
        }
        
        // set image for vice-president
        if(vPimg!=null){
            vPImg=new Image(getClass().getResourceAsStream(vPimg));
            vP_imgView.setImage(vPImg);
            label_vP.setText(vPName);
        }
        else{
            label_vP.setText("You chose not to vote for any candidate");
        }
        
        // set image for treasurer
        if(tImage!=null){
            treasImg=new Image(getClass().getResourceAsStream(tImage));
            treas_imgView.setImage(treasImg);
            label_treas.setText(tName);
        }
        else{
            label_treas.setText("You chose not to vote for any candidate");
        }
    }
    
    public void editVote(ActionEvent  event){
        try{
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            //FXMLLoader loader3=new FXMLLoader();
            Parent root=loader.load(getClass().getResource("votePresident.fxml").openStream());
            VoteController voteController=(VoteController)loader.getController();
            voteController.setBackground(p);
            
            Scene scene=new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(SubmitVoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void submitVote(ActionEvent event) throws IOException, SQLException{
        if(submitVoteModel.submit(voterId, p, vP, t)==""){
            ((Node)event.getSource()).getScene().getWindow().hide();
            VoteController voteController=new VoteController();
            voteController.emptyAspirants();
            // open new window
//            Stage primaryStage=new Stage();
//            FXMLLoader loader=new FXMLLoader();
//            
//            Parent root=loader.load(getClass().getResource("login.fxml").openStream());
//            LoginController loginController=(LoginController)loader.getController();
//            loginController.emptyCandidates();

//            Scene scene=new Scene(root);

//            primaryStage.setScene(scene);
//            primaryStage.show();
        }
        else{
            System.out.println("Could not execute query "+submitVoteModel.submit(voterId, p, vP, t));
        }
        
        
    }
    
}
