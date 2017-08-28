/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hp Pavilion g6
 */
public class LoginController implements Initializable {
    public LoginModel loginModel=new LoginModel();
    
    @FXML
    Label msg;
    
    @FXML
    TextField voter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void emptyCandidates(){
        VoteController voteController=new VoteController();
            voteController.emptyAspirants();
    }
    public void login(ActionEvent event){
        try {
            /* if user logs in succesfully
             */
            if(loginModel.userExists(voter.getText())){
                // if user has not cast any vote before
                if(!loginModel.hasVoted(voter.getText())){
                    SubmitVoteController submitVoteController=new SubmitVoteController();
                    submitVoteController.voter(voter.getText());
                    voter.clear();
                    // close present window
                    //((Node)event.getSource()).getScene().getWindow().hide();
                    // open new window
                    Stage primaryStage=new Stage();
                    FXMLLoader loader=new FXMLLoader();

                    Parent root=loader.load(getClass().getResource("votePresident.fxml").openStream());

                    Scene scene=new Scene(root);
                    primaryStage.initStyle(StageStyle.TRANSPARENT);
                    primaryStage.initModality(Modality.APPLICATION_MODAL);

                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
                else{
                    msg.setText("You cannot vote more than once");
                }
                
            }else{
                msg.setText("You have entered a wrong pin number");
            }
        } catch (Exception e) {
            msg.setText("You have entered a wrong pin number");
            e.printStackTrace();
        }
    }
    
    
}
