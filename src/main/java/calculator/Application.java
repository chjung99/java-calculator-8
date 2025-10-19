package calculator;

import calculator.core.Calculator;
import calculator.input.InputReader;
import calculator.output.MessagePrinter;
import calculator.parser.InputParser;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }
    public void run() {
        printInputMessage();
        String input = readUserInput();
        ArrayList<Integer> numbers = parseInput(input);
        int result = calculate(numbers);
        printResult(result);
    }

    private void printInputMessage(){
        MessagePrinter.printInputMessage();
    }

    private String readUserInput(){
        String input = readLine();
        InputReader inputReader = new InputReader(input);
        return inputReader.getInputString();
    }

    private ArrayList<Integer> parseInput(String input){
        return InputParser.parse(input);
    }

    private int calculate(ArrayList<Integer> numbers) {
        return Calculator.calculateSum(numbers);
    }

    private void printResult(int result){
        MessagePrinter.printOutputMessage(result);
    }
}
