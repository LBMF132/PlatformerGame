import java.awt.Panel;
import java.io.File;
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
		Player.playerSprite.setFitWidth(35);
		Player.playerSprite.setFitHeight(35);

		String uName = System.getProperty("user.name");
		Block[][] blocks =  ParserUtil.readCSV("C:\\users\\"+uName+"\\documents\\github\\PlatformerGame\\Source\\code\\Maps\\Map11.csv", 
				"C:\\users\\"+uName+"\\documents\\github\\PlatformerGame\\Source\\code\\Maps\\NegOneTiles.tsx");
//		CollisionUtil.map=CollisionUtil.b2R(blocks);
		Pane mainPane = ParserUtil.buildBlocks(blocks);
		mainPane.getChildren().add(Player.playerSprite);
		Scene mainScene = new Scene(mainPane,1000,1000);
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Player.updateVel(mainScene);
				CollisionUtil.collisions(blocks);
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
