import java.util.ArrayList;

/**
 * 既然敬爱的捞骑士诚心诚意的发问了
 * 超级可爱的Doge就大发慈悲的告诉你
 * 为了守护世界的和平
 * 可爱又迷人的反派角色
 * 我们就是穿梭在银河的不可以色色小队！
 * 
 * 给捞骑士的“不负责任”解答
 * BY：可爱像绿叶的抹茶菜菜子
 */
public class weixin{
    /**
     * 主要程序
     * @param args 没用到，可以无视
     */
    public static void main(String[] args)
    {
        // Test case 这里可以改变不同的数据
        int[] input = {2, 4, 8, 3, 6, 9};
        int n = 3;
        ////////////////////////////////////
        int[] output = new int[input.length];

        // copy
        ArrayList<Integer> copyInput = new ArrayList<>();
        for(int i = 0; i < input.length; i++)
        {
            copyInput.add(input[i]);
        }

        int divisibility = -1;
        int currentSmallest;

        for(int j = 0; j < input.length; j++)
        {
            currentSmallest = getNextNumber(copyInput, n, divisibility);
            if(currentSmallest == -1)
            {
                // 真可惜，僧多肉少，物资匮乏，少侠请节哀，你找不到比一开始的它更合适的数字了呢
                currentSmallest = getNextNumber(copyInput, n, -1);
            }
            output[j] = currentSmallest;
            divisibility = currentSmallest % n;
            copyInput.remove((Object)currentSmallest);
        }

        System.out.print("input : [");
        printArray(input);
        System.out.print(" n = " + n + "\n");

        System.out.print("output: [");
        printArray(output);
    }

    /**
     * 找到下一个合适的数字
     * @param input 目前的剩余数字
     * @param divisor n
     * @param prevDivisibility 之前数字的除于状态，只有零或者一两种可能
     * @return
     */
    private static int getNextNumber(ArrayList<Integer> input, int divisor, int prevDivisibility)
    {
        // Base case 
        if(input.size() == 0)
        {
            return -1;
        }

        // copy
        ArrayList<Integer> copyInput = new ArrayList<>();
        for(int i = 0; i < input.size(); i++)
        {
            copyInput.add(input.get(i));
        }

        int smallest = findSmallest(copyInput);
        int mod = smallest % divisor;
        // 确认此数字的除于状态
        if(mod > 0)
        {
            // 代表这个数字不能被n除于整
            mod = 1; // 具体的数字不重要，重要的是这个数字 能？还是 不能？
        }
        else
        {
            // 代表这个数字可以被n除于整
        }

        // 确认此数字和上个数字配不配
        if( isGoodMatch(mod, prevDivisibility) ) 
        {
            // 看来这个数字和你很合适呢，太棒了！
        }
        else
        {
            // 啊呀呀，这个看来不是Good Match呢，把它T了找下个吧
            copyInput.remove((Object)smallest);
            int nextSmallNum = getNextNumber(copyInput, divisor, prevDivisibility);
            if(nextSmallNum > smallest)
            {
                // 看来顺利找到合适的数字了呢，太棒了！
                smallest = nextSmallNum;
            }
            else
            {
                // 真可惜，僧多肉少，物资匮乏，少侠请节哀，你找不到比一开始的它更合适的数字了呢
                smallest = -1;
            }
        }

        return smallest;
    }

    /**
     * 永远找到最小一个的数字
     * @param input 剩余数字
     * @return 最小数字
     */
    private static int findSmallest(ArrayList<Integer> input)
    {
        int smallest = input.get(0);

        for(int i = 1; i < input.size(); i++)
        {
            if(smallest > input.get(i))
            {
                smallest = input.get(i);
            }
        }

        return smallest;
    }

    /**
     * 检查和上个数字的除于状态合不合适
     * @param mod 目前数字的除于状态
     * @param prevD 之前数字的除于状态
     * @return 结果
     */
    private static boolean isGoodMatch(int mod, int prevD)
    {
        if(mod == prevD)
        {
            return false; // 这个数字会和之前的数字有冲突呢
        }
        else
        {
            return true; // 这个数字看来没事呢，可以和之前的数字放一起哦
        }
    }

    /**
     * 这个程序无关的，无视
     * @param list 无视
     */
    private static void printArray(int[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(i < list.length - 1)
            {
                System.out.print(list[i] + ", ");
            }
            else
            {
                System.out.print(list[i]);
            }
        }
        System.out.print("]");
    }
}