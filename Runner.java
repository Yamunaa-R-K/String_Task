package run;
import task.StringTask;
import util.StringTaskUtil;
import java.util.Scanner;
import exception.StringProcessingException;
public class Runner {

    public static void main(String[] args) {
        StringTask stringTask = new StringTask();
        Scanner scanner = new Scanner(System.in);
<<<<<<< Updated upstream
   	String inputString = args[0];
        try{
	 System.out.println("Length of the string: " + stringTask.getStringLength(inputString));
	   }
	catch(StringProcessingException ex)
	{
	  System.out.println(ex.getMessage());
	}
        while (true) {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Convert to Character Array");
            System.out.println("2. Get Penultimate Character of a String");
            System.out.println("3. Count Occurrences of a Character");
            System.out.println("4. Find Greatest Position of a Character");
            System.out.println("5. Get Last n Characters");
            System.out.println("6. Get First n Characters");
            System.out.println("7. Replace First n Characters");
            System.out.println("8. Check if String Starts with particular string");
            System.out.println("9. Check if String Ends with particular string");
            System.out.println("10. Convert to Uppercase");
            System.out.println("11. Convert to Lowercase");
            System.out.println("12. Reverse String");
            System.out.println("13. Accept and Display Multiple Strings");
            System.out.println("14. Concatenate Strings");
            System.out.println("15. Enclose String in Array");
            System.out.println("16. Merge n Strings");
            System.out.println("17. Check Case-Sensitive Equality");
            System.out.println("18. Check Case-Insensitive Equality");
            System.out.println("19. Trim Spaces");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
		    try
		    {
		    	System.out.println("Enter the string: ");
		    	String inputStringForCharArray = scanner.nextLine();
                    	char[] charArray = stringTask.convertToCharArray(inputStringForCharArray);
                    	System.out.println("Character Array: " + Arrays.toString(charArray));
		    }
		     catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }

                    break;
                case 2:
		    try
		    {
		   	System.out.println("Enter the string: ");
		    	String inputStringForPenultimate = scanner.nextLine();
			System.out.println("Enter the position from End: ");
			int positionFromEnd = scanner.nextInt();
			char character = stringTask.getPenultimateCharacter(inputStringForPenultimate,positionFromEnd);
                    	System.out.println("Penultimate Character: " +character);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 3:
		    try
		    {
		    System.out.println("Enter the string: ");
		    String characterCountInput = scanner.nextLine();
                    System.out.print("Enter the character to count: ");
                    char targetChar = scanner.next().charAt(0);
                    int occurrences = stringTask.countOccurrences(characterCountInput, targetChar);
                    System.out.println("The character '" + targetChar + "' occurs " + occurrences + " times in the string.");
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 4:
		    try{
		    System.out.println("Enter the string: ");
		    String greatestPositionInput = scanner.nextLine();
		    System.out.print("Enter the character to find its greatest position: ");
                    char target = scanner.next().charAt(0);
                    int greatestPosition = stringTask.findGreatestPosition(greatestPositionInput , target);
                    System.out.println("Greatest position of '" + target + "': " + greatestPosition);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 5:
		    try{
		    System.out.println("Enter the string: ");
		    String lastCharactersInput = scanner.nextLine();
		    System.out.println("Enter number of characters: ");
		    int numberOfChars = scanner.nextInt();
		    String lastChars = stringTask.getLastCharacters(lastCharactersInput, numberOfChars);
                    System.out.println("Last" + numberOfChars + "characters: " + lastChars);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 6:
		    try{
		    System.out.println("Enter the string: ");
		    String firstCharactersInput = scanner.nextLine();
		    System.out.println("Enter number of characters: ");
		    int numberOfChars = scanner.nextInt();
		    String firstChars = stringTask.getFirstCharacters(firstCharactersInput , numberOfChars);
                    System.out.println("First" + numberOfChars + "characters: " + firstChars );
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 7:
		    try{
		    System.out.println("Enter the string: ");
		    String replaceCharactersInput = scanner.nextLine();
		    System.out.println("Enter number of Characters to replace: ");
		    int numberOfChars = scanner.nextInt();
		    System.out.println("Enter the String to Replace: ");
		    String stringToReplace = scanner.nextLine();
		    String replacedString = stringTask.replaceCharacters(replaceCharactersInput,numberOfChars,stringToReplace);
                    System.out.println("String after replacement: " + replacedString);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 8:
		    try{
		    System.out.println("Enter the string: ");
		    String startsWithInput = scanner.nextLine();
		    System.out.println("Enter the string: ");
		    String stringStartsWith = scanner.nextLine();
                    boolean startsWithString = stringTask.startsWithSubstring(startsWithInput,stringStartsWith);
                    System.out.println("Starts with " + startsWithString);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 9:
	            try{
		    System.out.println("Enter the string: ");
		    String endsWithInput = scanner.nextLine();
		    System.out.println("Enter the string: ");
		    String stringEndsWith = scanner.nextLine();
                    boolean endsWithString = stringTask.endsWithSubstring(endsWithInput,stringEndsWith);
                    System.out.println("Ends with " + endsWithString);
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
		    break;
                case 10:
		    try{
                    System.out.print("Enter a lowercase string: ");
                    String lowerCaseString = scanner.nextLine();
                    System.out.println("Uppercase string: " + stringTask.convertToUpperCase(lowerCaseString));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 11:
		    try{
                    System.out.print("Enter an uppercase string: ");
                    String upperCaseString = scanner.nextLine();
                    System.out.println("Lowercase string: " + stringTask.convertToLowerCase(upperCaseString));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 12:
                    try{
                    System.out.print("Enter a string to reverse: ");
                    String originalString = scanner.nextLine();
                    System.out.println("Reversed string: " + stringTask.reverseString(originalString));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 13:
		    try{
                    System.out.print("Enter a line with multiple strings: ");
                    String multipleStrings = scanner.nextLine();
                    System.out.println("Entered line with multiple strings: " + stringTask.acceptMultipleStrings(multipleStrings));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 14:
		    try{
                    System.out.print("Enter a line with multiple strings: ");
                    String line = scanner.nextLine();
		    System.out.println("Concatenated string: " + stringTask.concatenateStrings(line));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 15:
		    try{
                    System.out.print("Enter a line with multiple strings: ");
                    String arrayInput = scanner.nextLine();
		    String delimiter = "[-,\\s]+";

                    String[] words = stringTask.encloseInArray(arrayInput,delimiter);
                    System.out.print("Output: {");
                    for (int i = 0; i < words.length; i++) {
                        System.out.print("\"" + words[i] + "\"");
                        if (i < words.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("}");
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 16:
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
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 17:
		    try{
                    System.out.print("Enter String 1 for case-sensitive check: ");
                    String caseSensitiveStr1 = scanner.nextLine();
                    System.out.print("Enter String 2 for case-sensitive check: ");
                    String caseSensitiveStr2 = scanner.nextLine();
                    System.out.println(stringTask.checkCaseSensitiveEquality(caseSensitiveStr1, caseSensitiveStr2));
		    }
 		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }
                    break;
                case 18:
	            try{
                    System.out.print("Enter String 1: ");
                    String caseInsensitiveStr1 = scanner.nextLine();
                    System.out.print("Enter String 2: ");
                    String caseInsensitiveStr2 = scanner.nextLine();
                    System.out.println(stringTask.checkCaseInsensitiveEquality(caseInsensitiveStr1, caseInsensitiveStr2));
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }                    
		    break;
                case 19:
		    try{
                    System.out.print("Enter a string with spaces: ");
                    String spaceString = scanner.nextLine();
                    System.out.println("Output: \"" + stringTask.trimSpaces(spaceString) + "\"");
		    }
		    catch(StringProcessingException ex)
		    {
			System.out.println(ex.getMessage());
		    }      
		    break;
                case 0:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
=======
        String inputString = args[0];
        
        try {
           StringTaskUtil.displayStringLength(stringTask, inputString);
        } catch (StringProcessingException e) {
           System.out.println("An error occurred while displaying string length: " + e.getMessage());
        e.printStackTrace();
    }
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);
            
            if (choice == 0) {
                running = false;
                System.out.println("Exiting...");
            } else {
                handleOperation(choice, stringTask, scanner);
>>>>>>> Stashed changes
            }
        }
        
        scanner.close();
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

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    private static void handleOperation(int choice, StringTask stringTask, Scanner scanner) {
    scanner.nextLine();  
    try {
        switch (choice) {
            case 1:
                StringTaskUtil.convertToCharArray(stringTask, scanner);
                break;
            case 2:
                StringTaskUtil.getPenultimateCharacter(stringTask, scanner);
                break;
            case 3:
                StringTaskUtil.countOccurrences(stringTask, scanner);
                break;
            case 4:
                StringTaskUtil.findGreatestPosition(stringTask, scanner);
                break;
            case 5:
                StringTaskUtil.getLastCharacters(stringTask, scanner);
                break;
            case 6:
                StringTaskUtil.getFirstCharacters(stringTask, scanner);
                break;
            case 7:
                StringTaskUtil.replaceFirstCharacters(stringTask, scanner);
                break;
            case 8:
                StringTaskUtil.startsWithSubstring(stringTask, scanner);
                break;
            case 9:
                StringTaskUtil.endsWithSubstring(stringTask, scanner);
                break;
            case 10:
                StringTaskUtil.convertToUpperCase(stringTask, scanner);
                break;
            case 11:
                StringTaskUtil.convertToLowerCase(stringTask, scanner);
                break;
            case 12:
                StringTaskUtil.reverseString(stringTask, scanner);
                break;
            case 13:
                StringTaskUtil.acceptMultipleStrings(stringTask, scanner);
                break;
            case 14:
                StringTaskUtil.concatenateStrings(stringTask, scanner);
                break;
            case 15:
                StringTaskUtil.encloseInArray(stringTask, scanner);
                break;
            case 16:
                StringTaskUtil.mergeStrings(stringTask, scanner);
                break;
            case 17:
                StringTaskUtil.checkCaseSensitiveEquality(stringTask, scanner);
                break;
            case 18:
                StringTaskUtil.checkCaseInSensitiveEquality(stringTask, scanner);
                break;
            case 19:
                StringTaskUtil.trimSpaces(stringTask, scanner);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    } catch (StringProcessingException ex) {
        ex.printStackTrace();
    }
}




    
}
