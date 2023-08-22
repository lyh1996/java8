package easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/08/14 17:08
 **/

public class ExportData {

    @ExcelProperty(value = "员工")
    @CollectCustomMerge(needMerge = true, isPk = true)
    private String employeeName;

    @ExcelProperty(value = "统计时间")
    //@CollectCustomMerge(needMerge = true)
    @DateTimeFormat("yyyy-MM-dd")
    public String operateDay;

    @ExcelProperty(value = {"入库", "收货SKU数"})
    public long receiveSkuQtySum;

    @ExcelProperty(value = {"入库", "收货箱数"})
    public long receiveBoxQtySum;

    //上架SKU 数(常规入库，备货中转按产品入库)
    @ExcelProperty(value = {"入库", "上架SKU数"})
    public long shelfSkuQtySum;

    @ExcelProperty(value = {"入库", "上架箱数"})
    public long shelfBoxQtySum;

    @ExcelProperty(value = {"拣货", "拣货SKU数"})
    public long pickSkuQtySum;

    @ExcelProperty(value = {"拣货", "拣货箱数"})
    public long pickBoxQtySum;

    @ExcelProperty(value = {"拣货", "二次分拣产品数"})
    public long pickSortSkuQtySum;

    @ExcelProperty(value = {"拣货", "复核产品数"})
    public long pickCheckSkuQtySum;

    @ExcelProperty(value = {"出库", "一件代发单数"})
    public long dropShippingDeliveryOrderQtySum;

    @ExcelProperty(value = {"出库", "备货中转单数"})
    public long crossDockDeliveryOrderQtySum;

    @ExcelProperty(value = {"库内", "SKU库存调整"})
    public long skuAdjustQtySum;

    @ExcelProperty(value = {"出库", "箱库存调整"})
    public long boxAdjustQtySum;

    @ExcelProperty(value = {"出库", "SKU移库数"})
    public long skuMoveQtySum;

    @ExcelProperty(value = {"出库", "箱移库数"})
    public long boxMoveQtySum;

    @ExcelProperty(value = {"次品处理", "次品拣货数"})
    public long defectivePickQtySum;

    @ExcelProperty(value = {"次品处理", "次品处理数"})
    public long defectiveProcessQtySum;

    @ExcelProperty(value = {"退件", "签收包裹数"})
    public long returnSignQtySum;

    @ExcelProperty(value = {"退件", "清点SKU数"})
    public long returnClearQtySum;

    @ExcelProperty(value = {"退件", "上架SKU数"})
    public long returnShelfQtySum;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getOperateDay() {
        return operateDay;
    }

    public void setOperateDay(String operateDay) {
        this.operateDay = operateDay;
    }

    public long getReceiveSkuQtySum() {
        return receiveSkuQtySum;
    }

    public void setReceiveSkuQtySum(long receiveSkuQtySum) {
        this.receiveSkuQtySum = receiveSkuQtySum;
    }

    public long getReceiveBoxQtySum() {
        return receiveBoxQtySum;
    }

    public void setReceiveBoxQtySum(long receiveBoxQtySum) {
        this.receiveBoxQtySum = receiveBoxQtySum;
    }

    public long getShelfSkuQtySum() {
        return shelfSkuQtySum;
    }

    public void setShelfSkuQtySum(long shelfSkuQtySum) {
        this.shelfSkuQtySum = shelfSkuQtySum;
    }

    public long getShelfBoxQtySum() {
        return shelfBoxQtySum;
    }

    public void setShelfBoxQtySum(long shelfBoxQtySum) {
        this.shelfBoxQtySum = shelfBoxQtySum;
    }

    public long getPickSkuQtySum() {
        return pickSkuQtySum;
    }

    public void setPickSkuQtySum(long pickSkuQtySum) {
        this.pickSkuQtySum = pickSkuQtySum;
    }

    public long getPickBoxQtySum() {
        return pickBoxQtySum;
    }

    public void setPickBoxQtySum(long pickBoxQtySum) {
        this.pickBoxQtySum = pickBoxQtySum;
    }

    public long getPickSortSkuQtySum() {
        return pickSortSkuQtySum;
    }

    public void setPickSortSkuQtySum(long pickSortSkuQtySum) {
        this.pickSortSkuQtySum = pickSortSkuQtySum;
    }

    public long getPickCheckSkuQtySum() {
        return pickCheckSkuQtySum;
    }

    public void setPickCheckSkuQtySum(long pickCheckSkuQtySum) {
        this.pickCheckSkuQtySum = pickCheckSkuQtySum;
    }

    public long getDropShippingDeliveryOrderQtySum() {
        return dropShippingDeliveryOrderQtySum;
    }

    public void setDropShippingDeliveryOrderQtySum(long dropShippingDeliveryOrderQtySum) {
        this.dropShippingDeliveryOrderQtySum = dropShippingDeliveryOrderQtySum;
    }

    public long getCrossDockDeliveryOrderQtySum() {
        return crossDockDeliveryOrderQtySum;
    }

    public void setCrossDockDeliveryOrderQtySum(long crossDockDeliveryOrderQtySum) {
        this.crossDockDeliveryOrderQtySum = crossDockDeliveryOrderQtySum;
    }

    public long getSkuAdjustQtySum() {
        return skuAdjustQtySum;
    }

    public void setSkuAdjustQtySum(long skuAdjustQtySum) {
        this.skuAdjustQtySum = skuAdjustQtySum;
    }

    public long getBoxAdjustQtySum() {
        return boxAdjustQtySum;
    }

    public void setBoxAdjustQtySum(long boxAdjustQtySum) {
        this.boxAdjustQtySum = boxAdjustQtySum;
    }

    public long getSkuMoveQtySum() {
        return skuMoveQtySum;
    }

    public void setSkuMoveQtySum(long skuMoveQtySum) {
        this.skuMoveQtySum = skuMoveQtySum;
    }

    public long getBoxMoveQtySum() {
        return boxMoveQtySum;
    }

    public void setBoxMoveQtySum(long boxMoveQtySum) {
        this.boxMoveQtySum = boxMoveQtySum;
    }

    public long getDefectivePickQtySum() {
        return defectivePickQtySum;
    }

    public void setDefectivePickQtySum(long defectivePickQtySum) {
        this.defectivePickQtySum = defectivePickQtySum;
    }

    public long getDefectiveProcessQtySum() {
        return defectiveProcessQtySum;
    }

    public void setDefectiveProcessQtySum(long defectiveProcessQtySum) {
        this.defectiveProcessQtySum = defectiveProcessQtySum;
    }

    public long getReturnSignQtySum() {
        return returnSignQtySum;
    }

    public void setReturnSignQtySum(long returnSignQtySum) {
        this.returnSignQtySum = returnSignQtySum;
    }

    public long getReturnClearQtySum() {
        return returnClearQtySum;
    }

    public void setReturnClearQtySum(long returnClearQtySum) {
        this.returnClearQtySum = returnClearQtySum;
    }

    public long getReturnShelfQtySum() {
        return returnShelfQtySum;
    }

    public void setReturnShelfQtySum(long returnShelfQtySum) {
        this.returnShelfQtySum = returnShelfQtySum;
    }
}
