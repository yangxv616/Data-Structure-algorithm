package DataStructures.Lists;
import HelpFunction.Help;
import HelpFunction.Help.*;

/**
 * 普通的链表
 * 头节点head为其第一个节点
 */
public class LinkedList<E>
{
    /**
     * 定义链表中的最小单元node的类
     */
    class Node
    {
        /**
         * value为节点的主值
         */
        E value;

        /**
         * next为该节点的下一个节点
         * 若不存在下一个节点，则next = null
         */
        Node next;

        /**
         * 构造函数
         * @param value 为该节点具体的值
         */
        Node(E value)
        {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString()
        {
            return value.toString();
        }
    }

    /**
     * head为链表头节点
     * size为链表中节点的总数
     */
    private Node head;
    private int size;

    /**
     * 在指定位置插入新节点
     * @param pos 插入的位置（0 <= pos <= size）
     * @param value 插入节点的主值
     */
    public void add(int pos, E value)
    {
        if(pos < 0 || pos > size)
            throw new IllegalArgumentException("Add filed, Plaese cheak pos");
        Node target = new Node(value);

        if(pos == 0)
        {
            target.next = head;
            head = target;
            size++;
            return;
        }

        Node preNode = head;
        Node nowNode = head.next;
        for(int i = 1; i < pos; i++)
        {
            preNode = preNode.next;
            nowNode = nowNode.next;
        }

        preNode.next = target;
        target.next = nowNode;

        size++;
    }

    /**
     * 删除指定位置的节点
     * @param pos 要删除节点的位置
     */
    public void remove(int pos)
    {
        if(pos < 0)
            throw new IllegalArgumentException("Remove filed, pos can't less than 0");
        else if(pos > size - 1)
            throw new IllegalArgumentException("Remove filed, pos out of bounds");

        if(pos == 0)
        {
            head = head.next;
            size--;
            return;
        }

        Node preNode = head;
        Node nowNode = head.next;
        for(int i = 1; i < pos; i++)
        {
            preNode = preNode.next;
            nowNode = nowNode.next;
        }
        preNode.next = nowNode.next;

        size--;
    }

    /**
     * 判断链表是否为空
     * @return 若返回true则链表为空
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * @return 返回链表元素个数
     */
    public int getSize()
    {
        return size;
    }


    @Override
    public String toString()
    {
        if(size == 0)
            return "LinkedList is empty!";

        StringBuilder str = new StringBuilder();
        str.append("Head: " + head);

        Node target = head.next;
        for(int i = 1; i < size; i++)
        {
            str.append("->" + target);
            target = target.next;
        }
        str.append(" size = " + size);

        return str.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args)
    {
        int[] arr = Help.creatRandomIntArray();

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++)
        {
            list.add(i, arr[i]);
            System.out.println(list);
        }

        System.out.println("插入主值为101的头节点：");
        list.add(0, 101);
        System.out.println(list);

        System.out.println("在pos=5的位置插入主值为102的节点：");
        list.add(5, 102);
        System.out.println(list);

        System.out.println("删除尾节点：");
        list.remove(list.getSize() - 1);
        System.out.println(list);

        System.out.println("删除pos=5位置上的节点");
        list.remove(5);
        System.out.println(list);

        System.out.println("从头到尾逐个删除节点");
        while(list.getSize() != 0)
        {
            list.remove(0);
            System.out.println(list);
        }
    }
}