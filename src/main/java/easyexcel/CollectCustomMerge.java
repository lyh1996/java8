package easyexcel;

/**
 * 自定义注解，用于判断是否需要合并以及合并的主键   标记哪些属性需要合并，哪个是主键
 *
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/08/14 17:11
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CollectCustomMerge {

    /**
     * 是否需要合并单元格
     */
    boolean needMerge() default false;

    /**
     * 是否是主键,即该字段相同的行合并
     */
    boolean isPk() default false;
}


