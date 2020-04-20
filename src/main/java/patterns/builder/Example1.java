package patterns.builder;


public class Example1 {
    private int val1;
    private int val2;
    private int val3;
    private int val4;

    private Example1() {
    }

    public static Example1Builder getExample1Builder() {
        return new Example1Builder();
    }

    public static class Example1Builder {
        private Example1 example = new Example1();

        private Example1Builder() {
        }

        public Example1Builder reset(){
            example = new Example1();
            return this;
        }

        public Example1Builder setVal1(int val) {
            example.val1 = val;
            return this;
        }

        public Example1Builder setVal2(int val) {
            example.val2 = val;
            return this;
        }

        public Example1Builder setVal3(int val) {
            example.val3 = val;
            return this;
        }

        public Example1Builder withVal4(int val) {
            example.val4 = val;
            return this;
        }

        public Example1 build() {
            return example;
        }
    }

    @Override
    public String toString() {
        return "Example1{" +
                "val1=" + val1 +
                ", val2=" + val2 +
                ", val3=" + val3 +
                ", val4=" + val4 +
                '}';
    }
}
