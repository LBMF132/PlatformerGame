import java.awt.Rectangle;

public class Colliding {
//	public static 

	public static void b2R(Block[][] bs) {
		Rectangle[][] rectangles = new Rectangle[bs.length][bs[0].length];
		for (int i = 0; i < bs.length; i++) {
			Block[] bss = bs[i];
			for (int j = 0; j < bss.length; j++) {
				Block b = bss[j];
				Rectangle r = new Rectangle((int) b.image.getX(), (int) b.image.getY(), (int) b.image.getFitWidth(),
						(int) b.image.getFitHeight());
				b.rectangle = r;
			}
		}
	}
	private static void doCollision(Block b) {
		Rectangle bR = b.rectangle;
		Rectangle pR = Player.playerRectangle;
		double xD = pR.getX()-bR.getX();
		double yD = pR.getY()-bR.getY();
		if(yD>=0){
			
		}
		System.out.println(yD);
	}
	public static void checkColl(Block[][] blockSet) {
		int c=0;
//		System.out.println(Player.playerRectangle.getY());

		for(Block b[]:blockSet) {
			for(Block bR:b) {
				if(bR.rectangle.intersects(Player.playerRectangle)&&bR.blockID!=-1) {
					System.out.println("FFFFFFFFFFFFFFFFFFFFF");
					Player.xVel=0;
					Player.yVel=0;
					c++;
					doCollision(bR);
				}
			}
		}
	}
}
