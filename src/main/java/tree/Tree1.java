package tree;

import util.MyTree;

import java.util.*;

public class Tree1 {

    // Обход дерева в ширину. Вернуть в формате массива: [1, 2, 4, 3, 5, 2]
    //         1
    //       /   \
    //      2     4
    //       \   / \
    //        3 5   2
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

    //  Найти наибольшее value для каждого уровня(row) в дереве
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

    // Обход дерева. Посчитать сумму путей в формате: 123 + 145 + 142 = 410 Value равны значениям от 0-9
    //         1
    //       /   \
    //      2     4
    //       \   / \
    //        3 5   2
    public long digitTreeSum(MyTree<Integer> tree) {
        return Arrays.stream(collectPaths(tree, "").split(" ")).
                mapToLong(Long::parseLong).
                sum();
    }

    private String collectPaths(MyTree<Integer> tree, String acc) {
        if (tree == null) {
            return "";
        }
        acc += tree.value;
        return tree.left == null && tree.right == null ?
                acc + " " :
                collectPaths(tree.left, acc) + collectPaths(tree.right, acc);
    }

    public long digitTreeSum2(MyTree<Integer> tree) {
        return collectPaths2(tree, 0);
    }

    private long collectPaths2(MyTree<Integer> tree, long acc) {
        if (tree == null) {
            return 0;
        }
        acc = acc * 10 + tree.value; // acc=1, val=2 > 10+2=12 /or/ acc=5, val=0 > 50+0=50
        return tree.left == null && tree.right == null ?
                acc : // 123, 145, 142
                collectPaths2(tree.left, acc) + collectPaths2(tree.right, acc); // as result we got 123 + 145 + 142
    }

}
