import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class ImportedTile {
	public String path;
	public int id;
	public int x;
	public int y;
	public ImportedTile(String p, int i, int xd, int yd) {
		path=p;
		id=i;
		
		x=xd;
		y=yd;
	}
}
