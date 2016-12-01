package login_ui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Button Confirm;
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passwordField;
	
	
	@FXML
	private Hyperlink signUp;
	
	@FXML
	private Button okButton = new Button("OK"); //错误提示的OK按钮
	
	
	public Stage errorStage = new Stage();//错误提示的Stage
	
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
     public void checkLoginInfo(){
    	 if(isInputValid()){
    		 System.out.println("lol"); 
    	 }
    	 else{
    		 try{
    				
    			// Load the fxml file and create a new stage for the choosetype dialog.
    			FXMLLoader loader = new FXMLLoader();
   				loader.setLocation(MainApp.class.getResource("AlertDialog_css.fxml"));
   				GridPane page = (GridPane) loader.load();
    				
   				errorStage.setTitle("Message");
   				Scene scene = new Scene(page);
    			errorStage.setScene(scene);
    			errorStage.show();
    			okButton.setOnAction(new EventHandler<ActionEvent>(){
    		        @Override
    		        public void handle(ActionEvent event) {
    		        	errorStage.close();
    		        }
    		    });
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}	    		 
    	 }
     }
     
     @FXML
     public void closeErrorMessage(){
    	 errorStage.close();
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
