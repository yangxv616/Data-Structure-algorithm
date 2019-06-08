package Sorts.MergeSort;

import HelpFunction.Help;

/**
 * 归并排序
 */
public class MergeSort
{
    private MergeSort(){};

    /**
     * 归并操作
     * 序列arry[low, mid]和arry[mid + 1, high]均在其内部有序
     * 整理arry[low, high],使arry[low, high]有序
     * @param arry 总数组
     * @param low 左边界
     * @param mid 中界
     * @param high 有边界
     */
    public static  void merge(Comparable[] arry, int low, int mid, int high)
    {
        Comparable[] left = new Comparable[mid - low + 1];
        System.arraycopy(arry, low, left, 0, mid - low + 1);
        Comparable[] right =new Comparable[high - mid];
        System.arraycopy(arry, mid + 1, right, 0, high - mid);

        int i = 0;//left哨兵
        int j = 0;//right哨兵
        int k = low;//arry哨兵

        while(k <= high)
            if(i == left.length)
                arry[k++] = right[j++];
            else if(j == right.length)
                arry[k++] = left[i++];
            else
            {
                if(left[i].compareTo(right[j]) <= 0)
                    arry[k++] = left[i++];
                else
                    arry[k++] = right[j++];
            }
    }
    public static void sort(Comparable[] arry, int low, int high)
    {
        if(low >= high)
            return;

        int mid = (low + high) / 2;
        sort(arry, low, mid);
        sort(arry, mid + 1, high);
        merge(arry, low, mid, high);
    }
    public static void sort(Comparable[] arry)
    {
        sort(arry, 0, arry.length - 1);
    }

    public static void main(String[] args)
    {
        Integer[] arry = Help.creatRandomIntegerArray();
        System.out.println("原数组如下：");
        Help.printIntegerArray(arry);
        System.out.println("\n排序后的数组如下：");
        MergeSort.sort(arry);
        Help.printIntegerArray(arry);
    }
}
