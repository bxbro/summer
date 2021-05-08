package com.bxbro.summer.study.mooc;

/**
 * @author dong
 * @description 最大子列和
 * @date 2021/5/5
 */
public class MaxSubseqSum {

    public static void main(String[] args) {
        int[] array = {-4, 4, -3, 5, -6, -2, 3, -1, 2, 6, -2};

//        int maxSum = maxSubseqSum4(array);
        int maxSum = maxSubseqSum3(array);

        System.out.println("最大子列和为："+maxSum);
    }

    public static int maxSubseqSum1(int[] array) {
        int thisSum;
        int maxSum = 0;
        // i 是子列左端位置
        for (int i=0;i<array.length;i++) {
            // j是子列右端位置
            for (int j=i;j<array.length;j++) {
                // thisSum是从 array[i]到array[j]的子列和
                thisSum = 0;
                for (int k=i;k<=j;k++) {
                    thisSum += array[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubseqSum2(int[] array) {
        int thisSum;
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubseqSum3(int[] array) {
        return DivideAndConquer( array, 0, array.length-1 );
    }

    static int Max3( int A, int B, int C )
    { /* 返回3个整数中的最大值 */
        return A > B ? A > C ? A : C : B > C ? B : C;
    }

    static int DivideAndConquer( int List[], int left, int right )
    { /* 分治法求List[left]到List[right]的最大子列和 */
        int MaxLeftSum, MaxRightSum; /* 存放左右子问题的解 */
        int MaxLeftBorderSum, MaxRightBorderSum; /*存放跨分界线的结果*/

        int LeftBorderSum, RightBorderSum;
        int center, i;

        if( left == right )  { /* 递归的终止条件，子列只有1个数字 */
            if( List[left] > 0 )  {
                return List[left];
            }
            else{
                return 0;
            }
        }

        /* 下面是"分"的过程 */
        center = ( left + right ) / 2; /* 找到中分点 */
        /* 递归求得两边子列的最大和 */
        MaxLeftSum = DivideAndConquer( List, left, center );
        MaxRightSum = DivideAndConquer( List, center+1, right );

        /* 下面求跨分界线的最大子列和 */
        MaxLeftBorderSum = 0; LeftBorderSum = 0;
        for( i=center; i>=left; i-- ) { /* 从中线向左扫描 */
            LeftBorderSum += List[i];
            if( LeftBorderSum > MaxLeftBorderSum ){
                MaxLeftBorderSum = LeftBorderSum;
            }
        } /* 左边扫描结束 */

        MaxRightBorderSum = 0; RightBorderSum = 0;
        for( i=center+1; i<=right; i++ ) { /* 从中线向右扫描 */
            RightBorderSum += List[i];
            if( RightBorderSum > MaxRightBorderSum ){
                MaxRightBorderSum = RightBorderSum;
            }

        } /* 右边扫描结束 */

        /* 下面返回"治"的结果 */
        return Max3( MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum );
    }


    /**
     * 算法4：在线处理
     * “在线”的意思是指每输入一个数据就进行即时处理，在任何一个地方中止输入，算法都能正确给出当前的解。
     *
     * 时间复杂度：O(N)
     * @param array
     */
    public static int maxSubseqSum4(int[] array) {
        int thisSum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            // 向右累加
            thisSum += array[i];
            if (thisSum > maxSum) {
                // 找到更大的和，则更新当前结果
                maxSum = thisSum;
                end = i;
            }
            // 如果当前子列和为负，则不可能使后面的部分和增大，抛弃之
            else if (thisSum < 0) {
                thisSum = 0;
                start = i+1;
            }
        }
        System.out.println("子列首："+array[start]);
        System.out.println("子列尾："+array[end]);
        return maxSum;
    }
}
