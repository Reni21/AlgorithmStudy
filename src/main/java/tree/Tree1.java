package tree;

import util.MyTree;

import java.util.*;

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

    //  Найти наибольшее value для каждого уровня в дереве
    int[] largestValuesInTreeRows(MyTree<Integer> tree) {
        if (tree == null || tree.value == null) {
            return new int[]{};
        }

        List<Integer> result = new ArrayList<>();
        Queue<MyTree<Integer>> curLevel = new ArrayDeque<>();
        curLevel.add(tree);
        Queue<MyTree<Integer>> nextLevel = new ArrayDeque<>();

        int maxValue = Integer.MIN_VALUE;
        while (!curLevel.isEmpty()) {
            MyTree<Integer> entry = curLevel.poll();
            int value = entry.value;
            maxValue = Math.max(maxValue, value);

            MyTree<Integer> left = entry.left;
            if (left != null) {
                nextLevel.add(left);
            }
            MyTree<Integer> right = entry.right;
            if (right != null) {
                nextLevel.add(right);
            }

            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                nextLevel = new ArrayDeque<>();
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Посчитать сумму всех узлов дерева
    public int treeSum(MyTree<Integer> tree) {
        if (tree == null || tree.value == null) {
            return 0;
        }
        int sum = tree.value;
        MyTree<Integer> left = tree.left;
        if (left != null) {
            sum += treeSum(left);
        }
        MyTree<Integer> right = tree.right;
        if (right != null) {
            sum += treeSum(right);
        }
        return sum;
    }

}
