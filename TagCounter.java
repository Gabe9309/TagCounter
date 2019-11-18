import java.util.ArrayList;

public class TagCounter {
	private TagsRecord singleTag;
	private ArrayList<TagsRecord> openingTagsRecord;
	private ArrayList<TagsRecord> closingTagsRecord;
	private int positionFound;
	
	TagCounter(){
		openingTagsRecord = new ArrayList<TagsRecord>();
		closingTagsRecord = new ArrayList<TagsRecord>();
	}
	
	private void sortTags(ArrayList<TagsRecord> tagsToSort, int low, int high) {
		if (tagsToSort == null || tagsToSort.size() == 0)
			return;
	 
		if (low >= high)	
			return;
	
		int middle = low + (high - low) / 2;
		int pivot = tagsToSort.get(middle).getTagName().charAt(0);
	 
		int i = low, j = high;
		while (i <= j) {
			while (tagsToSort.get(i).getTagName().charAt(0) < pivot) {
				i++;
			}
	 
			while (tagsToSort.get(j).getTagName().charAt(0) > pivot) {
				j--;
			}
	 
			if (i <= j) {
				singleTag = tagsToSort.get(i);
				tagsToSort.set(i,tagsToSort.get(j));
				tagsToSort.set(j,singleTag);;
				i++;
				j--;
			}
		}
	 
		if (low < j)
			sortTags(tagsToSort, low, j);
		if (high > i)
			sortTags(tagsToSort, i, high);
		}	
	
	public ArrayList<TagsRecord> getOpeningTags(){
		sortTags(openingTagsRecord, 0 , openingTagsRecord.size() - 1);
		return openingTagsRecord;
	}
	
	public ArrayList<TagsRecord> getClosingTags(){
		sortTags(closingTagsRecord, 0 , closingTagsRecord.size() - 1);
		return closingTagsRecord;
	}
	
	private boolean findReapeatingTags(String tagName, ArrayList<TagsRecord> listToCheck) {
		
		for(int i = 0; i < listToCheck.size(); i++) {
			if(tagName.equals(listToCheck.get(i).getTagName())) {
				positionFound = i;
				return true;
			}
		}
		return false;
	}
	
	private void createNewRecord(String tagName, boolean isClosingTag) {
		
		if(isClosingTag) {
			singleTag = new TagsRecord(tagName, isClosingTag);
			closingTagsRecord.add(singleTag);
		}
		else
		{
			singleTag = new TagsRecord(tagName);
			openingTagsRecord.add(singleTag);
		}
		
	}
	
	
	public void setOpeningTag(String tagName) {
		
		final boolean IS_CLOSING = false;
		
		if(openingTagsRecord.isEmpty()) {
			createNewRecord(tagName, IS_CLOSING);
		}
		else if(findReapeatingTags(tagName, openingTagsRecord)) {
			singleTag = openingTagsRecord.get(positionFound);
			singleTag.increaseCounter();
			openingTagsRecord.set(positionFound, singleTag);
		}
		else
		{
			createNewRecord(tagName, IS_CLOSING);
		}

	}
	
	public void setClosingTag(String tagName) {
		final boolean IS_CLOSING = true;

		if(closingTagsRecord.isEmpty()) {
			createNewRecord(tagName, IS_CLOSING);
		}
		else if(findReapeatingTags(tagName, closingTagsRecord)) {
			singleTag = closingTagsRecord.get(positionFound);
			singleTag.increaseCounter();
			closingTagsRecord.set(positionFound, singleTag);
		}
		else
		{
			createNewRecord(tagName, IS_CLOSING);
		}
	}
}
