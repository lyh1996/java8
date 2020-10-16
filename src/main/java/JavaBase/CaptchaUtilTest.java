package JavaBase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-09 16:46
 * @since 1.7
 */
public class CaptchaUtilTest {
    public static void main(String[] args) {

        // 生成验证码
/*        CircleCaptcha lineCaptcha = CaptchaUtil.createCircleCaptcha(300,200);

        String path = "D://a/" + LocalDate.now() + ".png";
        System.out.println(lineCaptcha.getCode() + " >" + path);
        lineCaptcha.write(path);*/

        // 识别验证码

        //原始验证码地址
        String OriginalImg = "C:\\mysoftware\\images\\upload\\OcrImg\\oi.jpg";
        //识别样本输出地址
        String ocrResult = "C:\\mysoftware\\images\\upload\\OcrResult\\or.jpg";
        //去噪点
        CaptchaUtilTest.removeBackground(OriginalImg, ocrResult);
        //裁剪边角
        //ImgUtils.cuttingImg(ocrResult);
        //OCR识别
        //String code = Tess4J.executeTess4J(ocrResult);
        //输出识别结果
        //System.out.println("Ocr识别结果: \n" + code);

    }

    public static void removeBackground(String imgUrl, String resUrl) {
        //定义一个临界阈值
        int threshold = 300;
        try {
            BufferedImage img = ImageIO.read(new File(imgUrl));
            int width = img.getWidth();
            int height = img.getHeight();
            for (int i = 1; i < width; i++) {
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        Color color = new Color(img.getRGB(x, y));
                        System.out.println("red:" + color.getRed() + " | green:" + color.getGreen() + " | blue:" + color.getBlue());
                        int num = color.getRed() + color.getGreen() + color.getBlue();
                        if (num >= threshold) {
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            for (int i = 1; i < width; i++) {
                Color color1 = new Color(img.getRGB(i, 1));
                int num1 = color1.getRed() + color1.getGreen() + color1.getBlue();
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        Color color = new Color(img.getRGB(x, y));

                        int num = color.getRed() + color.getGreen() + color.getBlue();
                        if (num == num1) {
                            img.setRGB(x, y, Color.BLACK.getRGB());
                        } else {
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            File file = new File(resUrl);
            if (!file.exists()) {
                File dir = file.getParentFile();
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
