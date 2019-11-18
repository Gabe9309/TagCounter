import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	private File file;
	private String fullPath;
	private TagCounter tagCounter;
	private TagHandler tagHandler;
	private Scanner fileScanner;
	
	FileReader(String fileName, TagCounter tagCounter) throws FileNotFoundException{
		this.tagCounter = tagCounter;
		file = new File(fileName);
		fullPath = file.getAbsolutePath();
		file = new File(fullPath);
		fileScanner = new Scanner(file);
		
	}
	
	public void readFile() {
		String currentLine;
		
		while(fileScanner.hasNext()) {
			currentLine = fileScanner.nextLine();
			for(int i = 0; i < currentLine.length(); i++) {
				if(currentLine.charAt(i) == '<') {
					tagHandler = new TagHandler(currentLine, tagCounter);
				}
			}
		}
	}
	
}
