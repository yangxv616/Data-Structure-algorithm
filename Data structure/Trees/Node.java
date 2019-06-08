package DataStructures.Trees;

/**
 * 二叉树节点
 * 单独做成一个类是为了方便继承和扩展
 * @param <E>
 */
public class Node<E>
{
    private E value;
    private Node<E> left;
    private Node<E> right;

    /**
     * 构造函数
     * 同时设置主值和左右子树
     * @param value 主值
     * @param left 左子树
     * @param right 右子树
     */
    public Node(E value, Node<E> left, Node<E> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * 构造函数
     * 只设置主值
     * @param value 主值
     */
    public Node(E value)
    {
        this(value, null, null);
    }

    public E getValue()
    {
        return value;
    }

    public Node<E> getLeft()
    {
        return left;
    }

    public Node<E> getRight()
    {
        return right;
    }

    public void setValue(E value)
    {
        this.value = value;
    }

    public void setLeft(Node<E> left)
    {
        this.left = left;
    }

    public void setRight(Node<E> right)
    {
        this.right = right;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}
