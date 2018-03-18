import javafx.scene.image.ImageView;

public class Block {
	public ImageView image;
	public int xPos;
	public int yPos;
	public int width;
	public int height;
	public Block(ImportedTile i,int x,int y) {
		image = new ImageView(i.path);
		width = i.x;
		height = i.y;
		image.setX(x*width);
		image.setY(height*y);
	}
}
