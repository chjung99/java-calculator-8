package calculator.core;

import java.util.List;

public class Calculator {
    public static int calculateSum(List<Integer> arrayList){
        return arrayList.stream().mapToInt(Integer::intValue).sum();
    }
}
