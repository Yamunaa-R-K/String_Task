package run;

import task.StringTask;
import util.StringTaskUtil;
import exception.StringProcessingException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class Runner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StringTask stringTask = new StringTask();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide an command line arguement.");
            return;
        }

        String inputString = args[0];

        try {
            displayStringLength(inputString);
        } catch (StringProcessingException e) {
            System.out.println("An error occurred while displaying string length: " + e.getMessage());
            e.printStackTrace();
        }

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            if (choice == 0) {
                running = false;
                System.out.println("Exiting");
            } else {
                handleOperation(choice);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Convert to character array");
        System.out.println("2. Get penultimate character");
        System.out.println("3. Count occurrences of a character");
        System.out.println("4. Find greatest position of a character");
        System.out.println("5. Get last characters");
        System.out.println("6. Get first characters");
        System.out.println("7. Replace first characters");
        System.out.println("8. Check if starts with substring");
        System.out.println("9. Check if ends with substring");
        System.out.println("10. Convert to uppercase");
        System.out.println("11. Convert to lowercase");
        System.out.println("12. Reverse the string");
        System.out.println("13. Accept multiple strings");
        System.out.println("14. Concatenate strings");
        System.out.println("15. Enclose in array");
        System.out.println("16. Merge strings");
        System.out.println("17. Check Case-Sensitive Equality");
        System.out.println("18. Check Case-Insensitive Equality");
        System.out.println("19. Trim Spaces");
        System.out.println("0. Exit");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input.");
            scanner.nextLine(); 
        }
        return choice;
    }

    private static void handleOperation(int choice) {
        try {
            switch (choice) {
                case 1 : convertToCharArray(); break;
                case 2 : getPenultimateCharacter(); break;
                case 3 : countOccurrences(); break;
                case 4 : findGreatestPosition(); break;
                case 5 : getLastCharacters(); break;
                case 6 : getFirstCharacters(); break;
                case 7 : replaceFirstCharacters(); break;
                case 8 : startsWithSubstring(); break; 
                case 9 : endsWithSubstring(); break;
                case 10 : convertToUpperCase(); break;
                case 11 : convertToLowerCase(); break;
                case 12 : reverseString(); break;
                case 13 : acceptMultipleStrings(); break;
                case 14 : concatenateStrings(); break;
                case 15 : encloseInArray(); break;
                case 16 : mergeStrings(); break;
                case 17 : checkCaseSensitiveEquality(); break;
                case 18 : checkCaseInSensitiveEquality(); break;
                case 19 : trimSpaces(); break;
                default : System.out.println("Invalid choice");
            }
        } catch (StringProcessingException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
     public static void displayStringLength(String inputString) throws StringProcessingException {
        try {
            System.out.println("Length of the string: " + stringTask.getStringLength(inputString));
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error displaying string length", ex);
        }
    }

    public static void convertToCharArray() throws StringProcessingException {
        try {
            System.out.println("Enter the string: ");
            String inputStringForCharArray = scanner.nextLine();
            char[] charArray = stringTask.convertToCharArray(inputStringForCharArray);
            System.out.println("Character Array: " + Arrays.toString(charArray));
        } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to character array", ex);
        }
    }

    public static void getPenultimateCharacter() throws StringProcessingException {
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

    public static void countOccurrences() throws StringProcessingException {
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

    public static void findGreatestPosition() throws StringProcessingException {
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

    public static void getLastCharacters() throws StringProcessingException {
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

    public static void getFirstCharacters() throws StringProcessingException {
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

    public static void replaceFirstCharacters() throws StringProcessingException {
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

    public static void startsWithSubstring() throws StringProcessingException {
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

    public static void endsWithSubstring() throws StringProcessingException {
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

    public static void convertToUpperCase() throws StringProcessingException {
         try{
             System.out.print("Enter a lowercase string: ");
             String lowerCaseString = scanner.nextLine();
             System.out.println("Uppercase string: " + stringTask.convertToUpperCase(lowerCaseString));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to uppercase", ex);
        }
    }

    public static void convertToLowerCase() throws StringProcessingException {
          try{
              System.out.print("Enter an uppercase string: ");
              String upperCaseString = scanner.nextLine();
              System.out.println("Lowercase string: " + stringTask.convertToLowerCase(upperCaseString));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error converting string to lowercase", ex);
        }
    }

    public static void reverseString() throws StringProcessingException {
         try{
             System.out.print("Enter a string to reverse: ");
             String originalString = scanner.nextLine();
             System.out.println("Reversed string: " + stringTask.reverseString(originalString));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error reversing string", ex);
        }
    }

    public static void acceptMultipleStrings() throws StringProcessingException {
        try{
            System.out.print("Enter a line with multiple strings: ");
            String multipleStrings = scanner.nextLine();
            System.out.println("Entered line with multiple strings: " + stringTask.acceptMultipleStrings(multipleStrings));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error accepting multiple strings", ex);
        }
    }

    public static void concatenateStrings() throws StringProcessingException {
        try{
            System.out.print("Enter a line with multiple strings: ");
            String line = scanner.nextLine();
	    System.out.println("Concatenated string: " + stringTask.concatenateStrings(line));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error concatenating strings", ex);
        }
    }

     public static void encloseInArray() throws StringProcessingException {
        try {
            System.out.print("Enter a line with multiple strings: ");
            String arrayInput = scanner.nextLine();
            System.out.print("Enter delimiter: ");
            String delimiter = scanner.next();

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
    public static void mergeStrings() throws StringProcessingException {
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

    public static void checkCaseSensitiveEquality() throws StringProcessingException {
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

    public static void checkCaseInSensitiveEquality() throws StringProcessingException {
       try{
           System.out.print("Enter String 1: ");
           String caseInsensitiveStr1 = scanner.nextLine();
           System.out.print("Enter String 2: ");
           String caseInsensitiveStr2 = scanner.nextLine();
           System.out.println(stringTask.checkCaseInsensitiveEquality(caseInsensitiveStr1, caseInsensitiveStr2));
	} catch (StringProcessingException ex) {
            throw new StringProcessingException("Error checking case-insensitive equality", ex);
        }
    }

    public static void trimSpaces() throws StringProcessingException {
          try{
              System.out.print("Enter a string with spaces: ");
              String spaceString = scanner.nextLine();
              System.out.println("Output: \"" + stringTask.trimSpaces(spaceString) + "\"");
	  } catch (StringProcessingException ex) {
            throw new StringProcessingException("Error trimming spaces from string", ex);
        }
    }

}




    

