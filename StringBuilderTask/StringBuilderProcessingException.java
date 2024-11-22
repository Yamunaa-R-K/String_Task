package exception;

public class StringBuilderProcessingException extends Exception {
public StringBuilderProcessingException(String s)
 {
   super(s);
 }
 public StringBuilderProcessingException(String message, Throwable cause) 
 {
        super(message, cause);
 }
}