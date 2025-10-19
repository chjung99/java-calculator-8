package calculator.core;

import java.util.ArrayList;

public class Calculator {
    public static int calculateSum(ArrayList<Integer> arrayList){
        return arrayList.stream().mapToInt(Integer::intValue).sum();
    }
}
