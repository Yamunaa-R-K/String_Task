package run;
import task.StringTask;
import util.StringTaskUtil;
import java.util.Scanner;
import exception.StringProcessingException;
public class Runner {

    public static void main(String[] args) {
        StringTask stringTask = new StringTask();
        Scanner scanner = new Scanner(System.in);
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
