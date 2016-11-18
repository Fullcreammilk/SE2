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
	 * 显示注册界面
	 */
	public void showRegisterUI(){
		try{
			// Load the fxml file and create a new stage for the choosetype dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("ChooseType.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage typeStage = new Stage();
			typeStage.setTitle("Register");
			
			Scene scene = new Scene(page);
			typeStage.setScene(scene);
			typeStage.show();
		}catch(IOException e){
			e.printStackTrace();
		}
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
