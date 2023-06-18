package helpers;

import io.qameta.allure.Step;

public class Calculation {
    @Step("Вычисление {number}-го числа Фибоначчи")
    public static int calculateFibonacciNumber(int number) {
        int a = 0;
        int b = 1;
        for (int i = 2; i < number; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}
