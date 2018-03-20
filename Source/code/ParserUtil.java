
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ParserUtil {
	public static void main(String[] args) {

		String fileName = "C:\\Users\\19lfreeman\\Documents\\GitHub\\PlatformerGame\\Source\\code\\Tiles.tsx";
		// This will reference one line at a time
		String line = null;

		readTileSet(fileName);
	}

	public static ImportedTile findTile(int id, ArrayList<ImportedTile> a) {
		ImportedTile t = null;
		for (ImportedTile f : a) {
			if (f.id == id)
				return f;
		}
		return t;
	}

	public static Scene readCSV(String csvPath, String xmlPath) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 1000);
		ArrayList<ImportedTile> tileset = readTileSet(xmlPath);
		try {
			FileReader fileReader = new FileReader(csvPath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			ArrayList<String> allStrings = new ArrayList<String>(5);
			while ((line = bufferedReader.readLine()) != null) {
				allStrings.add(line);
			}
			int mapWidth = allStrings.get(0).split(",").length;
			int mapHeight = allStrings.size();
			Block[][] mapBlocks = new Block[mapHeight][mapWidth];
			int xOffset = 0;
			for (int i = 0; i < allStrings.size(); i++) {
				xOffset = 0;
				String sRow = allStrings.get(i);
				// top row is first
				String[] splitRow = sRow.split(",");
				for (int j = 0; j < splitRow.length; j++) {
					String num = splitRow[j];
					int bID = Integer.parseInt(num);
						ImportedTile thisTile = findTile(bID, tileset);
						Block thisBlock = new Block(thisTile, i, j, xOffset, i * thisTile.y/2);
						mapBlocks[i][j] = thisBlock;
						xOffset+=thisTile.x/2;

				}
			}
			for (Block[] blocks : mapBlocks) {
				for (Block blk : blocks) {
					if (blk != null)
						pane.getChildren().add(blk.image);
				}
			}
			// pa
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + csvPath + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + csvPath + "'");
		}
		return scene;
	}

	public static ArrayList<ImportedTile> readTileSet(String fpath) {
		ArrayList<ImportedTile> tiles = new ArrayList<ImportedTile>();
		String fileName = fpath;
		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.indexOf("<image") != -1) {
					// is an image
					String path = line.substring(line.indexOf("source") + 7, line.length() - 2);
					// int id = line.substring
					// System.out.println(line);
					// System.out.println(path);
				} else {
					if (line.indexOf("id=") != -1) {
						String nLine = bufferedReader.readLine();
						String path = nLine.substring(nLine.indexOf("source") + 7, nLine.length() - 2);
						// line=bufferedReader.readLine();
						int id = Integer.parseInt(line.substring(11, line.indexOf("\">")));
						int x = Integer.parseInt(nLine.substring(16, nLine.indexOf("\" h")));
						int y = Integer.parseInt(nLine.substring(nLine.indexOf("t=") + 3, nLine.indexOf("\" s")));
						ImportedTile iTile = new ImportedTile(path, id, x, y);
						tiles.add(iTile);
					}
				}
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return tiles;
	}

}
