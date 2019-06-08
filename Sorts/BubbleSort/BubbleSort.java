package Sorts.BubbleSort;

import HelpFunction.Help;

/**
 * 冒泡排序
 * 原地排序
 * 时间复杂度为N²
 */
public class BubbleSort
{
    private BubbleSort()
    {}

    public static Comparable[] sort(Comparable[] arry)
    {
        int len = arry.length;

        for(int i = 0; i < len; i++)
            for(int j = 1; j < len - i; j++)
                if(arry[j - 1].compareTo(arry[j]) > 0)
                {
                    Comparable temp = arry[j];
                    arry[j] = arry[j - 1];
                    arry[j - 1] = temp;
                }
        return arry;
    }

    public static void main(String[] args)
    {
        Integer[] arry = Help.creatRandomIntegerArray();
        System.out.println("原数组如下：");
        Help.printIntegerArray(arry);
        System.out.println("\n排序后的数组如下：");
        BubbleSort.sort(arry);
        Help.printIntegerArray(arry);
    }
}
