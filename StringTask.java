package task;

public class StringTask {
    public int getStringLength(String string) {
	checkNull(string);
        return string.length();
    }

    public char[] convertToCharArray(String string) {
	checkNull(string);
        return string.toCharArray();
    }

    public char getPenultimateCharacter(String string) {
	checkNull(string);
        int length = getStringLength(string);
        if (length < 2) {
            throw new MyException("Invalid length");
        }
        return string.charAt(length - 2);
    }

    public int countOccurrences(String string, char target) {
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

    public int findGreatestPosition(String string, char target) {
	checkNull(string);
        if (string.contains(String.valueOf(target))) {
            return string.lastIndexOf(target);
        } else {
            throw new MyException("Invalid target");
        }
    }

    public String getLastCharacters(String string, int numberOfChars) {
	checkNull(string);
        int length = getStringLength(string);
        if (length < numberOfChars) {
            throw new MyException("Invalid numberOfChars");
        }
        return string.substring(length - numberOfChars);
    }

    public String getFirstCharacters(String string, int numberOfChars) {
	checkNull(string);
        int length = getStringLength(string);
        if (length <= numberOfChars) {
            throw new MyException("Invalid numberOfChars");
        }
        return string.substring(0, numberOfChars);
    }

    public String replaceCharacters(String string, String prefix) {
	checkNull(string);
	checkNull(prefix);
        if (getStringLength(string) < getStringLength(prefix)) {
            throw new MyException("Invalid prefix");
        }
        return prefix + string.substring(getStringLength(prefix));
    }

    public boolean startsWithSubstring(String string, String prefix) {
	checkNull(string);
	checkNull(prefix);
        return string.startsWith(prefix);
    }

    public boolean endsWithSubstring(String string, String suffix) {
	checkNull(string);
	checkNull(suffix);
        return string.endsWith(suffix);
    }

    public String convertToUpperCase(String lowerCaseString) {
	checkNull(lowerCaseString);
        return lowerCaseString.toUpperCase();
    }

    public String convertToLowerCase(String upperCaseString) {
	checkNull(upperCaseString);
        return upperCaseString.toLowerCase();
    }

    public String reverseString(String originalString) {
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

    public String acceptMultipleStrings(String multipleStrings) {
	checkNull(multipleStrings);
        return multipleStrings;
    }

    public String concatenateStrings(String line) {
	checkNull(line);
        return line.replace(" ", "");
    }

    public String[] encloseInArray(String line) {
	checkNull(line);
        return line.split(" ");
    }

    public String mergeStrings(String[] strings, char character) {
        for (String string : strings) {
            if (string == null) {
                throw new MyException("Null value encountered in array");
            }
        }
        return String.join(String.valueOf(character), strings);
    }

    public boolean checkCaseSensitiveEquality(String str1, String str2) {
	checkNull(str1);
	checkNull(str2);
        return str1.equals(str2);
    }

    public boolean checkCaseInsensitiveEquality(String str1, String str2) {
	checkNull(str1);
	checkNull(str2);
	return str1.equalsIgnoreCase(str2);
    }

    public String trimSpaces(String inputString) {
	checkNull(inputString);
        return inputString.trim();
    }

    private void checkNull(String string) {
        if (string == null) {
            throw new MyException("Null value encountered");
        }
	
    }
}
