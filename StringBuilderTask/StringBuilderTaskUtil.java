package util;


import exception.StringBuilderProcessingException;
import java.util.*;

public class StringBuilderTaskUtil {
      public static void checkNull(StringBuilder stringBuilder) throws StringBuilderProcessingException {
        if (stringBuilder == null) {
            throw new StringBuilderProcessingException("Null value encountered");
	    }
       }
   }
