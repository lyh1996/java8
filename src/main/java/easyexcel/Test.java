package easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/08/14 17:25
 **/
public class Test {
    public static void main(String[] args) {
        List<ExportData> list = new ArrayList<>();
        ExportData exportData = new ExportData();
        exportData.setEmployeeName("pm");
        exportData.setOperateDay("2023-08-09");
        exportData.setReceiveBoxQtySum(14);
        exportData.setPickSkuQtySum(2);

        list.add(exportData);

        ExportData exportData2 = new ExportData();
        exportData2.setEmployeeName("pm");
        exportData2.setOperateDay("2023-08-10");
        exportData2.setReceiveSkuQtySum(54);
        exportData2.setShelfSkuQtySum(65);
        exportData2.setShelfBoxQtySum(2);
        exportData2.setPickBoxQtySum(7);
        exportData2.setDropShippingDeliveryOrderQtySum(1);
        exportData2.setCrossDockDeliveryOrderQtySum(1);
        list.add(exportData2);

        ExportData exportData3 = new ExportData();
        exportData3.setEmployeeName("pm");
        exportData3.setOperateDay("2023-08-11");
        exportData3.setReceiveSkuQtySum(18);
        exportData3.setReceiveBoxQtySum(150);
        exportData3.setPickBoxQtySum(18);
        exportData3.setDropShippingDeliveryOrderQtySum(12);
        list.add(exportData3);


        EasyExcel.write("D:/CollectExport.xlsx").head(ExportData.class)
                .registerWriteHandler(new CustomMergeStrategy(ExportData.class))
                .sheet().doWrite(list);
    }
}
