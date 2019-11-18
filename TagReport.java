import java.util.ArrayList;

public class TagReport {
	
	private ArrayList<TagsRecord> openingTags;
	private ArrayList<TagsRecord> closingTags;
	
	TagReport(ArrayList<TagsRecord> openingTags, ArrayList<TagsRecord> closingTags){
		this.closingTags = new ArrayList<TagsRecord>();
		this.openingTags = new ArrayList<TagsRecord>();
		this.openingTags.addAll(openingTags);
		this.closingTags.addAll(closingTags);
	}
	
	public void printReport() {
		
		System.out.println("Opening Tags>>");
		for(int i = 0; i < openingTags.size(); i++) {
			System.out.println(openingTags.get(i));
		}
		
		System.out.println();
		
		System.out.println("Closing Tags>>");
		for(int i = 0; i < closingTags.size(); i++) {
			System.out.println(closingTags.get(i));
		}
	}
	
	
}
