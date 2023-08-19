package com.wxx.java.search;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author wxxstar
 * @create 2023-08-12 9:33
 * <p>
 * 查阅资料，如何借助二分搜索树实现以下函数：min、max、floor、ceil、rank、select。
 * 二分搜索树还可以回答很多数据之间的关系的问题。
 * <p>
 * BST定义如下：
 * 一棵二叉搜索树（BST）首先是一棵二叉树，
 * 其中每个结点都含有一个可以比较的键（对于 Java 语言来说，就是实现了 Comparable 接口的对象）
 * 以及相关联的值，且每个结点的键都大于其左子树中的任意结点的键而小于右子树中任意结点的键。
 * <p>
 * BST 是一种能够将链表插入的灵活性和有序数组查找的高效性结合起来的数据结构。
 */
public class BST {

    // 使用内部类来表示结点
    private class Node {

        // 为了说明算法，我们将 key 设置成易于比较的 int 类型，设计成实现了 Comparable 接口的对象是更标准的做法
        private int key;
        private int value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    // 节根点
    private Node root;

    // 二分搜索树中的结点个数
    private int count;

    // 默认构造一棵空的二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的结点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }


    /**
     * 向一棵二分搜索树的根结点插入 key 和 value，
     * 看看放在左边还是放在右边，然后把插入以后形成的树的根结点返回。
     * 注意这里的递归调用实现，初学的时候，不是很好理解。
     * 可以尝试从最最简单的情况开始分析。
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, int key, int value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key == node.key) {
            // 如果 key 值存在，直接覆盖就好了，即更新
            node.value = value;

        } else if (key < node.key) {
            // 递归调用结束以后，要把根结点返回回去
            // 因为很可能，node.left 是空，要让新创建的结点接到原来的根，就得执行这步操作
            node.left = insert(node.left, key, value);
        } else {
            // 递归调用结束以后，要把根结点返回回去
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(int key) {
        return contain(root, key);
    }

    private boolean contain(Node node, int key) {
        // 先处理递归到底的情况
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        } else if (key < node.key) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    public Integer search(int key) {
        return search(root, key);
    }

    // 在以 node 为根的二分搜索树中查找 key 所对应的 value
    private Integer search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node.value;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.printf("%s ", node.key);
            postOrder(node.left);
            postOrder(node.right);
        }

    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.printf("%s ", node.key);
            inOrder(node.right);
        }

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.printf("%s ", node.key);
        }
    }

    private void destroy(Node node) {
        if (node != null) {
            destroy(node.left);
            destroy(node.right);

            node.left = null;
            node.right = null;
            node.key = 0;
            node.value = 0;
            count--;
        }
    }

    public void destroy() {
        destroy(root);
    }

    public int minimum() {
        Node min = minimum(root);
        return min == null ? -1 : min.key;
    }

    private Node minimum(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private int maximum() {
        Node max = maximum(root);
        return max == null ? -1 : max.key;
    }

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public void sLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    // 从二分搜索树中删除最小 key 所在的结点
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    // 特别注意：删除了一个结点以后，根元素很可能会发生变化，因此，算法设计的时候，一定要把根结点返回回去
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大 key 所在的结点
    public void removeMax() {
        if (root != null) {
            // 删除了最大元素以后的根结点很有可能不是原来的根结点
            // 所以一定要赋值回去
            root = removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left=null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(7, 7);
        bst.insert(3, 3);
        bst.insert(10, 10);
        bst.insert(3, 33);
        bst.insert(5, 5);
        bst.insert(11, 11);
        bst.insert(15, 15);
        bst.insert(6, 6);
        bst.insert(1, 1);


        System.out.println(bst.contain(4));
        System.out.println(bst.contain(3));

        Integer v = bst.search(6);
        System.out.println(v == null ? "" : v);
        System.out.println(bst.search(5));

        bst.preOrder();
        bst.inOrder();
        bst.postOrder();

        bst.levelOrder();
        System.out.println(bst);

        System.out.println(bst.minimum());
        System.out.println(bst.maximum());

        bst.removeMin();
        bst.removeMax();

        System.out.println(bst.minimum());
        System.out.println(bst.maximum());


    }
}
