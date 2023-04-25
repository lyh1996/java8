package translate;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/03/14 11:24
 **/
public class Test {

    public static void main(String args[]) throws Exception {
        System.out.println("-----test-----");
        String txt =
                "Happiness is to live in the moment and be happy with each other. Sweet thoughts linger day and night, belong to each other, have a clear and elegant taste, and are free and unfettered between mountains and rivers and clouds.";
        GT g = GT.getInstance();
        System.out.println(g.translateText(txt, "auto", "zh_cn"));
        //System.out.println( g.translateText("谁能说支持不支持","auto","en"));
    }
}
