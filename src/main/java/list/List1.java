package list;

import util.MyList;

public class List1 {
    public static void main(String[] args) {
        MyList<Integer> l1 = new MyList<Integer>(1);
        MyList<Integer> l2 = new MyList<Integer>(2);
        MyList<Integer> l3 = new MyList<Integer>(3);
        l2.next = l3;
        l1.next = l2;
        System.out.println(l1);

        l1 = reverseListRecursiv(l1);
        System.out.println(l1);
    }

    // Развернуть односвязный список: пример https://www.geeksforgeeks.org/reverse-a-linked-list/
    private MyList<Integer> reverseList(MyList<Integer> list) {
        MyList<Integer> newNext = null;
        MyList<Integer> current = list;
        MyList<Integer> temp = null;

        while (current != null) {
            temp = current.next; // Сохраняем весь хвост, отрезаем его от текущего эл-та

            current.next = newNext; // Перестановка1:  перезаписываем некст у текущего эл-та, разворачиваем указатель
            newNext = current; // Перестановка2: говорим что текущий становится в конец, будет новым некст

            current = temp; // Назначаем эл-т на следующую итерацию (тот э-т, который достали в начале)
        }
        return newNext;
    }

    private static MyList<Integer> reverseListRecursiv(MyList<Integer> node) {
        MyList<Integer> newHead;

        if(node.next == null){
            return node;
        }
        newHead = reverseListRecursiv(node.next);

        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
