package login_ui;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
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
    		 Alert alert = new Alert(AlertType.INFORMATION);
    		 alert.setTitle("Message");
    		 alert.setHeaderText(null);
    		 alert.setContentText("用户名或密码错误，请重新输入");
    		 alert.showAndWait();
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
