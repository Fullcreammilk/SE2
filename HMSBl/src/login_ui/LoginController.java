package login_ui;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

import java.io.IOException;

import org.controlsfx.dialog.Dialogs;

public class LoginController {

	@FXML
	private Button Confirm;
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passwordField;
	
	
	@FXML
	private Hyperlink signUp;
	
	//对main application的引用
	private MainApp mainApp;


    /**
     * 点击“注册新账号”打开注册界面
     */
    @FXML
    public void register(){
    	MemberType tp = mainApp.showRegisterUI();
    	
    	if(tp==MemberType.NORMAL){
    		mainApp.showNormalUI();
    	}else{
    		mainApp.showBusiUI();
    	}
    }
    

     @FXML
     public void test(){
    	 if(isInputValid()){
    		 System.out.println("lol"); 
    	 }
    	 else{
    		 try{
    				
    			// Load the fxml file and create a new stage for the choosetype dialog.
    			FXMLLoader loader = new FXMLLoader();
   				loader.setLocation(MainApp.class.getResource("AlertDialog_css.fxml"));
   				AnchorPane page = (AnchorPane) loader.load();
    				
   				Stage stage = new Stage();
   				stage.setTitle("Message");
   				Scene scene = new Scene(page);
    			stage.setScene(scene);
    			stage.show();
    		}catch(IOException e){
    			e.printStackTrace();
    		}	    		 
    	 }
     }
     
     /**
      * Initializes the controller class. This method is automatically called
      * after the fxml file has been loaded.
      */
 	@FXML
 	public void initialize(){
 	}
 	
 	/**
 	 *检查输入是否完整
 	 */
 	private boolean isInputValid(){
 		String errorMessage = "";
 		
 		if(userNameField.getText()==null || userNameField.getText().length()==0){
 			errorMessage += "No valid username!\n";
 		}
 		else if(passwordField.getText()==null || passwordField.getText().length()==0){
 			errorMessage += "No valid password!\n";
 		}
 		
 		if(errorMessage.length()==0){
 			return true;
 		}else{
 			return false;
 		}	
 	}
 	
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
