package util;

import task.StringTask;
import exception.StringProcessingException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class StringTaskUtil {

    public static void displayStringLength(StringTask stringTask, String inputString) throws StringProcessingException {
        try {
            System.out.println("Length of the string: " + stringTask.getStringLength(inputString));
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error displaying string length", ex);
        }
    }

    public static void convertToCharArray(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String inputStringForCharArray = scanner.nextLine();
            char[] charArray = stringTask.convertToCharArray(inputStringForCharArray);
            System.out.println("Character Array: " + Arrays.toString(charArray));
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to character array", ex);
        }
    }

    public static void getPenultimateCharacter(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String inputStringForPenultimate = scanner.nextLine();
            try {
                System.out.print("Enter the position from End: ");
                int positionFromEnd = scanner.nextInt();
                scanner.nextLine();
                char character = stringTask.getPenultimateCharacter(inputStringForPenultimate, positionFromEnd);
                System.out.println("Penultimate Character: " + character);
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Position From End.");
                scanner.nextLine();
            }
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error getting penultimate character", ex);
        }
    }

    public static void countOccurrences(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String characterCountInput = scanner.nextLine();
            System.out.print("Enter the character to count: ");
            char targetChar = scanner.next().charAt(0);
            int occurrences = stringTask.countOccurrences(characterCountInput, targetChar);
            System.out.println("The character '" + targetChar + "' occurs " + occurrences + " times in the string.");
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error counting occurrences of character", ex);
        }
    }

    public static void findGreatestPosition(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String greatestPositionInput = scanner.nextLine();
            System.out.print("Enter the character to find its greatest position: ");
            char targetChar = scanner.next().charAt(0);
            int greatestPosition = stringTask.findGreatestPosition(greatestPositionInput, targetChar);
            System.out.println("Greatest position of '" + targetChar + "': " + greatestPosition);
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error finding greatest position of character", ex);
        }
    }

    public static void getLastCharacters(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String lastCharactersInput = scanner.nextLine();
            try {
                System.out.print("Enter number of characters: ");
                int numberOfChars = scanner.nextInt();
                scanner.nextLine();
                String lastChars = stringTask.getLastCharacters(lastCharactersInput, numberOfChars);
                System.out.println("Last " + numberOfChars + " characters: " + lastChars);
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Number of Characters.");
                scanner.nextLine();
            }
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error getting last characters", ex);
        }
    }

    public static void getFirstCharacters(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String firstCharactersInput = scanner.nextLine();
            try {
                System.out.print("Enter number of characters: ");
                int numberOfChars = scanner.nextInt();
                scanner.nextLine();
                String firstChars = stringTask.getFirstCharacters(firstCharactersInput, numberOfChars);
                System.out.println("First " + numberOfChars + " characters: " + firstChars);
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Number of Characters.");
                scanner.nextLine();
            }
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error getting first characters", ex);
        }
    }

    public static void replaceFirstCharacters(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String replaceCharactersInput = scanner.nextLine();
            System.out.println("Enter the string to replace: ");
            String stringToReplace = scanner.nextLine();
            try {
                System.out.print("Enter number of characters to replace: ");
                int numberOfChars = scanner.nextInt();
                scanner.nextLine();
                String  replacedString = stringTask.replaceCharacters(replaceCharactersInput, numberOfChars, stringToReplace);
                System.out.println("String after replacement: " + replacedString);
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Number of Characters.");
                scanner.nextLine();
            }
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error replacing first characters", ex);
        }
    }

    public static void startsWithSubstring(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String startsWithInput = scanner.nextLine();
            System.out.println("Enter the starting substring: ");
            String stringStartsWith = scanner.nextLine();
            boolean startsWithString = stringTask.startsWithSubstring(startsWithInput, stringStartsWith);
            System.out.println("Starts with " + stringStartsWith + ": " + startsWithString);
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error checking start with substring", ex);
        }
    }

    public static void endsWithSubstring(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String endsWithInput = scanner.nextLine();
            System.out.println("Enter the ending substring: ");
            String stringEndsWith = scanner.nextLine();
            boolean endsWithString = stringTask.endsWithSubstring(endsWithInput,stringEndsWith);
            System.out.println("Ends with " + stringEndsWith  + ": " + endsWithString);
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error checking end with substring", ex);
        }
    }

    public static void convertToUpperCase(StringTask stringTask, Scanner scanner) throws StringProcessingException {
         try{
                    System.out.print("Enter a lowercase string: ");
                    String lowerCaseString = scanner.nextLine();
                    System.out.println("Uppercase string: " + stringTask.convertToUpperCase(lowerCaseString));
		    }catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to uppercase", ex);
        }
    }

    public static void convertToLowerCase(StringTask stringTask, Scanner scanner) throws StringProcessingException {
          try{
                    System.out.print("Enter an uppercase string: ");
                    String upperCaseString = scanner.nextLine();
                    System.out.println("Lowercase string: " + stringTask.convertToLowerCase(upperCaseString));
		    } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to lowercase", ex);
        }
    }

    public static void reverseString(StringTask stringTask, Scanner scanner) throws StringProcessingException {
         try{
                    System.out.print("Enter a string to reverse: ");
                    String originalString = scanner.nextLine();
                    System.out.println("Reversed string: " + stringTask.reverseString(originalString));
		    }catch (StringProcessingException ex) {
            throw new StringProcessingException("Error reversing string", ex);
        }
    }

    public static void acceptMultipleStrings(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try{
                    System.out.print("Enter a line with multiple strings: ");
                    String multipleStrings = scanner.nextLine();
                    System.out.println("Entered line with multiple strings: " + stringTask.acceptMultipleStrings(multipleStrings));
		    }catch (StringProcessingException ex) {
            throw new StringProcessingException("Error accepting multiple strings", ex);
        }
    }

    public static void concatenateStrings(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try{
                    System.out.print("Enter a line with multiple strings: ");
                    String line = scanner.nextLine();
		    System.out.println("Concatenated string: " + stringTask.concatenateStrings(line));
		    } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error concatenating strings", ex);
        }
    }

    public static void encloseInArray(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try {
            System.out.print("Enter a line with multiple strings: ");
            String arrayInput = scanner.nextLine();
            String delimiter = "[-,\\s]+";
            String[] words = stringTask.encloseInArray(arrayInput, delimiter);
            System.out.print("Output: {");
            for (int i = 0; i < words.length; i++) {
                System.out.print("\"" + words[i] + "\"");
                if (i < words.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error enclosing strings in array", ex);
        }
    }

    public static void mergeStrings(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try{
		    System.out.println("Enter number of Strings: ");
		    int numberOfStrings = scanner.nextInt();
                    System.out.print("Enter strings to merge: ");
                    String[] mergeInputs = new String[numberOfStrings];
                    for (int i = 0; i < numberOfStrings; i++) {
                        mergeInputs[i] = scanner.nextLine();
                    }
		    System.out.println("Enter character to merge: ");
		    char character = scanner.next().charAt(0);

                    System.out.println("Merged string: " + stringTask.mergeStrings(mergeInputs,character));
		    } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error merging strings", ex);
        }
    }

    public static void checkCaseSensitiveEquality(StringTask stringTask, Scanner scanner) throws StringProcessingException {
        try{
                    System.out.print("Enter String 1 for case-sensitive check: ");
                    String caseSensitiveStr1 = scanner.nextLine();
                    System.out.print("Enter String 2 for case-sensitive check: ");
                    String caseSensitiveStr2 = scanner.nextLine();
                    System.out.println(stringTask.checkCaseSensitiveEquality(caseSensitiveStr1, caseSensitiveStr2));
		    } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error checking case-sensitive equality", ex);
        }
    }

    public static void checkCaseInSensitiveEquality(StringTask stringTask, Scanner scanner) throws StringProcessingException {
       try{
                    System.out.print("Enter String 1: ");
                    String caseInsensitiveStr1 = scanner.nextLine();
                    System.out.print("Enter String 2: ");
                    String caseInsensitiveStr2 = scanner.nextLine();
                    System.out.println(stringTask.checkCaseInsensitiveEquality(caseInsensitiveStr1, caseInsensitiveStr2));
		    }catch (StringProcessingException ex) {
            throw new StringProcessingException("Error checking case-insensitive equality", ex);
        }
    }

    public static void trimSpaces(StringTask stringTask, Scanner scanner) throws StringProcessingException {
          try{
                    System.out.print("Enter a string with spaces: ");
                    String spaceString = scanner.nextLine();
                    System.out.println("Output: \"" + stringTask.trimSpaces(spaceString) + "\"");
		    } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error trimming spaces from string", ex);
        }
    }
}
