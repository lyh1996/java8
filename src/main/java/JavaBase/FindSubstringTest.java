package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 查找子串
 * @create 2019-03-29 10:26
 * @since 1.7
 */
public class FindSubstringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "vabcdkjlabc";
       // System.out.println(str2.contains(str1));
          //  System.out.println(str2.indexOf(str1, 1));
        //int pos = isSon(str2, str1, 0);
        //System.out.println(pos);
        check(str2, str1);

    }

    public static int isSon(String mother,String son,int pos){
        int i = pos; //主串mother当前位置下标处
        int j = 0;//子串son中当前位置下标值，子串从第一个开始
        while (i<=mother.length()-1 && j<=son.length()-1) {//循环条件：mother串和son串都没有比较完
            if(mother.toCharArray()[i] == son.toCharArray()[j]){
                //相等则继续
                ++j;
                ++i;
            }else{
                //不相等，则
                i = i-j+1;//主串位置向后移动一位
                j = 0;//子串继续回到起点
            }

        }
        if(j == son.length()){
            return i-j;
        }else{
            return -1;
        }

    }

    public static void check(String str,String subStr){
        int t = str.length();
        int count = 0;
        do{
         t = str.lastIndexOf(subStr,t-1);
         if(t==-1){
         break;
         }
         System.out.print(t+"\t");
         count++;
         }while(t!=-1);
         System.out.println();
         System.out.println("子串个数:"+count);
 }


}
