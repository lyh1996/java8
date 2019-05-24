package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 位运算
 * @create 2019-05-21 8:50
 * @since 1.7
 */
public class BitOperation {
    public static void main(String[] args) {
        BitOperation bitOperation = new BitOperation();
       boolean num = bitOperation.isOddNumber(1);
        System.out.println("是否是奇数？" + num);
        int a = 5;
        int b = 6;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("num1：" + a + " num2：" +b);


        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        System.out.println("没有重复的数字是:" + bitOperation.find(arr));

        System.out.println(bitOperation.pow(3));

        System.out.println(bitOperation.findN(19));

        int size = 1024 * 1024;

        System.out.println(size);

    }

    /**
     * @description:
     * @method:   判断一个数是奇数还是偶数
     * @author:   633805  LYH
     * @param a
     * @return: boolean
     * @exception:
     * @date: 2019/5/21 9:15
     */
    private boolean isOddNumber(int a) {
        int num = a & 1;
        return a == 1;
    }

    /**
     * @description:查找找出没有重复的数  两个相同的数异或之后结果会等于 0，即 n ^ n = 0。并且任何数与 0 异或等于它本身，即 n ^ 0 = n
     * @method:   find
     * @author:   633805  LYH
     * @param arr
     * @return: int
     * @exception:
     * @date: 2019/5/21 10:37
     */
    private int find(int[] arr){

        int tmp = arr[0];
        for(int i = 1;i < arr.length; i++){
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }

    /**
     * @description: 2的n次方
     * @method:   pow
     * @author:   633805  LYH
     * @param n
     * @return: int
     * @exception:
     * @date: 2019/5/21 11:18
     */
    private int pow(int n){
        int sum = 1;
        int tmp = 2;
        int isTrue = n & 1;
        while(n != 0){
            if(isTrue == 1){
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        return sum;
    }

    /**
     * @description:查找  找出不大于N的最大的2的幂指数
     * @method:   findN
     * @author:   633805  LYH
     * @param n
     * @return: int
     * @exception:
     * @date: 2019/5/21 14:01
     */
    private int findN(int n){
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8; // 整型一般是 32 位，上面我是假设 8 位。
        return (n + 1) >> 1;
    }
}
