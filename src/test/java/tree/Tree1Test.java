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
    public void shouldReturnArrayWithNumbersInExpectedOrder() {
        MyTree<Integer> tree1 = constructIntTree2();

        int[] res = instance.traverseTree(tree1);
        Assertions.assertThat(res).containsSequence(1, 2, 4, 3, 5, 2);
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
        MyTree<Integer> treeMin1 = constructIntTree1();

        int[] res = instance.largestValuesInTreeRows(treeMin1);
        Assertions.assertThat(res).containsSequence(-1, 7, 1);
    }

    @Test
    public void shouldCountAllTreeValues() {
        MyTree<Integer> treeMin1 = constructIntTree1();

        int res = instance.treeSum(treeMin1);
        Assert.assertEquals(12, res);
    }

    @Test
    public void shouldFindDigitTreePathSum() {
        MyTree<Integer> stringTree = constructIntTree2();
        long res = instance.digitTreeSum(stringTree);
        Assert.assertEquals(410, res);
    }

    @Test
    public void shouldFindDigitTreePathSumV2() {
        MyTree<Integer> stringTree = constructIntTree2();
        long res = instance.digitTreeSum2(stringTree);
        Assert.assertEquals(410, res);
    }

    //        -1
    //       /   \
    //      5     7
    //             \
    //              1
    private MyTree<Integer> constructIntTree1() {
        MyTree<Integer> treeMin1 = new MyTree<>(-1);
        MyTree<Integer> tree5 = new MyTree<>(5);
        MyTree<Integer> tree7 = new MyTree<>(7);
        MyTree<Integer> tree1 = new MyTree<>(1);
        treeMin1.left = tree5;
        treeMin1.right = tree7;
        tree7.right = tree1;
        return treeMin1;
    }

    //         1
    //       /   \
    //      2     4
    //       \   / \
    //        3 5   2
    private MyTree<Integer> constructIntTree2() {
        MyTree<Integer> root = new MyTree<>(1);
        MyTree<Integer> leaf2 = new MyTree<>(2);
        MyTree<Integer> leaf2V2 = new MyTree<>(2);
        MyTree<Integer> leaf3 = new MyTree<>(3);
        MyTree<Integer> leaf4 = new MyTree<>(4);
        MyTree<Integer> leaf5 = new MyTree<>(5);

        root.left = leaf2;
        root.right = leaf4;

        leaf2.right = leaf3;
        leaf4.left = leaf5;
        leaf4.right = leaf2V2;
        return root;
    }
}