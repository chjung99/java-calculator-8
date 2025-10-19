package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public static List<Integer> parse(String input){
        String delimiter = DEFAULT_DELIMITERS;
        String filteredString = input;

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()){
            delimiter += "|" + Pattern.quote(matcher.group(1));
            filteredString = matcher.group(2);
        }
        return extractNumbers(filteredString, delimiter);
    }

    public static List<Integer> extractNumbers(String input, String delimiterRegex) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.isEmpty()){
            return result;
        }

        String[] tokens = input.split(delimiterRegex);
        for (String token: tokens){
            int number = parsePositiveInteger(token);
            result.add(number);
        }
        return result;
    }

    public static int parsePositiveInteger(String token){
        try {
            int value = Integer.parseInt(token);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
            }
            return value;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + token, e);
        }
    }

}
