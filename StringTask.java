package task;

public class StringTask {
    public int getStringLength(String string) {
        return string.length();
    }

    public char[] convertToCharArray(String string) throws StringProcessingException {
	checkNull(string);
        return string.toCharArray();
    }

    public char getCharacterAtPosition(String string,int position) throws StringProcessingException {
	checkNull(string);
        int length = getStringLength(string);
        if (position < 1 || position > length)
        {
        throw new StringProcessingException("Invalid position");
        }
        return string.charAt(position);
    }

    public int countOccurrences(String string, char target) throws StringProcessingException {
	checkNull(string);
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
	checkNull(string);
	int position = string.lastIndexOf(target);
	  if (position == -1) {
        throw new StringProcessingException("Character '" + target + "' not found in the string");
      }
          return position; 
    }

    public String getLastCharacters(String string, int numberOfChars) throws StringProcessingException {
	checkNull(string);
        int length = getStringLength(string);
        if (length < numberOfChars) {
            throw new StringProcessingException("Invalid numberOfChars");
        }
        return string.substring(length - numberOfChars);
    }

    public String getFirstCharacters(String string, int numberOfChars) throws StringProcessingException {
	checkNull(string);
        int length = getStringLength(string);
        if (length <= numberOfChars) {
            throw new StringProcessingException("Invalid numberOfChars");
        }
        return string.substring(0, numberOfChars);
    }

    public String replaceCharacters(String string, String prefix) throws StringProcessingException {
	checkNull(string);
	checkNull(prefix);
        if (getStringLength(string) < getStringLength(prefix)) {
            throw new StringProcessingException("Invalid prefix");
        }
        return prefix + string.substring(getStringLength(prefix));
    }

    public boolean startsWithSubstring(String string, String prefix) throws StringProcessingException {
	checkNull(string);
	checkNull(prefix);
        return string.startsWith(prefix);
    }

    public boolean endsWithSubstring(String string, String suffix) throws StringProcessingException {
	checkNull(string);
	checkNull(suffix);
        return string.endsWith(suffix);
    }

    public String convertToUpperCase(String lowerCaseString) throws StringProcessingException {
	checkNull(lowerCaseString);
        return lowerCaseString.toUpperCase();
    }

    public String convertToLowerCase(String upperCaseString) throws StringProcessingException {
	checkNull(upperCaseString);
        return upperCaseString.toLowerCase();
    }

    public String reverseString(String originalString) throws StringProcessingException {
        checkNull(originalString);
        char[] charArray = originalString.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }

        return new String(charArray);
    }

    public String acceptMultipleStrings(String multipleStrings) throws StringProcessingException {
	checkNull(multipleStrings);
        return multipleStrings;
    }

    public String concatenateStrings(String line,char character) throws StringProcessingException {
	checkNull(line);
        return line.replace(String.valueOf(character), "").replace(" ","");
    }

    public String[] encloseInArray(String line,String delimiter) throws StringProcessingException {
	checkNull(line);
        return line.split(delimiter);
    }

    public String mergeStrings(String[] strings, char character) throws StringProcessingException {
        for (String string : strings) {
            if (string == null) {
                throw new StringProcessingException("Null value encountered in array");
            }
        }
        return String.join(String.valueOf(character), strings);
    }

    public boolean checkCaseSensitiveEquality(String str1, String str2) throws StringProcessingException {
	checkNull(str1);
	checkNull(str2);
        return str1.equals(str2);
    }

    public boolean checkCaseInsensitiveEquality(String str1, String str2) throws StringProcessingException {
	checkNull(str1);
	checkNull(str2);
	return str1.equalsIgnoreCase(str2);
    }

    public String trimSpaces(String inputString) throws StringProcessingException {
	checkNull(inputString);
        return inputString.trim();
    }

    private void checkNull(String string) throws StringProcessingException {
        if (string == null) {
            throw new StringProcessingException("Null value encountered");
        }
	
    }
}
