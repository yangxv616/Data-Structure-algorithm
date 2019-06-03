package DataStructures.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import HelpFunction.Help;

/**
 * 一种只许插入不许删除的数据结构
 */
public class Bag<E> implements Iterable<E>
{
    /**
     *Bag中存放的最小单元
     */
    class Node<E>
    {
        private E value;
        private Node<E> next;

        @Override
        public String toString()
        {
            return value.toString();
        }
    }

    private Node<E> firstNode;//Bag里的第一个元素
    private int size;//Bag的大小

    /**
     * 无参构造器
     */
    private Bag()
    {
        firstNode = null;
        size = 0;
    }

    /**
     * 向Bag中添加新元素
     * @param value 新元素的主值
     */
    public void add(E value)
    {
        Node<E> oldFirtsNode = firstNode;
        firstNode = new Node<>();
        firstNode.value = value;
        firstNode.next = oldFirtsNode;
        size++;
    }

    /**
     * 判断Bag是否为空
     * @return 返回true是Bag为空
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * @return 返回数组的大小
     */
    public int getSize()
    {
        return size;
    }

    /**
     * 判断Bag中是否包含主值为value的元素
     * @param value 目标主值
     * @return 若包含则返回true
     */
    public boolean contains(E value)
    {
        Node<E> currentNode = firstNode;

        while(currentNode != null)
            if(currentNode.value == value)
                return true;

        return false;
    }

    /**
     * 迭代器
     */
    @Override
    public Iterator<E> iterator()
    {
        class Iter<E> implements Iterator<E>
        {
            private Node<E> currentNode;

            public Iter(Node<E> node)
            {
                currentNode = node;
            }

            @Override
            public boolean hasNext()
            {
                return currentNode != null;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                    throw new NoSuchElementException();
                E currentValue = currentNode.value;
                currentNode = currentNode.next;

                return currentValue;
            }
        }

        return new Iter<E>(firstNode);
    }

    @Override
    public String toString()
    {
        if(firstNode == null)
            return "Empty Bag";

        Node<E> currentNode = firstNode;
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < size - 1; i++)
        {
            str.append(currentNode + ", ");
            currentNode = currentNode.next;
        }
        str.append(currentNode + "] Size = " + size);

        return str.toString();
    }

    public static void main(String[] args)
    {
        int[] arr = Help.creatRandomIntArray();
        System.out.println("即将依次放入bag的元素：");
        Help.printArray(arr);

        System.out.println("开始插入：");
        Bag<Integer> bag = new Bag<>();
        for(int e : arr)
        {
            bag.add(e);
            System.out.println("更新bag：" + bag);
        }

        System.out.println("向bag中插入主值为101的节点：");
        bag.add(101);
        System.out.println("更新bag：" + bag);

        System.out.println("bag中是否存在主值为101的节点：" + bag.contains(101));

    }
}
