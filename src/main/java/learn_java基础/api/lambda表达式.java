package learn_java基础.api;

import java.util.function.IntBinaryOperator;

public class lambda表达式 {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;

            } else {
                return 0;
            }
        };

    }
}
