/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hp Pavilion g6
 */
public class VoteController implements Initializable {
    // Buttons on vote president scene
    @FXML
    Button btn_presd1;
    @FXML
    Button btn_presd2;
    @FXML
    Button nextBtn_pres;
    @FXML
    Button nvBtn_pres;
    // Buttons on vote vice-president scene
    @FXML
    Button btn_vP1;
    @FXML
    Button btn_vP2;
    @FXML
    Button nextBtn_vP;
    @FXML
    Button prevBtn_vP;
    @FXML
    Button nvBtn_vP;
    // Buttons on vote treasurer scene
    @FXML
    Button forTreas;
    @FXML
    Button againstTreas;
    @FXML
    Button submit;
    @FXML
    Button prevBtn_treas;
    @FXML
    Button nvBtn_tr;
    // Variables to select candidates
    public static String president;
    public static String presidentImg;
    public static String vP;
    public static String vPImg;
    public static String treasurer;
    public static String treasurerImg;
    // root
    Pane root;
    // Stage
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void emptyAspirants(){
        president=null;
        presidentImg=null;
        vP=null;
        vPImg=null;
        treasurer=null;
        treasurerImg=null;
    }
    
    // this method sets the buttons bgColor when scenes are switched
    public void setBackground(String candidate){
        // set bgColor for buttons on vote president scene
        if("koiki_1".equals(candidate)){
            btn_presd1.setStyle("-fx-background-color:#036");
        }
        else if("koiki_2".equals(candidate)){
            btn_presd2.setStyle("-fx-background-color:#036");
        }
        else if("no_presd".equals(candidate)){
            nvBtn_pres.setStyle("-fx-background-color:#036");
        }
        // set bgColor for buttons on vote vice-president scene
        if("Thabo".equals(candidate)){
            btn_vP1.setStyle("-fx-background-color:#036");
        }
        else if("Mercy".equals(candidate)){
            btn_vP2.setStyle("-fx-background-color:#036");
        }
        else if("no_vP".equals(candidate)){
            nvBtn_vP.setStyle("-fx-background-color:#036");
        }
        // set bgColor for buttons on vote treasurer scene
        if("forTreas".equals(candidate)){
            forTreas.setStyle("-fx-background-color:#036");
        }
        else if("againstTreas".equals(candidate)){
            againstTreas.setStyle("-fx-background-color:#036");
        }
        else if("no_tr".equals(candidate)){
            nvBtn_tr.setStyle("-fx-background-color:#036");
        }
    }
    
    // this method changes the buttons bgColor and select candidates when the buttons are clicked
    public void selectCandidate(ActionEvent event){
        // assign selected ppresident to variable 
        if(event.getSource()==btn_presd1){
            btn_presd2.setStyle("-fx-background-color:#000");
            nvBtn_pres.setStyle("-fx-background-color:red");
            btn_presd1.setStyle("-fx-background-color:#036");
            president="koiki_1";
            presidentImg="aspirantsPix/koiki_1.jpg";
        }
        else if(event.getSource()==btn_presd2){
            btn_presd1.setStyle("-fx-background-color:#000");
            nvBtn_pres.setStyle("-fx-background-color:red");
            btn_presd2.setStyle("-fx-background-color:#036");
            president="koiki_2";
            presidentImg="aspirantsPix/koiki_2.jpg";
        }
        else if(event.getSource()==nvBtn_pres){
            btn_presd1.setStyle("-fx-background-color:#000");
            btn_presd2.setStyle("-fx-background-color:#000");
            nvBtn_pres.setStyle("-fx-background-color:#036");
            president="no_presd";
            presidentImg=null;
        }
        // assign selected vice-president to variable
        else if(event.getSource()==btn_vP1){
            btn_vP2.setStyle("-fx-background-color:#000");
            nvBtn_vP.setStyle("-fx-background-color:red");
            btn_vP1.setStyle("-fx-background-color:#036");
            vP="Thabo";
            vPImg="aspirantsPix/thabo.jpg";
        }
        else if(event.getSource()==btn_vP2){
            btn_vP1.setStyle("-fx-background-color:#000");
            nvBtn_vP.setStyle("-fx-background-color:red");
            btn_vP2.setStyle("-fx-background-color:#036");
            vP="Mercy";
            vPImg="aspirantsPix/mercy.jpg";
        }
        else if(event.getSource()==nvBtn_vP){
            btn_vP1.setStyle("-fx-background-color:#000");
            btn_vP2.setStyle("-fx-background-color:#000");
            nvBtn_vP.setStyle("-fx-background-color:#036");
            vP="no_vP";
            vPImg=null;
        }
        // assign selected treasurer to variable
        else if(event.getSource()==forTreas){
            againstTreas.setStyle("-fx-background-color:#000");
            nvBtn_tr.setStyle("-fx-background-color:red");
            forTreas.setStyle("-fx-background-color:#036");
            treasurer="forTreas";
            treasurerImg="aspirantsPix/ope.jpg";
        }
        else if(event.getSource()==againstTreas){
            forTreas.setStyle("-fx-background-color:#000");
            nvBtn_tr.setStyle("-fx-background-color:red");
            againstTreas.setStyle("-fx-background-color:#036");
            treasurer="againstTreas";
            treasurerImg="aspirantsPix/ope.jpg";
        }
        else if(event.getSource()==nvBtn_tr){
            forTreas.setStyle("-fx-background-color:#000");
            againstTreas.setStyle("-fx-background-color:#000");
            nvBtn_tr.setStyle("-fx-background-color:#036");
            treasurer="no_tr";
            treasurerImg=null;
        }
    }
    
    // This method switches scenes
    @FXML
    public void scenesSwitchHandler(ActionEvent event){
        
        try{
            if(event.getSource()==nextBtn_pres){
                stage=(Stage) nextBtn_pres.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                root=loader.load(getClass().getResource("voteVicePresident.fxml").openStream());
                VoteController voteController=(VoteController)loader.getController();
                voteController.setBackground(vP);
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();  
            }
            else if(event.getSource()==nextBtn_vP){
                stage=(Stage) nextBtn_vP.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                root=loader.load(getClass().getResource("voteTreasurer.fxml").openStream());
                VoteController voteController=(VoteController)loader.getController();
                voteController.setBackground(treasurer);
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show(); 
            }
            else if(event.getSource()==prevBtn_vP){
                stage=(Stage) prevBtn_vP.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                root=loader.load(getClass().getResource("votePresident.fxml").openStream());
                VoteController voteController=(VoteController)loader.getController();
                voteController.setBackground(president);
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else if(event.getSource()==submit){
                ((Node)event.getSource()).getScene().getWindow().hide();
                stage=new Stage();
                FXMLLoader loader=new FXMLLoader();
                Parent r=loader.load(getClass().getResource("submitVote.fxml").openStream());
                Scene scene=new Scene(r);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                SubmitVoteController submitVoteController=(SubmitVoteController)loader.getController();
                submitVoteController.dispayCandidates(president, vP, treasurer, presidentImg, vPImg, treasurerImg);
                System.out.println("President: "+president);
                System.out.println("Vice-president: "+vP);
                System.out.println("Treasurer: "+treasurer);
            }
            else if(event.getSource()==prevBtn_treas){
                stage=(Stage) prevBtn_treas.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                root=loader.load(getClass().getResource("voteVicePresident.fxml").openStream());
                VoteController voteController=(VoteController)loader.getController();
                voteController.setBackground(vP);
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        catch(Exception e){
            System.out.println("Error: "+ e.toString()); 
        }
        
    }
}
