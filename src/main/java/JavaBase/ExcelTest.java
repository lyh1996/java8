package JavaBase;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-10 19:15
 * @since 1.7
 */
public class ExcelTest {
    public static void main(String[] args) {

        List<User> list = Arrays.asList(new User("1", "lyh", 12, 1.0), new User("2", "小老弟", 23, 1.0));
        Map<String, String> map = new HashMap<>();

        map.put("uid", "编号");
        map.put("name", "姓名");
        map.put("age", "年龄");

        ExcelWriter excelWriter = ExcelUtil.getWriter("D://a.xlsx");
        // 设置表头
        excelWriter.setHeaderAlias(map);

        // 写入数据
        excelWriter.write(list, true);

        // 设置样式
        // 获取第一行第一列 设置样式
        CellStyle cellStyle = excelWriter.getWorkbook().createCellStyle();
        Cell cell = excelWriter.getCell(1, 2, true);
        Font cellFont = excelWriter.createFont();
        cellFont.setColor(IndexedColors.GREEN.index);
        cellFont.setFontName("华文行楷");
        cellFont.setFontHeightInPoints((short)10);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //cellStyle.setFillBackgroundColor(IndexedColors.RED.index);
        cellStyle.setFont(cellFont);
        cell.setCellStyle(cellStyle);

        System.out.println(cell.getStringCellValue());



        // 设置表头字体
        CellStyle cellStyle1 = excelWriter.getHeadCellStyle();
        Font font = excelWriter.createFont();
        // 设置字体名称
        font.setFontName("华文行楷");
        // 设置字号
        font.setFontHeightInPoints((short)28);
        // 设置是否为斜体
        font.setItalic(false);
        // 设置是否加粗
        font.setBold(true);
        //设置字体颜色
        font.setColor(IndexedColors.RED.index);

        cellStyle1.setFont(font);


        // 自动调整列大小
        excelWriter.autoSizeColumnAll();

        // 设置列的宽度
        excelWriter.setColumnWidth(0, 30);
        excelWriter.setColumnWidth(1, 30);
        excelWriter.setColumnWidth(2, 30);


        excelWriter.flush();
        excelWriter.close();

    }
}
