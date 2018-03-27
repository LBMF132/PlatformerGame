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
	public Block(ImportedTile i,int sxPos,int syPos,int realX, int realY) {
		image = new ImageView(i.path.substring(3,i.path.length()-1));
		width = i.x/2;
		height = i.y/2;
		image.setX(realX);
		System.out.println("X Position "+sxPos+"\nReal X pos "+realX+"\nY Position "+syPos+"\nReal Y pos "+realY);
		image.setY(realY);
		image.setFitWidth(i.x/2);
		image.setFitHeight(i.y/2);
		xPos=sxPos;
		yPos = syPos;
		blockID = i.id;
	}
}
