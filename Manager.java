import java.io.FileNotFoundException;

public class Manager {
	
	private FileReader fileReader;
	private TagCounter tagCounter;
	private TagReport tagReport;
	private String fileName;
	
	Manager(String fileName){
		this.fileName = fileName;
	}
	public void Manage() throws FileNotFoundException{
		tagCounter = new TagCounter();
		fileReader = new FileReader(fileName, tagCounter);
		fileReader.readFile();
		tagReport = new TagReport(tagCounter.getOpeningTags(), tagCounter.getClosingTags());
		tagReport.printReport();
	}

}
