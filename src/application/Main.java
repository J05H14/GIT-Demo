package application;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	private Label[][] labels = new Label[11][11];
	@Override
	public void start(Stage primaryStage) {

		BorderPane bp = new BorderPane();	
		bp.getStyleClass().add("grid");

		GridPane gp = new GridPane();


		Label question = new Label("Answer:");
		question.getStyleClass().add("question");
		Label title = new Label("Reverse Multiplication Table:");
		title.getStyleClass().add("title");
		
		HBox ttl = new HBox();
		HBox prompt = new HBox();

		prompt.getStyleClass().add("input");
		prompt.getChildren().add(question);
		ttl.getStyleClass().add("title");
		ttl.getChildren().add(title);

		TextField inAns = new TextField();
		prompt.getChildren().add(inAns);



		Scene sc = new Scene(bp);
		sc.getStylesheets().add("application/application.css");


		for (int rowCounter = 0; rowCounter < 11; rowCounter++)
			for (int colCounter = 0; colCounter < 11; colCounter++) {
				Label num;
				if(rowCounter == 0){
					num = new Label(colCounter + "");
					num.getStyleClass().add("axis");
				}
				else if(colCounter == 0){
					num = new Label(rowCounter + ""); 
					num.getStyleClass().add("axis");
				}
				else{
					num = new Label(" " + rowCounter + " * " + colCounter);
					num.getStyleClass().add("default");
				}
				num.setAlignment(Pos.CENTER);
				num.setPrefHeight(50);
			    num.setPrefWidth(85);
			    
			    
				labels[rowCounter][colCounter] = num;
				gp.add(num, colCounter, rowCounter);
			}

		Button b = new Button("Find Factors");
		b.setMinWidth(50);
		b.getStyleClass().add("button");
		prompt.getChildren().add(b);

		b.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				for(int row = 0; row < 11; row++){
					for(int col = 0; col < 11; col++){
						labels[row][col].getStyleClass().remove("answer");
						
						if(Integer.parseInt(inAns.getText()) == col * row){
							labels[row][col].getStyleClass().add("answer");
						}
					}
				}

			}
		});

		bp.setTop(ttl);
		bp.setCenter(prompt);
		bp.setBottom(gp);

		primaryStage.setTitle("Lab 8");
		primaryStage.setScene(sc);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}


}
