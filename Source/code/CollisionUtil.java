import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionUtil {
	public static Rectangle[][] map = null;

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

	public static int[] collisions(Block[][] blockset) {
		// first, make an ideal rectangle for player position
		b2R(blockset);
		int xPos = (int) (Player.playerSprite.getX() / Player.playerSprite.getFitHeight());
		int yPos = (int) (Player.playerSprite.getY() / Player.playerSprite.getFitHeight());

		ArrayList<Block> collidingBlocks = new ArrayList<Block>(10);
		for (int i = 0; i < blockset.length; i++) {
			Block[] blocks = blockset[i];
			for (int j = 0; j < blocks.length; j++) {
				Block block = blocks[j];
				double xDiff =Player.xPos-block.xPos;
				double yDiff =Player.yPos-block.yPos;
				if (Math.abs(xDiff)<=block.width&&Math.abs(yDiff)<=block.height) {
					collidingBlocks.add(block);
				}
			}
		}
		System.out.println(collidingBlocks.size());
		Boolean horizontalCollide = null;
		// System.out.println("Player xPos: "+Player.xPos+"\nPlayer yPos:
		// "+Player.yPos);
		for (Block testBlock : collidingBlocks) {
			double xD = Player.xPos - testBlock.xPos;
			double yD = Player.yPos - testBlock.yPos;
			if (xD >= 0 && xD < testBlock.width && yD < testBlock.height) {
				// leftSide Collision
				double overLap = testBlock.width - xD;
				System.out.println("left colliding");
			} else if (xD <= 0 && Math.abs(xD) < testBlock.width && Math.abs(yD) < testBlock.height) {
				// right Side Collision
				System.out.println("right colliding");

			}
			if (yD <= 0 && Math.abs(yD) < testBlock.height && Math.abs(xD) < testBlock.width) {
				// bottom collision
				System.out.println("bottom colliding");

			} else if (yD > 0 && Math.abs(yD) < testBlock.height && Math.abs(xD) < testBlock.width) {
				// top collision
				System.out.println("top colliding");

			}
			if (Player.xPos < testBlock.xPos && Player.yPos < testBlock.yPos - testBlock.height) {

			}
		}

		// ArrayList with all colliding blocks that aren't background

		return null;
	}

}
