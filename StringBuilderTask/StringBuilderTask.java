package task;
import util.StringBuilderTaskUtil;
import exception.StringBuilderProcessingException;
public class StringBuilderTask {
	public int getLength(StringBuilder stringBuilder) throws StringBuilderProcessingException {
 		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.length();
        }
	public StringBuilder insertStringsWithDelimter(StringBuilder stringBuilder, String[] stringsToAdd, String delimiter) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		for (String str : stringsToAdd) {
                   stringBuilder.append(delimiter).append(str);
                }
		return stringBuilder;
	}
	public StringBuilder insertStringBetween(StringBuilder stringBuilder, String stringToInsert, int position1, int position2) throws StringBuilderProcessingException {
		 StringBuilderTaskUtil.checkNull(stringBuilder);
		 if (position1 <= 0 || position2 <= 0 || position1 >= stringBuilder.length() || position2 != position1 + 1) {
            		throw new StringBuilderProcessingException("Invalid positions for insertion.");
        	 } 
		 int position1Index = findTokenEndIndex(stringBuilder, position1);
        	 int position2Index = findTokenEndIndex(stringBuilder, position2);
		 if (position1Index == -1 || position2Index == -1 || position2Index <= position1Index) {
            		throw new StringBuilderProcessingException("Invalid positions for insertion.");
                 }
		 stringBuilder.insert(position1Index + 1, stringToInsert + " "); 
		 return stringBuilder;
	}
	private int findTokenEndIndex(StringBuilder sb, int position) {
        	int spaceCount = 0;
        	for (int i = 0; i < sb.length(); i++) {
            		if (sb.charAt(i) == ' ') {
                	  spaceCount++;
            	        }
            	        if (spaceCount == position) {
                          return i;
		        }
                 }
       		 return -1; 
    	}
	
	public StringBuilder deleteSpecificString(StringBuilder stringBuilder, int position) throws StringBuilderProcessingException {
    		StringBuilderTaskUtil.checkNull(stringBuilder);
   		if (position <= 0 || position >  countWords(stringBuilder)) {
        		throw new StringBuilderProcessingException("Invalid position for deletion.");
    		}
   		int startIndex = calculateStartIndex(stringBuilder, position);
    		int endIndex = calculateEndIndex(stringBuilder, position);
    		stringBuilder.delete(startIndex, endIndex);
    		return stringBuilder;
    	}
	private int calculateStartIndex(StringBuilder stringBuilder, int position) {
    		int index = 0;
    		int wordCount = 1;
	        for (int i = 0; i < stringBuilder.length(); i++) {
        		if (wordCount == position) {
            			index = i;
                		break;
            		}
        		if (stringBuilder.charAt(i) == ' ') {
            			wordCount++;
        		}
    		}	
    		return index;
	}
	private int calculateEndIndex(StringBuilder stringBuilder, int position) {
    		int index = stringBuilder.length();
    		int wordCount = 1;
    		for (int i = 0; i < stringBuilder.length(); i++) {
        		if (wordCount == position + 1) {
            			index = i; 
            			break;
        		}
        		if (stringBuilder.charAt(i) == ' ') {
            			wordCount++;
        		}
    		}
    		return index;
	}
	 private int countWords(StringBuilder sb) {
        	int wordCount = 0;
        	for (int i = 0; i < sb.length(); i++) {
            		if (sb.charAt(i) == ' ') {
                		wordCount++;
            		}
        	}
        	return wordCount + 1; 
	}

       public StringBuilder replaceSpacesBySpecialCharacters(StringBuilder stringBuilder,String delimiter) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		if (delimiter == null || delimiter.isEmpty()) {
              		 throw new StringBuilderProcessingException("Delimiter cannot be null or empty.");
        	}
		int length = stringBuilder.length();
        	StringBuilder result = new StringBuilder();
		int start = 0;
        	for (int i = 0; i < length; i++) {
            		char c = stringBuilder.charAt(i);	
            		if (c == ' ') {
                             result.append(stringBuilder.substring(start, i));
			     result.append(delimiter);
               		     start = i + 1;
            		}
        	}
        	result.append(stringBuilder.substring(start, length));
		return result;
	}
        public StringBuilder reverseStrings(StringBuilder stringBuilder) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		stringBuilder.reverse();
		return stringBuilder;
	}
	public StringBuilder deleteSpecificCharacters(StringBuilder stringBuilder,int startIndex,int endIndex) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		if (startIndex < 0 || endIndex > stringBuilder.length() || startIndex >= endIndex) {
                	throw new StringBuilderProcessingException( "Invalid indices.");
           	}
		stringBuilder.delete(startIndex, endIndex);
		return stringBuilder;
	}
	public StringBuilder replaceSpecificCharacters(StringBuilder stringBuilder,int startIndex,int endIndex,String stringToReplace) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		if (startIndex < 0 || endIndex > stringBuilder.length() || startIndex >= endIndex) {
                	throw new StringBuilderProcessingException( "Invalid indices.");
           	}
                stringBuilder.replace(startIndex,endIndex,stringToReplace);
		return stringBuilder;
	}
	public int getFirstIndexOfDelimiter(StringBuilder stringBuilder,String delimiter) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		int firstIndex = stringBuilder.indexOf(delimiter);
		return firstIndex;
	}
	public int getLastIndexOfDelimiter(StringBuilder stringBuilder,String delimiter) throws StringBuilderProcessingException {
		StringBuilderTaskUtil.checkNull(stringBuilder);
		int LastIndex = stringBuilder.indexOf(delimiter);
		return LastIndex;
	}




}  