package algorithm;


import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
//        for (int i = 0; i < 16; i++) {
//            System.out.println(fib(i));
//        }
        fibonacciStream(5);
    }

    // Возвращает число фибоначче, кот стоит на заданном порядковом номере в последовательности
    public static int fib(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fib(number - 1) + fib(number - 2);
        }
    }

    // Напечатает все цифры фибоначче кот есть в пределах заданного числа: для 7 > 1 1 2 3 5
    public static void fibonacci(int bound) {
        int prev = 1;
        int cur = 1;

        while (cur < bound) {
            System.out.println(cur);
            int newVal = prev + cur;
            prev = cur;
            cur = newVal;
        }
    }



    // Напечатает все цифры фибоначче кот есть в пределах заданного числа
    public static void fibonacciRecur(int bound, int prev, int cur) {
        if (cur < bound) {
            System.out.println(cur);
            fibonacciRecur(bound, cur, cur + prev);
        }
    }

    // Напечатает все цифры фибоначче кот есть в пределах заданного числа: для 7 > 1 1 2 3 5
    public static void fibonacciStream(int bound) { // [current], [prev] + [current]
        // значение, ф-я кот применяется к нему > значение перезаписывается результатом ф-ии и к новому снова применяется ф-я
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0]+ arr[1]})
                .limit(bound)
                .map(arr -> arr[0])
                .forEach(System.out::println);

    }
}
