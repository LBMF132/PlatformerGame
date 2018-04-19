import java.awt.Rectangle;

public class Colliding {
	// public static

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

	private static double[] doCollision(Block b) {
		Rectangle bR = b.rectangle;
		Rectangle pR = Player.playerRectangle;
		double deltaVX = 0;
		double deltaVY = 0;
		double xD = pR.getX() - bR.getX();
		double yD = pR.getY() - bR.getY();
		// bottom collision

		if (35 - Math.abs(yD) < 3) {
			// close enough to be colliding - for jumping
			Player.bottomColliding = true;
		}
		if (yD < 0) {
			deltaVY += 1.1 * yD;
			System.out.println(deltaVY);
			// bottom Colliding
			Player.bottomColliding = true;
		} else if (yD > 0) {
			// top colliding
			deltaVY -= 1.1 * yD;
		}
		if (xD < 0) {
			// colliding from the left
			deltaVX += 0.5*(-1) * (Math.pow(35 - Math.abs(xD), 2));
			System.out.println(xD);
		} else if (xD > 0) {
			deltaVX += 0.5*Math.abs(Math.pow(35 - Math.abs(xD), 2));
			// colliding from the right
		}
		Player.yVel = deltaVY;
		Player.xVel = deltaVX;
		return null;
	}

	public static void checkColl(Block[][] blockSet) {
		int c = 0;
		// System.out.println(Player.playerRectangle.getY());
		double changeX = 0;
		double changeY = 0;
		for (Block b[] : blockSet) {
			for (Block bR : b) {
				if (bR.rectangle.intersects(Player.playerRectangle) && bR.blockID != -1) {
					c++;
					double[] ds = doCollision(bR);
					
				}
			}
		}

	}
}
