package login_ui;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class MainApp extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hotel Management System");
		
		//展示登录界面
		showLoginUI();
	}

	
	/**
	 * 展示登录界面
	 */
	public void showLoginUI(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Login.fxml"));
			AnchorPane loginUI = (AnchorPane) loader.load();
		
			//Give the controller access to the main app
			LoginController controller = loader.getController();
			controller.setMainApp(this);
			
			//Show the scene containing the loginUI
			Scene scene = new Scene(loginUI);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	

	/**
	 * 显示选择注册类型界面
	 */
	public MemberType showRegisterUI(){
		try{
	
			// Load the fxml file and create a new stage for the choosetype dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("ChooseType.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Register");
			
			ChooseTypeController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
			
			return controller.getType();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;		
	}
	
	
	/**
	 * 显示普通会员注册界面
	 */
	public void showNormalUI(){
		try{
	
			// Load the fxml file and create a new stage for the choosetype dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Register(Normal).fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage stage = new Stage();
			stage.setTitle("Register");
			
			Scene scene = new Scene(page);
			stage.setScene(scene);
			stage.show();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 显示企业会员注册界面
	 */
	public void showBusiUI(){
		try{
//			typeStage.close();
			// Load the fxml file and create a new stage for the choosetype dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Register(Busi).fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage stage = new Stage();
			stage.setTitle("Register");
			
			Scene scene = new Scene(page);
			stage.setScene(scene);
			stage.show();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 输入信息不完整，显示错误信息
	 */
	public void showErrorMessage(){
	
	}
	
	
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
	public static void main(String[] args) {
		launch(args);
	}
}
