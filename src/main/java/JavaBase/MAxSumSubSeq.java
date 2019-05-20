package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 最大连续子串和
 * @create 2019-03-29 16:02
 * @since 1.7
 */
public class MAxSumSubSeq {


    public static void main(String[] args) {
        int[] a = {1, 2, -1, 3, -2};
        getMaxSumSeq(a);
        System.out.println(maxSum(a));
    }
    private static void getMaxSumSeq(int[] a){
        int rmax = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int temp = -1;
        for(int i = 0 ;i<a.length;i++){
            if(sum>0){
                sum+=a[i];
            }else{
                sum = a[i];
                temp = i;
            }
            if(sum>rmax){
                start = temp;
                rmax= sum;
                end = i;
            }
        }
        for(int j = start;j<=end;j++){
            System.out.print(a[j]+" ");
        }
        System.out.println("\nsum:"+rmax);
    }

    private static int maxSum(int[] num){
        int result = num[0];
        int maxResult = num[0];
        for (int i = 1; i < num.length; i++) {
            result += num[i];
            // 相加之后大于结果值，注意需要考虑全是负数的情况
            if (result > maxResult) {
                // 比较是否大于最大值maxResult
                maxResult = result;
            }else {
                if (result < 0) {
                    // 否则如果相加的结果小于0，并且小于maxResult，这个子串的最大值就确定下来了
                    result = 0;//重置
                }
            }
        }
        return maxResult;

    }
}
