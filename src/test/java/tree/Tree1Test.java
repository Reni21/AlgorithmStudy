package tree;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import util.MyTree;

public class Tree1Test {
    private final Tree1 instance = new Tree1();

    @Test
    public void shouldReturnEmptyArrayForEmptyTreeValue() {
        MyTree<Integer> tree = new MyTree<>(null);
        int[] res = instance.traverseTree(tree);
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void shouldReturnEmptyArrayIfTreeIsNull() {
        int[] res = instance.traverseTree(null);
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void shouldReturnArrayWithNumbersInExpectedOrder1() {
        MyTree<Integer> tree1 = new MyTree<>(1);
        MyTree<Integer> tree2 = new MyTree<>(2);
        MyTree<Integer> tree3 = new MyTree<>(3);
        MyTree<Integer> tree4 = new MyTree<>(4);
        MyTree<Integer> tree5 = new MyTree<>(5);
        MyTree<Integer> tree6 = new MyTree<>(6);
        MyTree<Integer> tree7 = new MyTree<>(7);
        MyTree<Integer> tree8 = new MyTree<>(8);
        MyTree<Integer> tree9 = new MyTree<>(9);
        tree1.left = tree2;
        tree1.right = tree4;

        tree2.left = tree7;
        tree2.right = tree3;

        tree4.left = tree5;
        tree4.right = tree6;

        tree3.left = tree8;
        tree5.right = tree9;

        int[] res = instance.traverseTree(tree1);
        Assertions.assertThat(res).containsSequence(1, 2, 4, 7, 3, 5, 6, 8, 9);
    }

    @Test
    public void shouldReturnArrayWithNumbersInExpectedOrder() {
        MyTree<Integer> tree1 = new MyTree<>(1);
        MyTree<Integer> tree2 = new MyTree<>(2);
        MyTree<Integer> tree3 = new MyTree<>(3);
        MyTree<Integer> tree4 = new MyTree<>(4);
        MyTree<Integer> tree5 = new MyTree<>(5);
        tree1.left = tree2;
        tree1.right = tree4;
        tree2.right = tree3;
        tree4.left = tree5;

        int[] res = instance.traverseTree(tree1);
        Assertions.assertThat(res).containsSequence(1, 2, 4, 3, 5);
    }

    @Test
    public void shouldReturnArrayWithOneNumberIfTreeContainsOnlyRoot() {
        MyTree<Integer> tree1 = new MyTree<>(1);

        int[] res = instance.traverseTree(tree1);
        Assertions.assertThat(res)
                .hasSize(1)
                .containsOnly(1);
    }

    @Test
    public void shouldReturnArrayWithMaxValuesOfEachRow() {
        MyTree<Integer> treeMin1 = constructTree();

        int[] res = instance.largestValuesInTreeRows(treeMin1);
        Assertions.assertThat(res).containsSequence(-1, 7, 1);
    }

    @Test
    public void shouldCountAllTreeValues() {
        MyTree<Integer> treeMin1 = constructTree();

        int res = instance.treeSum(treeMin1);
        Assert.assertEquals(12, res);
    }

    private MyTree<Integer> constructTree(){
        MyTree<Integer> treeMin1 = new MyTree<>(-1);
        MyTree<Integer> tree5 = new MyTree<>(5);
        MyTree<Integer> tree7 = new MyTree<>(7);
        MyTree<Integer> tree1 = new MyTree<>(1);
        treeMin1.left = tree5;
        treeMin1.right = tree7;
        tree7.right = tree1;
        return treeMin1;
    }
}