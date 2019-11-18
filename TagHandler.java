
public class TagHandler {
	
	private TagCounter tagCounter;
	private String line;
	
	TagHandler(String line, TagCounter tagCounter){
		this.tagCounter = tagCounter;
		this.line = line;
		handleTheLine();
	}
	
	public void handleTheLine() {
		String closingTag;
		String opennigTag;
		
		for(int i = 0; i < line.length(); i++) {
			
			if((line.charAt(i) == '<') && (line.charAt(i + 1) == '/')) {
				for(int j = i; j < line.length(); j++) {
					if(line.charAt(j) == '>') {
						closingTag = line.substring((i + 2), j);
						saveClosingTag(closingTag);
						break;
					}
				}
			}
			
			else if (line.charAt(i) == '<') {
				for(int j = i; j < line.length(); j++) {
					if((line.charAt(j) == '>') || (line.charAt(j) == ' ')){
						opennigTag = line.substring((i + 1), j);
						saveOpeningTag(opennigTag);
						break;
					}
				}
			}
		}
	}
	
	private void saveClosingTag(String closingTag) {
		tagCounter.setClosingTag(closingTag);
	}
	
	private void saveOpeningTag(String openingTag) {
		tagCounter.setOpeningTag(openingTag);
	}
	
}
