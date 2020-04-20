package util;

public class MyList<T> {
    public T value;
    public MyList<T> next;

    public MyList(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "value=" + value +
                ", next=" + (next == null ? "null" : next.toString()) +
                '}';
    }
}
