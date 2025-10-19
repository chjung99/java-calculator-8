package calculator.parser;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputParser {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public static ArrayList<Integer> parse(String inputString){
        String customDelimiter = null;
        String trimedInputString = inputString;
        String[] tokens;
        if (inputString.startsWith(CUSTOM_DELIMITER_START)&&
                inputString.startsWith(CUSTOM_DELIMITER_END, CUSTOM_DELIMITER_START.length()+1)){
            customDelimiter = inputString.substring(CUSTOM_DELIMITER_START.length(), CUSTOM_DELIMITER_START.length()+1);
            trimedInputString = inputString.substring(inputString.indexOf(CUSTOM_DELIMITER_END)+CUSTOM_DELIMITER_END.length());
        }
        if (customDelimiter == null){
            tokens = trimedInputString.split(COMMA_DELIMITER + "|" + COLON_DELIMITER);
        } else {
            tokens = trimedInputString.split(COMMA_DELIMITER+"|"+COLON_DELIMITER+"|"+ Pattern.quote(customDelimiter));
        }
        ArrayList<Integer> parsedIntArray = new ArrayList<>();

        for (String s : tokens){
            try {
                long number = Long.parseLong(s);
                if (number < 0 || number > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException();
                }
                parsedIntArray.add((int) number);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        return parsedIntArray;
    }
}
