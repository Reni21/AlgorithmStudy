package util;

public class MyTree<T> {
    public MyTree(T x) {
        value = x;
    }

    public T value;
    public MyTree<T> left;
    public MyTree<T> right;

    @Override
    public String toString() {
        return "MyTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}