package com.scenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;//Deberemos importar un nodo para usarlo despues
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuCont implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button myButton;
	@FXML
	private StackPane myStPane;


	
	@FXML
	private AnchorPane myAnchorPane;
	
	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

	
	//tomemos en cuenta que, al realizar cambios de escenas, lo unico que cambiamos es el anchor pane de cada escena, la escena principal (el menu), se compone de 1 stack pane
	//el cual contiene un image view con el respectivo fondo, y un anchor pane, el cual es el encargado de almacenar todos los nodos de una escena determinada
	@FXML
	private void loadconfig(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("config.fxml")); 
		Scene scene = myButton.getScene();
		
		root.translateYProperty().set(scene.getHeight()); //aqui movemos el root (escena a cargar), en este caso la altura 
		myStPane.getChildren().add(root);
		
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(root);
		translate.setDuration(Duration.millis(150));
		translate.setToY(0);
		translate.setOnFinished(event1 -> {
			myStPane.getChildren().remove(myAnchorPane);//Esto se ejecuta al finalizar la animacion
		});
		
		TranslateTransition translat2 = new TranslateTransition();
		translat2.setNode(myAnchorPane);
		translat2.setDuration(Duration.millis(200));
		translat2.setToY(-500);

		
		translate.playFromStart();
		translat2.playFromStart();
	}

	@FXML///cambiar este metodo y checar temita con el stack pane flojo
	private void loadmenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml")); //la escena raiz se carga, es decir toma como base esta desde la escena que se usara a continuacion
		Scene scene = myButton.getScene();//se toma la escena desde un nodo, en este caso el boton que inicia la accion
		
		root.translateYProperty().set(scene.getHeight()); //aqui movemos el root (escena a cargar), en este caso la altura 
		myStPane.getChildren().add(root);
		
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(root);
		translate.setDuration(Duration.millis(150));
		translate.setToY(0);
		translate.setOnFinished(event1 -> {
			myStPane.getChildren().remove(myAnchorPane);//Esto se ejecuta al finalizar la animacion
		});
		
		TranslateTransition translat2 = new TranslateTransition();
		translat2.setNode(myAnchorPane);
		translat2.setDuration(Duration.millis(200));
		translat2.setToY(-500);

		
		translate.playFromStart();
		translat2.playFromStart();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}