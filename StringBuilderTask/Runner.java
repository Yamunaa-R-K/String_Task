package run;

import java.io.*;
import java.util.*;
import task.StringBuilderTask;
import exception.StringBuilderProcessingException;

public class Runner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StringBuilderTask stringBuilderTask = new StringBuilderTask();

    public static void main(String[] args) {
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

    public static void displayMenu() {
        System.out.println("\nSelect an Option:");
        System.out.println("1. Get Length of String");
	System.out.println("2. Add n Strings and Get Length");
	System.out.println("3. Display Strings With Spaces");
	System.out.println("4. Delete any String and Get Length");
	System.out.println("5. Print with special characters inbetween Strings and Get Length");
	System.out.println("6. Get Reversed and Original Strings Length");
	System.out.println("7. Delete specific Characters inbetween Strings and Get Length");
	System.out.println("8. Replace specific Characters inbetween Strings and Get Length");
	System.out.println("9. Get the First index of inbetween delimiter");
	System.out.println("10. Get the Last index of inbetween delimiter");
        System.out.println("0. Exit");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
        }
        return choice;
    }

    private static void handleOperation(int choice) {
        try {
            switch (choice) {
                case 1:
                    getLength();
                    break;
		case 2:
		    insertStringsWithDelimter();
		    break;
		case 3:
		    insertStringBetween();
		    break;
		case 4:
		    deleteSpecificString();
		    break;
		case 5:
		    replaceSpacesBySpecialCharacters();
		    break;
		case 6:
		    reverseStrings();
		    break;
		case 7:
		    deleteSpecificCharacters();
		    break;
		case 8:
		    replaceSpecificCharacters();
		    break;
		case 9:
		    getFirstIndexOfDelimiter();
		    break;
		case 10:
		    getLastIndexOfDelimiter();
		    break;
		default:
                    System.out.println("Invalid choice.");
            }
        } catch (StringBuilderProcessingException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    private static StringBuilder getStringBuilder(String input) {
	return new StringBuilder();
    }

    public static void getLength() throws StringBuilderProcessingException {
        try {
            System.out.println("Enter the String: ");
            String inputString = scanner.nextLine();
            StringBuilder stringBuilder = getStringBuilder(inputString);
	    System.out.println("Length of the string: " + stringBuilderTask.getLength(stringBuilder));
        } catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying string length", ex);
        }
    }
    public static void insertStringsWithDelimter() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String: ");
            String initialString = scanner.nextLine();
	    StringBuilder stringBuilder = getStringBuilder(initialString);
	    System.out.println("Length of the string before adding other strings: " + stringBuilderTask.getLength(stringBuilder));
	    System.out.println("Enter Number of Strings to Add: ");
	    int numberOfStrings = scanner.nextInt();
            scanner.nextLine();
	    String[] stringsToAdd = new String[numberOfStrings];
	    System.out.println("Enter the Strings: ");
	    for(int i = 0; i < numberOfStrings; i++) {
		stringsToAdd[i] = scanner.nextLine();
	    }
	    System.out.println("Enter delimiter: ");
	    String delimiter = scanner.nextLine();
	    stringBuilder = stringBuilderTask.insertStringsWithDelimter(stringBuilder, stringsToAdd, delimiter);
	    System.out.println("Length of the final string: " + stringBuilderTask.getLength(stringBuilder));
            System.out.println("Updated String: " + stringBuilder.toString());	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
	}
    }
    public static void insertStringBetween() throws StringBuilderProcessingException {
        try {
            System.out.println("Enter the number of strings you want to concatenate: ");
            int numberOfStrings = scanner.nextInt();
            scanner.nextLine(); 
            StringBuilder concatenatedString = getStringBuilder("");
            for (int i = 0; i < numberOfStrings; i++) {
            	System.out.println("Enter String " + (i + 1) + ": ");
            	String inputString = scanner.nextLine();
            	concatenatedString.append(inputString);
            }
            System.out.println("Enter the Intermediate String: ");
            String intermediateString = scanner.nextLine();
	    System.out.println("Enter 2 String number in which you want to insert this String in between: ");
	    int stringNumber1 = scanner.nextInt();
	    scanner.nextLine();
	    int stringNumber2 = scanner.nextInt();
	    scanner.nextLine();
	    System.out.println("Length before inserting Intermediate String: " + stringBuilderTask.getLength(concatenatedString));
	    concatenatedString = stringBuilderTask.insertStringBetween(concatenatedString,intermediateString,stringNumber1,stringNumber2);
            System.out.println("Length of the final string after inserting: " + stringBuilderTask.getLength(concatenatedString));
            System.out.println("Updated String: " + concatenatedString);
        } catch (StringBuilderProcessingException ex) {
        throw new StringBuilderProcessingException("Error processing string concatenation or insertion", ex);
      }
    } 

    public static void deleteSpecificString() throws StringBuilderProcessingException {
        try {
            System.out.println("Enter the number of strings you want to concatenate: ");
            int numberOfStrings = scanner.nextInt();
            scanner.nextLine(); 
            StringBuilder concatenatedString = getStringBuilder("");

            for (int i = 0; i < numberOfStrings; i++) {
            	System.out.println("Enter String " + (i + 1) + ": ");
            	String inputString = scanner.nextLine();
            	concatenatedString.append(inputString);
            }
	    System.out.println("Enter Which Number Of String You Want to Delete: ");
	    int stringNumber = scanner.nextInt();
	    scanner.nextLine();
	    System.out.println("Length before deleting first string: " + stringBuilderTask.getLength(concatenatedString));
            concatenatedString = stringBuilderTask.deleteSpecificString(concatenatedString,stringNumber);
            System.out.println("Length of the final string after deletion: " + stringBuilderTask.getLength(concatenatedString));
            System.out.println("Updated String: " + concatenatedString.toString());
        } catch (StringBuilderProcessingException ex) {
        throw new StringBuilderProcessingException("Error processing string concatenation or deletion", ex);
       }
    }
    public static void replaceSpacesBySpecialCharacters() throws StringBuilderProcessingException {
    try {
        System.out.println("Enter the number of strings you want to concatenate: ");
        int numberOfStrings = scanner.nextInt();
        scanner.nextLine(); 
        StringBuilder concatenatedString = getStringBuilder("");

        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println("Enter String " + (i + 1) + ": ");
            String inputString = scanner.nextLine();
            concatenatedString.append(inputString);
        }

        System.out.println("Length before replacing spaces: " + stringBuilderTask.getLength(concatenatedString));
        System.out.println("Enter special character to replace spaces with: ");
        String specialCharacter = scanner.nextLine();
        concatenatedString = stringBuilderTask.replaceSpacesBySpecialCharacters(concatenatedString, specialCharacter);
        System.out.println("Length of the final string after replacement: " + stringBuilderTask.getLength(concatenatedString));
        System.out.println("Updated String: " + concatenatedString);
    } catch (StringBuilderProcessingException ex) {
        throw new StringBuilderProcessingException("Error processing string concatenation or replacement", ex);
    }
   }
   public static void reverseStrings() throws StringBuilderProcessingException {
    try {
        System.out.println("Enter the number of strings you want to concatenate: ");
        int numberOfStrings = scanner.nextInt();
        scanner.nextLine();
        StringBuilder concatenatedString = getStringBuilder("");

        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println("Enter String " + (i + 1) + ": ");
            String inputString = scanner.nextLine();
            concatenatedString.append(inputString);
        }

        System.out.println("Length before reversing: " + stringBuilderTask.getLength(concatenatedString));
        concatenatedString = stringBuilderTask.reverseStrings(concatenatedString);
        System.out.println("Length of the final string after reversing: " + stringBuilderTask.getLength(concatenatedString));
        System.out.println("Updated String: " + concatenatedString.toString());
    } catch (StringBuilderProcessingException ex) {
        throw new StringBuilderProcessingException("Error processing string concatenation or reversal", ex);
    }
   }


   public static void deleteSpecificCharacters() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the minimum number of Characters of a String: ");
	    int minNumOfChars = scanner.nextInt();
	    scanner.nextLine();
            System.out.println("Enter a string with at least " + minNumOfChars + " characters:");
            String inputString = scanner.nextLine();
	    if (inputString.length() < minNumOfChars) {
                throw new StringBuilderProcessingException(
                        "The input string must have" + minNumOfChars + " characters.");
            }
	    StringBuilder stringBuilder = getStringBuilder(inputString);
	    System.out.println("Enter the starting index for deletion:");
            int startIndex = scanner.nextInt();
            System.out.println("Enter the ending index for deletion:");
            int endIndex = scanner.nextInt();
	    System.out.println("Length before deleting specified characters: "+stringBuilderTask.getLength(stringBuilder));
	    stringBuilder = stringBuilderTask.deleteSpecificCharacters(stringBuilder,startIndex,endIndex);
	    System.out.println("Length of the final string after deleting specified characters: " + stringBuilderTask.getLength(stringBuilder));
            System.out.println("Updated String: " + stringBuilder.toString());	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void replaceSpecificCharacters() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the minimum number of Characters of a String: ");
	    int minNumOfChars = scanner.nextInt();
	    scanner.nextLine();
            System.out.println("Enter a string with at least " + minNumOfChars + " characters:");
            String inputString = scanner.nextLine();
	    if (inputString.length() < minNumOfChars) {
                throw new StringBuilderProcessingException(
                        "The input string must have" + minNumOfChars + " characters.");
            }
	    StringBuilder stringBuilder = getStringBuilder(inputString);
	    System.out.println("Enter the starting index for replacing:");
            int startIndex = scanner.nextInt();
            System.out.println("Enter the ending index for replacing:");
            int endIndex = scanner.nextInt();
	    System.out.println("Enter a string to replace: ");
	    String stringToReplace = scanner.nextLine();
	    System.out.println("Length before replacing specified characters: "+stringBuilderTask.getLength(stringBuilder));
	    stringBuilder = stringBuilderTask.replaceSpecificCharacters(stringBuilder,startIndex,endIndex,stringToReplace);
	    System.out.println("Length of the final string after replacing specified characters: " + stringBuilderTask.getLength(stringBuilder));
            System.out.println("Updated String: " + stringBuilder.toString());	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void getFirstIndexOfDelimiter() throws StringBuilderProcessingException {
    	try {
            System.out.println("Enter the number of strings you want to concatenate: ");
            int numberOfStrings = scanner.nextInt();
            scanner.nextLine(); 
            StringBuilder concatenatedString = getStringBuilder("");
            System.out.println("Enter delimiter: ");
            String delimiter = scanner.nextLine();

            for (int i = 0; i < numberOfStrings; i++) {
            	System.out.println("Enter String " + (i + 1) + ": ");
            	String inputString = scanner.nextLine();
            	concatenatedString.append(inputString).append(delimiter);
            }
	    concatenatedString.delete(concatenatedString.length() - delimiter.length(), concatenatedString.length());
            System.out.println("Length before getting first index: " + stringBuilderTask.getLength(concatenatedString));
            System.out.println("Enter the delimiter to search for: ");
            String delimiterToSearch = scanner.nextLine();
            int firstIndexOfDelimiter = stringBuilderTask.getFirstIndexOfDelimiter(concatenatedString, delimiterToSearch);
            System.out.println("Index of first delimiter: " + firstIndexOfDelimiter);
       } catch (StringBuilderProcessingException ex) {
        	throw new StringBuilderProcessingException("Error processing string concatenation or delimiter search", ex);
       }
   }
   public static void getLastIndexOfDelimiter() throws StringBuilderProcessingException {
       try {
           System.out.println("Enter the number of strings you want to concatenate: ");
           int numberOfStrings = scanner.nextInt();
           scanner.nextLine();
           StringBuilder concatenatedString = getStringBuilder("");
           System.out.println("Enter delimiter: ");
           String delimiter = scanner.nextLine();
           for (int i = 0; i < numberOfStrings; i++) {
            	System.out.println("Enter String " + (i + 1) + ": ");
            	String inputString = scanner.nextLine();
            	concatenatedString.append(inputString).append(delimiter);
           }
	   concatenatedString.delete(concatenatedString.length() - delimiter.length(), concatenatedString.length());
	   System.out.println("Length before getting last index: " + stringBuilderTask.getLength(concatenatedString));
           System.out.println("Enter the delimiter to search for: ");
           String delimiterToSearch = scanner.nextLine();
           int lastIndexOfDelimiter = stringBuilderTask.getLastIndexOfDelimiter(concatenatedString, delimiterToSearch);
           System.out.println("Index of last delimiter: " + lastIndexOfDelimiter);
   	} catch (StringBuilderProcessingException ex) {
       		throw new StringBuilderProcessingException("Error processing string concatenation or delimiter search", ex);
    	}
   }
 

    




}
