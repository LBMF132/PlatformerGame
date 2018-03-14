

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserUtil {
	public static void main(String[] args) {

		String fileName =  "C:\\Users\\19lfreeman\\Documents\\GitHub\\PlatformerGame\\Source\\code\\Tiles.tsx";
		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
				if(line.indexOf("<image")!=-1) {
					//is an image
					String path = line.substring(line.indexOf("source")+7, line.length()-2);
//					int id = line.substring
//					System.out.println(line);
//					System.out.println(path);
				}else {
					if(line.indexOf("id=")!=-1) {
						String nLine = bufferedReader.readLine();
						String path = nLine.substring(nLine.indexOf("source")+7, nLine.length()-2);
						int id = Integer.parseInt(line.substring(11,line.indexOf("\">")));
						System.out.println(id);

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
	}

}
