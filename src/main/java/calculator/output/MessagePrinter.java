package calculator.output;

public class MessagePrinter {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";
    public static void printInputMessage(){
        System.out.println(INPUT_MESSAGE);
    }
    public static void printOutputMessage(int outputValue){
        System.out.println(OUTPUT_MESSAGE+outputValue);
    }
}
