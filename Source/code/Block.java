import java.awt.Rectangle;

import javafx.scene.image.ImageView;

public class Block {
	public ImageView image;
	public int xPos;
	public int yPos;
	public int width;
	public int height;
	public int blockID;
	public Rectangle rectangle;
	public Block(ImportedTile i,int sxPos,int syPos,int realX, int realY,String fPath) {
		System.out.println("N "+i.path);
		image = new ImageView("file:"+fPath);
		width = i.x/2;
		height = i.y/2;
		image.setX(realX);
		image.setY(realY);
		image.setFitWidth(i.x/2);
		image.setFitHeight(i.y/2);
		xPos=sxPos;
		yPos = syPos;
		blockID = i.id;
	}
}
