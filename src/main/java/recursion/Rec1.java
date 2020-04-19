package recursion;

public class Rec1 {
    public static void main(String[] args) {
    }

    static void printStringNTime(String s, int n) {
        if (n == 0) {
            return;
        }
        System.out.println(s);
        printStringNTime(s, n - 1);
    }

}
