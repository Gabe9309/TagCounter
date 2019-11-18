
public class TagsRecord {
	private String tagName;
	private boolean isClosingTag;
	private int amountOfOcurrences;
	
	TagsRecord(String tagName){
		this.tagName = tagName;
		this.isClosingTag = false;
		this.amountOfOcurrences = 0;
	}
	
	TagsRecord(String tagName, boolean closing){
		this.tagName = tagName;
		this.isClosingTag = closing;
		this.amountOfOcurrences = 0;
	}
	
	@Override 
	public String toString() {
		if(isClosingTag)
			return "</" + tagName + ">" + " apears " + (amountOfOcurrences + 1) + " times.";
		else 
			return "<" + tagName + ">" + " apears " + (amountOfOcurrences + 1) + " times.";
	}
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public boolean isClosingTag() {
		return isClosingTag;
	}
	public void seIsClosingTag(boolean isClosed) {
		this.isClosingTag = isClosed;
	}
	public int getAmountOfOcurrences() {
		return amountOfOcurrences;
	}
	public void increaseCounter() {
		this.amountOfOcurrences++;
	}
	
	

}
