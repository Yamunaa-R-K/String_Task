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
	System.out.println("4. Delete first String and Get Length");
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
                    displayStringLength();
                    break;
		case 2:
		    displayStringsAndLength();
		    break;
		case 3:
		    displayStringsWithSpaces();
		    break;
		case 4:
		    deleteFirstString();
		    break;
		case 5:
		    replaceSpacesBySpecialCharacters();
		    break;
		case 6:
		    reverseStringsAndGetLength();
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

    public static void displayStringLength() throws StringBuilderProcessingException {
        try {
            System.out.println("Enter the String: ");
            String inputString = scanner.nextLine();
	    System.out.println("Length of the string: " + stringBuilderTask.getLength(inputString));
        } catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying string length", ex);
        }
    }
    public static void displayStringsAndLength() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String: ");
            String initialString = scanner.nextLine();
	    System.out.println("Length of the string: " + stringBuilderTask.getLength(initialString));
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
	    String finalString = stringBuilderTask.getUpdatedString(initialString, stringsToAdd, delimiter);

            System.out.println("Length of the final string: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void displayStringsWithSpaces() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStrings(firstString,secondString);
	    System.out.println("Length before inserting Intermediate String: "+stringBuilderTask.getLength(concatenatedString));
	    System.out.println("Enter the Intermediate String: ");
            String intermediateString = scanner.nextLine();
	    String finalString = stringBuilderTask.getStringsWithSpaces(firstString, concatenatedString, intermediateString);
            System.out.println("Length of the final string: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void deleteFirstString() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStrings(firstString,secondString);
	    System.out.println("Length before deleting First String: "+stringBuilderTask.getLength(concatenatedString));
	    String finalString = stringBuilderTask.getRemainingString(firstString, concatenatedString);

            System.out.println("Length of the final string: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void replaceSpacesBySpecialCharacters() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    System.out.println("Enter the String 3: ");
            String thirdString = scanner.nextLine();
	    System.out.println("Enter delimiter: ");
            String delimiter = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStrings(firstString,secondString);
	    String concatenatedWithAnotherString = stringBuilderTask.concatenateStrings(concatenatedString,thirdString);
	    System.out.println("Length before replacing with Special Characters: "+stringBuilderTask.getLength(concatenatedWithAnotherString));
	    String finalString = stringBuilderTask.replaceSpacesBySpecialCharacters(concatenatedWithAnotherString,delimiter);
	    System.out.println("Length of the final string: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void reverseStringsAndGetLength() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    System.out.println("Enter the String 3: ");
            String thirdString = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStrings(firstString,secondString);
	    String concatenatedWithAnotherString = stringBuilderTask.concatenateStrings(concatenatedString,thirdString);
	    System.out.println("Length before reversing: "+stringBuilderTask.getLength(concatenatedWithAnotherString));
	    String finalString = stringBuilderTask.reverseStrings(concatenatedWithAnotherString);
	    System.out.println("Length of the final string after reversing: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
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
	    System.out.println("Enter the starting index for deletion:");
            int startIndex = scanner.nextInt();
            System.out.println("Enter the ending index for deletion:");
            int endIndex = scanner.nextInt();
	    System.out.println("Length before deleting specified characters: "+stringBuilderTask.getLength(inputString));
	    String finalString = stringBuilderTask.deleteSpecificCharacters(inputString,startIndex,endIndex);
	    System.out.println("Length of the final string after deleting specified characters: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
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
	    System.out.println("Enter the starting index for replacing:");
            int startIndex = scanner.nextInt();
            System.out.println("Enter the ending index for replacing:");
            int endIndex = scanner.nextInt();
	    System.out.println("Enter a string to replace: ");
	    String stringToReplace = scanner.nextLine();
	    System.out.println("Length before replacing specified characters: "+stringBuilderTask.getLength(inputString));
	    String finalString = stringBuilderTask.replaceSpecificCharacters(inputString,startIndex,endIndex,stringToReplace);
	    System.out.println("Length of the final string after replacing specified characters: " + stringBuilderTask.getLength(finalString));
            System.out.println("Updated String: " + finalString);	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
    public static void getFirstIndexOfDelimiter() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    System.out.println("Enter the String 3: ");
            String thirdString = scanner.nextLine();
	    System.out.println("Enter the delimiter: ");
	    String delimiter = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStringsWithDelimiter(firstString,secondString,delimiter);
	    String concatenatedWithAnotherString = stringBuilderTask.concatenateStringsWithDelimiter(concatenatedString,thirdString,delimiter);
	    System.out.println("Length before getting First index: "+stringBuilderTask.getLength(concatenatedWithAnotherString));
	    int firstIndexOfDelimiter = stringBuilderTask.getFirstIndexOfDelimiter(concatenatedWithAnotherString,delimiter);
	    System.out.println("Index of First Delimiter: " + firstIndexOfDelimiter);    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }
     public static void getLastIndexOfDelimiter() throws StringBuilderProcessingException {
	try {
	    System.out.println("Enter the String 1: ");
            String firstString = scanner.nextLine();
	    System.out.println("Enter the String 2: ");
            String secondString = scanner.nextLine();
	    System.out.println("Enter the String 3: ");
            String thirdString = scanner.nextLine();
	    System.out.println("Enter the delimiter: ");
	    String delimiter = scanner.nextLine();
	    String concatenatedString = stringBuilderTask.concatenateStringsWithDelimiter(firstString,secondString,delimiter);
	    String concatenatedWithAnotherString = stringBuilderTask.concatenateStringsWithDelimiter(concatenatedString,thirdString,delimiter);
	    System.out.println("Length before getting Last index: "+stringBuilderTask.getLength(concatenatedWithAnotherString));
	    int lastIndexOfDelimiter = stringBuilderTask.getLastIndexOfDelimiter(concatenatedWithAnotherString,delimiter);
	    System.out.println("Index of Last Delimiter: " + lastIndexOfDelimiter); 	    
 	} catch (StringBuilderProcessingException ex) {
            throw new StringBuilderProcessingException("Error displaying strings length", ex);
        }
    }


    




}
