package JavaBase;

import cn.hutool.core.util.StrUtil;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-10 15:42
 * @since 1.7
 */
public class TestUser {
    public static void main(String[] args) {
        String str = "";
        String str2 = " ";

        if (StrUtil.isEmpty(str2)) {
            System.out.println("没有空格的空");
        }

        if (StrUtil.isBlank(str)) {
            System.out.println("完全的空");
        }

    }
}
