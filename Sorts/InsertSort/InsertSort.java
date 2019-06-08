package Sorts.InsertSort;

import HelpFunction.Help;

/**
 * 插入排序
 */
public class InsertSort
{
    private InsertSort(){};

    public static Comparable[] sort(Comparable[] arry)
    {
        for(int i = 1; i < arry.length; i++)
            for(int j = i - 1; j >= 0; j--)
                if(arry[j + 1].compareTo(arry[j]) < 0)
                {
                    Comparable temp = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
                else
                    break;

        return arry;
    }

    public static void main(String[] args)
    {
        Integer[] arry = Help.creatRandomIntegerArray();
        System.out.println("原数组如下：");
        Help.printIntegerArray(arry);
        System.out.println("\n排序后的数组如下：");
        InsertSort.sort(arry);
        Help.printIntegerArray(arry);
    }
}
