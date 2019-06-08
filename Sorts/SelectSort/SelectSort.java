package Sorts.SelectSort;

import HelpFunction.Help;

/**
 * 简单选择排序
 */
public class SelectSort
{
    private SelectSort(){};

    public static Comparable[] sort(Comparable[] arry)
    {
        for(int i = arry.length - 1; i > 0 ; i--)
        {
            int maxPos = 0;
            for(int j = 1; j <= i; j++)
                if(arry[j].compareTo(arry[maxPos]) > 0)
                    maxPos = j;

            Comparable temp = arry[i];
            arry[i] = arry[maxPos];
            arry[maxPos] = temp;
        }

        return arry;
    }

    public static void main(String[] args)
    {
        Integer[] arry = Help.creatRandomIntegerArray();
        System.out.println("原数组如下：");
        Help.printIntegerArray(arry);
        System.out.println("\n排序后的数组如下：");
        SelectSort.sort(arry);
        Help.printIntegerArray(arry);
    }
}
