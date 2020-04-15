package tree;

import util.MyTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree1 {

    // Обход дерева в ширину. Вернуть в формате массива: [1, 2, 4, 3, 5]
    //         1
    //       /   \
    //      2     4
    //       \   /
    //        3 5
    int[] traverseTree(MyTree<Integer> tree) {
        if (tree == null || tree.value == null) {
            return new int[]{};
        }

        List<Integer> result = new ArrayList<>();
        Queue<MyTree<Integer>> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            MyTree<Integer> current = queue.poll();
            result.add(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //    public int[] traverseTree(MyTree<Integer> tree) {
//        List<Integer> res = new ArrayList<>();
//        List<MyTree<Integer>> iter = new ArrayList<>();
//        iter.add(tree);
//
//        while (tree != null && tree.value != null) {
//            List<MyTree<Integer>> iterNew = new ArrayList<>();
//            for (MyTree<Integer> entry : iter) {
//                res.add(entry.value);
//
//                MyTree<Integer> left = entry.left;
//                if (left != null) {
//                    iterNew.add(left);
//                }
//                MyTree<Integer> right = entry.right;
//                if (right != null) {
//                    iterNew.add(right);
//                }
//            }
//            if (iterNew.isEmpty()) {
//                tree = null;
//            } else {
//                iter = iterNew;
//            }
//        }
//
//        return res.stream().mapToInt(number -> number).toArray();
//    }

}
