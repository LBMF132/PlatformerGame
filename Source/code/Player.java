package code;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public abstract class Player {
	public static ImageView playerSprite = new ImageView("/data/basicPlayerSprite.png");
	public static double xPos = 0;
	public static double yPos = 0;
	//vel is in pix/second
	public static double xVel = 0;
	public static double yVel =0;
	public static double xAccel = 0;
	public static double yAccel=200;
	public static final double STD_X_ACCEL=50;
	public static final double STD_Y_ACCEL=50;
	public static final double XVMAX=300;
	public static final double YVMAX=300;
	public static void updateVel(Scene s){
		s.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.A) {
		        Player.xAccel=(-1)*STD_X_ACCEL;
		    }
		    if(e.getCode()==KeyCode.D) {
		    	Player.xAccel=STD_X_ACCEL;
		    }
		    if(e.getCode()==KeyCode.W) {
		    	Player.yVel-=100;
		    }
		    if(e.getCode()==KeyCode.S) {
		    	Player.yAccel=STD_Y_ACCEL;
		    }
		});
		s.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.A) {
		        Player.xAccel=0;
		    }
		    if(e.getCode()==KeyCode.D) {
		    	Player.xAccel=0;
		    }
		    if(e.getCode()==KeyCode.W) {
		    	Player.yAccel=0;
		    }
		    if(e.getCode()==KeyCode.S) {
		    	Player.yAccel=0;
		    }
		});
		//check collision with floor, if not then add in gravity, if so then 0 yaccel
		//gravity/friction
		if(xVel>=XVMAX) {
			xVel=XVMAX;
		}
		if(xVel<=(-1)*XVMAX) {
			xVel=(-1)*XVMAX;
		}
		if(yVel>=YVMAX) {
			yVel=YVMAX;
		}
		if(yVel<=(-1)*YVMAX) {
			yVel=(-1)*YVMAX;
		}
		Player.xVel+=Player.xAccel/30;
		Player.yVel+=Player.yAccel/30;
		System.out.println(xVel);
		Player.playerSprite.setX(Player.xPos+(Player.xVel/30));
		Player.xPos+=Player.xVel/30;
		Player.playerSprite.setY(Player.yPos + (Player.yVel / 30));
		Player.yPos+=Player.yVel/30;
	}
}
