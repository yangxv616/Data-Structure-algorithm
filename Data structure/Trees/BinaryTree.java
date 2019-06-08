package DataStructures.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 * @param <E>
 */
public class BinaryTree<E>
{
    private Node<E> root;

    /**
     * 构造器
     * 构造一棵只有根节点的二叉树
     * @param value 根节点主值
     */
    public BinaryTree(E value)
    {
        root = new Node<E>(value);
    }

    /**
     * 默认构造器
     */
    public BinaryTree(){}

    /**
     * 遍历二叉树时对遍历到的节点进行的操作
     * 这里的操作是打印输出该节点，后面可根据需要修改
     * @param node 此时遍历到的节点
     */
    private void operate(Node<E> node)
    {
        System.out.print(node + " ");
    }

    /**
     * 前序遍历二叉树
     * 递归实现
     */
    public void preOrder()
    {
        preOrder(root);
    }
    public void preOrder(Node<E> root)
    {
        if(root == null)
            return;

        operate(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历二叉树
     * 递归实现
     */
    public void inOrder()
    {
        inOrder(root);
    }
    public void inOrder(Node<E> root)
    {
        if(root == null)
            return;

        inOrder(root.getLeft());
        operate(root);
        inOrder(root.getRight());
    }

    /**
     * 后序遍历二叉树
     * 递归实现
     */
    public void postOrder()
    {
        postOrder(root);
    }
    public void postOrder(Node<E> root)
    {
        if(root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        operate(root);
    }

    /**
     * 层次遍历二叉树
     */
    public void levelOrder()
    {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node<E> target = queue.element();

            if(target.getLeft() != null)
                queue.add(target.getLeft());
            if(target.getRight() != null)
                queue.add(target.getRight());

            operate(target);

            queue.remove();
        }
    }

    /**
     * 根据先序遍历和中序遍历构建一颗二叉树
     * 必须要保证所要构建的二叉树的节点主值没有重复
     * 否则构建的二叉树不唯一
     * 输出结果不确定
     * @param preArry 先序遍历序列
     * @param inArry  中序遍历序列
     */
    public void buildTreeByPreAndIn(ArrayList<E> preArry, ArrayList<E> inArry)
    {
        root = buildTreeByPreAndIn(preArry, 0, preArry.size() - 1, inArry, 0, inArry.size() - 1);
    }

    /**
     * 根据先序遍历和中序遍历构建一颗二叉树的递归实现
     * @param preArry 完全先序遍历序列
     * @param preMin 有效先序遍历序列的左边界
     * @param preMax 有效先序遍历序列的左边界
     * @param inArry 完全中序遍历序列
     * @param inMin 有效中序遍历序列的左边界
     * @param inMax 有效中序遍历序列的左边界
     * @return 当前遍历序列的根节点
     */
    public Node<E> buildTreeByPreAndIn(ArrayList<E> preArry, int preMin, int preMax, ArrayList<E> inArry, int inMin, int inMax)
    {
        if(inMin > inMax)
            return null;
        else if(inMin == inMax)
            return new Node<E>(inArry.get(inMin));

        Node<E> root = new Node<E>(preArry.get(preMin));

        int nextLInMin = inMin;
        int nextLInMax = inMin;
        while(!inArry.get(nextLInMax).equals(root.getValue()))
            nextLInMax++;
        nextLInMax--;
        int nextRInMin = nextLInMax + 2;
        int nextRInMax = inMax;

        int nextLPreMin = preMin + 1;
        int nextLPreMax = nextLPreMin + (nextLInMax - nextLInMin);
        int nextRPreMin = nextLPreMax + 1;
        int nextRPreMax = preMax;

        root.setLeft(buildTreeByPreAndIn(preArry, nextLPreMin, nextLPreMax, inArry, nextLInMin, nextLInMax));
        root.setRight(buildTreeByPreAndIn(preArry, nextRPreMin, nextRPreMax, inArry, nextRInMin, nextRInMax));

        return root;
    }

    /**
     * 根据中序遍历和后序遍历构建一颗二叉树
     * 必须要保证所要构建的二叉树的节点主值没有重复
     * 否则构建的二叉树不唯一
     * 输出结果不确定
     * @param inArry 中序遍历序列
     * @param postArry  后序遍历序列
     */
    public void buildTreeByInAndPost(ArrayList<E> inArry, ArrayList<E> postArry)
    {
        root = buildTreeByInAndPost(inArry, 0, inArry.size() - 1, postArry, 0, postArry.size() - 1);
    }

    /**
     * 根据中序遍历和后序遍历构建一颗二叉树的递归实现
     * @param inArry 完全中序遍历序列
     * @param inMin 有效中序遍历序列的左边界
     * @param inMax 有效中序遍历序列的右边界
     * @param postArry 完全后序遍历序列
     * @param postMin 有效后序遍历序列的左边界
     * @param postMax 有效后序遍历序列的右边界
     * @return 当前遍历序列的根节点
     */
    public Node<E> buildTreeByInAndPost(ArrayList<E> inArry, int inMin, int inMax, ArrayList<E> postArry, int postMin, int postMax)
    {
        if(inMin > inMax)
            return null;
        else if(inMin == inMax)
            return new Node<E>(inArry.get(inMin));

        Node<E> root = new Node<E>(postArry.get(postMax));

        int nextLInMin = inMin;
        int nextLInMax = inMin;
        while(!inArry.get(nextLInMax).equals(root.getValue()))
            nextLInMax++;
        nextLInMax--;
        int nextRInMin = nextLInMax + 2;
        int nextRInMax = inMax;

        int nextLPostMin = postMin;
        int nextLPostMax = nextLPostMin + (nextLInMax - nextLInMin);
        int nextRPostMin = nextLPostMax + 1;
        int nextRPostMax = postMax -1;

        root.setLeft(buildTreeByInAndPost(inArry, nextLInMin, nextLInMax, postArry, nextLPostMin, nextLPostMax));
        root.setRight(buildTreeByInAndPost(inArry, nextRInMin, nextRInMax, postArry, nextRPostMin, nextRPostMax));

        return root;
    }

    public static void main(String[] args)
    {
        Integer[] arr1 = {1,2,3,4,5,6,7,8,9};
        Integer[] arr2 = {2,4,3,1,5,8,7,9,6};
        Integer[] arr3 = {4,3,2,8,9,7,6,5,1};

        ArrayList<Integer> preArry = new ArrayList<Integer>(Arrays.asList(arr1));
        ArrayList<Integer> inArry = new ArrayList<Integer>(Arrays.asList(arr2));
        ArrayList<Integer> postArry = new ArrayList<Integer>(Arrays.asList(arr3));

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.buildTreeByInAndPost(inArry, postArry);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }
}
