package patterns.builder;

public class Main {
    public static void main(String[] args) {
        Example1 example = Example1.getExample1Builder()
                .setVal1(1)
                .setVal2(2)
                .setVal3(3)
                .build();
        System.out.println(example);
    }
}
