package calculator.input;

public class InputReader {
    private final String inputString;
    private static final int MAX_INPUT_LENGTH = 1_000;

    public InputReader(String inputString) {
        if (inputString.length()>=MAX_INPUT_LENGTH){
            throw new IllegalArgumentException("입력 길이가 최대치를 초과했습니다.");
        }
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }
}
