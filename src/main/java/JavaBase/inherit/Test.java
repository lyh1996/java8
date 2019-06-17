package JavaBase.inherit;

import JavaBase.JsonUtil;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-15 14:23
 * @since 1.7
 */
public class Test {
    public static void main(String[] args) {
        Inherit2 inherit2 = new Inherit2();
        inherit2.setAge("12");
        inherit2.setSex("男");
        inherit2.setUname("lyh");

        JavaBase.inherit2.Inherit2 inherit3 = new JavaBase.inherit2.Inherit2();
        inherit3.setSex("男");
        inherit3.setUname("lyh");

        Test test = new Test();
        String str = test.getInherit(inherit2);
        String str2 = test.getInherit(inherit3);

        test.setInherit(str);
        test.setInherit(str2);

        test.setInherit2(str2);
    }

    private String getInherit(Inhert inhert) {

        String data = JsonUtils.toJsonString(inhert);
        System.out.println(data);

        return data;

    }

    private void setInherit(String date) {
        Inhert inhert1 = JsonUtils.toObject(date, Inhert.class);

        System.out.println("输出"+JsonUtils.toJsonString(inhert1));
    }

    private void setInherit2(String date) {
        Inhert inhert1 = JsonUtil.parseObject(date, Inhert.class);

        System.out.println("输出未指定"+JsonUtil.toJsonString(inhert1));
    }
}
