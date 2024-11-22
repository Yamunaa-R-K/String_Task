package exception;
public class StringProcessingException extends Exception
{
 public StringProcessingException(String s)
 {
   super(s);
 }
 public StringProcessingException(String message, Throwable cause) 
 {
        super(message, cause);
 }
}
