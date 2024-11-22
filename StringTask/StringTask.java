package task;

import exception.StringProcessingException;
import util.StringTaskUtil;
import java.util.*;
public class StringTask {
    public int getStringLength(String string) throws StringProcessingException {
	StringTaskUtil.checkNull(string);
        return string.length();
    }

    public char[] convertToCharArray(String string) throws StringProcessingException {
	StringTaskUtil.checkNull(string);
        return string.toCharArray();
    }

    public char getPenultimateCharacter(String string,int positionFromEnd) throws StringProcessingException {
         int length = getStringLength(string);
	 if (positionFromEnd < 1||positionFromEnd > length) {
            throw new StringProcessingException("Invalid Position From End");
        }
             return string.charAt(length - positionFromEnd);
    }

    public int countOccurrences(String string, char target) throws StringProcessingException {
        int count = 0;
        int length = getStringLength(string);
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    public int findGreatestPosition(String string, char target) throws StringProcessingException {
	StringTaskUtil.checkNull(string);
	int position = string.lastIndexOf(target);
	  if (position == -1) {
        throw new StringProcessingException("Character '" + target + "' not found in the string");
      }
          return position; 
    }

    public String getLastCharacters(String string, int numberOfChars) throws StringProcessingException {
        int length = getStringLength(string);
        if (length < numberOfChars) {
            throw new StringProcessingException("Invalid numberOfChars");
        }
        return string.substring(length - numberOfChars);
    }

    public String getFirstCharacters(String string, int numberOfChars) throws StringProcessingException {
        int length = getStringLength(string);
        if (length < numberOfChars) {
            throw new StringProcessingException("Invalid numberOfChars");
        }
        return string.substring(0, numberOfChars);
    }    
    public String replaceCharacters(String string, int numberOfChars, String stringToReplace) throws StringProcessingException {
    	StringTaskUtil.checkNull(string); 
    	if (numberOfChars > string.length()) {
        	throw new StringProcessingException("Number of characters to replace exceeds string length.");
    	}
    String subString = string.substring(0, numberOfChars);
    return string.replaceAll(subString,stringToReplace);
    }


    public boolean startsWithSubstring(String string, String prefix) throws StringProcessingException {
	StringTaskUtil.checkNull(string);
	StringTaskUtil.checkNull(prefix);
        return string.startsWith(prefix);
    }

    public boolean endsWithSubstring(String string, String suffix) throws StringProcessingException {
	StringTaskUtil.checkNull(string);
	StringTaskUtil.checkNull(suffix);
        return string.endsWith(suffix);
    }

    public String convertToUpperCase(String lowerCaseString) throws StringProcessingException {
	StringTaskUtil.checkNull(lowerCaseString);
        return lowerCaseString.toUpperCase();
    }

    public String convertToLowerCase(String upperCaseString) throws StringProcessingException {
	StringTaskUtil.checkNull(upperCaseString);
        return upperCaseString.toLowerCase();
    }

    public String reverseString(String originalString) throws StringProcessingException {
        char[] charArray = originalString.toCharArray();
        int length = getStringLength(originalString);

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }

        return new String(charArray);
    }

    public String acceptMultipleStrings(String multipleStrings) throws StringProcessingException {
	StringTaskUtil.checkNull(multipleStrings);
        return multipleStrings;
    }


   public String concatenateStrings(String line) throws StringProcessingException {
    StringTaskUtil.checkNull(line);  
    String[] words = line.split("\\s+");
    return String.join("", words);
   }


    public String[] encloseInArray(String line,String delimiter) throws StringProcessingException {
	StringTaskUtil.checkNull(line);
        return line.split(Pattern.quote(delimiter));
    }

    public String mergeStrings(String[] strings, char character) throws StringProcessingException {
	if(strings == null) {
	   throw new StringProcessingException("Null array encountered");
	}
        for (String string : strings) {
            if (string == null) {
                throw new StringProcessingException("Null value encountered in array");
            }
        }
        return String.join(String.valueOf(character), strings);
    }

    public boolean checkCaseSensitiveEquality(String str1, String str2) throws StringProcessingException {
	StringTaskUtil.checkNull(str1);
	StringTaskUtil.checkNull(str2);
        return str1.equals(str2);
    }

    public boolean checkCaseInsensitiveEquality(String str1, String str2) throws StringProcessingException {
	StringTaskUtil.checkNull(str1);
	StringTaskUtil.checkNull(str2);
	return str1.equalsIgnoreCase(str2);
    }

    public String trimSpaces(String inputString) throws StringProcessingException {
	StringTaskUtil.checkNull(inputString);
        return inputString.trim();
    }

 

    
}
