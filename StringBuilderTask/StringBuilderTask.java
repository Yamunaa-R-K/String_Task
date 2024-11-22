package task;
import build.BuildStringBuilder;
import util.StringBuilderTaskUtil;
import exception.StringBuilderProcessingException;
public class StringBuilderTask {
	public int getLength(String string) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(string);
 		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.length();
        }
	public String getUpdatedString(String initialString, String[] stringsToAdd, String delimiter) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(initialString);
		for (String str : stringsToAdd) {
                   stringBuilder.append(delimiter).append(str);
                }
		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.toString();

	}
	public String concatenateStrings(String firstString, String secondString) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(firstString + " " + secondString);
		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.toString();
	}
	public String concatenateStringsWithDelimiter(String firstString, String secondString,String delimiter) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(firstString + delimiter + secondString);
		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.toString();
	}

		
	public String getStringsWithSpaces(String firstString, String concatenatedString,String intermediateString) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(concatenatedString);
		stringBuilder.insert(firstString.length() + 1, " " + intermediateString + " ");
		StringBuilderTaskUtil.checkNull(stringBuilder);
		return stringBuilder.toString();
       }
       public String getRemainingString(String firstString, String concatenatedString) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(concatenatedString);
		stringBuilder.delete(0, firstString.length() + 1);
       		return stringBuilder.toString();
	}
       public String replaceSpacesBySpecialCharacters(String input,String delimiter) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(input);
		for (int i = 0; i < stringBuilder.length(); i++) {
        		if (stringBuilder.charAt(i) == ' ') {
            			 stringBuilder.replace(i, i + 1, delimiter);
           	                 i += delimiter.length() - 1;
                        }
                 }
     
    		return stringBuilder.toString();
	}
        public String reverseStrings(String input) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(input);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}
	public String deleteSpecificCharacters(String input,int startIndex,int endIndex) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(input);
		if (startIndex < 0 || endIndex > stringBuilder.length() || startIndex >= endIndex) {
                	throw new StringBuilderProcessingException( "Invalid indices.");
           	}
		stringBuilder.delete(startIndex, endIndex);
		return stringBuilder.toString();
	}
	public String replaceSpecificCharacters(String inputString,int startIndex,int endIndex,String stringToReplace) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(inputString);
		if (startIndex < 0 || endIndex > stringBuilder.length() || startIndex >= endIndex) {
                	throw new StringBuilderProcessingException( "Invalid indices.");
           	}
                stringBuilder.replace(startIndex,endIndex,stringToReplace);
		return stringBuilder.toString();
	}
	public int getFirstIndexOfDelimiter(String input,String delimiter) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(input);
		int firstIndex = stringBuilder.indexOf(delimiter);
		return firstIndex;
	}
	public int getLastIndexOfDelimiter(String input,String delimiter) throws StringBuilderProcessingException {
		StringBuilder stringBuilder = BuildStringBuilder.buildStringBuilder(input);
		int LastIndex = stringBuilder.indexOf(delimiter);
		return LastIndex;
	}




}  