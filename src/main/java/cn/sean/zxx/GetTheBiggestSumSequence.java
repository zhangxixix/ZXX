package cn.sean.zxx;

import org.junit.Test;

/**
 * 最大子序列和问题;
 * 
 * @author zWX453510
 */
public class GetTheBiggestSumSequence
{
    @Test
    public void test()
    {
        int[] a = {4, 3, -10, 10, -2, -1, 2, 6, -2};
        System.out.println(maxSumRec(a, 0, a.length - 1));
        System.out.println(maxSumRec(a));
    }

    /**
     * 时间复杂度O(N);
     * 
     * @param a
     * @return
     */
    public static int maxSumRec(int[] a)
    {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++)
        {
            thisSum += a[i];
            if (thisSum > maxSum)
            {
                maxSum = thisSum;
            }
            else if (thisSum < 0)
            {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 时间复杂度O(logN)
     * 
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int maxSumRec(int[] a, int left, int right)
    {
        if (left == right)
        {
            if (a[left] > 0)
            {
                return a[left];
            }
            else
            {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--)
        {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
            {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++)
        {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
            {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, maxRightBorderSum + maxLeftBorderSum);

    }

    private static int max3(int a, int b, int c)
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

}
