package calculator;

import calculator.core.Calculator;
import calculator.input.InputReader;
import calculator.output.MessagePrinter;
import calculator.parser.InputParser;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        MessagePrinter.printInputMessage();
        InputReader inputReader = new InputReader(readLine());
        ArrayList<Integer> parsedArrayList = InputParser.parse(inputReader.getInputString());
        int result = Calculator.calculateSum(parsedArrayList);
        MessagePrinter.printOutputMessage(result);
    }
}
