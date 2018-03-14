package code;

import java.awt.Panel;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainPlatformer extends Application {
	public static Pane pane = new Pane();

	public void start(Stage mainStage) {
		pane.getChildren().add(Player.playerSprite);
		Scene mainScene = new Scene(pane, 100, 100, Color.RED);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Player.updateVel(mainScene);
			}
		},0, (long) 33.33);
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	}

	public static void gameFrame(Scene s) {
		s.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.A) {
		        Player.xAccel-=50;
		    }
		});
		Player.xVel+=Player.xAccel/30;
		Player.yVel+=Player.yAccel/30;
		Player.playerSprite.setX(Player.xPos+(Player.xVel/30));
		Player.xPos+=Player.xVel/30;
		Player.playerSprite.setY(Player.yPos + (Player.yVel / 30));
		Player.yPos+=Player.yVel/30;
	}
}
