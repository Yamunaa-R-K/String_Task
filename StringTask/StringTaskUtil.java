package util;


import exception.StringProcessingException;
import java.util.*;

public class StringTaskUtil {
      public static void checkNull(String string) throws StringProcessingException {
        if (string == null) {
            throw new StringProcessingException("Null value encountered");
	    }
       }
   }
