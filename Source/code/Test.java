package code;

import java.io.File;

public class Test {
	public static void main(String args[]) {
		File f = new File("");
		String fn = f.getAbsolutePath();
		System.out.println(fn);
		String filePath = new File("").getAbsolutePath();
		filePath += ("\npath to the property file");
	}
}