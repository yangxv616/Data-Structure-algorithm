package HelpFunction;

public class Help
{
    /**
     * 私有构造函数
     * 即不能创建Help的对象
     */
    private Help()
    {}

    /**
     * 创建一个int型随机数组
     * @param min 最小值
     * @param max 最大值
     * @param nums 元素个数
     * @return 返回创建好的数组
     */
    public static int[] creatRandomIntArray(int min, int max, int nums)
    {
        int[] arr = new int[nums];
        for(int i = 0; i < nums; i++)
            arr[i] = (int) (min + (max - min) * Math.random());
        return arr;
    }

    /**
     * 创建一个元素小于100，大于0，长度为15的int数组
     * @return 返回创建好的数组
     */
    public static int[] creatRandomIntArray()
    {
        return creatRandomIntArray(0, 100, 15);
    }

    /**
     * 从头到尾打印int型数组
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr)
    {
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[arr.length - 1] + "]");
    }
}
